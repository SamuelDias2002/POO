import java.io.*;
import java.util.ArrayList;
import java.util.Date;
public class FuncCarros{

	private static int dias;
	private static Date dataInicio;

	/*
	 * Função que permite criar/adicionar um carro a lista dos carros
	 */

	public static void cria_carro(ArrayList <Carro> carros) {
		System.out.println("Digite a marca do carro: ");
		String marca = Ler.umaString();
		System.out.println("Digite a modelo do carro: ");
		String modelo = Ler.umaString();
		System.out.println("Digite o ano do carro: ");
		int ano = Ler.umInt();
		System.out.println("Digite a quilometragem do carro: ");
		int km = Ler.umInt();
		System.out.println("Digite a cilindrada do carro: ");
		int cilindrada = Ler.umInt();
		System.out.println("Digite a potência do carro: ");
		int potencia = Ler.umInt();
		System.out.println("Digite o preço de aluguer do carro: ");
		double preco_aluguer = Ler.umDouble();
		System.out.println("Digite o preço de compra do carro: ");
		double preco_compra = Ler.umDouble();
		Carro novoCarro = new Carro(marca,modelo,ano,km,cilindrada,potencia,preco_compra,preco_aluguer);
		carros.add(novoCarro);
		try {
			ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("C:\\POOpratica\\MainProjeto\\src\\Carros.dat"));// ALTEREM SEMPRE A VOSSA DIRETORIA
			os.writeObject(carros);
			os.flush();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	/*
	 * Função que vai permitir verificar/observar a lista de carros através do seu preço de aluguer
	 */

	public static void lista_Carros(ArrayList <Carro> carros) {//mudar para -> listar todos ou só os premium(carros que são mais //caros para alugar) ou só os comerciais
		System.out.println("Digite se quer listar todos os carros, apenas os premium ou só os comerciais");
		String lista = Ler.umaString();
		if(lista.toLowerCase().equals("todos")) {
			for(int i=0;i<carros.size();i++){					   
				System.out.println(carros.get(i).toString());
			}
		}else{if(lista.toLowerCase().equals("premium")) {
			for(int i=0;i<carros.size();i++){					   
				if(carros.get(i).getPreco_aluguer() >= 100.0) {	
					System.out.println(carros.get(i).toString());
				}
			}
		}else {
			for(int i=0;i<carros.size();i++){					   
				if(carros.get(i).getPreco_aluguer() < 100.0) {	
					System.out.println(carros.get(i).toString());
				}
			}
		}
		}
	}
	/*
	 *  Função para apagar carro, caso o carro não exista mais na agencia
	 */

	public static void apaga_Carro(ArrayList <Carro> carros) throws ApagarException {
		System.out.println("Digite a marca do carro a REMOVER: ");
		String marca = Ler.umaString();
		System.out.println("Digite o modelo do carro a REMOVER: ");
		String modelo = Ler.umaString();
		System.out.println("Digite o ano do carro a REMOVER: ");
		int ano = Ler.umInt();
		System.out.println("Digite a quilometragem do carro a REMOVER: ");
		int km = Ler.umInt();
		
		for (int i=0;i<carros.size();i++) {
			if (carros.get(i).getMarca().equals(marca) && carros.get(i).getModelo().equals(modelo) && carros.get(i).getAno()==ano && carros.get(i).getKm()==km) {
				carros.remove(i);
			} else {
				throw new ApagarException ("O carro" + marca + " " + modelo + "com as carateristicas pretendidas nao existe");
			}
		
		}
		try {
			ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("C:\\POOpratica\\MainProjeto\\src\\Carros.dat")); // ALTEREM SEMPRE A VOSSA DIRETORIA
			os.writeObject(carros);
			os.flush();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	/*
	 * Função que permite pesquisar um determinado carro por Marca, matricula, modelo
	 */

	public static void pesquisa(ArrayList<Carro> carros) throws CarroException {
		System.out.println("Prentende pesquisar por marca, modelo ou ano?");
		String s= Ler.umaString();

		if (s.toLowerCase().equals("marca")) {
			System.out.println("Indique a marca");
			String a = Ler.umaString();
			for (int i=0; i<carros.size();i++) {
				if(carros.get(i).getMarca().equals(a)) {
					System.out.println(carros.get(i).toString());
				}
			}		
		} else if (s.toLowerCase().equals("modelo")) {
			System.out.println("Indique o modelo");
			String d = Ler.umaString();
			for(int i=0;i<carros.size();i++) {
				if(carros.get(i).getModelo().equals(d)) {
					System.out.println(carros.get(i).toString());
				}
			}
		} else if (s == "Ano" || s == "ano") {
			System.out.println("Indique o ano");
			int g = Ler.umInt();
			for (int i=0;i<carros.size();i++) {
				if (carros.get(i).getAno()== g) {
					System.out.println(carros.get(i).toString());
				}
			}
		} else {
			throw new CarroException ("Inválido");
		}
	}

	/*
	 * Adicionar Cliente
	 */
	public static void AdicionarCliente(ArrayList<Cliente> clientes) {
		System.out.println("Digite o seu nome: ");
		String nome2 = Ler.umaString();
		System.out.println("Digite a sua cidade: ");
		String cidade2 = Ler.umaString();
		System.out.println("Digite a sua idade: ");
		int idade2 = Ler.umInt();
		System.out.println("Digite o seu NIF: ");
		int NIF2 = Ler.umInt();
		clientes.add(new Cliente(nome2,cidade2,idade2,NIF2));
		try {
			ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("C:\\POOpratica\\MainProjeto\\src\\Clientes.dat"));// ALTEREM SEMPRE A VOSSA DIRETORIA
			os.writeObject(clientes);
			os.flush();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

	}

	/*
	 * Função para alugar um carro.
	 * Armazena no ficheiro
	 */

	public static void alugar_Carro(ArrayList<Carro> carros, ArrayList<Cliente> clientes)throws alugarExcecao{
		System.out.println("Já pertence à lista de clientes da agência?(Se sim digite Sim, caso contrário digite Nao) ");
		int verificar = 0;
		String resposta = Ler.umaString();
		if (resposta.toLowerCase().equals("sim")) {
			System.out.println("Digite o seu nome:");
			String nome = Ler.umaString();
			for (int i = 0; i < clientes.size(); i++) {
				if (clientes.get(i).getNome().equals(nome) ) {
					System.out.println("Bem-vindo de volta");
					break;
				}
				else {
					verificar++;
				}
			}
			if (verificar == clientes.size()) {
				System.out.println("Não existe nenhum cliente com o nome que digitou!");
				return;
			}
		}

		if (resposta.toLowerCase().equals("nao")) {
			AdicionarCliente(clientes);
		}
		int cliente = 0;
		System.out.println("Digite o id (índice da lista de carros) do carro que pretende alugar");
		int id = Ler.umInt();//índice da posição do carro da lista de carros que o cliente pretende alugar

		if(carros.size() != 0) {
			for (int i = 0; i < clientes.size(); i++) {
				System.out.println("Tem a certeza que quer alugar este carro? Vai ter um custo de " + carros.get(id).getPreco_aluguer() +" por dia");
				String sn = Ler.umaString();
				if (sn.toLowerCase().equals("sim")) {
					System.out.println("Quantos dias pertende alugar o carro?");
					dias = Ler.umInt();
					dataInicio = new Date();
					carros.get(id).setAlugado("Alugado durante " + dias +" dias.");
					System.out.println("O carro foi alugado às " + dataInicio + " por " + dias + " dias!");
					clientes.get(cliente).setCarro(carros.get(id));
					try {
						ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("C:\\POOpratica\\MainProjeto\\src\\Carros.dat"));// ALTEREM SEMPRE A VOSSA DIRETORIA
						os.writeObject(carros);
						os.flush();
					} catch (IOException e) {
						System.out.println(e.getMessage());
					}
					try {
						ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("C:\\POOpratica\\MainProjeto\\src\\Clientes.dat")); // ALTEREM SEMPRE A VOSSA DIRETORIA
						os.writeObject(clientes);
						os.flush();
					} catch (IOException e) {
						System.out.println(e.getMessage());
					}
					return;

				}else if (sn.toLowerCase().equals("nao")) {
					throw new alugarExcecao("O aluguer do carro foi cancelado.");
				}

			}
		} else {
			throw new alugarExcecao("Lista de carros vazia."); 

		}
	}



	/*
	 * Função para entregar carro 
	 */

	public static void entregar_Carro(ArrayList<Carro> carros, ArrayList<Cliente> clientes) throws EntregarException, clienteException {
		int cliente = 0;
		System.out.println("Tem ficha cliente?");
		String resposta = Ler.umaString();
		if (resposta.toLowerCase().equals("sim")) {
			System.out.println("Digite o seu nome:");
			String nome = Ler.umaString();
			if (clientes.size() > 0 ) {
				for (int i = 0; i < clientes.size(); i++) {
					if (clientes.get(i).getNome().equals(nome)) {
						cliente = i; //Cliente que está a alugar o carro -> clientes.get(cliente)
						System.out.println("Bem-vindo de volta");
						if(clientes.get(cliente).getCarrosAlugados().size() > 0 ) {
							System.out.println("Digite o id (índice da lista de carros alugados do cliente) do carro que pretende entregar");
							int id = Ler.umInt(); //índice da posição do carro da lista de carros alugados do cliente que vai ser entregue
							for(int j = 0; j < carros.size(); j++) {
								//Percorrer a lista dos carros e comparar cada carro com o carro que pretendemos entregar da lista de carros alugados do cliente
								//Caso sejam iguais esse carro passa para Não Alugado na lista de carros
								if(Carro.comparaCarro(clientes.get(cliente).getCarrosAlugados().get(id),(carros.get(j)))) {
									carros.get(j).setAlugado("Não Alugado");
									System.out.println("Entrega do " + carros.get(j).getMarca()+ " "+ carros.get(i).getModelo() + " realizada com Sucesso!");
								}
							}
							//O carro entregue é removido da lista de carros alugados do cliente
							clientes.get(cliente).getCarrosAlugados().remove(id);
						}else {
							throw new EntregarException("A entrega do carro foi cancelada.");
						}
						/*
						 * Escrever nos respetivos ficheiros
						 */
						try {
							ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("C:\\POOpratica\\MainProjeto\\src\\Carros.dat"));// ALTEREM SEMPRE A VOSSA DIRETORIA
							os.writeObject(carros);
							os.flush();
						} catch (IOException e) {
							System.out.println(e.getMessage());
						}
						try {
							ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("C:\\POOpratica\\MainProjeto\\src\\Clientes.dat")); // ALTEREM SEMPRE A VOSSA DIRETORIA
							os.writeObject(clientes);
							os.flush();
						} catch (IOException e) {
							System.out.println(e.getMessage());
						}
					}
				}
				
			}
			else {
				throw new clienteException ("Não há clientes!");
				
			}	
		} else if (resposta.toLowerCase().equals("nao")) {

			System.out.println("Cria ficha de cliente");
			return;
		}

		

		
	}

	/*
	 * Função que permite verificar o modelo mais alugado 
	 */
	public static String mais_Alugado(ArrayList<Carro> carros) throws Mais_Alugado_Exception {
		ArrayList<String> modelo = new ArrayList<>();
		int cont = 0, k = 0, total = 0;
		for(int i = 0; i < carros.size(); i++) {
			if(carros.get(i).getAlugado().equals("Alugado")) {
				modelo.add(carros.get(i).getModelo());
			} else {
				throw new Mais_Alugado_Exception ("Não existem carros alugados");
			}
		}
		for(int i = 0; i < modelo.size(); i++) {
			for(int j = 0; j < modelo.size(); j++) {
				if(modelo.get(i).equals(modelo.get(j))) {
					cont ++;
				}
			}
			if(cont > total) {
				total = cont;
				cont = 0;
				k = i;
			}else {
				cont = 0;
			}
		}
		for(int i = 0; i <carros.size(); i++) {
			if(modelo.get(k).equals(carros.get(i).getModelo())) {
				return ("Marca do carro: " + carros.get(i).getMarca() + "\nModelo: " + modelo.get(i) + "\nNúmero de vezes alugado: " + total);
			}
		}

		throw new Mais_Alugado_Exception("Não existe nenhum carro alugado!");
	}

	/*
	 * Função que permite visualizar a lista de clientes
	 */
	public static void lista_Clientes(ArrayList<Cliente> clientes) {

		for(int i = 0; i < clientes.size(); i++) {
			System.out.println(clientes.get(i).toString());
			System.out.println("");
		}
	}

	/*
	 * Função listar todos os carros alugados
	 */
	public static void Lista_CarrosAlugados(ArrayList<Carro> carros){
		for(int i = 0; i < carros.size(); i++) {
			if(carros.get(i).getAlugado().equals("Alugado")) {
				System.out.println(carros.get(i));
			}
		}
	}


}