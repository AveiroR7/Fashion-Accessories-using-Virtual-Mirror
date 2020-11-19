/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.virtual;

/**
 *
 * @author Iee
 */
public class EmailAndMobile {
    public static boolean isValidEmailAddress(String email) {
        java.util.regex.Pattern p = java.util.regex.Pattern.compile("^[(a-zA-Z-0-9-\\_\\+\\.)]+@[(a-z-A-z)]+\\.[(a-zA-z)]{2,3}$");
        java.util.regex.Matcher m = p.matcher(email);
        return m.matches();
    }
    
    
     public static boolean isValidMobilNumber(String mobNo) {
        java.util.regex.Pattern p = java.util.regex.Pattern.compile("^[7-9][0-9]{9}$");
        java.util.regex.Matcher m = p.matcher(mobNo);
        return m.matches();
    }
 
}
