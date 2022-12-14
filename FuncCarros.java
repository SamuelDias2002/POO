import java.io.*;
import java.util.ArrayList;
public class FuncCarros{
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
		Carro novoCarro = new Carro(marca,modelo,ano,km,cilindrada,potencia,preco_aluguer,preco_compra);
		carros.add(novoCarro);
	}

	public static void lista_Carros(ArrayList <Carro> carros) {
		for(int i=0;i<carros.size();i++){
			System.out.println(carros.get(i).toString());
		}
	}

	public void apaga_Carro(ArrayList <Carro> carros) throws ApagarException {
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

	public void alugar_Carro() {

	}

	public void entregar_Carro() {

	}

	public void pagar_Aluguer() {

	}

	public void mais_Alugado(ArrayList<Carro> carros) {
		ArrayList<String> nomes = new ArrayList<String>();
		int total = 0;
		if (carros.size()>0) {
			for (int j = 0 ; j < carros.size(); j++) {
				nomes.add(carros.get(j).getModelo());
				total++;
				for (int i=0;i<carros.size();i++) {
					if(carros.get(i).getModelo().equals(nomes.get(i)))
					{
						total++;
					}
					else {
						nomes.clear();
						total = 1;
						nomes.add(carros.get(i).getModelo());

					}
				}
			}
		}
	}


}

