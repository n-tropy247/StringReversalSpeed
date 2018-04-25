/*
 * Copyright (C) 2018 Ryan Castelli
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package StringReversal;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Panel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.EventQueue;
import java.awt.Graphics2D;
import java.awt.BasicStroke;

/**
 * Graphical representation of speed results
 *
 * @author NTropy
 * @version 10/2/17
 */
public class Graph extends JFrame {

    private static JFrame frame;
    private final BackGroundPanel BACKGROUND_PANEL = new BackGroundPanel();

    private static final int NUM_TO_TEST = 6;

    private static final int[] X1 = new int[NUM_TO_TEST];
    private static final int[] Y1 = new int[NUM_TO_TEST];
    private static final int[] X2 = new int[NUM_TO_TEST];
    private static final int[] Y2 = new int[NUM_TO_TEST];

    /**
     * Constructor
     */
    private Graph() {
        init();
    }

    /**
     * Creates JFrame thread
     *
     * @param args
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            frame = new Graph();
            frame.setVisible(true);
        });
    }

    /**
     * Settings for JFrame
     */
    private void init() {
        requestFocus();
        setSize(1400, 600);
        BACKGROUND_PANEL.setLayout(new BorderLayout());
        setLayout(new BorderLayout());
        add(BACKGROUND_PANEL, BorderLayout.CENTER);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        values();
    }

    /**
     * Creates x and y coordinates for graph lines
     */
    private void values() {
        String results = Timer.reversal(NUM_TO_TEST);
        String[] resultsSplit = results.split("\\s");

        int[] xCoords = new int[NUM_TO_TEST];
        int[] yCoords = new int[NUM_TO_TEST];

        int loopNum = 0;
        for (int j = 0; j < NUM_TO_TEST * 2; j++) {
            if (j % 2 == 0) {
                xCoords[j - loopNum] = (((int) ((Double.valueOf(resultsSplit[j])) / Math.pow(10, 5))) * 60) + 32;
            } else {
                loopNum++;
                yCoords[j - loopNum] = (378 - (int) (((Double.valueOf(resultsSplit[j]))) / 100));
            }
        }
        for (int i = 0; i < xCoords.length - 1; i++) {
            X1[i] = xCoords[i];
            X2[i] = xCoords[i + 1];
            Y1[i] = yCoords[i];
            Y2[i] = yCoords[i + 1];

            BACKGROUND_PANEL.repaint();
        }
    }

    /**
     * Graphics for frame
     */
    private class BackGroundPanel extends Panel {

        private final int POINT_RADIUS = 2; //radius of each point as a number of pixels

        /**
         * Constructor, just refers to parent class
         */
        private BackGroundPanel() {
            super();
        }

        /**
         * Draws in line and points
         *
         * @param g
         */
        @Override
        public void paint(Graphics g) {
            g.setColor(Color.red);
            for (int j = 0; j < NUM_TO_TEST; j++) {
                g.fillOval(X1[j], Y1[j], POINT_RADIUS, POINT_RADIUS);
                g.fillOval(X2[j], Y2[j], POINT_RADIUS, POINT_RADIUS);
            }

            super.paint(g);

            Graphics2D g2 = (Graphics2D) g;
            g2.setStroke(new BasicStroke(3));
            for (int j = 0; j < NUM_TO_TEST; j++) {
                g2.drawLine(X1[j], Y1[j], X2[j], Y2[j]);
            }
        }
    }
}
