package exercicios;
import java.util.Scanner;

/*2. Entrar via teclado com dez valores positivos. Consistir a digitação e enviar mensagem de
erro, se necessário. Após a digitação, exibir:

a. O maior valor;
b. A soma dos valores;
c. A média aritmética dos valores.*/

public class TP02Ex02 {
	public static void main(String[] args) {
	    Scanner scanner = new Scanner(System.in);
	    double[] valores1 = new double[10];

        System.out.println("=== Digite 10 valores positivos ===\n");

        for (int i = 0; i < 10; i++) {
            while (true) {
                System.out.print("Valor " + (i + 1) + ": ");
                
                if (scanner.hasNextDouble()) {
                    double v = scanner.nextDouble();
                    if (v > 0) {
                        valores1[i] = v;
                        break;
                    } else {
                        System.out.println("❌ Erro: o valor deve ser positivo (maior que zero). Tente novamente.");
                    }
                } else {
                    System.out.println("❌ Erro: entrada inválida. Digite um número. Tente novamente.");
                    scanner.next(); // descarta o token inválido
                }
            }
        }

        // --- Cálculos ---
        double maior = valores1[0];
        double soma  = 0;

        for (double v : valores1) {
            if (v > maior) maior = v;
            soma += v;
        }

        double media = soma / 10;

        // --- Resultados ---
        System.out.println("\n========= RESULTADOS =========");
        System.out.println("Maior valor : " + maior);
        System.out.printf ("Soma        : %.2f%n", soma);
        System.out.printf ("Média       : %.2f%n", media);
        System.out.println("==============================");

        scanner.close();
	}
}
