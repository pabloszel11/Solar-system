package com.solarsystem;

import java.awt.*;

public class CelestialBodyRunnable implements Runnable
{
    private CelestialBody cb;
    private Component component;

    public CelestialBodyRunnable(CelestialBody c, Component cmp)
    {
        cb = c;
        component = cmp;
    }

    public synchronized void run()
    {
        try
        {
            while(true)
            {
                cb.move();
                component.repaint();
                Thread.sleep(5);
            }
        }
        catch(InterruptedException e)
        {

        }
    }
}
