package com.solarsystem;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Frame extends JFrame
{
    private CelestialBodyComponent comp;
    public static java.util.List<CelestialBody> celestialBodies = new ArrayList<>();
    public static JSlider speed = new JSlider(JSlider.HORIZONTAL, 1,12,1);

    public void createObjects()
    {

        CelestialBody sun = CelestialBody.Sun;
        CelestialBody mercury = CelestialBody.Mercury;
        CelestialBody venus = CelestialBody.Venus;
        CelestialBody earth = CelestialBody.Earth;
        CelestialBody mars = CelestialBody.Mars;
        CelestialBody jupiter = CelestialBody.Jupiter;
        CelestialBody saturn = CelestialBody.Saturn;
        CelestialBody uranus = CelestialBody.Uranus;
        CelestialBody neptune = CelestialBody.Neptune;

        CelestialBody moon = CelestialBody.Moon;
        CelestialBody phobos = CelestialBody.Phobos;

        CelestialBody ceres = CelestialBody.Ceres;
        CelestialBody pluto = CelestialBody.Pluto;

        celestialBodies.add(sun);
        celestialBodies.add(mercury);
        celestialBodies.add(venus);
        celestialBodies.add(earth);
        celestialBodies.add(mars);
        celestialBodies.add(jupiter);
        celestialBodies.add(saturn);
        celestialBodies.add(uranus);
        celestialBodies.add(neptune);

        celestialBodies.add(moon);
        celestialBodies.add(phobos);

        celestialBodies.add(ceres);
        celestialBodies.add(pluto);



        for(CelestialBody c : celestialBodies)
        {
            Runnable r = new CelestialBodyRunnable(c,comp);
            Thread t = new Thread(r);
            t.start();
        }


    }
    public Frame()
    {
        setSize(1920,1080);
        speed.setMajorTickSpacing(1);
        speed.setPaintLabels(true);
        speed.setPaintTicks(true);
        add(speed,BorderLayout.SOUTH);


        comp = new CelestialBodyComponent();
        comp.setBackground(new Color(25,38,61));
        add(comp, BorderLayout.CENTER);
        createObjects();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
}