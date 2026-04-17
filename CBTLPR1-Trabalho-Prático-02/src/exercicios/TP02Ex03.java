package exercicios;

import java.util.Scanner;

/*3. Entrar via teclado com “N” valores quaisquer. O valor “N” (que representa a quantidade de
números) será digitado, deverá ser positivo, porém menor que vinte. Caso a quantidade não
satisfaça a restrição, enviar mensagem de erro e solicitar o valor novamente. Após a
digitação dos “N” valores, exibir:
a. O maior valor;
b. O menor valor;
c. A soma dos valores;
d. A média aritmética dos valores;
e. A porcentagem de valores que são positivos;
f. A porcentagem de valores negativos;
Após exibir os dados, perguntar ao usuário de deseja ou não uma nova execução do
programa. Consistir a resposta no sentido de aceitar somente “S” ou “N” e encerrar o
programa em função dessa resposta.
*/

public class TP02Ex03 {
	public static void main(String[] args) {
	    Scanner scanner = new Scanner(System.in);
		String continuar = "S";
 
        while (continuar.equals("S")) {
 
            // --- Leitura e consistência de N ---
            int n = 0;
            while (true) {
                System.out.print("Digite a quantidade de valores N (positivo e menor que 20): ");
                if (scanner.hasNextInt()) {
                    n = scanner.nextInt();
                    if (n > 0 && n < 20) break;
                    else System.out.println("❌ Erro: N deve ser positivo e menor que 20. Tente novamente.");
                } else {
                    System.out.println("❌ Erro: entrada inválida. Digite um número inteiro.");
                    scanner.next();
                }
            }
 
            double[] valores = new double[n];
            System.out.println("\n=== Digite " + n + " valores ===\n");
 
            for (int i = 0; i < n; i++) {
                while (true) {
                    System.out.print("Valor " + (i + 1) + ": ");
                    if (scanner.hasNextDouble()) {
                        valores[i] = scanner.nextDouble();
                        break;
                    } else {
                        System.out.println("❌ Erro: entrada inválida. Digite um número.");
                        scanner.next();
                    }
                }
            }
 
            // --- Cálculos ---
            double maior = valores[0];
            double menor = valores[0];
            double soma  = 0;
            int positivos = 0;
            int negativos = 0;
 
            for (double v : valores) {
                if (v > maior) maior = v;
                if (v < menor) menor = v;
                soma += v;
                if (v > 0) positivos++;
                else if (v < 0) negativos++;
            }
 
            double media       = soma / n;
            double pctPositivo = (positivos * 100.0) / n;
            double pctNegativo = (negativos * 100.0) / n;
 
            // --- Resultados ---
            System.out.println("\n========= RESULTADOS =========");
            System.out.printf("Maior valor     : %.2f%n",   maior);
            System.out.printf("Menor valor     : %.2f%n",   menor);
            System.out.printf("Soma            : %.2f%n",   soma);
            System.out.printf("Média           : %.2f%n",   media);
            System.out.printf("%% Positivos     : %.2f%%%n", pctPositivo);
            System.out.printf("%% Negativos     : %.2f%%%n", pctNegativo);
            System.out.println("==============================\n");
 
            // --- Pergunta de nova execução ---
            while (true) {
                System.out.print("Deseja nova execução? (S/N): ");
                continuar = scanner.next().toUpperCase();
                if (continuar.equals("S") || continuar.equals("N")) break;
                else System.out.println("❌ Erro: resposta inválida. Digite apenas S ou N.");
            }
            System.out.println();
        }
 
        System.out.println("Programa encerrado.");
        scanner.close();
	}
}
