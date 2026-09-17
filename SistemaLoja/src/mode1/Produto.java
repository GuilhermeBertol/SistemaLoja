package mode1;

public class Produto {
	
	private int codigo;
	private String nome;
	private double preco;
	private int quantidadeEstoque;
	
	public Produto(int codigo, String nome, double preco, int quantidadeEstoque) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.preco = preco;
		this.quantidadeEstoque = quantidadeEstoque;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public int getQuantidadeEstoque() {
		return quantidadeEstoque;
	}

	public void setQuantidadeEstoque(int quantidadeEstoque) {
		this.quantidadeEstoque = quantidadeEstoque;
	}

	@Override
	public String toString() {

	    return "Código = " + codigo + "\n"
	            + "Nome = " + nome + "\n"
	            + "Preço = " + String.format("R$ %.2f", preco) + "\n"
	            + "Quantidade no estoque = " + quantidadeEstoque + "\n";

	}
}