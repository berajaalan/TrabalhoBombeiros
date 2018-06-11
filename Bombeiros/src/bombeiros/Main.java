/*
    Alunos:
      Alan Garcia Beraja
      Janaina de Araujo Silva
*/

package bombeiros;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        
        Scanner input = new Scanner(System.in);
        
        System.out.println("Defina o nome do mapa: (É necessário que o arquivo esteja na raiz do projeto)");
        
        Mapa m = new Mapa(input.next()); //Cria um novo mapa
    }
    
}
