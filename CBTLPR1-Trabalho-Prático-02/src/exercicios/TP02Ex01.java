package exercicios;
import java.util.Scanner;

/*Entrar com dois valores via teclado, onde o segundo valor deverá ser maior que o primeiro. 
Caso contrário solicitar novamente apenas o segundo valor.*/

public class TP02Ex01 {
	public static void main(String[] args) {
	    Scanner scanner = new Scanner(System.in);
	    
	    double V1,V2;
	    
	    do
	    {
		    System.out.println("Insira o primeiro valor:");
		    V1 = scanner.nextDouble();
		    System.out.println("Insira o segundo valor:");
		    V2 = scanner.nextDouble();
	    	System.out.println("");
		    if (V1>V2) {
		    	System.out.println("Erro: O 1º valor deve ser menor que o 2º valor");
		    	System.out.println("");
		    }
	    }
	    while (V1>V2); 
	    scanner.close();
	  }
}
