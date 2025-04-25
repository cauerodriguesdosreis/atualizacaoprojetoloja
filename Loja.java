package produtosEcompra;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//Controla a interação com o usuário e a lógica de compra
public class Loja {
 private Cliente cliente;
 private static String nome;
 private List<Produto> produtos;
 private Scanner scanner;
 private boolean desejaComprar;
 
 public Loja(Cliente cliente) {
     this.cliente = cliente;
     this.scanner = new Scanner(System.in);
     this.produtos = new ArrayList<>();
     // Cadastrando alguns produtos no menu
     produtos.add(new Produto("Suco de Caju", 8.00));
     produtos.add(new Produto("Bolo de Chocolate", 12.50));
     produtos.add(new Produto("Coca-Cola 2L", 10.00));
     produtos.add(new Produto("Chocolate LACTA Família", 15.00));
 }
 
 private static String getNome() {
	return nome;
}
 
 // Método principal que controla o fluxo
 public void run() {
     perguntarCompra();
     if (desejaComprar) {
         exibirMenu();
     } else {
         System.out.println("Agradecemos pela visita, " + Loja.getNome() + "!");
     }
     scanner.close();
 }

// Pergunta inicial se o cliente deseja comprar
 private void perguntarCompra() {
     System.out.println("Olá! Seja bem-vindo à nossa loja virtual.");
     System.out.println("Qual é seu nome?");
     String nome = Loja.getNome();
     System.out.print("Você deseja comprar algo? (s/n): ");
     char resposta = scanner.next().toLowerCase().charAt(0);
     this.desejaComprar = (resposta == 's');
 }

 // Exibe o menu de produtos enquanto o cliente quiser continuar
 private void exibirMenu() {
     int opcao;
     do {
         System.out.println("\n----- MENU DE PRODUTOS -----");
         for (int i = 0; i < produtos.size(); i++) {
             Produto p = produtos.get(i);
             System.out.printf("%d. %s - R$ %.2f\n", i + 1, p.getNome(), p.getPreco());
         }
         System.out.println(produtos.size() + 1 + ". Sair");
         System.out.print("Escolha uma opção: ");
         opcao = scanner.nextInt();

         if (opcao >= 1 && opcao <= produtos.size()) {
             realizarCompra(produtos.get(opcao - 1));
         } else if (opcao == produtos.size() + 1) {
             System.out.println("Obrigado por comprar conosco!");
         } else {
             System.out.println("Opção inválida. Tente novamente.");
         }
     } while (opcao != produtos.size() + 1);
 }

 // Executa a compra de um produto selecionado
 private void realizarCompra(Produto produto) {
     System.out.printf("Você selecionou: %s (R$ %.2f)\n", produto.getNome(), produto.getPreco());
     if (cliente.getSaldo() >= produto.getPreco()) {
         cliente.debitar(produto.getPreco());
         System.out.printf("Compra realizada com sucesso! Saldo restante: R$ %.2f\n", cliente.getSaldo());
     } else {
         System.out.println("Saldo insuficiente para essa compra.");
     }
 }
}
