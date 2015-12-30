/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package turbo.interceptor;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Enumeration;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;
import turbo.POJO.AccessToken;
import turbo.service.AccessTokenDAO;
import turbo.service.UserDAO;

/**
 *
 * @author LeeSan
 */
public class AuthenticationInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private AccessTokenDAO accessTokenDAO;

    @Override
    public boolean preHandle(HttpServletRequest request,
            HttpServletResponse response, Object handler)
            throws Exception {
//        String uri = request.getRequestURI();
//        if (uri.endsWith("payCart.do")) {
//            Customer cus = (Customer) ((HttpServletRequest) request).getSession().getAttribute("customer");
//            if (cus == null) {
//                response.sendRedirect("/Spring/uynguyen/users/login.do?act=loginRequire");
//                return false;
//            }
//        }

        System.out.println("preHandle");
        String token = extractHeaderToken(request);

        if (token == null || token == "") {
            response.sendRedirect(request.getContextPath() + "/user/requireToken");
            return false;
        }

        AccessToken accessToken = accessTokenDAO.getAccessToken(token);

        Timestamp currentTime = new Timestamp(new Date().getTime());
        if (accessToken.getExpire().compareTo(currentTime) < 0) { //Expire
            response.sendRedirect(request.getContextPath() + "/user/tokenExpire");
            return false;
        }

        System.out.println("User access token " + token);
        if (accessToken != null && accessToken.getAccessToken().compareTo(token) == 0) {
            return true;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request,
            HttpServletResponse response, Object handler,
            ModelAndView modelAndView)
            throws Exception {
        System.out.println("postHandle");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
            Object handler, Exception ex)
            throws Exception {
        System.out.println("afterCompletion");
    }

    protected String extractHeaderToken(HttpServletRequest request) {
        try {
            Enumeration<String> headers = request.getHeaders("Authorization");
            while (headers.hasMoreElements()) { // typically there is only one (most servers enforce that)
                String value = headers.nextElement();
                if ((value.toLowerCase().startsWith(OAuth2AccessToken.BEARER_TYPE.toLowerCase()))) {
                    String authHeaderValue = value.substring(OAuth2AccessToken.BEARER_TYPE.length()).trim();

                    return authHeaderValue;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }
}
