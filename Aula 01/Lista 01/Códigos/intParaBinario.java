import java.util.Scanner;

public class intParaBinario {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Insira um número decimal inteiro: ");
        int decimal = scanner.nextInt();
        String binario = "";
        
        while (decimal > 0) {

            int resto = decimal % 2;
            binario = resto + binario;
            decimal = decimal / 2;

        }

        System.out.println("O número inserido em binário é: " + binario);
        scanner.close();

    }

}
