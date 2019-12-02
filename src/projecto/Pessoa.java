
package projecto;
import java.io.Serializable;

public class Pessoa implements Serializable {
    private String nome, funcao;
    private int idade, id;
    private double salario;
    private Data contrato;

    public Pessoa(int id, String nome, String funcao, int idade, double salario, Data contrato) {
        this.id=id;
        this.nome = nome;
        this.funcao = funcao;
        this.idade = idade;
        this.salario = salario;
        this.contrato = contrato;
    }
    
    public Pessoa(){
        this.id=0;
        this.nome = "";
        this.funcao = "";
        this.idade = 0;
        this.salario = 0.0;
        this.contrato = new Data();
    }
    
    public int getId(){
        return this.id;
    }
    
    public void setId(int id){
        this.id=(id);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public Data getContrato() {
        return contrato;
    }

    public void setContrato(Data contrato) {
        this.contrato = contrato;
    }

    @Override
    public String toString() {
        return "Pessoa{" +"ID=" + id + " nome=" + nome + ", funcao=" + funcao + ", idade=" + idade + ", salario=" + salario + ", contrato=" + contrato.toString() + '}';
    }
    
    @Override
    public boolean equals(Object o){
        if(o!=null && this.getClass()==o.getClass()){
            Pessoa x =(Pessoa) o;
            return (x.id==this.id)&&(x.nome.equals(this.nome))&&(this.funcao.equals(x.funcao))&&(this.idade==x.idade)&&(this.salario==x.salario)&&(this.contrato.equals(x.contrato));
        }
        return false;
    } 
    
    @Override
    public Object clone(){
        Pessoa clone=new Pessoa(this.id, this.nome, this.funcao, this.idade, this.salario, this.contrato);
        return clone;
    }
    
}
