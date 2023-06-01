import java.util.Scanner;

public class binarioParaDecimal {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Insira um número binário: ");
        String binario = scanner.nextLine();
        int decimal = 0;

        for (int i = binario.length() - 1, j = 0; i >= 0; i--, j++) {

            if (binario.charAt(i) == '1') {

                decimal += Math.pow(2, j);

            }

        }

        System.out.println("O número inserido em decimal é: " + decimal);
        scanner.close();

    }

}