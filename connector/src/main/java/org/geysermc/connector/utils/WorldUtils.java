/*
 * Copyright (c) 2019-2020 GeyserMC. http://geysermc.org
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 *
 * @author GeyserMC
 * @link https://github.com/GeyserMC/Geyser
 */

package org.geysermc.connector.utils;

public class WorldUtils {
    private static String capitalizeWords(String delimiter, String str) {
        String words[] = str.split(delimiter); // Split input string into an array of words

        String output = "";

        for (String w : words) {
            String first = w.substring(0, 1);
            String afterfirst = w.substring(1);
            output += first.toUpperCase() + afterfirst + " ";
        }
        return output.trim();
    }

    public static String handleWorldName(String identifier) {
        // Check that the override config option was not already specified.

        // Remove the namespace from the identifier if it exists.
        String name = identifier;
        if (identifier.contains(":"))
            name = identifier.split(":")[1];

        /* Replace all underscores with spaces.
         * Capitalize every word.
         * Capitalize every character with '/' before it.
         * 
         * Return the value.
        */
        return capitalizeWords("\\s", capitalizeWords("\\/", name.replaceAll("_", " ")));
    }

    public static String[] handleWorldNames(String[] names) {
        String[] output = new String[names.length];

        for (int i = 0; i < names.length; i++) {
            output[i] = handleWorldName(names[i]);
        }

        return output;
    }
}