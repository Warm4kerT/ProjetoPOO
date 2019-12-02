
package projecto;
import java.io.Serializable;

public class Contador implements Serializable {
    private int conta;
    
    public Contador(){
        conta=0;
    }
    
    public Contador(int conta){
        this.conta=conta;
    }
    
    public int getConta(){
        return conta;
    }
    
    public void incConta(){
        conta++;
    }
    
    public void incConta(int inc){
        conta=conta+inc;
    }
    
    public void decConta(){
        conta--;
    }
    
    public void decConta(int dec){
        conta=conta-dec;
    }
    
    @Override
    public String toString(){
        return ("Contador: "+conta);
    }
}

