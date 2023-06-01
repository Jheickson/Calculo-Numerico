public class Seidel {
    public static void main(String[] args) {

        // double[][] A = {{5, 2, 1}, {1, 4, 1}, {2, 1, 6}};
        // double[] b = {29, 18, 36};

        // double[][] A = {{4, 2, -2}, {1, -3, -1}, {3, -1, 4}};
        // double[] b = {0, 7, 5};

        double[][] A = {{4, -1, -1}, {-2, 6, 1}, {-1, 1, 7}};
        double[] b = {3, 9, -6};

        // double[][] A = {{1, 2}, {4, 5}};
        // double[] b = {3, 6};

        double[] x = solveSystem(A, b);

        System.out.println("Solucao:");

        for (int i = 0; i < x.length; i++) {

            System.out.println("x[" + i + "] = " + x[i]);

        }

    }

    public static double[] solveSystem(double[][] A, double[] b) {

        int n = A.length;
        double[] x = new double[n];

        for (int i = 0; i < n; i++) {

            x[i] = 0;

        }

        // Número máximo de iterações e epsilon
        int maxIterations = 1000;
        double epsilon = 1e-6;

        for (int iter = 0; iter < maxIterations; iter++) {

            double error = 0;

            for (int i = 0; i < n; i++) {

                double sum = 0;

                for (int j = 0; j < n; j++) {

                    if (j != i) {

                        sum += A[i][j] * x[j];

                    }

                }

                double xNew = (b[i] - sum) / A[i][i];

                error += Math.abs(xNew - x[i]);

                x[i] = xNew;

            }

            if (error < epsilon) {

                return x;

            }

        }

        return x;

    }

}