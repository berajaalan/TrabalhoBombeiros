package bombeiros;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Mapa {
    
    private String path = System.getProperty("user.dir") + "\\mapa.txt";
    private Digraph mapa;
    
    public Mapa () throws FileNotFoundException, IOException{
        
        FileReader fr = new FileReader(path);
        BufferedReader br = new BufferedReader(fr);
        
        int ln = 2;//indice - utilizado para indicar linha
        mapa = new Digraph(Integer.parseInt(br.readLine())); //convertendo a primeira linha para Inteiro
        
        while(true){
            
            // Definir variaveis
            String l[] = br.readLine().split(" "); //vetor do tipo String iguinorando a separação
            int x = Integer.parseInt(l[0]), //Converter a posição x e y para inteiro
                y = Integer.parseInt(l[1]);
            boolean ciclo = false, ins = false; //ins- Inserido
            
            System.out.println("X:" + x + " Y:" + y);
            
            // Condição de parada
            // Condição de parada para o final do arquivo 0 0
            if (x == 0 && y == 0) {
                System.out.println("--------------------------------------------");
                System.out.println("Leitura do mapa completa");
                break;
            }
            
            // Mensagens de erro
            
            // Igual
            if (x == y) {
                System.out.println("Linha " + ln +", Par " + x + "," + y + ": x deve ser diferente de y.");
            }
            
            // Ja inserido
            else if (mapa.buscaArco(x-1, y-1)) {
                System.out.println("Linha " + ln +", Par " + x + "," + y + ": arco já inserido");
                ins = true;
            }
            
            // Ciclo
            else if (mapa.buscaCiclo(x-1, y-1)) {
                System.out.println("Linha " + ln +", Par " + x + "," + y + ": forma ciclo");
                ciclo = true;
            }
            
            // Adicionar Arcos
            if (x != y && !ciclo && !ins) {
                mapa.insereArco(x-1, y-1);
            }
            
            // Define linha atual do arquivo
            System.out.println(ln);
            ln ++;
        }
        
        mapa.mostra();
        
    }
    
}
