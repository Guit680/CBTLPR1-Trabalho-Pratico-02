package exercicios;

import java.util.Scanner;

/*7. Entrar via teclado com doze valores e armazená-los em uma matriz de ordem 3x4. Após a
digitação dos valores solicitar uma constante multiplicativa, que deverá multiplicar cada
valor matriz e armazenar o resultado na própria matriz, nas posições correspondentes.*/

public class TP02Ex07 {
	public static void main(String[] args) {
	    Scanner scanner = new Scanner(System.in);
        double[][] matriz = new double[3][4];
        
        System.out.println("=== Matriz 3x4 — Digite 12 valores ===\n");
 
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                while (true) {
                    System.out.print("Elemento [" + i + "][" + j + "]: ");
                    if (scanner.hasNextDouble()) {
                        matriz[i][j] = scanner.nextDouble();
                        break;
                    } else {
                        System.out.println("❌ Erro: entrada inválida. Digite um número.");
                        scanner.next();
                    }
                }
            }
        }
 
        // --- Leitura da constante multiplicativa ---
        double constante = 0;
        while (true) {
            System.out.print("\nDigite a constante multiplicativa: ");
            if (scanner.hasNextDouble()) {
                constante = scanner.nextDouble();
                break;
            } else {
                System.out.println("❌ Erro: entrada inválida. Digite um número.");
                scanner.next();
            }
        }
 
        // --- Multiplicação na própria matriz ---
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 4; j++)
                matriz[i][j] *= constante;
 
        // --- Exibição ---
        System.out.println("\n=== Matriz 3x4 após multiplicação por " + constante + " ===");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 4; j++) {
                System.out.printf("%10.2f ", matriz[i][j]);
            }
            System.out.println("|");
        }
 
        scanner.close();
    }
}
