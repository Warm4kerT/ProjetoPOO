
package projecto;
import java.util.*;
import java.io.*;

public class Projecto {
    public static Data novaData(){
        System.out.println("Insira a data por ordem Dia/Mes/Ano");
        try{
            Data d=new Data();
            d.setDia(ler.umInt());
            d.setMes(ler.umInt());
            d.setAno(ler.umInt());
            return d;
        }catch(DataErrada e){
            System.out.println(e.getMessage());
            return novaData();
        }
    }
    
    public static int searchID(ArrayList <Pessoa> lista, int id){
        int i=0;
        for(Pessoa aux:lista){
            if(aux.getId()==id){
                return i;
            }
            ++i;
        }
        if(i==lista.size()){
            System.out.println("ID Inexistente!!");
            return searchID(lista,ler.umInt());
        }
        return 0;
    }
    
    public static int searchEsp(ArrayList <Espetaculo> lista, String nome){
        int i=0;
        for(Espetaculo aux:lista){
            if(aux.getNome().equalsIgnoreCase(nome)){
                return i;
            }
            ++i;
        }
        if(i==lista.size()){
            System.out.println("Espetáculo Inexistente!!");
            return searchEsp(lista,ler.umaString());
        }
        return 0;
    }
    
    public static int searchInt(ArrayList <Integer> lista, int id){
        int i=0;
        for(int aux:lista){
            if(aux==id){
                return i;
            }
            ++i;
        }
        if(i==lista.size()){
            System.out.println("ID Inexistente neste Espetáculo!!");
            return searchInt(lista,ler.umInt());
        }
        return 0;
    }
    
    public static void printID(Espetaculo a,ArrayList <Pessoa> array){
        int v;
        System.out.println("Realizadores:");
        for(int aux:a.getRealizador()){
            v=searchID(array,aux);
            System.out.println(array.get(v).getNome());
        }
        System.out.println("Atores:");
        for(int aux:a.getAtores()){
            v=searchID(array,aux);
            System.out.println(array.get(v).getNome());
        }
        System.out.println("Staff:");
        for(int aux:a.getStaff()){
            v=searchID(array,aux);
            System.out.println(array.get(v).getNome());
        }
    }

    public static void main(String[] args) {
        ArrayList <Pessoa> funcionarios=new ArrayList <Pessoa>();
        ArrayList <Espetaculo> espetaculos=new ArrayList <Espetaculo>();
        int v=0,v1=0,v2=0,v3=0,v4=0,v5=0,v6=0,v7=0,v8=0,v9=0, contaID;
        
        try{
           ObjectInputStream is=new ObjectInputStream(new FileInputStream("./Pessoas.dat"));
           funcionarios= (ArrayList <Pessoa>) is.readObject();
           contaID=(funcionarios.get(funcionarios.size()-1).getId());
        }catch(IOException | ClassNotFoundException e){
            System.out.println(e.getMessage());
            contaID=0;
        }
        
        try{
            ObjectInputStream is=new ObjectInputStream(new FileInputStream("./Espetaculo.dat"));
            espetaculos= (ArrayList <Espetaculo>) is.readObject();
        }catch(IOException | ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
        
        
        
        while(v!=3){
            System.out.println("Gestor Teatro");
            System.out.println("1 - Funcionários\n2 - Espetáculos\n3 - Exit");
            v=ler.umInt();
            switch(v){
                case 1:
                    while(v1!=5){
                        System.out.println("1 - Consultar Funcionários\n2 - Modificar Funcionários\n3 - Adicionar Funcioário\n4 - Eliminar Funcionário\n5 - Exit");
                        v1=ler.umInt();
                        switch(v1){
                            case 1:
                                while(v2!=5){
                                    System.out.println("1 - Todos os Funcionários\n2 - Atores\n3 - Staff\n4 - Realizadores\n5 - Exit");
                                    v2=ler.umInt();
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
                                System.out.println("Insira o ID do Funcionário:");
                                int aux=searchID(funcionarios,ler.umInt());
                                System.out.println("É este o Funcionário a modificar?\n"+funcionarios.get(aux).toString()+"\n1 - Sim\n2 - Não");
                                int valida=ler.umInt();
                                if(valida==1){
                                    while(v3!=6){    
                                        System.out.println("1 - Nome\n2 - Idade\n3 - Salario\n4 - Data Contrato\n5 - Função\n6 - Exit");
                                        v3=ler.umInt();
                                        switch(v3){
                                            case 1:
                                                    System.out.println("Novo nome");
                                                    funcionarios.get(aux).setNome(ler.umaString());
                                            break;
                                            case 2:
                                                    System.out.println("Novo Idade");
                                                    funcionarios.get(aux).setIdade(ler.umInt());
                                            break;
                                            case 3:
                                                    System.out.println("Novo Salario");
                                                    funcionarios.get(aux).setSalario(ler.umDouble());
                                            break;
                                            case 4:
                                                    System.out.println("Nova Data de Contrato");
                                                    funcionarios.get(aux).setContrato(novaData());
                                            break;
                                            case 5:
                                                System.out.println("Nova Função");
                                                System.out.println("1 - Ator\t2 - Realizador\t3 - Staff");
                                                int f=ler.umInt();
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
                                            break;
                                        }
                                        valida=0;aux=0;
                                    }
                                }
                                v3=0;
                            break;
                            case 3:
                                Pessoa nova=new Pessoa();
                                ++contaID;
                                nova.setId(contaID);
                                System.out.println("Insira o Nome");
                                nova.setNome(ler.umaString());
                                System.out.println("Insira a Idade");
                                nova.setIdade(ler.umInt());
                                System.out.println("Insira o Salario");
                                nova.setSalario(ler.umDouble());
                                System.out.println("Insira a Data de Contrato");
                                nova.setContrato(novaData());
                                System.out.println("Escolha a Função");
                                System.out.println("1 - Ator\t2 - Realizador\t3 - Staff");
                                int f=ler.umInt();
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
                                int aux1=searchID(funcionarios,ler.umInt());
                                System.out.println("É este o Funcionário a modificar?\n"+funcionarios.get(aux1).toString()+"\n1 - Sim\n2 - Não");
                                int valida1=ler.umInt();
                                if(valida1==1){
                                    funcionarios.remove(aux1);
                                }
                            break;
                        }
                    }
                    v1=0;
                break;
                
                case 2:
                    while(v4!=6){
                        System.out.println("1 - Consultar Epetáculos\n2 - Estatistica\n3 - Modificar Espetáculos\n4 - Adicionar Espétaculo\n5 - Eliminar Espetáculo\n6 - Exit");
                        v4=ler.umInt();
                        switch(v4){
                            case 1:
                                while(v5!=4){
                                    System.out.println("1 - Consultar todos\n2 - Consultar por local\n3 - Consultar por nome\n4 - Exit");
                                    v5=ler.umInt();
                                    switch(v5){
                                        case 1:
                                            for(Espetaculo aux:espetaculos){
                                                System.out.println(aux.toString());
                                                printID(aux,funcionarios);
                                                
                                            }
                                        break;
                                        case 2:
                                            System.out.println("Locais\n 1 - Lisboa\t2 - Porto\t3 - Funchal");
                                            int f=ler.umInt();
                                            switch(f){
                                                case 1:
                                                    for(Espetaculo aux:espetaculos){
                                                        if("Lisboa".equalsIgnoreCase(aux.getLocal())){
                                                            System.out.println(aux.toString());
                                                            printID(aux,funcionarios);
                                                        }
                                                    }
                                                break;
                                                case 2:
                                                    for(Espetaculo aux:espetaculos){
                                                        if("Porto".equalsIgnoreCase(aux.getLocal())){
                                                            System.out.println(aux.toString());
                                                            printID(aux,funcionarios);
                                                        }
                                                    }
                                                break;
                                                case 3:
                                                    for(Espetaculo aux:espetaculos){
                                                        if("Funchal".equalsIgnoreCase(aux.getLocal())){
                                                            System.out.println(aux.toString());
                                                            printID(aux,funcionarios);
                                                        }
                                                    }
                                                break;
                                            }
                                            f=0;   
                                        break;
                                        case 3:
                                            System.out.println("Insira o nome");
                                            String nome=ler.umaString();
                                            for(Espetaculo aux:espetaculos){
                                                if(nome.equalsIgnoreCase(aux.getNome())){
                                                    System.out.println(aux.toString());
                                                    printID(aux,funcionarios);
                                                }
                                            }
                                        break;
                                        
                                    }
                                }
                                v5=0;
                            break;
                            
                            case 2:
                                while(v6!=4){
                                    System.out.println("1 - Consultar Estatistica\n2 - Modificar Estatistica\n3 - Adiciona Estatistica\n4 - Exit");
                                    v6=ler.umInt();
                                    switch(v6){
                                        case 1:
                                            while(v7!=4){
                                                System.out.println("1 - Consultar todas\n2 - Consultar por local\n3 - Consultar por nome\n4 - Exit");
                                                v7=ler.umInt();
                                                switch(v7){
                                                    case 1:
                                                        for(Espetaculo aux:espetaculos){
                                                            System.out.println(aux.getNome());
                                                            System.out.println(aux.getStats().toString());
                                                        }
                                                    break;
                                                    case 2:
                                                        System.out.println("Locais\n 1 - Lisboa\t2 - Porto\t3 - Funchal");
                                                        int f=ler.umInt();
                                                        switch(f){
                                                            case 1:
                                                                for(Espetaculo aux:espetaculos){
                                                                    if("Lisboa".equalsIgnoreCase(aux.getLocal()))
                                                                        System.out.println(aux.getNome());
                                                                        System.out.println(aux.getStats().toString());
                                                                }
                                                            break;
                                                            case 2:
                                                                for(Espetaculo aux:espetaculos){
                                                                    if("Porto".equalsIgnoreCase(aux.getLocal()))
                                                                        System.out.println(aux.getNome());
                                                                        System.out.println(aux.getStats().toString());
                                                                }
                                                            break;
                                                            case 3:
                                                                for(Espetaculo aux:espetaculos){
                                                                    if("Funchal".equalsIgnoreCase(aux.getLocal()))
                                                                        System.out.println(aux.getNome());
                                                                        System.out.println(aux.getStats().toString());
                                                                }
                                                            break;
                                                        }
                                                        f=0;   
                                                    break;
                                                    case 3:
                                                        System.out.println("Insira o nome");
                                                        String nome=ler.umaString();
                                                        for(Espetaculo aux:espetaculos){
                                                            if(nome.equalsIgnoreCase(aux.getNome()))
                                                                System.out.println(aux.getNome());
                                                                System.out.println(aux.getStats().toString());
                                                        }
                                                    break;
                                                    case 4:
                                                        
                                                    break;

                                                    }
                                            }
                                        break;                                       
                                        case 2:
                                            System.out.println("Insira o nome do espetáculo:");
                                            int aux=searchEsp(espetaculos,ler.umaString());
                                            System.out.println("É este o espetáculo a modificar?\n"+espetaculos.get(aux).getNome()+"\n1 - Sim\n2 - Não");
                                            int valida=ler.umInt();
                                            if(valida==1){
                                                while(v8!=6){
                                                    System.out.println("1 - Vizualizações\n2 - Rating\n3 - Valor Ganho\n4 - Preço Bilhete\n5 - Duração\n6 - Exit");
                                                    v8=ler.umInt();
                                                    switch(v8){
                                                        case 1:
                                                                System.out.println("Novo valor de vizualizações");
                                                                espetaculos.get(aux).getStats().setViews(ler.umInt());
                                                        break;
                                                        case 2:
                                                                System.out.println("Nova rating");
                                                                espetaculos.get(aux).getStats().setRating(ler.umInt());
                                                        break;
                                                        case 3:
                                                                System.out.println("Novo valor ganho");
                                                                espetaculos.get(aux).getStats().setDinheiro(ler.umDouble());
                                                        break;
                                                        case 4:
                                                                System.out.println("Novo Preço do Bilhete");
                                                                espetaculos.get(aux).getStats().setBilhete(ler.umDouble());
                                                        break;
                                                        case 5:
                                                                System.out.println("Nova duração do espetaculo");
                                                                espetaculos.get(aux).getStats().setDuracao(ler.umDouble());
                                                        break;
                                                    }
                                                }
                                            }
                                        break;
                                        case 3:
                                            System.out.println("Insira o espetaculo a adicionar a estatistica:");
                                            int search=searchEsp(espetaculos,ler.umaString());
                                            System.out.println("É este o espetáculo a modificar?\n"+espetaculos.get(search).getNome()+"\n1 - Sim\n2 - Não");
                                            int valida1=ler.umInt();
                                            if(valida1==1){
                                                System.out.println("Insira as visualizações");
                                                espetaculos.get(search).getStats().setViews(ler.umInt());
                                                System.out.println("Insira o rating");
                                                espetaculos.get(search).getStats().setRating(ler.umInt());
                                                System.out.println("Insira o valor ganho");
                                                espetaculos.get(search).getStats().setDinheiro(ler.umDouble());
                                                System.out.println("Insira o preço do bilhete");
                                                espetaculos.get(search).getStats().setBilhete(ler.umDouble());
                                                System.out.println("Insira a duração");
                                                espetaculos.get(search).getStats().setDuracao(ler.umDouble());
                                                System.out.println("Done.");
                                            } 
                                        break;
                                    } 
                                }
                            v7=0;
                            break;
                            
                            case 3:
                                int aux=0,valida=0;
                                System.out.println("Insira o nome do espetáculo:");
                                aux=searchEsp(espetaculos,ler.umaString());
                                System.out.println("É este o espetáculo a modificar?\n"+espetaculos.get(aux).getNome()+"\n1 - Sim\n2 - Não");
                                valida=ler.umInt();
                                if(valida==1){
                                    while(v9!=5){
                                        System.out.println("1 - Modificar Nome\n2 - Modificar Local\n3 - Modificar Data\n4 - Modificar Participante\n5 - Exit");
                                        v9=ler.umInt();
                                            switch(v9){
                                                case 1:
                                                    System.out.println("Novo nome");
                                                    espetaculos.get(aux).setNome(ler.umaString());
                                                break;
                                                case 2:
                                                    System.out.println("Novo local");
                                                    System.out.println("Locais\n 1 - Lisboa\t2 - Porto\t3 - Funchal");
                                                    switch(ler.umInt()){
                                                        case 1:
                                                            espetaculos.get(aux).setLocal("Lisboa");
                                                        break;
                                                        case 2:
                                                            espetaculos.get(aux).setLocal("Porto");
                                                        break;
                                                        case 3:
                                                            espetaculos.get(aux).setLocal("Funchal");
                                                        break;
                                                    }
                                                break;
                                                case 3:
                                                    System.out.println("Nova Data");
                                                    espetaculos.get(aux).setDia(novaData());
                                                break;
                                                case 4:
                                                    System.out.println("O que pretende modificar?\n1 - Realizador\t2 - Atores\t3 - Staff");
                                                    switch(ler.umInt()){
                                                        case 1:
                                                            System.out.println("Pretende\n1 - Adicionar ou 2 - Remover");
                                                            switch(ler.umInt()){
                                                                case 1:
                                                                    System.out.println("Insira o ID a adicionar:");
                                                                    espetaculos.get(aux).getRealizador().add(ler.umInt());
                                                                break;
                                                                case 2:
                                                                    System.out.println("Insira o ID a remover");
                                                                    espetaculos.get(aux).getRealizador().remove(searchInt(espetaculos.get(aux).getRealizador(),ler.umInt()));
                                                                break;
                                                            }
                                                        break;
                                                        case 2:
                                                            System.out.println("Pretende\n1 - Adicionar ou 2 - Remover");
                                                            switch(ler.umInt()){
                                                                case 1:
                                                                    System.out.println("Insira o ID a adicionar:");
                                                                    espetaculos.get(aux).getAtores().add(ler.umInt());
                                                                break;
                                                                case 2:
                                                                    System.out.println("Insira o ID a remover");
                                                                    espetaculos.get(aux).getAtores().remove(searchInt(espetaculos.get(aux).getAtores(),ler.umInt()));
                                                                break;
                                                            }
                                                        break;
                                                        case 3:
                                                            System.out.println("Pretende\n1 - Adicionar ou 2 - Remover");
                                                            switch(ler.umInt()){
                                                                case 1:
                                                                    System.out.println("Insira o ID a adicionar:");
                                                                    espetaculos.get(aux).getStaff().add(ler.umInt());
                                                                break;
                                                                case 2:
                                                                    System.out.println("Insira o ID a remover");
                                                                    espetaculos.get(aux).getStaff().remove(searchInt(espetaculos.get(aux).getStaff(),ler.umInt()));
                                                                break;
                                                            }
                                                        break;
                                                    }
                                                break;
                                            }
                                    }
                                }           
                            break;
                            
                            case 4:
                                int tempAux=0;
                                Espetaculo novo=new Espetaculo();
                                System.out.println("Insira o nome");
                                novo.setNome(ler.umaString());
                                System.out.println("Selecione o local");
                                System.out.println("Locais\n 1 - Lisboa\t2 - Porto\t3 - Funchal");
                                switch(ler.umInt()){
                                    case 1:
                                        novo.setLocal("Lisboa");
                                    break;
                                    case 2:
                                        novo.setLocal("Porto");
                                    break;
                                    case 3:
                                        novo.setLocal("Funchal");
                                    break;
                                }
                                System.out.println("Insira a data");
                                novo.setDia(novaData());
                                System.out.println("Quantos Realizadores a adicionar:");
                                tempAux=ler.umInt();
                                ArrayList<Integer> temp=new ArrayList<Integer>();
                                for(int i=0;i<tempAux;++i){
                                    System.out.println("Insira o id");
                                    temp.add(ler.umInt());
                                }
                                novo.setRealizador(temp);
                                System.out.println("Quantos Atores a adicionar:");
                                tempAux=ler.umInt();
                                temp=new ArrayList<Integer>();
                                for(int i=0;i<tempAux;++i){
                                    System.out.println("Insira o id");
                                    temp.add(ler.umInt());
                                }
                                novo.setAtores(temp);
                                System.out.println("Quantos Staffs a adicionar:");
                                tempAux=ler.umInt();
                                temp=new ArrayList<Integer>();
                                for(int i=0;i<tempAux;++i){
                                    System.out.println("Insira o id");
                                    temp.add(ler.umInt());
                                }
                                novo.setStaff(temp);
                                espetaculos.add(novo);
                                System.out.println("Done.");
                            break;
                            
                            case 5:
                                System.out.println("Insira o nome do espetaculo a eliminar:");
                                int pos=searchEsp(espetaculos,ler.umaString());
                                System.out.println("É este o espetaculo a eliminar?\n1 - Sim\t2 - Não");
                                if(ler.umInt()==1){
                                    espetaculos.remove(pos);
                                }
                                System.out.println("Done.");
                            break;
                        }
                    }
                    v4=0;
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
        
        try{
           ObjectOutputStream os=new ObjectOutputStream(new FileOutputStream("./Espetaculo.dat"));
                os.writeObject(espetaculos);
            os.flush(); 
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }  
}