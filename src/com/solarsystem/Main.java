package com.solarsystem;

import java.awt.*;

public class Main {

    public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                Frame f = new Frame();
                f.setTitle("Solar system");

            }
        });
    }
}
