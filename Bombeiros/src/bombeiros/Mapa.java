package bombeiros;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

class Mapa {
    
    String path = System.getProperty("user.dir") + "\\mapa.txt";
    Digraph mapa;
    
    Mapa () throws FileNotFoundException, IOException{
        
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
            
            // Mensagens de erro igualdade
            if (x == y) {
                System.out.println("Linha " + ln +", Par " + x + "," + y + ": x deve ser diferente do y.");
            }
            
            for (int i = 0; i < mapa.length; i++) {
                
                // Mensagem de erro forma ciclo
                if (i == y-1) {
                    while(mapa[i].getProx() != null){
                        if (mapa[i].getElem() == x) {
                            System.out.println("Linha " + ln +", Par " + x + "," + y + ": forma ciclo.");
                            ciclo = true;
                        }
                    }
                }
                
                // Mensagem de erro já inserido
                if (i == x-1) {
                    while(mapa[i].getProx() != null){
                        if (mapa[i].getElem() == y) {
                            System.out.println("Linha " + ln +", Par " + x + "," + y + ": já inserido.");
                            ins = true;
                        }
                    }
                } 
            }
            
            // Definir conexoes
            if (x != y && !ciclo && !ins) {
                if (ln == 1) {
                    mapa[x-1] = new No(y,null);
                }else{
                    while (true){
                        No 
                        if () {
                            
                        }
                    }
                }
            }
            
            // Define linha atual do arquivo
            ln ++;
        }
        
    }
    
}
