/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.masasdani.pemira.template;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author badak
 */
public class Enkripsi {
    public static String md5(String pass){
        try{
            MessageDigest md =MessageDigest.getInstance("MD5");
            md.update(pass.getBytes());
            return new String(md.digest());
        }catch(NoSuchAlgorithmException e){
            System.err.println(e);
        }
        return null;
    }
}
