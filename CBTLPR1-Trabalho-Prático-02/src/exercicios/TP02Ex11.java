package exercicios;

import java.util.Scanner;

/*11. Entrar com uma matriz de ordem MxM, onde a ordem também será escolhida pelo usuário,
sendo que no máximo será de ordem 10 e quadrática. Após a digitação dos elementos,
calcular e exibir determinante da matriz.*/

public class TP02Ex11 {
	public static void main(String[] args) {
	    Scanner scanner = new Scanner(System.in);
	    

        int m = 0;
        while (true) {
            System.out.print("Digite a ordem da matriz quadrada M (1 a 10): ");
            if (scanner.hasNextInt()) {
                m = scanner.nextInt();
                if (m >= 1 && m <= 10) break;
                else System.out.println("❌ Erro: a ordem deve estar entre 1 e 10.");
            } else {
                System.out.println("❌ Erro: entrada inválida. Digite um número inteiro.");
                scanner.next();
            }
        }
 
        double[][] matriz = new double[m][m];
 
        System.out.println("\n=== Matriz " + m + "x" + m + " — Digite os valores ===\n");
 
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
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
 
        double det = calcularDeterminante(matriz, m);
 
        System.out.println("\n=== Matriz (" + m + "x" + m + ") ===");
        exibirMatriz(matriz, m);
        System.out.printf("%n=== Determinante: %.4f ===%n", det);
 
        scanner.close();
    }
 
    // Expansão de Laplace (recursivo) — funciona para qualquer ordem até 10
    static double calcularDeterminante(double[][] mat, int n) {
        if (n == 1) return mat[0][0];
        if (n == 2) return mat[0][0] * mat[1][1] - mat[0][1] * mat[1][0];
 
        double det = 0;
        for (int col = 0; col < n; col++) {
            double[][] submatriz = submatriz(mat, 0, col, n);
            det += Math.pow(-1, col) * mat[0][col] * calcularDeterminante(submatriz, n - 1);
        }
        return det;
    }
 
    static double[][] submatriz(double[][] mat, int excluiLinha, int excuiColuna, int n) {
        double[][] sub = new double[n - 1][n - 1];
        int linhaIdx = 0;
        for (int i = 0; i < n; i++) {
            if (i == excluiLinha) continue;
            int colIdx = 0;
            for (int j = 0; j < n; j++) {
                if (j == excuiColuna) continue;
                sub[linhaIdx][colIdx++] = mat[i][j];
            }
            linhaIdx++;
        }
        return sub;
    }
 
    static void exibirMatriz(double[][] m, int ordem) {
        for (int i = 0; i < ordem; i++) {
            System.out.print("| ");
            for (int j = 0; j < ordem; j++) {
                System.out.printf("%10.4f ", m[i][j]);
            }
            System.out.println("|");
        }
    }
}
