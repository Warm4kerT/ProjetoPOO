
package projecto;
import myinputs.*;
import java.util.*;
import java.io.*;

public class Projecto {
    public static Data novaData(){
        System.out.println("Insira a data por ordem Dia/Mes/Ano");
        Data d=new Data(Ler.umInt(),Ler.umInt(),Ler.umInt());
        return d;
    }
    
    public static int searchID(ArrayList <Pessoa> lista, int id){
        int i=0;
        while(lista.get(i).getId()!=id){
            ++i;
        }
        return i;
    }

    public static void main(String[] args) {
        ArrayList <Pessoa> funcionarios=new ArrayList <Pessoa>();
        int v=0,v1=0,v2=0,v3=0,v4=0,v5=0, contaID;
        
        try{
           ObjectInputStream is=new ObjectInputStream(new FileInputStream("./Pessoas.dat"));
           funcionarios= (ArrayList <Pessoa>) is.readObject();
           contaID=(funcionarios.get(funcionarios.size()-1).getId());
        }catch(IOException | ClassNotFoundException e){
            System.out.println(e.getMessage());
            contaID=0;
        }
        
        
        
        while(v!=3){
            System.out.println("Gestor Teatro");
            System.out.println("1 - Funcionários\n2 - Espetáculos\n3 - Exit");
            v=Ler.umInt();
            switch(v){
                case 1:
                    while(v1!=5){
                        System.out.println("1 - Consultar Funcionários\n2 - Modificar Funcionários\n3 - Adicionar Funcioário\n4 - Eliminar Funcionário\n5 - Exit");
                        v1=Ler.umInt();
                        switch(v1){
                            case 1:
                                while(v2!=5){
                                    System.out.println("1 - Todos os Funcionários\n2 - Atores\n3 - Staff\n4 - Realizadores\n5 - Exit");
                                    v2=Ler.umInt();
                                    switch(v2){
                                        case 1:
                                            for (Pessoa aux : funcionarios) {
                                                System.out.println(aux.toString());
                                            }
                                        break;
                                        case 2:
                                            for (Pessoa aux : funcionarios) {
                                                if("Ator".equalsIgnoreCase(aux.getFuncao()))
                                                    System.out.println(aux.toString());
                                            }
                                        break;
                                        case 3:
                                            for (Pessoa aux : funcionarios) {
                                                if("Staff".equalsIgnoreCase(aux.getFuncao()))
                                                    System.out.println(aux.toString());
                                            }
                                        break;
                                        case 4:
                                            for (Pessoa aux : funcionarios) {
                                                if("Realizador".equalsIgnoreCase(aux.getFuncao()))
                                                    System.out.println(aux.toString());
                                            }
                                        break;
                                    }
                                }
                                v2=0;
                            break;
                            case 2:
                                while(v3!=6){
                                    System.out.println("1 - Nome\n2 - Idade\n3 - Salario\n4 - Data Contrato\n5 - Função\n6 - Exit");
                                    v3=Ler.umInt();
                                    int aux=0,valida=0;
                                    switch(v3){
                                        case 1:
                                            System.out.println("Insira o ID do Funcionário:");
                                            aux=searchID(funcionarios,Ler.umInt());
                                            System.out.println("É este o Funcionário a modificar?\n"+funcionarios.get(aux).toString()+"\n1 - Sim\n2 - Não");
                                            valida=Ler.umInt();
                                            if(valida==1){
                                                System.out.println("Novo nome");
                                                funcionarios.get(aux).setNome(Ler.umaString());
                                            }
                                        break;
                                        case 2:
                                            System.out.println("Insira o ID do Funcionário:");
                                            aux=searchID(funcionarios,Ler.umInt());
                                            System.out.println("É este o Funcionário a modificar?\n"+funcionarios.get(aux).toString()+"\n1 - Sim\n2 - Não");
                                            valida=Ler.umInt();
                                            if(valida==1){
                                                System.out.println("Novo Idade");
                                                funcionarios.get(aux).setIdade(Ler.umInt());
                                            }
                                        break;
                                        case 3:
                                            System.out.println("Insira o ID do Funcionário:");
                                            aux=searchID(funcionarios,Ler.umInt());
                                            System.out.println("É este o Funcionário a modificar?\n"+funcionarios.get(aux).toString()+"\n1 - Sim\n2 - Não");
                                            valida=Ler.umInt();
                                            if(valida==1){
                                                System.out.println("Novo Salario");
                                                funcionarios.get(aux).setSalario(Ler.umDouble());
                                            }
                                        break;
                                        case 4:
                                            System.out.println("Insira o ID do Funcionário:");
                                            aux=searchID(funcionarios,Ler.umInt());
                                            System.out.println("É este o Funcionário a modificar?\n"+funcionarios.get(aux).toString()+"\n1 - Sim\n2 - Não");
                                            valida=Ler.umInt();
                                            if(valida==1){
                                                System.out.println("Nova Data de Contrato");
                                                funcionarios.get(aux).setContrato(novaData());
                                            }
                                        break;
                                        case 5:
                                            System.out.println("Insira o ID do Funcionário:");
                                            aux=searchID(funcionarios,Ler.umInt());
                                            System.out.println("É este o Funcionário a modificar?\n"+funcionarios.get(aux).toString()+"\n1 - Sim\n2 - Não");
                                            valida=Ler.umInt();
                                            if(valida==1){
                                                System.out.println("Nova Função");
                                                System.out.println("1 - Ator\t2 - Realizador\t3 - Staff");
                                                int f=Ler.umInt();
                                                switch(f){
                                                    case 1:
                                                        funcionarios.get(aux).setFuncao("Ator");
                                                    break;
                                                    case 2:
                                                        funcionarios.get(aux).setFuncao("Realizador");
                                                    break;
                                                    case 3:
                                                        funcionarios.get(aux).setFuncao("Staff");
                                                    break;
                                                }
                                                f=0;
                                            }
                                        break;
                                    }
                                    valida=0;aux=0;
                                }
                                v3=0;
                            break;
                            case 3:
                                Pessoa nova=new Pessoa();
                                ++contaID;
                                nova.setId(contaID);
                                System.out.println("Insira o Nome");
                                nova.setNome(Ler.umaString());
                                System.out.println("Insira a Idade");
                                nova.setIdade(Ler.umInt());
                                System.out.println("Insira o Salario");
                                nova.setSalario(Ler.umDouble());
                                System.out.println("Insira a Data de Contrato");
                                nova.setContrato(novaData());
                                System.out.println("Escolha a Função");
                                System.out.println("1 - Ator\t2 - Realizador\t3 - Staff");
                                int f=Ler.umInt();
                                switch(f){
                                case 1:
                                    nova.setFuncao("Ator");
                                break;
                                case 2:
                                    nova.setFuncao("Realizador");
                                break;
                                case 3:
                                    nova.setFuncao("Staff");
                                break;
                                }
                                f=0;
                                funcionarios.add(nova);
                                System.out.println("Done.");
                            break;
                            case 4:
                                System.out.println("Insira o ID do Funcionario a eliminar");
                                int aux=searchID(funcionarios,Ler.umInt());
                                System.out.println("É este o Funcionário a modificar?\n"+funcionarios.get(aux).toString()+"\n1 - Sim\n2 - Não");
                                int valida=Ler.umInt();
                                if(valida==1){
                                    funcionarios.remove(aux);
                                }
                            break;
                        }
                    }
                    v1=0;
                break;
                
                case 2:
                break;
            }
        }
        
        try{
            ObjectOutputStream os=new ObjectOutputStream(new FileOutputStream("./Pessoas.dat"));
                os.writeObject(funcionarios);
            os.flush();
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
    
}
