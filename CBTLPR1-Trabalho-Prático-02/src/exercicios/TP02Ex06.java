package exercicios;

import java.util.Scanner;

/*6. Armazenar seis nomes em uma matriz de ordem 2x3. Apresentar os nomes na tela.*/

public class TP02Ex06 {
	public static void main(String[] args) {
	    Scanner scanner = new Scanner(System.in);
        String[][] matriz = new String[2][3];
        
        System.out.println("=== Matriz 2x3 — Digite 6 nomes ===\n");
 
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print("Nome [" + i + "][" + j + "]: ");
                matriz[i][j] = scanner.next();
            }
        }
 
        System.out.println("\n=== Exibição da Matriz 2x3 de Nomes ===");
        for (int i = 0; i < 2; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.printf("%-15s ", matriz[i][j]);
            }
            System.out.println("|");
        }
 
        scanner.close();
    }
}
