/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package turbo.common;

/**
 *
 * @author LeeSan
 */
public class AccessToken {
    private String access_token;
    private int exprire;

    /**
     * @return the access_token
     */
    public String getAccess_token() {
        return access_token;
    }

    /**
     * @param access_token the access_token to set
     */
    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    /**
     * @return the exprire
     */
    public int getExprire() {
        return exprire;
    }

    /**
     * @param exprire the exprire to set
     */
    public void setExprire(int exprire) {
        this.exprire = exprire;
    }
    
}
