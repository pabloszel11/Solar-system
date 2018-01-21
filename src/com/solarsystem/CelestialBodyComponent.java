package com.solarsystem;

import javax.swing.*;
import java.awt.*;

import static java.awt.Color.*;

public class CelestialBodyComponent extends JPanel
{
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        for(CelestialBody c : Frame.celestialBodies)
        {
            switch(c)
            {
                case Sun:
                    g2.setPaint(yellow);
                    break;
                case Mercury:
                    g2.setPaint(gray);
                    break;
                case Venus:
                    g2.setPaint(new Color(187, 199, 251));
                    break;
                case Earth:
                    g2.setPaint(new Color(0, 92, 227));
                    break;
                case Mars:
                    g2.setPaint(new Color(222, 15, 29));
                    break;
                case Jupiter:
                    g2.setPaint(new Color(255,70,0));
                    break;
                case Saturn:
                    g2.setPaint(new Color(188, 118, 33));
                    break;
                case Uranus:
                    g2.setPaint(new Color(0, 204, 255));
                    break;
                case Neptune:
                    g2.setPaint(new Color(0, 1, 144));
                    break;
                default:
                    g2.setPaint(white);
                    break;
            }

            g2.fill(c.getShape());
        }


    }
}
