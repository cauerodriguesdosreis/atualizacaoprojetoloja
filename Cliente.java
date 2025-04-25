package produtosEcompra;

// Representa um cliente da loja
public class Cliente {

    private double saldo;

    public Cliente(double saldo) {

        this.saldo = saldo;
    }

    public double getSaldo() {
        return saldo;
    }

    public void debitar(double valor) {
        this.saldo -= valor;
    }
}
