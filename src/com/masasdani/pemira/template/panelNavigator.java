/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.masasdani.pemira.template;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author badak
 */
public class panelNavigator extends JPanel{

    Image image;
    public panelNavigator() {
        setOpaque(false);
        image=new ImageIcon(getClass().getResource("/com/masasdani/pemira/image/panel.png")).getImage();
        int side=super.getWidth()-getWidth();
        int bottom=super.getHeight()-getHeight();
        setLocation(side/2, bottom);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D gd=(Graphics2D) g.create();
        gd.drawImage(image, 0,getHeight()-80,getWidth(),80, null);
        gd.dispose();
    }


}
