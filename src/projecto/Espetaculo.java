package projecto;
import java.io.Serializable;
import java.util.*;

public class Espetaculo implements Serializable{
    private String nome, local;
    private Data dia;
    private ArrayList <Integer> Realizador, Atores, Staff;
    private Estatistica stats;

    public Espetaculo(String nome, String local, Data dia) {
        this.nome = nome;
        this.local = local;
        this.dia = dia;
        this.Atores=new ArrayList <Integer>();
        this.Realizador=new ArrayList <Integer>();
        this.Staff=new ArrayList <Integer>();
        this.stats=new Estatistica();
    }
    
    public Espetaculo() {
        this.nome = "";
        this.local = "";
        this.dia = new Data();
        this.Atores=new ArrayList <Integer>();
        this.Realizador=new ArrayList <Integer>();
        this.Staff=new ArrayList <Integer>();
        this.stats=new Estatistica();
    }
    
    public Espetaculo(Espetaculo o){
        this.nome=o.getNome();
        this.local=o.getLocal();
        this.dia=o.getDia();
        this.Realizador=o.getRealizador();
        this.Atores=o.getAtores();
        this.Staff=o.getStaff();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public Data getDia() {
        return dia;
    }

    public void setDia(Data dia) {
        this.dia = dia;
    }

    public ArrayList<Integer> getRealizador() {
        return Realizador;
    }

    public void setRealizador(ArrayList<Integer> Realizador) {
        this.Realizador = Realizador;
    }

    public ArrayList<Integer> getAtores() {
        return Atores;
    }

    public void setAtores(ArrayList<Integer> Atores) {
        this.Atores = Atores;
    }

    public ArrayList<Integer> getStaff() {
        return Staff;
    }

    public void setStaff(ArrayList<Integer> Staff) {
        this.Staff = Staff;
    }

    public Estatistica getStats() {
        return stats;
    }

    public void setStats(Estatistica stats) {
        this.stats = stats;
    }
    
    public void printFuncionarios(){
        
    }

    @Override
    public String toString() {
        return "Espetaculo{" + "nome=" + nome + ", local=" + local + ", dia=" + dia;
    }
    
    

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Espetaculo other = (Espetaculo) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.local, other.local)) {
            return false;
        }
        if (!Objects.equals(this.dia, other.dia)) {
            return false;
        }
        if (!Objects.equals(this.Realizador, other.Realizador)) {
            return false;
        }
        if (!Objects.equals(this.Atores, other.Atores)) {
            return false;
        }
        if (!Objects.equals(this.Staff, other.Staff)) {
            return false;
        }
        if(!Objects.equals(this.stats, other.stats)){
            return false;
        }
        return true;
    }
    
    
    
}
