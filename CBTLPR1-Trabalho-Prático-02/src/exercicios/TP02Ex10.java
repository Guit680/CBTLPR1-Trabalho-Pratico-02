package exercicios;

import java.util.Scanner;

/*10. Entrar com uma matriz de ordem MxM, onde a ordem também será escolhida pelo usuário,
sendo que no máximo será de ordem 10 e quadrática. Após a digitação dos elementos,
calcular e exibir a matriz inversa. Exibir as matrizes na tela, sob a forma matricial (linhas x
colunas).*/

public class TP02Ex10 {
	public static void main(String[] args) {
	    Scanner scanner = new Scanner(System.in);

        // --- Leitura da ordem M ---
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
 
        // --- Cálculo da inversa por Gauss-Jordan ---
        double[][] inversa = calcularInversa(matriz, m);
 
        System.out.println("\n=== Matriz Original (" + m + "x" + m + ") ===");
        exibirMatriz(matriz, m);
 
        if (inversa == null) {
            System.out.println("\n❌ A matriz não possui inversa (determinante = 0).");
        } else {
            System.out.println("\n=== Matriz Inversa (" + m + "x" + m + ") ===");
            exibirMatriz(inversa, m);
        }
 
        scanner.close();
    }
 
    static double[][] calcularInversa(double[][] original, int m) {
        // Copiar matriz e criar identidade aumentada [A | I]
        double[][] aug = new double[m][2 * m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++)
                aug[i][j] = original[i][j];
            aug[i][i + m] = 1.0; // identidade
        }
 
        // Eliminação de Gauss-Jordan
        for (int col = 0; col < m; col++) {
            // Encontrar pivô
            int pivotRow = -1;
            for (int row = col; row < m; row++) {
                if (Math.abs(aug[row][col]) > 1e-9) { pivotRow = row; break; }
            }
            if (pivotRow == -1) return null; // singular
 
            // Trocar linhas
            double[] tmp = aug[col]; aug[col] = aug[pivotRow]; aug[pivotRow] = tmp;
 
            // Normalizar linha do pivô
            double pivo = aug[col][col];
            for (int j = 0; j < 2 * m; j++) aug[col][j] /= pivo;
 
            // Zerar coluna nas outras linhas
            for (int row = 0; row < m; row++) {
                if (row == col) continue;
                double fator = aug[row][col];
                for (int j = 0; j < 2 * m; j++)
                    aug[row][j] -= fator * aug[col][j];
            }
        }
 
        // Extrair a inversa
        double[][] inversa = new double[m][m];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < m; j++)
                inversa[i][j] = aug[i][j + m];
        return inversa;
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
