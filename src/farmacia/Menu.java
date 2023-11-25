package farmacia;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Optional;
import java.util.Scanner;

import farmacia.controller.ProdutoController;
import farmacia.model.*;
import farmacia.model.Cosmetico;
import farmacia.model.Medicamento;

public class Menu {

	static Scanner leia = new Scanner(System.in);

	public static void main(String[] args) {

		ProdutoController produtos = new ProdutoController();
		int opcao = 0, codigo, tipo;
		String nome, generico, fragrancia;
		float preco;

		while (true) {

			System.out.println("-------------------------------------");
			System.out.println("               Farmácia              ");
			System.out.println("-------------------------------------");
			System.out.println("     1 - Cadastrar produto           ");
			System.out.println("     2 - Listar produtos             ");
			System.out.println("     3 - Pesquisar produto por número");
			System.out.println("     4 - Atualizar produto           ");
			System.out.println("     5 - Remover produto             ");
			System.out.println("     0 - Sair                        ");
			System.out.println("-------------------------------------");
			System.out.println("  - Insira a opção desejada          ");

			try {
				opcao = leia.nextInt();

			} catch (InputMismatchException e) {
				leia.nextLine();
				opcao = 0;
			}

			switch (opcao) {
			case 1 -> {
				System.out.println("Opção cadastrar selecionada!");

				System.out.print("Digite o nome do produto: ");
				leia.skip("\\R");
				nome = leia.nextLine();

				System.out.print("Digite o tipo do produto: 1 Medicamento | 2 Cosmetico");

				do {
					tipo = leia.nextInt();
				} while (tipo < 1 || tipo > 2);

				System.out.print("Digite o valor do produto: ");
				preco = leia.nextFloat();

				leia.nextLine();
				switch (tipo) {

				case 1 -> {

					System.out.print("Digite o nome do genérico: ");
					generico = leia.nextLine();
					produtos.cadastrarProduto(new Medicamento(produtos.gerarCodigo(), nome, tipo, preco, generico));

				}
				case 2 -> {

					System.out.print("Digite a fragrância do produto: ");
					fragrancia = leia.nextLine();
					produtos.cadastrarProduto(new Cosmetico(produtos.gerarCodigo(), nome, tipo, preco, fragrancia));
				}
				}
				keyPress();
			}
			case 2 -> {
				System.out.println("Opção listar produtos selecionada!");

				produtos.listarProdutos();

				keyPress();
			}
			case 3 -> {
				System.out.println("Opção pesquisar produto selecionada!");

				System.out.print("Digite o código do produto: ");
				codigo = leia.nextInt();
				produtos.pesquisarPorNumero(codigo);

				keyPress();
			}
			case 4 -> {
				System.out.println("Opção atualizar produto selecionada!");

				System.out.print("Digite o código do produto: ");
				codigo = leia.nextInt();

				Optional<Produto> produtoTipo = produtos.percorrerLista(codigo);

				if (produtoTipo.isPresent()) {

					System.out.print("Digite o nome do produto: ");
					leia.skip("\\R");
					nome = leia.nextLine();

					tipo = produtoTipo.get().getId();

					switch (tipo) {
					case 1 -> {
						System.out.print("Digite o valor do produto: ");
						preco = leia.nextFloat();

						System.out.print("Digite o nome do genérico: ");
						leia.skip("\\R");
						generico = leia.nextLine();

						produtos.atualizarProduto(new Medicamento(codigo, nome, tipo, preco, generico));

					}
					case 2 -> {
						System.out.print("Digite o valor do produto: ");
						preco = leia.nextFloat();

						System.out.print("Digite o nome do genérico: ");
						fragrancia = leia.nextLine();

						produtos.atualizarProduto(new Cosmetico(codigo, nome, tipo, preco, fragrancia));
					}
					}

				} else
					System.out.println("Produto não encontrado");

				keyPress();
			}
			case 5 -> {
				System.out.println("Opção remover produto selecionada!");

				System.out.print("Digite o código do produto: ");
				codigo = leia.nextInt();
				produtos.removerProduto(codigo);

				keyPress();
			}
			case 0 -> {
				System.out.println("Programa encerrado");

				keyPress();
				sobre();
				System.exit(0);
			}
			default -> {
				System.out.println("Opção inválida!");
			}
			}
		}
	}

	public static void sobre() {

		System.out.println("                                                                        ");
		System.out.println("************************************************************************");
		System.out.println(" Projeto farmácia desenvolvido por: Vitor do Nascimento Ferreira        ");
		System.out.println(" Generation Brasil - generation@generation.org                          ");
		System.out.println(" GitHub: github.com/Vitornasc3/conta_bancaria                           ");
		System.out.println("************************************************************************");

	}

	public static void keyPress() {

		try {
			System.out.println("\n\n  ***  Pressione a tecla Enter para continuar...");
			System.in.read();

		} catch (IOException e) {

			System.out.println("Você pressionou uma tecla inválida!");
		}
	}

}
