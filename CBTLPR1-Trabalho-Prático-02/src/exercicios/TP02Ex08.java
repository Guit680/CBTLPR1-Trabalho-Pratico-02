package exercicios;
import java.util.Scanner;

/*8. Entrar via teclado com doze valores e armazená-los em uma matriz de ordem 3x4. Após a
digitação dos valores solicitar uma constante multiplicativa, que deverá multiplicar cada
valor matriz e armazenar o resultado em outra matriz de mesma ordem, nas posições
correspondentes. Exibir as matrizes na tela, sob a forma matricial, ou seja, linhas por
colunas.*/

public class TP02Ex08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[][] matrizA = new double[3][4];
        double[][] matrizB = new double[3][4];

        System.out.println("=== Matriz 3x4 — Digite 12 valores ===\n");

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                while (true) {
                    System.out.print("Elemento [" + i + "][" + j + "]: ");
                    if (scanner.hasNextDouble()) {
                        matrizA[i][j] = scanner.nextDouble();
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

        // --- Multiplicação em nova matriz ---
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 4; j++)
                matrizB[i][j] = matrizA[i][j] * constante;

        // --- Exibição das duas matrizes ---
        System.out.println("\n=== Matriz Original (A) 3x4 ===");
        exibirMatriz(matrizA, 3, 4);

        System.out.println("\n=== Matriz Resultado (B = A × " + constante + ") 3x4 ===");
        exibirMatriz(matrizB, 3, 4);

        scanner.close();
    }

    static void exibirMatriz(double[][] m, int linhas, int colunas) {
        for (int i = 0; i < linhas; i++) {
            System.out.print("| ");
            for (int j = 0; j < colunas; j++) {
                System.out.printf("%10.2f ", m[i][j]);
            }
            System.out.println("|");
        }
    }
}
