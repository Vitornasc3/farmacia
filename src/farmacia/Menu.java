package farmacia;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

	static Scanner leia = new Scanner(System.in);

	public static void main(String[] args) {

		int opcao = 0;

		while (true) {

			System.out.println("---------------------------------");
			System.out.println("            Farmácia             ");
			System.out.println("---------------------------------");
			System.out.println(" 1 - Cadastrar produto           ");
			System.out.println(" 2 - Listar produtos             ");
			System.out.println(" 3 - Pesquisar produto por número");
			System.out.println(" 4 - Atualizar produto           ");
			System.out.println(" 5 - Remover produto             ");
			System.out.println(" 0 - Sair                        ");
			System.out.println("---------------------------------");
			System.out.println("  - Insira a opção desejada      ");

			try {
				opcao = leia.nextInt();

			} catch (InputMismatchException e) {
				leia.nextLine();
				opcao = 0;
			}

			switch (opcao) {
			case 1 -> {System.out.println("Opção cadastrar selecionada!");
			
			keyPress();
			}
			case 2 -> {System.out.println("Opção listar produtos selecionada!");
			
			keyPress();
			}
			case 3 -> {System.out.println("Opção pesquisar produto selecionada!");
			
			keyPress();
			}
			case 4 -> {System.out.println("Opção atualizar produto selecionada!");
			
			keyPress();
			}
			case 5 -> {System.out.println("Opção remover produto selecionada!");
			
			keyPress();
			}
			case 0 -> {System.out.println("Programa encerrado");
			
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
