import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;
public class Cliente implements Serializable{
	private String nome, cidade;
	private int idade, NIF, carros_Alugados;
	private ArrayList<Carro> carrosAlugados;
	public Cliente(String nome, String cidade, int idade, int nIF) {
		this.nome = nome;
		this.cidade = cidade;
		this.idade = idade;
		NIF = nIF;
		carrosAlugados = new ArrayList<Carro>();
	}
	public String getNome() {
		return nome;
	}
	public String getCidade() {
		return cidade;
	}
	public int getNIF(){
		return NIF;
	}
	public ArrayList<Carro> getCarrosAlugados(){
		return carrosAlugados;
	}
	public void adicionarCarroAlugado(Carro carro) {
		carrosAlugados.add(carro);
	}
	@Override
	public String toString() {
		return "\nNome: " + nome + "\nCidade: " + cidade + "\nIdade: " + idade + "\nNIF:" + NIF
				+ "\nNúmero de carros alugados: " + carros_Alugados + "\nCarros alugados: " + carrosAlugados + "\n";
	}
}