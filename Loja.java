package pooLoja;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Loja {

	private Cliente cliente;
	private Loja loja;
	private List<Produto> produtos = new ArrayList<>();
	private Scanner sc = new Scanner(System.in);
	private char ComprarNovamente;
	private boolean MaisCompras;
	private boolean comprando;
	private boolean interacao;

	public Loja() {
		// inicializa o catálogo de produtos
		produtos.add(new Produto("Suco de Caju", 8.00, 10));
		produtos.add(new Produto("Bolo de chocolate", 15.00, 6));
		produtos.add(new Produto("Coca-Cola 2L", 12.00, 7));
		produtos.add(new Produto("Chocolate LACTA - Tamanho Família", 13.00, 9));
		produtos.add(new Produto("Trakinas - Morango", 7.00, 12));
	}

	public void run() {
		InteraçãoInicialCliente();
		sc.close();
	}

	private void InteraçãoInicialCliente() {
		interacao = true;
		
			// --- 1) Boas-vindas ---
			System.out.println("Olá! Seja bem-vindo(a) à nossa loja virtual.");
			
			while (interacao) {
			// --- 2) Pergunta se quer comprar ---
			System.out.print("Você deseja comprar algo? (s/n): ");
			char resposta = sc.nextLine().trim().toLowerCase().charAt(0);

			if (resposta != 's' && resposta != 'n') {
				System.out.println("Digite sim ou não...");
			}

			else if (resposta == 's') {

				// --- 3) Pergunta dados do cliente e os armazena ---
				System.out.println("Qual é seu nome? ");
				String nome = sc.nextLine();

				System.out.print("Digite seu saldo disponível (R$): ");
				double saldo = sc.nextDouble();
				sc.nextLine(); // consome o ENTER restante

				this.cliente = new Cliente(nome, saldo);

				System.out.println("\nCerto, levaremos você ao nosso menu...");
				
				interacao = false;
				ExibirMenu(cliente);
				
			} else if (resposta == 'n') {
				System.out.println("Tudo bem, volte sempre!");
				return;
			}
			
		}
			
		}
		
	private void ExibirMenu(Cliente cliente) {

		// --- 4) Loop do menu de produtos ---
		comprando = true;
		int opcao = 0;
		while (comprando) {
			System.out.println("\n----- MENU DE PRODUTOS -----");
			for (int i = 0; i < produtos.size(); i++) {
				Produto p = produtos.get(i);
				System.out.printf("%d) %s — R$ %.2f (%d disponíveis)\n", i + 1, p.getNome(), p.getPreco(), p.getQtd());
			}
			System.out.printf("%d) Sair\n", produtos.size() + 1);
			System.out.print("Escolha uma opção: ");
			opcao = sc.nextInt();
			sc.nextLine();

			if (opcao >= 1 && opcao <= produtos.size()) {
				realizarCompra(produtos.get(opcao - 1));
			} else if (opcao == produtos.size() + 1) {
				System.out.println("Obrigado por comprar conosco, " + cliente.getNome() + "!");
				comprando = false;
				MaisCompras = false;
				return;
			} else {
				System.out.println("Opção inválida. Tente novamente.");
			}
		}
	}

	// Método de compra após selecionar o produto desejado
	private void realizarCompra(Produto produto) {
		if (produto.getQtd() <= 0) {
			System.out.println("Produto indisponível em estoque.");
			return;
		}
		System.out.println("|");
		System.out.printf("Você selecionou: %s (R$ %.2f)\n", produto.getNome(), produto.getPreco());

		if (cliente.getSaldo() >= produto.getPreco()) {
			cliente.Compra(produto.getPreco());
			produto.venderUmaUnidade();
			System.out.printf("Compra realizada! Saldo restante: R$ %.2f\n", cliente.getSaldo());
			System.out.printf("Quantidade restante do mesmo produto: %d", produto.CompraProduto());
		}
		
		else {
			System.out.println("Compra não efetuada pois você não possui saldo suficiente.");
			System.out.println("Volte com mais dinheiro!");
			comprando = false;
			MaisCompras = false;
			return;
		}
		
		MaisCompras = true;
		System.out.println();
		System.out.println("|");
		
		while (MaisCompras) {
			System.out.println("Deseja comprar mais alguma coisa? (s/n)");
			ComprarNovamente = sc.next().toLowerCase().charAt(0);
			
			if (ComprarNovamente == 's') {
				ExibirMenu(cliente);
			}
			else if (ComprarNovamente == 'n') {
				System.out.println("Obrigado por comprar conosco, " + cliente.getNome() + "!");
				MaisCompras = false;
				comprando = false;
				return;
			}
			else {
				System.out.println("Não entendemos. Poderia digitar novamente?");
				
			}
		}

	}

}
