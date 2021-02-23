package ru.job4j.oop;


import org.junit.Test;

import static org.junit.Assert.*;

public class PointTest {

    @Test
    public void when38to25then316() {
        Point point1 = new Point(3, 8);
        Point point2 = new Point(2, 5);
        double out = point1.distance(point2);
        assertEquals(3.16, out, 0.01);
    }

    @Test
    public void when00to30then3() {
        Point point1 = new Point(0, 0);
        Point point2 = new Point(3, 0);
        double out = point1.distance(point2);
        assertEquals(3, out, 0.01);
    }

    @Test
    public void when00to40then4() {
        Point point1 = new Point(0, 0);
        Point point2 = new Point(4, 0);
        double out = point1.distance(point2);
        assertEquals(4, out, 0.01);
    }

    @Test
    public void when000to300then3() {
        Point point1 = new Point(0, 0, 0);
        Point point2 = new Point(3, 0, 0);
        double out = point1.distance(point2);
        assertEquals(3, out, 0.01);
    }

    @Test
    public void when040to000then4() {
        Point point1 = new Point(0, 4, 0);
        Point point2 = new Point(0, 0, 0);
        double out = point1.distance(point2);
        assertEquals(4, out, 0.01);
    }
}