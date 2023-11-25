package farmacia.controller;

import java.util.ArrayList;
import java.util.Optional;

import farmacia.model.Produto;
import farmacia.repository.ProdutoRepository;

public class ProdutoController implements ProdutoRepository {

	private ArrayList<Produto> listaProdutos = new ArrayList<Produto>();

	int codigo = 0;

	@Override
	public void cadastrarProduto(Produto produto) {
		listaProdutos.add(produto);
		System.out.println("Produto adicionado!");
	}

	@Override
	public void listarProdutos() {
		for (var produto : listaProdutos) {
			produto.visualizar();
		}
	}

	@Override
	public void atualizarProduto(Produto produto) {

		Optional<Produto> buscaProduto = percorrerLista(produto.getId());

		if (buscaProduto.isPresent()) {
			listaProdutos.set(listaProdutos.indexOf(buscaProduto.get()), produto);
			System.out.println("Produto " + produto.getId() + " atualizado com sucesso!");
		} else
			System.out.println("O produto " + produto.getId() + " não foi localizado.");

	}

	@Override
	public void removerProduto(int codigo) {

		Optional<Produto> produto = percorrerLista(codigo);

		if (produto.isPresent()) {
			if (listaProdutos.remove(produto.get())) {
				System.out.println("O produto " + codigo + " foi removido");
			}
		} else {
			System.out.println("Produto não encontrado");
		}

	}

	@Override
	public void pesquisarPorNumero(int codigo) {

		Optional<Produto> produto = percorrerLista(codigo);

		if (produto.isPresent())
			produto.get().visualizar();
		else
			System.out.println("Produto não localizado");

	}

	public int gerarCodigo() {
		return ++codigo;

	}

	public Optional<Produto> percorrerLista(int codigo) {

		for (var produto : listaProdutos) {
			if (produto.getId() == codigo) {
				return Optional.of(produto);

			}
		}

		return Optional.empty();
	}

}
