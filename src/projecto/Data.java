
package projecto;
import java.io.Serializable;
public class Data implements Serializable{
    int dia, mes, ano;

    public Data(){
        this.dia=0;
        this.mes=0;
        this.ano=0;
    }

    public Data(int dia, int mes, int ano) throws DataErrada {
        if(dia<=31 && 1<=dia){
            this.dia = dia;
        }else{
            throw new DataErrada("O dia tem de ser entre 1 e 31!!");
        }
        if(mes<=12 && 1<=mes){
            this.mes = mes;
        }else{
            throw new DataErrada("O mes tem de ser entre 1 e 12!!!");
        }
        if(((int)(Math.log10(ano) + 1))==4){
            this.ano = ano;
        }else{
            throw new DataErrada("O ano tem de ter 4 algarismos!!!");
        }
        
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia)throws DataErrada {
        if(dia<=31 && 1<=dia){
            this.dia = dia;
        }else{
            throw new DataErrada("O dia tem de ser entre 1 e 31!!");
        }
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes)throws DataErrada {
        if(mes<=12 && 1<=mes){
            this.mes = mes;
        }else{
            throw new DataErrada("O mes tem de ser entre 1 e 12!!!");
        }
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano)throws DataErrada{
        if(((int)(Math.log10(ano) + 1))==4){
            this.ano = ano;
        }else{
            throw new DataErrada("O ano tem de ter 4 algarismos!!!");
        }
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
