/*
 * Projeto Loja Virtual - Exemplo de POO
 *
 * Explicação:
 * - Classe Cliente: encapsula dados e métodos relacionados ao cliente.
 * - Classe Produto: encapsula dados de um produto.
 * - Classe Loja: responsável pela interação com o usuário, menu e lógica de compra.
 * - Classe Main: ponto de entrada, inicializa a Loja e chama o método run().
 *
 * Princípios de POO aplicados:
 * 1. Encapsulamento: atributos privados, acesso via getters/setters.
 * 2. Responsabilidade única: cada classe tem uma única responsabilidade.
 * 3. Baixo acoplamento: dependências claras e bem definidas.
 */

package produtosEcompra;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Ponto de entrada da aplicação
public class codigo {
    public static void main(String[] args) {
        Cliente joao = new Cliente(80.00);
        Loja minhaLoja = new Loja(joao);
        minhaLoja.run();
    }
}
