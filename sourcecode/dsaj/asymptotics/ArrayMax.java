/*
 * Copyright 2014, Michael T. Goodrich, Roberto Tamassia, Michael H. Goldwasser
 *
 * Developed for use with the book:
 *
 *    Data Structures and Algorithms in Java, Sixth Edition
 *    Michael T. Goodrich, Roberto Tamassia, and Michael H. Goldwasser
 *    John Wiley & Sons, 2014
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
package dsaj.asymptotics;

/**
 * Demonstration of algorithm for finding the maximum element of an array.
 *
 * @author Michael T. Goodrich
 * @author Roberto Tamassia
 * @author Michael H. Goldwasser
 */
class ArrayMax {

  /** Returns the maximum value of a nonempty array of numbers. */
  public static double arrayMax(double[] data) {
    int n = data.length;
    double currentMax = data[0];     // assume first entry is biggest (for now)
    for (int j=1; j < n; j++)        // consider all other entries
      if (data[j] > currentMax)      // if data[j] is biggest thus far...
        currentMax = data[j];        // record it as the current max
    return currentMax;
  }

}
