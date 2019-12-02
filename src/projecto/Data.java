
package projecto;
import java.io.Serializable;
public class Data implements Serializable{
    int dia, mes, ano;

    public Data(){
        this.dia=0;
        this.mes=0;
        this.ano=0;
    }

    public Data(int dia, int mes, int ano) {
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    @Override
    public String toString() {
        return "Data{" + "dia=" + dia + ", mes=" + mes + ", ano=" + ano + '}';
    }
    
    @Override
    public boolean equals(Object o){
        if(o!=null && this.getClass()==o.getClass()){
            Data x =(Data) o;
            return (x.ano==this.ano)&&(this.dia==x.dia)&&(this.mes==x.mes);
        }
        return false;
    } 
    
    @Override
    public Object clone(){
        Data clone=new Data();
        clone.dia=this.dia;
        clone.mes=this.mes;
        clone.ano=this.ano;
        return clone;
    }
    
    
}
