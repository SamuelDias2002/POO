import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Main {
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
		System.out.println("");
		opcao = Ler.umInt();
		return opcao;
	}
	/*
	 * Função que torna a opções dadas no menu usaveis
	 */
	public static void main(String[] args) throws clienteException{
		
		ArrayList<Carro> carros = new ArrayList<Carro>();
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
		int opcao = 0;
		Agencia a = new Agencia();
		a.lerCarro();
		a.lerClientes();
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
				try {
					System.out.println(FuncCarros.mais_Alugado(carros));
				} catch (Mais_Alugado_Exception e1) {
		
					System.out.println(e1.getMessage());
				}
				break;
			case 6:
				try {
					System.out.println(FuncCarros.mais_Alugado(carros));
				} catch (Mais_Alugado_Exception e1) {
				
					System.out.println(e1.getMessage());
				}
				break;
			case 7:
				FuncCarros.Lista_CarrosAlugados(carros);
				break;
			case 8:
				try {
					FuncCarros.alugar_Carro(carros, clientes);
				} catch (alugarExcecao e) {
					System.out.println(e.getMessage());
				}
				break;
			case 9:
				try {
					FuncCarros.entregar_Carro(carros, clientes);
				} catch (EntregarException e) {
					System.out.println(e.getMessage());
				}
				break;
			case 10:
				//Executa a parte de codigo para adicionar um novo cliente
				FuncCarros.AdicionarCliente(clientes);
				break;
			case 11:
				FuncCarros.lista_Clientes(clientes);
				break;
			}
		}while(opcao != 12);
	}
}
