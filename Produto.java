package pooLoja;

public class Produto {
	
	private String nome;
	private double preco;
	private int qtd;

	public Produto(String nome, double preco, int qtd) {
		this.nome = nome;
		this.preco = preco;
		this.qtd = qtd;
	}
	
	public String getNome() {
		return nome;
	}

	public double getPreco() {
		return preco;
	}
	
	public int getQtd() {
		return qtd;
	}
	
	public int CompraProduto() {
		return qtd;
	}
	
    public boolean venderUmaUnidade() {
        if (qtd > 0) {
            qtd--;
            return true;
        } else {
            return false;
        }
    }	
}
