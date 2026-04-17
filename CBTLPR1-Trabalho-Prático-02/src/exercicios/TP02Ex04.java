package exercicios;
import java.util.Scanner;

/*4. Armazenar seis valores em uma matriz de ordem 2x3. Apresentar os valores na tela.*/

public class TP02Ex04 {
	public static void main(String[] args) {
	    Scanner scanner = new Scanner(System.in);
	    double[][] matriz = new double[2][3];
 
        System.out.println("=== Matriz 2x3 — Digite 6 valores ===\n");
 
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
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
 
        System.out.println("\n=== Exibição da Matriz 2x3 ===");
        for (int i = 0; i < 2; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.printf("%8.2f ", matriz[i][j]);
            }
            System.out.println("|");
        }
 
        scanner.close();
    }
}
