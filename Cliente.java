package pooLoja;

public class Cliente {
	
	private String nome;
	private double saldo;

	public Cliente(String nome, double saldo) {
		this.nome = nome;
		this.saldo = saldo;
	}
	
	public String getNome() {
		return nome;
	}
	
	public double getSaldo() {
		return saldo;
	}
	
	public void Compra (double valor) {
		this.saldo -= valor;
	}
}
