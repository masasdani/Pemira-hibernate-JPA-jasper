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
public class panelImage extends JPanel{

    Image image;
    public panelImage() {
        //setSize(800, 600);
        image=new ImageIcon(getClass().getResource("/com/masasdani/pemira/image/background.png")).getImage();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D gd=(Graphics2D) g.create();
        gd.drawImage(image, 0,0, getWidth(), getHeight(), null);
        gd.dispose();
    }

}
