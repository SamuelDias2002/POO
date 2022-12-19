import java.io.*;
import java.util.ArrayList;
public class Agencia {
	
	/*
	 * Menu que contem todas as opções que o utilizador pode usufruir
	 */
	public static int menu() {
		int opcao;
		System.out.println("\n1 - Novo carro");
		System.out.println("2 - Listar todos os carros (todos ou apenas premium ou apenas comercial)");
		System.out.println("3 - Apagar carro");
		System.out.println("4 - Consultar carros");
		System.out.println("5 – Qual a marca mais alugada");
		System.out.println("6 – Qual o carro (modelo) mais alugado");
		System.out.println("7 – Consultar todos os carros alugados");
		System.out.println("8 – Alugar carro");
		System.out.println("9 - Entregar carro alugado anteriormente");
		System.out.println("10 - Adicionar Cliente");
		System.out.println("11 - Listar todos os clientes");
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
			ObjectInputStream is = new ObjectInputStream(new FileInputStream("D:\\\\Files POO\\\\Carros.dat"));// ALTEREM SEMPRE A VOSSA DIRETORIA
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
			ObjectInputStream is = new ObjectInputStream(new FileInputStream("D:\\Files POO\\Clientes.dat")); // ALTEREM SEMPRE A VOSSA DIRETORIA
			clientes = (ArrayList<Cliente>) is.readObject();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
		/*
		 * Verificar se é cliente (mas será que precisamos mesmo disto? Pois este menu vai ser dedicado a quem trabalha na Agencia)
		 */
		System.out.println("Já pertence á lista de clientes da agência?(Se sim digite Sim, caso contrário digite Nao) ");
		String resposta = Ler.umaString();
		if (resposta.toLowerCase().equals("sim")) {
			System.out.println("Digite o seu nome:");
			String nome = Ler.umaString();
			if (clientes.size() < 0 ) {
				for (int i = 0; i < clientes.size(); i++) {
					if (clientes.get(i).getNome().equals(nome)) {
						cliente = i; //Cliente que está a alugar o carro -> clientes.get(cliente)
						System.out.println("Bem-vindo de volta " + clientes.get(i).getNome());
					}
				}
			}
			else {
				throw new clienteException ("Não há clientes!");
					}	
		} else if (resposta.toLowerCase().equals("nao")) {

			System.out.println("Digite o seu nome: ");
			String nome = Ler.umaString();
			System.out.println("Digite a sua cidade: ");
			String cidade = Ler.umaString();
			System.out.println("Digite a sua idade: ");
			int idade = Ler.umInt();
			System.out.println("Digite o seu NIF: ");
			int NIF = Ler.umInt();
			clientes.add(new Cliente(nome,cidade,idade,NIF));
			cliente = clientes.size() - 1;
		}
		
		/*
		 * Escrever no ficheiro Clientes
		 */
		try {
			ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("D:\\\\Files POO\\\\Clientes.dat")); // ALTEREM SEMPRE A VOSSA DIRETORIA
			os.writeObject(clientes);
			os.flush();
		} catch (IOException e) {
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
				break;
			case 4:
				try {
					FuncCarros.pesquisa(carros);
				} catch (CarroException e) {
					System.out.println(e.getMessage());
				}
				break;
			case 5:
				break;
			case 6:
				System.out.println(FuncCarros.mais_Alugado(carros));
				break;
			case 7:
				break;
			case 8:
				try {

					FuncCarros.alugar_Carro(carros, clientes, cliente);
				} catch (alugarExcecao e) {
					System.out.println(e.getMessage());
				}
				break;
			case 9:
				try {
					FuncCarros.entregar_Carro(carros, clientes, cliente);
				} catch (EntregarException e) {
					System.out.println(e.getMessage());
				}
			case 10:
				
			//Executa a parte de codigo para adicionar um novo cliente
					System.out.println("Digite o seu nome: ");
					String nome2 = Ler.umaString();
					System.out.println("Digite a sua cidade: ");
					String cidade2 = Ler.umaString();
					System.out.println("Digite a sua idade: ");
					int idade2 = Ler.umInt();
					System.out.println("Digite o seu NIF: ");
					int NIF2 = Ler.umInt();
					clientes.add(new Cliente(nome2,cidade2,idade2,NIF2));
					cliente = clientes.size() - 1;
					break;
				
			case 11:
				System.out.println(FuncCarros.lista_Clientes(clientes));
				break;
			}
		}while(opcao != 12);
	}
}