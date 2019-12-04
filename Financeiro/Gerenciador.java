package Financeiro;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Map.Entry;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Gerenciador {
    static Connection conexao;
    public static void main(String[] args) throws Exception {   

        System.out.println("Iniciando o Banco de Dados");        
        conexao = Conexao.getConnection();        
        System.out.println("Conexão feita");

        Scanner scanner = new Scanner(System.in);
        Map<Integer, Pessoas> pessoas = new HashMap<>();
        Map<Integer, Dividas> dividas = new HashMap<>();
        Map<Integer, Proventos> proventos = new HashMap<>();

        System.out.println("==== Bem vindo ao Financeiro ====");
        int opcao = 0;
        do{
            imprimirOpcoes();
            opcao = scanner.nextInt();
            switch(opcao){
                case 1:
                    cadastrarPessoa(scanner, pessoas);
                    break;
                case 2:
                    cadastrarDivida(scanner, pessoas, dividas);
                    break;
                case 3:
                    cadastrarProventos(scanner, pessoas, proventos);
                    break;
                case 4:
                    Conexao.findPeople(conexao);
                    break;
                case 5:
                    imprimirObjeto(dividas);
                    break;
                case 6:
                    imprimirObjeto(proventos);
                    break;
                case 7:
                    conexao.close();
                    System.out.println("Até o próximo semestre!");
                    return;
                default:
                    System.out.println("Opção Inválida");    
                    break;
            }

        } while(opcao != 9);

        scanner.close();        
    }

    private static void imprimirOpcoes(){
        System.out.println("Escolha a Opção: ");
        System.out.println("1 - Cadastrar Pessoa");
        System.out.println("2 - Cadastrar Divida");
        System.out.println("3 - Cadastrar Proventos");        
        System.out.println("4 - Listar Pessoas");
        System.out.println("5 - Listar Dividas");
        System.out.println("6 - Listar Proventos");                
        System.out.println("7 - Sair");
    }

    private static void cadastrarPessoa(Scanner scanner, Map<Integer,Pessoas> pessoas) throws Exception {
        Pessoas pessoa = new Pessoas();
        System.out.println("Digite o Nome: ");
        pessoa.setNome(scanner.next());
        System.out.println("Digite o Email: ");
        pessoa.setEmail(scanner.next());

        Integer idPessoa;        
        if (pessoas.size() == 0) {
            idPessoa = 1;
        } else {
            idPessoa = pessoas.size() + 1;
        }

        pessoa.setIdPessoa(idPessoa);

        pessoas.put(idPessoa, pessoa);
        Conexao.insertPeople(conexao, idPessoa, pessoa.getNome(), pessoa.getEmail());
    }

    private static void cadastrarDivida(Scanner scanner, Map<Integer,Pessoas> pessoas, Map<Integer,Dividas> dividas) throws Exception {
        Pessoas pessoa = (Pessoas) retornaObjeto(pessoas, "Digite o código da pessoa: ", scanner);

        Dividas divida = new Dividas();
        System.out.println("Digite o ano da dívida: ");
        divida.setAnoConta(scanner.nextInt());
        System.out.println("Digite o mês da dívida: ");
        divida.setMesConta(scanner.nextInt());
        System.out.println("Digite o valor da dívida: ");
        divida.setVlrConta(scanner.nextDouble());
        System.out.println("Digite o percentual de desconto da dívida: ");
        divida.setPercentualDesconto(scanner.nextDouble());
        divida.setObjPessoas(pessoa);

        Integer idDivida;
        if (dividas.size() == 0) {
            idDivida = 1;
        } else {
            idDivida = dividas.size() + 1;
        }

        dividas.put(idDivida, divida);

        Conexao.insertDebt(conexao, idDivida, divida.getAnoConta(), divida.getMesConta(), divida.getVlrConta(), divida.getPercentualDesconto(), pessoa.idPessoa);
    }

    private static void cadastrarProventos(Scanner scanner, Map<Integer,Pessoas> pessoas, Map<Integer,Proventos> proventos) throws Exception {
        Pessoas pessoa = (Pessoas) retornaObjeto(pessoas, "Digite o código da pessoa: ", scanner);

        Proventos provento = new Proventos();
        System.out.println("Digite o ano do provento: ");
        provento.setAnoConta(scanner.nextInt());
        System.out.println("Digite o mês do provento: ");
        provento.setMesConta(scanner.nextInt());
        System.out.println("Digite o valor do provento: ");
        provento.setVlrConta(scanner.nextDouble());
        System.out.println("Digite o percentual de imposto do provento: ");
        provento.setImposto(scanner.nextDouble());
        provento.setObjPessoas(pessoa);

        Integer idProvento;
        if (proventos.size() == 0) {
            idProvento = 1;
        } else {
            idProvento = proventos.size() + 1;
        }        

        proventos.put(idProvento, provento);

        Conexao.insertSalary(conexao, idProvento, provento.getAnoConta(), provento.getMesConta(), provento.getVlrConta(), provento.getImposto(), pessoa.idPessoa);
    }        

    private static void imprimirObjeto(Map<Integer, ?> map){
        for(Entry<Integer,?> obj: map.entrySet()){
            System.out.print("ID: " + obj.getKey() + " ");
            System.out.print(obj.getValue().toString());
            System.out.print("\n");
        }
    }    

    private static Object retornaObjeto(Map<Integer, ?> map, String msg, Scanner scanner){
        Object obj = null;
        do{
            System.out.println(msg);
            int selection = scanner.nextInt();
            if (map.containsKey(selection)){
                obj = map.get(selection);
            } else {
                System.out.println("Informação não existe, tente novamente.");
            }
        }while(obj == null);

        return obj;
    }

}