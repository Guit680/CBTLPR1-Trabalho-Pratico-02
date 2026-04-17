package exercicios;

import java.util.Scanner;

/*9. Entrar com uma matriz de ordem MxN, onde a ordem também será escolhida pelo usuário,
sendo que no máximo 10x10. A matriz não precisa ser quadrática. Após a digitação dos
elementos, calcular e exibir a matriz transposta.*/

public class TP02Ex09 {
	public static void main(String[] args) {
	    Scanner scanner = new Scanner(System.in);

	    
        int m = lerDimensao(scanner, "linhas (M)");
        int n = lerDimensao(scanner, "colunas (N)");
 
        double[][] matriz    = new double[m][n];
        double[][] transposta = new double[n][m];
 
        System.out.println("\n=== Matriz " + m + "x" + n + " — Digite os valores ===\n");
 
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
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
 
        // --- Cálculo da transposta ---
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                transposta[j][i] = matriz[i][j];
 
        // --- Exibição ---
        System.out.println("\n=== Matriz Original (" + m + "x" + n + ") ===");
        exibirMatriz(matriz, m, n);
 
        System.out.println("\n=== Matriz Transposta (" + n + "x" + m + ") ===");
        exibirMatriz(transposta, n, m);
 
        scanner.close();
    }
 
    static int lerDimensao(Scanner scanner, String nome) {
        int val = 0;
        while (true) {
            System.out.print("Digite o número de " + nome + " (1 a 10): ");
            if (scanner.hasNextInt()) {
                val = scanner.nextInt();
                if (val >= 1 && val <= 10) break;
                else System.out.println("❌ Erro: o valor deve estar entre 1 e 10.");
            } else {
                System.out.println("❌ Erro: entrada inválida. Digite um número inteiro.");
                scanner.next();
            }
        }
        return val;
    }
 
    static void exibirMatriz(double[][] m, int linhas, int colunas) {
        for (int i = 0; i < linhas; i++) {
            System.out.print("| ");
            for (int j = 0; j < colunas; j++) {
                System.out.printf("%8.2f ", m[i][j]);
            }
            System.out.println("|");
        }
    }
}
