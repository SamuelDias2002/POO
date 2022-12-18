import java.io.*;
import java.util.ArrayList;
import java.util.Date;
public class FuncCarros{
	
	private static int dias;
	private static Date dataInicio;
	
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
			ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("D:\\Files POO\\Carros.dat"));// ALTEREM SEMPRE A VOSSA DIRETORIA
			os.writeObject(carros);
			os.flush();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void lista_Carros(ArrayList <Carro> carros) {//mudar para -> listar todos ou só os premium(carros que são mais 
		for(int i=0;i<carros.size();i++){					   //caros para alugar) ou só os comerciais
			System.out.println(carros.get(i).toString());
		}
	}

	public static void apaga_Carro(ArrayList <Carro> carros) throws ApagarException {
		System.out.println("Digite a marca do carro a REMOVER: ");
		String marca = Ler.umaString();
		System.out.println("Digite o modelo do carro a REMOVER: ");
		String modelo = Ler.umaString();
		System.out.println("Digite o ano do carro a REMOVER: ");
		int ano = Ler.umInt();
		System.out.println("Digite a quilometragem do carro a REMOVER: ");
		int km = Ler.umInt();
		System.out.println("Digite a cilindrada do carro a REMOVER: ");

		for (int i=0;i<carros.size();i++) {
			if (carros.get(i).getMarca().equals(marca) && carros.get(i).getModelo().equals(modelo) && carros.get(i).getAno()==ano && carros.get(i).getKm()==km) {
				carros.remove(i);
			} else {
				throw new ApagarException ("O carro" + marca + " " + modelo + "com as carateristicas pretendidas nao existe");
			}
		}
		try (ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("D:\\Files POO\\Carros.dat"))) { // ALTEREM SEMPRE A VOSSA DIRETORIA
			os.writeObject(carros);
			os.flush();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

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
		} else if ( s.toLowerCase().equals("modelo")) {
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

	public static void alugar_Carro(ArrayList<Carro> carros) throws alugarExcecao{
		System.out.println("Digite o id (indice) do carro que pretende alugar");
		int id = Ler.umInt();
		System.out.println("Tem a certeza que quer alugar este carro? Vai ter um custo de " + carros.get(id-1).getPreco_aluguer() +" por dia");
		String sn = Ler.umaString();
		if (sn.toLowerCase().equals("sim")) {
			System.out.println("Quantos dias pertende alugar o carro?");
			 dias = Ler.umInt();
			 dataInicio = new Date();
			carros.get(id-1).setAlugado("Alugado durante " +dias+" dias.");
			System.out.println("O carro foi alugado às " + dataInicio + " por " + dias + " dias! ");
		}
		else {
			throw new alugarExcecao("O aluguer do carro foi cancelado.");
		}
		

	}

	public static void entregar_Carro(ArrayList<Carro> carros) throws EntregarException {
		System.out.println("Digite o id (indice) do carro que pretende entregar");
		int id = Ler.umInt();
		if (carros.get(id-1).getAlugado().equals("Não Alugado")) {
			throw new EntregarException("ERRO! Esse carro não estava alugado");
		} else {
			carros.get(id-1).setAlugado("Não alugado");
			
		}	
		System.out.println("Entrega do " + carros.get(id-1).getMarca() + carros.get(id-1).getModelo() + " realizada com Sucesso!");
	}

	public static void pagar_Aluguer(ArrayList<Carro> carros) {
		
	}

	public static String mais_Alugado(ArrayList<Carro> carros) {
		ArrayList<String> modelo = new ArrayList<>();
		int cont = 0, k = 0, total = 0;
		for(int i = 0; i < carros.size(); i++) {
			if(carros.get(i).getAlugado().equals("Alugado")) {
				modelo.add(carros.get(i).getModelo());
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
		return("Não existe nenhum carro alugado!");
	}
	
	public static String lista_Clientes(ArrayList<Cliente> clientes) {
		String s = "";
		for(int i = 0; i < clientes.size(); i++) {
			s = s + clientes.get(i).toString();
		}
		return s;
	}
}