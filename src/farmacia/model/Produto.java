package farmacia.model;

public abstract class Produto {

	private int id;
	private String nome;
	private int tipo;
	private float preco;

	public Produto(int id, String nome, int tipo, float preco) {
		super();
		this.id = id;
		this.nome = nome;
		this.tipo = tipo;
		this.preco = preco;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}

	public void visualizar() {

		String tipo = "";

		switch (this.tipo) {
		case 1 -> tipo = "Medicamento";
		case 2 -> tipo = "Cosmético";
		}

		System.out.println("\n\n***********************************");
		System.out.println("           Dados do produto            ");
		System.out.println("***************************************");
		System.out.println(" ID do produto: " + this.id);
		System.out.println(" Nome do produto: " + this.nome);
		System.out.println(" Tipo do produto: " + tipo);
		System.out.printf(" Preço do produto: R$%.2f \n", this.preco);

	}

}
