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

import java.util.Arrays;

/**
 * Handles reversals of strings
 *
 * @author NTropy
 * @version 1.0
 */
public class Reversals {

    /**
     * Constructor
     */
    public Reversals() {
    }

    /**
     * Char array reversal
     *
     * @param s
     */
    public static void reversalArray(String s) {
        String tester = s; //starting string

        char temp[] = tester.toCharArray(); //string to chars

        char temp2[] = new char[tester.length()]; //empty char array for new string

        for (int i = 0; i < tester.length(); i++) {
            temp2[i] = temp[tester.length() - 1 - i]; //uses char array to append each new char in reverse
        }
        String reversed = Arrays.toString(temp2);
    }

    //substring reversal
    public static void reversalSubstring(String s) {
        String tester = s; //starting string

        String temp = ""; //temp string

        for (int i = 0; i < tester.length(); i++) {
            temp += tester.substring((tester.length() - 1 - i), (tester.length() - i)); //uses substring to reverse each character
        }
    }
}
