package com.solarsystem;

import java.awt.*;
import java.awt.geom.Ellipse2D;


public enum CelestialBody
{
    Sun(332946.0, 695700.0, 0, 0, null, 100, 0),
    Mercury(0.055, 2440.0, 88.0, 57.91, Sun, 5, 95),
    Venus(0.815, 12104.0, 224.7, 108.2, Sun, 7, 75),
    Earth(1.0, 12742.0, 365.0, 149.6, Sun, 10, 250),
    Mars(0.107,6780.0,686.9, 227.9, Sun, 10, 165),
    Jupiter(317.8,0,4332.59,778.5,Sun,40,150),
    Saturn(95.159,0,10759.22,1433.44,Sun,30,89),
    Uranus(14.53,0,30688.5,2870.972,Sun,20,330),
    Neptune(17.147,0,60182.0,4503.443,Sun,20,20),

    Moon(0.0123,0,0.0027,0.000384,Earth,3,0),
    Phobos(1.7,0,0.3189,0.009323,Mars,3,0),

    Ceres(0.00015,946.0,1680.0,414.0,Sun,3,230),
    Pluto(0.00218,2377.0,90560.0,59063760.272,Sun,3,0);

    int x,y,onScreenSize, onScreenDistance;
    private double mass, diameter, yearDuration, distance, degrees;
    private CelestialBody whoseSatellite;



    CelestialBody(double m, double d, double yd, double dist, CelestialBody ws, int oss, double deg)
    {
        mass = m;
        diameter = d;
        yearDuration = yd;
        distance = dist;
        whoseSatellite = ws;
        x = calculateStartingPosX(ws);
        y = calculateStartingPosY(ws);
        onScreenSize = oss;
        degrees = deg;
        if(ws != null)
            onScreenDistance = (int)(Math.log(distance) * 100) - 300;
        else
            onScreenDistance = 0;

        if(onScreenDistance < 0)
            onScreenDistance = 7;
    }


    public double getMass() //unit: earth mass
    {
        return mass;
    }

    public double getDiameter() //unit: kilometers
    {
        return diameter;
    }

    public double getYearDuration() //unit: earth days
    {
        return yearDuration;
    }

    public double getDistance() //unit millions of kilometers
    {
        return distance;
    }

    public int getX()
    {
        return x;
    }

    public int getY()
    {
        return y;
    }


    public CelestialBody getWhoseSatellite()
    {
        return whoseSatellite;
    }

    public int calculateStartingPosX(CelestialBody ws) // ws -> whoseSatellite
    {
        if(ws == null)
            return 960;
        else
        {
            return ws.getX() + onScreenDistance;
        }

    }

    public int calculateStartingPosY(CelestialBody ws) // ws -> whoseSatellite
    {
        if(ws == null)
            return 540;
        else
            return 540 - (ws.onScreenSize/2); //1 pixel - 500 000km
    }

    public Ellipse2D getShape()
    {
        return new Ellipse2D.Double(x - onScreenSize,y - onScreenSize,onScreenSize,onScreenSize);

    }

    public long getPointXOnOrbit()
    {
        double rads = Math.toRadians(degrees);

        if(this != Sun)
            return Math.round(((whoseSatellite.getX() - whoseSatellite.onScreenSize/2) + Math.cos(rads) * onScreenDistance));
        else
            return x;
    }

    public long getPointYOnOrbit()
    {
        double rads = Math.toRadians(degrees);
        if(this != Sun)
            return Math.round(((whoseSatellite.getY() - whoseSatellite.onScreenSize/2) + Math.sin(rads) * onScreenDistance));
        else
            return y;
    }


    public void move()
    {
        x = (int)getPointXOnOrbit();
        y = (int)getPointYOnOrbit();
        double userMultiplier = Frame.speed.getValue();
        double multiplier = Earth.yearDuration / this.yearDuration;


        degrees = (degrees - 0.1408 * multiplier * userMultiplier) % 360;
    }




}
