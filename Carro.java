import java.io.Serializable;
import java.util.Date;
import java.io.Serializable;
public class Carro implements Serializable{
		private String marca, modelo, alugado;
		private int ano, km, cilindrada, potencia;
		private double preco_compra, preco_aluguer;
		private Date dataInicio;
		private Date datafim;
		
		
		public Date getDataInicio() {
			return dataInicio;
		}

		public void setStartDate(Date dataInicio) {
			this.dataInicio = dataInicio;
		}

		public Date getDatafim() {
			return datafim;
		}

		public void setEndDate(Date datafim) {
			this.datafim = datafim;
		}
		
		public String getMarca() {
			return marca;
		}
		public void setMarca(String marca) {
			this.marca = marca;
		}
		public String getModelo() {
			return modelo;
		}
		public void setModelo(String modelo) {
			this.modelo = modelo;
		}
		public String getAlugado() {
			return alugado;
		}
		public void setAlugado(String alugado) {
			this.alugado = alugado;
		}
		public int getAno() {
			return ano;
		}
		public void setAno(int ano) {
			this.ano = ano;
		}
		public int getKm() {
			return km;
		}
		public void setKm(int km) {
			this.km = km;
		}
		public int getCilindrada() {
			return cilindrada;
		}
		public void setCilindrada(int cilindrada) {
			this.cilindrada = cilindrada;
		}
		public int getPotencia() {
			return potencia;
		}
		public void setPotencia(int potencia) {
			this.potencia = potencia;
		}
		public double getPreco_compra() {
			return preco_compra;
		}
		public void setPreco_compra(double preco_compra) {
			this.preco_compra = preco_compra;
		}
		public double getPreco_aluguer() {
			return preco_aluguer;
		}
		public void setPreco_aluguer(double preco_aluguer) {
			this.preco_aluguer = preco_aluguer;
		}
		@Override
		public String toString() {
			return "Carros\nMarca: " + marca + "\nModelo: " + modelo + "\nAlugado: " + alugado + "\nAno: " + ano + "\nKm: "
					+ km + "\nCilindrada: " + cilindrada + "\nPotência: " + potencia + "\nPreço de compra: " + preco_compra
					+ "\nPreço de aluguer: " + preco_aluguer + '}';
		}
		public Carro(String marca, String modelo, int ano, int km, int cilindrada, int potencia, double preco_compra,
				double preco_aluguer) {
			super();
			this.marca = marca;
			this.modelo = modelo;
			this.ano = ano;
			this.km = km;
			this.cilindrada = cilindrada;
			this.potencia = potencia;
			this.preco_compra = preco_compra;
			this.preco_aluguer = preco_aluguer;
			this.alugado="Não alugado";
			
		}
		public static boolean comparaCarro(Carro carro1, Carro carro2) {
			if(carro1.marca.equals(carro2.marca) && carro1.modelo.equals(carro2.modelo) && carro1.ano == carro2.ano &&
			   carro1.km == carro2.km && carro1.cilindrada == carro2.cilindrada && carro1.potencia == carro2.potencia && 
			   carro1.potencia == carro2.potencia && carro1.preco_aluguer == carro2.preco_aluguer && 
			   carro1.preco_compra == carro2.preco_compra && carro1.alugado.equals(carro2.alugado)) {
				return true;
			}
			return false;
		}
}