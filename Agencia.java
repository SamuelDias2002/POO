import java.io.*;
import java.util.ArrayList;
public class Agencia {
	ArrayList<Carro> carros = new ArrayList<Carro>();
	ArrayList<Cliente> clientes = new ArrayList<Cliente>();
	public Agencia() {

	}
	public void lerCarro() {
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
	}
	/*
	 * Ler ficheiro Clientes
	 */
	public void lerClientes() {
		ArrayList<Carro> carros = new ArrayList<Carro>();
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
		int cliente = 0;
		try {
			ObjectInputStream is = new ObjectInputStream(new FileInputStream("C:\\POOpratica\\MainProjeto\\src\\Clientes.dat")); // ALTEREM SEMPRE A VOSSA DIRETORIA
			clientes = (ArrayList<Cliente>) is.readObject();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}

	}
}



