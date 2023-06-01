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

import java.util.*;

/**
 *
 * @author lutusp
 */
public final class MatrixFunctions {

    // don't allow this class to be instantiated
    private MatrixFunctions() {
    }

    // produce a single y result for a given x
    static double regress(double x, ArrayList<Double> terms) {
        double a = 0;
        double t = 1;
        for (double term : terms) {
            a += term * t;
            t *= x;
        }
        return a;
    }

    // correlation coefficient
    static double corr_coeff(ArrayList<Pair> data, ArrayList<Double> terms) {
        double r = 0;
        int n = data.size();
        double sx = 0, sx2 = 0, sy = 0, sy2 = 0, sxy = 0;
        double x, y;
        for (Pair pr : data) {
            x = regress(pr.x, terms);
            y = pr.y;
            sx += x;
            sy += y;
            sxy += x * y;
            sx2 += x * x;
            sy2 += y * y;
        }
        double div = Math.sqrt((sx2 - (sx * sx) / n) * (sy2 - (sy * sy) / n));
        if (div != 0) {
            r = Math.pow((sxy - (sx * sy) / n) / div, 2);
        }
        return r;
    }

    // standard error
    static double std_error(ArrayList<Pair> data, ArrayList<Double> terms) {
        double r = 0;
        int n = data.size();
        if (n > 2) {
            double a = 0;
            for (Pair pr : data) {
                a += Math.pow((regress(pr.x, terms) - pr.y), 2);
            }
            r = Math.sqrt(a / (n - 2));
        }
        return r;
    }

}
