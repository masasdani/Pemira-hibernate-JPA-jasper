/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.masasdani.pemira.template;

import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

/**
 *
 * @author badak
 */
public class panelTransparan extends JPanel{

    public panelTransparan() {
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D gd=(Graphics2D) g.create();
        
        gd.dispose();
    }


}
