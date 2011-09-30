/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.masasdani.pemira;

import com.masasdani.pemira.gui.LoginBox;
import com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author badak
 */
public class Pemira {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //MahasiswaDao dao=HibernateUtil.getMahasiswaDao();
        try{
            UIManager.setLookAndFeel(new NimbusLookAndFeel());
        }catch(UnsupportedLookAndFeelException e){
            System.out.println(e.getMessage());
        }
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                LoginBox loginBox=new LoginBox();
                loginBox.setLocationRelativeTo(null);
                loginBox.setVisible(true);
            }
        });
    }
}
