import java.util.ArrayList;

public class Agencia {
	public static void main(String []args) {
		ArrayList<Carro> carros = new ArrayList<Carro>();
		FuncCarros.cria_carro(carros);
		FuncCarros.lista_Carros(carros);
		try {
			FuncCarros.pesquisa(carros);
		} catch (CarroException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}
}
