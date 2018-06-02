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
        
        mapa = new Digraph(Integer.parseInt(br.readLine()));
        int ln = 1;
        
        while(true){
            
            // Definir variaveis
            String l[] = br.readLine().split(" ");
            int x = Integer.parseInt(l[0]),
                y = Integer.parseInt(l[1]);
            boolean ciclo = false, ins = false;
            
            // Condição de parada
            if (x == 0 && y == 0) {
                break;
            }
            
            // Mensagens de erro
            
            // Igual
            if (x == y) {
                System.out.println("Linha " + ln +", Par " + x + "," + y + ": x deve ser diferente do y.");
            }
            
            // Ciclo
            if (mapa.buscaArco(y, x)) {
                System.out.println("Linha " + ln +", Par " + x + "," + y + ": forma ciclo");
                ciclo = true;
            }
            
            // Ja inserido
            if (mapa.buscaArco(x, y)) {
                System.out.println("Linha " + ln +", Par " + x + "," + y + ": arco já inserido");
                ins = true;
            }
            
            // Adicionar Arcos
            if (x != y && !ciclo && !ins) {
                mapa.insereArco(x, y);
            }
            
            // Define linha atual do arquivo
            ln ++;
        }
    }
    
    public void findPaths(){
        
    }
    
}
