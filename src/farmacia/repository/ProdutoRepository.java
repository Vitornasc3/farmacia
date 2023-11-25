package farmacia.repository;

import farmacia.model.Produto;

public interface ProdutoRepository {

	public void cadastrarProduto(Produto produto);

	public void listarProdutos();

	public void pesquisarPorNumero(int codigo);

	public void atualizarProduto(Produto produto);

	public void removerProduto(int codigo);

}
