import java.io.*;
import java.util.ArrayList;
public class Agencia {
	public static int menu() { // função na classe do main
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
		System.out.println("10 - Listar todos os clientes");
		System.out.println("11 - Sair");
		System.out.println("\nQual a sua opção:");
		opcao = Ler.umInt();
		return opcao;
	}
	public static void main(String[] args) {
		int opcao = 0;
		ArrayList<Carro> carros = new ArrayList<Carro>();
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
		int cliente = 0;
		try {//ler ficheiro dos carros
			ObjectInputStream is = new ObjectInputStream(new FileInputStream("C:\\POOpratica\\MainProjeto\\src\\Carros.dat"));// ALTEREM SEMPRE A VOSSA DIRETORIA
			carros = (ArrayList<Carro>) is.readObject();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}

		try {//ler ficheiro dos clientes
			ObjectInputStream is = new ObjectInputStream(new FileInputStream("C:\\POOpratica\\MainProjeto\\src\\Clientes.dat")); // ALTEREM SEMPRE A VOSSA DIRETORIA
			clientes = (ArrayList<Cliente>) is.readObject();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}

		System.out.println("Já pertence á lista de clientes da agência ?(Se sim digite S, caso contrário digite N) ");
		String resposta = Ler.umaString();
		if(resposta.equals("N")) {
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
		}else {
			System.out.println("Digite o seu nome: ");
			String nome = Ler.umaString();
			for(int i = 0; i < clientes.size(); i++) {
				if(clientes.get(i).getNome().equals(nome)) {
					cliente = i; //Cliente que está a alugar o carro -> clientes.get(cliente)
					System.out.println("Bem-vindo de volta " + clientes.get(i).getNome());
				}else {
					System.out.println("Ainda não pertence à lista de clientes da agência ou escreveu mal o seu nome!");
					return ;
				}
			}
		}
		try {//escrever no ficheiro Clientes
			ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("C:\\POOpratica\\MainProjeto\\src\\Clientes.dat")); // ALTEREM SEMPRE A VOSSA DIRETORIA
			os.writeObject(clientes);
			os.flush();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
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
				System.out.println(FuncCarros.lista_Clientes(clientes));
				break;
			}
		}while(opcao != 11);
	}
}