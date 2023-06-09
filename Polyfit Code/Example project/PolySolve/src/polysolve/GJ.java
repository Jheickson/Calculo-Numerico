/***************************************************************************
 *   Copyright (C) 2019 by Paul Lutus                                      *
 *   lutusp@arachnoid.com                                                  *
 *                                                                         *
 *   This program is free software; you can redistribute it and/or modify  *
 *   it under the terms of the GNU General Public License as published by  *
 *   the Free Software Foundation; either version 2 of the License, or     *
 *   (at your option) any later version.                                   *
 *                                                                         *
 *   This program is distributed in the hope that it will be useful,       *
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of        *
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the         *
 *   GNU General Public License for more details.                          *
 *                                                                         *
 *   You should have received a copy of the GNU General Public License     *
 *   along with this program; if not, write to the                         *
 *   Free Software Foundation, Inc.,                                       *
 *   59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.             *
 ***************************************************************************/

package polysolve;

import java.util.ArrayList;

/**
 *
 * @author lutusp
 */
public class GJ {
    
    // don't allow this class to be instantiated
    private GJ() {
    }
    
    // classic Gauss-Jordan matrix manipulation functions
    static private void divide(double[][] A, int i, int j, int m) {
        for (int q = j + 1; q < m; q++) {
            A[i][q] /= A[i][j];
        }
        A[i][j] = 1;
    }

    static private void eliminate(double[][] A, int i, int j, int n, int m) {
        for (int k = 0; k < n; k++) {
            if (k != i && A[k][j] != 0) {
                for (int q = j + 1; q < m; q++) {
                    A[k][q] -= A[k][j] * A[i][q];
                }
                A[k][j] = 0;
            }
        }
    }

    static private void echelonize(double[][] A) {
        int n = A.length;
        int m = A[0].length;
        int i = 0;
        int j = 0;
        int k;
        double[] swap;
        while (i < n && j < m) {
            //look for non-zero entries in col j at or below row i
            k = i;
            while (k < n && A[k][j] == 0) {
                k++;
            }
            // if an entry is found at row k
            if (k < n) {
                //  if k is not i, then swap row i with row k
                if (k != i) {
                    swap = A[i];
                    A[i] = A[k];
                    A[k] = swap;
                }
                // if A[i][j] is != 1, divide row i by A[i][j]
                if (A[i][j] != 1) {
                    divide(A, i, j, m);
                }
                // eliminate all other non-zero entries
                eliminate(A, i, j, n, m);
                i++;
            }
            j++;
        }
    }
    
    // create regression coefficients
    // for provided data set
    static ArrayList<Double> compute_coefficients(ArrayList<Pair> data, int p) {
        p += 1;
        int n = data.size();
        int r, c;
        int rs = 2 * p - 1;
        //
        // by request: read each datum only once
        // not the most efficient processing method
        // but required if the data set is huge
        //
        // create square matrix with added RH column
        double[][] m = new double[p][p + 1];
        // create array of precalculated matrix data
        double[] mpc = new double[rs];
        mpc[0] = n;
        double x;
        for (Pair pr : data) {
            // process precalculation array
            x = pr.x;
            for (r = 1; r < rs; r++) {
                mpc[r] += x;
                x *= pr.x;
            }
            // process RH column cells
            m[0][p] += pr.y;
            x = pr.x;
            for (r = 1; r < p; r++) {
                m[r][p] += x * pr.y;
                x *= pr.x;
            }
        }
        // populate square matrix section
        for (r = 0; r < p; r++) {
            for (c = 0; c < p; c++) {
                m[r][c] = mpc[r + c];
            }
        }
        // reduce matrix
        echelonize(m);
        // extract result column
        ArrayList<Double> terms = new ArrayList<Double>();
        int j = 0;
        for (double[] mc : m) {
            terms.add(mc[p]);
        }
        return terms;
    }
}
