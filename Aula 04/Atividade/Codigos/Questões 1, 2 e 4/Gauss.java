public class Gauss {
    public static void main(String[] args) {

        // Declaração do sistema

        // Sistema da questão 1
        // double[][] A = {{1, 2, 1, 2}, {0, -1, -1, -3}, {0, 0, 3, 5}, {0, 0, 0, 11/3}};
        // double[] b = {-2, 4, 1, -11/3};

        // Sistema da questão 2
        // double[][] A = {{1, 2, 1, 2}, {2, 3, 1, 1}, {1, 1, 3, 4}, {3, 2, 1, 1}};
        // double[] b = {-2, 0, 3, 7};

        // Sistema da questão 4
        double[][] A = {
            {2, 1, 7, 4, -3, -1, 4, 4, 7, 0},
            {4, 2, 2, 3, -2, 0, 3, 3, 4, 1},
            {3, 4, 4, 2, 1, -2, 2, 1, 9, - 3},
            {9, 3, 5, 1, 0, 5, 6, -5, - 3, 4},
            {2, 0, 7, 0, -5, 7, 1, 0, 1, 6},
            {1, 9, 8, 0, 3, 9, 9, 0, 0, 5},
            {4, 1, 9, 0, 4, 3, 7, -4, 1, 3},
            {6, 3, 1, 1, 6, 8, 3, 3, 0, 2},
            {6, 5, 0, -7, 7, -7, 6, 2, -6, 1},
            {1, 6, 3, 4, 8, 3, -5, 0, -6, 0}
        };
        double[] b = {86, 45, 52.5, 108, 66.5, 90.5, 139, 61, -43.5, 31};

        

        // Imprime o sistema sem modificações
        System.out.println("Sistema inserido:");
        printSystem(A, b);

        // Realiza a Eliminação Gaussiana
        // O array duplo "U" será a matriz trangularizada
        double[][] U = gaussianElimination(A, b);

        // Imprime o sistema triangularizado
        System.out.println("Sistema triangularizado:");
        printSystem(U, b);

        // Encontra os resultados a partir da matriz triangularizada
        double[] x = solveSystem(U, b);

        // Imprime a solucao
        System.out.println("Solucao:");

        for (int i = 0; i < x.length; i++) {

            System.out.println("x[" + i + "] = " + x[i]);

        }

    }

    // Faz a Eliminação Gaussiana no sistema e retorna uma nova matriz "U" triangularizada
    public static double[][] gaussianElimination(double[][] A, double[] b) {

        int n = A.length;
        double[][] U = new double[n][n + 1];

        // Junta A e b em uma unica matriz
        for (int i = 0; i < n; i++) {

            for (int j = 0; j < n; j++) {

                U[i][j] = A[i][j];

            }

            U[i][n] = b[i];

        }

        // Triangulariza a matriz
        for (int i = 0; i < n; i++) {

            // Encontra o pivô
            int maxIndex = i;

            for (int j = i + 1; j < n; j++) {

                if (Math.abs(U[j][i]) > Math.abs(U[maxIndex][i])) {

                    maxIndex = j;

                }

            }

            double[] temp = U[i];
            U[i] = U[maxIndex];
            U[maxIndex] = temp;

            for (int j = i + 1; j < n; j++) {

                double factor = U[j][i] / U[i][i];

                for (int k = i; k <= n; k++) {

                    U[j][k] -= factor * U[i][k];

                }

            }

        }

        return U;

    }

    // Resolve o sistema e retorna a solução em um vetor
    public static double[] solveSystem(double[][] U, double[] b) {

        int n = U.length;
        double[] x = new double[n];

        for (int i = n - 1; i >= 0; i--) {

            double sum = 0;

            for (int j = i + 1; j < n; j++) {

                sum += U[i][j] * x[j];

            }

            x[i] = (b[i] - sum) / U[i][i];

        }

        return x;

    }

    // Função para imprimir o sistema
    public static void printSystem(double[][] A, double[] b) {

        int n = A.length;

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < n; j++) {

                System.out.print(A[i][j] + "x[" + j + "]");

                if (j < n - 1) {

                    System.out.print(" + ");

                }

            }

            System.out.println(" = " + b[i]);

        }

        System.out.println();

    }

}