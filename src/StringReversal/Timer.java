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

import java.util.Random;

/**
 * Class to find time for various string reversal methods
 *
 * @author NTropy
 * @version 10/2/17
 */
public class Timer {

    private static String currentTester;

    private static long startTime1;
    private static long startTime2;
    private static long stopTime1;
    private static long stopTime2;
    private static long elapsed1;
    private static long elapsed2;

    private static String resultString = "";

    public static String reversal(int numTest) {
        int loops = numTest;

        char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        StringBuilder sb = new StringBuilder();

        for (int j = 0; j < loops; j++) {
            currentTester = "";
            startTime1 = 0;
            stopTime1 = 0;
            startTime2 = 0;
            stopTime2 = 0;
            elapsed1 = 0;
            elapsed2 = 0;

            Random random = new Random(); //random int

            for (int i = 0; i < 500 * Math.pow(2, j); i++) {
                char c = chars[random.nextInt(chars.length)]; //grabs random char
                sb.append(c); //adds char to string
            }
            currentTester = sb.toString(); //converts to string

            startTime1 = System.nanoTime(); //start tinme

            Reversals.reversalArray(currentTester); //runs array reversal

            stopTime1 = System.nanoTime(); //end time

            elapsed1 = stopTime1 - startTime1; //elapsed time for array reversal

            startTime2 = System.nanoTime(); //start time

            Reversals.reversalSubstring(currentTester); //elapsed time for array reversal

            stopTime2 = System.nanoTime(); //stop time

            elapsed2 = stopTime2 - startTime2; //elapsed time for substring reversal

            resultString += ((elapsed1 + " " + (500 * Math.pow(2, j)) + " ")); //places each time for the char array followed by its string length
        }
        return resultString;
    }
}
