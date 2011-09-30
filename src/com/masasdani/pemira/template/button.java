/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.masasdani.pemira.template;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;

/**
 *
 * @author badak
 */
public class button extends JButton{

    
    public button() {
        setOpaque(false);
        setContentAreaFilled(false);
        addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {
                //super.mouseEntered(e);
                //setLabel(TOOL_TIP_TEXT_KEY);
                setLocation((int) getLocation().getX(), (int) (getLocation().getY() - 10));
                
            }

            @Override
            public void mouseExited(MouseEvent e) {
                //super.mouseExited(e);
                //setLabel("");
                setLocation((int) getLocation().getX(), (int) (getLocation().getY() + 10));
            }

        });

    }

}
