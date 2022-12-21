import java.io.*;
import java.util.ArrayList;
public class Agencia {
	static String nome_Agencia = "AGÊNCIA GMS"; // Alterar consoante o nome que pretender
	/*
	 * Menu que contem todas as opções que o utilizador pode usufruir
	 */
	public static int menu() {
		int opcao;
		System.out.println("");
		System.out.println("\t\t\t\t\tBEM VINDO À " + nome_Agencia);
		System.out.println("1 - Novo carro");
		//Carros premium - Carros mais caros para alugar - Preço de aluguer >= 100$ por dia
		System.out.println("2 - Listar todos os carros (todos ou apenas premium ou apenas comercial)");
		System.out.println("3 - Apagar carro");
		System.out.println("4 - Consultar carros");
		System.out.println("5 - Criar ficha de cliente");
		System.out.println("6 - Listar todos os clientes");		
		System.out.println("7 – Alugar carro");
		System.out.println("8 - Entregar carro alugado anteriormente");
		System.out.println("9 – Qual o carro (marca e modelo) mais alugado");
		System.out.println("10 – Consultar todos os carros alugados");
		System.out.println("11 – Melhor(es) cliente(s) da agência"); //Os que alugaram mais carros
		System.out.println("12 - Sair");
		System.out.println("\nQual a sua opção:");
		opcao = Ler.umInt();
		return opcao;
	}
	/*
	 * Classe Main:
	 * Abre o ficheiros Carros e Clientes
	 * Faz a questão inicial para verificar se o utilizador já é cliente e escreve no ficheiro clientes
	 * Torna as opções do menu usáveis 
	 */
	public static void main(String[] args) throws clienteException{
		int opcao = 0;
	
		ArrayList<Carro> carros = new ArrayList<Carro>();
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
		int cliente = 0;
		/*
		 * Ler ficheiro Carros
		 */
		try {
			ObjectInputStream is = new ObjectInputStream(new FileInputStream("C:\\POOpratica\\MainProjeto\\src\\Carros.dat"));// ALTEREM SEMPRE A VOSSA DIRETORIA
			carros = (ArrayList<Carro>) is.readObject();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
	/*
	 * Ler ficheiro Clientes
	 */
		try {
			ObjectInputStream is = new ObjectInputStream(new FileInputStream("C:\\POOpratica\\MainProjeto\\src\\Clientes.dat")); // ALTEREM SEMPRE A VOSSA DIRETORIA
			clientes = (ArrayList<Cliente>) is.readObject();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}

		/*
		 * Função que torna a opções dadas no menu usaveis
		 */
		do {
			opcao = menu();
			switch(opcao){
			case 1:
				FuncCarros.cria_carro(carros);
				break;
			case 2:
				FuncCarros.lista_Carros(carros);
				break;
			case 3:
				try{
					FuncCarros.apaga_Carro(carros);
				}catch(ApagarException e) {
					System.out.println(e.getMessage());
				}
				break;
			case 4:
				try {
					FuncCarros.pesquisa(carros);
				} catch (CarroException e) {
					System.out.println(e.getMessage());
				}
				break;
			case 5:
				//Executa a parte de codigo para adicionar um novo cliente
				FuncCarros.AdicionarCliente(clientes);
				break;
			case 6:
				FuncCarros.lista_Clientes(clientes);
				break;
			case 7:
				try {
					FuncCarros.alugar_Carro(carros, clientes);
				} catch (alugarExcecao e) {
					System.out.println(e.getMessage());
				}
				break;
			case 8:
				try {
					FuncCarros.entregar_Carro(carros, clientes);
				} catch (EntregarException e) {
					System.out.println(e.getMessage());
				}
				break;
			case 9:
				try {
					System.out.println(FuncCarros.mais_Alugado(carros));
				} catch (Mais_Alugado_Exception e1) {
		
					System.out.println(e1.getMessage());
				}
				break;
			case 10:
				FuncCarros.Lista_CarrosAlugados(carros);
				break;
			case 11:
				try {
					System.out.println(FuncCarros.melhor_Cliente(clientes));
				}catch(clienteException e) {
					System.out.println(e.getMessage());
				}
				break;
			}
		}while(opcao != 12);
	}
}