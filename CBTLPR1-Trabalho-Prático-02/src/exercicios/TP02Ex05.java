package exercicios;

import java.util.Scanner;

/*5. Armazenar seis valores em uma matriz de ordem 3x2. Apresentar os valores na tela.*/

public class TP02Ex05 {
	public static void main(String[] args) {
	    Scanner scanner = new Scanner(System.in);
	    double[][] matriz = new double[3][2];
	    
        System.out.println("=== Matriz 3x2 — Digite 6 valores ===\n");
 
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 2; j++) {
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
 
        System.out.println("\n=== Exibição da Matriz 3x2 ===");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 2; j++) {
                System.out.printf("%8.2f ", matriz[i][j]);
            }
            System.out.println("|");
        }
 
        scanner.close();
    }
}
