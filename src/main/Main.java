package main;

import mode1.Produto;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		ArrayList<Produto> produtos = new ArrayList<>();

		int op = -1;

		while (op != 0) {

			System.out.println("=== SISTEMA DA LOJA ===");
			System.out.println("1 - Cadastrar produto");
			System.out.println("2 - Listar produtos");
			System.out.println("3 - Buscar produto");
			System.out.println("4 - Remover do estoque");
			System.out.println("5 - Adicionar estoque");
			System.out.println("6 - Alterar produto");
			System.out.println("7 - Excluir produto do sistema");
			System.out.println("0 - Sair");
			System.out.println("Escolha uma opção");

			op = sc.nextInt();

			switch (op) {

			case 1:
				System.out.println("Digite o código do produto: ");
				int codigo = sc.nextInt();
				if (codigo <= 0) {
					System.out.println("Código inválido!");
					break;
				}
				boolean codigoExiste = false;
				for (Produto produtoBusca : produtos) {
					if (produtoBusca.getCodigo() == codigo) {
						codigoExiste = true;
					}
				}
				if (codigoExiste == true) {
					System.out.println("Código já cadastrado!");
					break;
				}
				
				sc.nextLine();

				System.out.println("Digite o nome do produto: ");
				String nome = sc.nextLine();

				System.out.println("Digite o preço do produto: ");
				double preco = sc.nextDouble();
				if (preco <= 0) {
					System.out.println("Preço invalido!");
					break;
				}

				System.out.println("Digite a quantidade: ");
				int quantidadeEstoque = sc.nextInt();
				if (quantidadeEstoque < 0) {
					System.out.println("Quantidade invalida!");
					break;
				}

				Produto produto = new Produto(codigo, nome, preco, quantidadeEstoque);

				produtos.add(produto);

				System.out.println("Produto cadastrado com sucesso!");

				break;

			case 2:
				if (produtos.isEmpty()) {
					System.out.println("Nenhum item cadastrado.");
				} else {
					System.out.println("O sistema tem um total de " + produtos.size() + " produto(s).");
					System.out.println();

					for (Produto produtoLista : produtos) {
						System.out.println(produtoLista);
					}
				}

				break;
				
			case 3:
				System.out.println("Digite o código do produto que deseja buscar: ");
				int codigoBusca = sc.nextInt();
				
				boolean encontrado = false;
				
				for (Produto produtoBusca : produtos) {
					if (produtoBusca.getCodigo() == codigoBusca) {
						System.out.println(produtoBusca);
						encontrado = true;
					}
				}
				if (encontrado != true) {
					System.out.println("Produto não encontrado.");
				}
				
				break;
				
			case 4:
				System.out.println("Digite o código do produto que deseja remover: ");
				codigoBusca = sc.nextInt();
				Produto produtoRemover = null;
				
				for (Produto produtoBusca : produtos) {
					if (produtoBusca.getCodigo() == codigoBusca) {
						produtoRemover = produtoBusca;
					}
				}
				
				if (produtoRemover != null) {
					System.out.println("Digite a quantidade que deseja remover: ");
					int quantidadeRemover = sc.nextInt();
					
					if (quantidadeRemover <= 0) {
						System.out.println("Quantidade inválida!");
						break;
					} else {
						if (quantidadeRemover <= produtoRemover.getQuantidadeEstoque()) {
						    int novaQuantidade = produtoRemover.getQuantidadeEstoque() - quantidadeRemover;
	
						    produtoRemover.setQuantidadeEstoque(novaQuantidade);
	
						    System.out.println("Quantidade removida com sucesso!");
						} else {
							System.out.println("Não tem estoque suficiente!");
						}
					}
					
				} else {
					System.out.println("Produto não encontrado.");
				}
				
				break;
				
			case 5:
				System.out.println("Digite o código do produto que deseja adicionar ao estoque: ");
				int codigoAdicionar = sc.nextInt();
				
				Produto produtoAdicionar = null;
				
				for (Produto produtoBusca : produtos) {
					if (produtoBusca.getCodigo() == codigoAdicionar) {
						produtoAdicionar = produtoBusca;
					}
				}
				
				if (produtoAdicionar != null) {
					System.out.println("Quantas unidades desse código deseja adicionar ao estoque: ");
					int quantidadeAdicionar = sc.nextInt();
					if (quantidadeAdicionar <= 0) {
						System.out.println("Quantidade inválida!");
					} else {
						int novaQuantidade = produtoAdicionar.getQuantidadeEstoque() + quantidadeAdicionar;
						produtoAdicionar.setQuantidadeEstoque(novaQuantidade);
						System.out.println("Quantidade adicionada ao produto de código " + codigoAdicionar + " com sucesso!");
					}	
				} else {
					System.out.println("Produto não encontrado.");
				}
				
				break;
				
			case 6:
				System.out.println("Digite o código do produto que deseja alterar: ");
				int codigoAlterar = sc.nextInt();
				Produto produtoAlterar = null;
				
				for (Produto produtoBusca : produtos) {
					if (produtoBusca.getCodigo() == codigoAlterar) {
						produtoAlterar = produtoBusca;
					}
				}
				
				if (produtoAlterar != null) {
					System.out.println("Produto encontrado.");
					System.out.println("1 - Alterar nome");
					System.out.println("2 - Alterar preço");
					System.out.println("3 - Alterar nome e preço");
					
					int opcaoAlterar = sc.nextInt();
					
					switch (opcaoAlterar) {
					
					case 1:{
						sc.nextLine();
						System.out.println("Digite o novo nome: ");
						String novoNome = sc.nextLine();
						
						produtoAlterar.setNome(novoNome);
						
						System.out.println("Troca de nome concluida!");
						break;
					}
					case 2:{
						System.out.println("Digite o novo preço do produto: ");
						double novoPreco = sc.nextDouble();
						if (novoPreco <= 0) {
							System.out.println("Preço invalido!");
							break;
						}
						produtoAlterar.setPreco(novoPreco);
						
						System.out.println("Troca de preço concluida!");
						break;
					}
					case 3:{
						System.out.println("Digite o novo preço do produto: ");
						double novoPreco = sc.nextDouble();
						if (novoPreco <= 0) {
							System.out.println("Preço invalido!");
							break;
						}
						produtoAlterar.setPreco(novoPreco);
						
						System.out.println("Troca de preço concluida!");
						sc.nextLine();
						System.out.println("Digite o novo nome: ");
						String novoNome = sc.nextLine();
						
						produtoAlterar.setNome(novoNome);
						
						System.out.println("Troca de nome concluida!");
						
						break;
					}
					default:
						System.out.println("Opção inválida!");
					}
					
				} else {
					System.out.println("Produto não encontrado.");
				}
				
				break;
				
			case 7:
				System.out.println("Digite o código que deseja excluir: ");
				int codigoExcluir = sc.nextInt();
				Produto produtoExcluir = null;
				
				for (Produto produtoBusca : produtos) {
					if (produtoBusca.getCodigo() == codigoExcluir) {
						produtoExcluir = produtoBusca;
					}
				}
				
				if (produtoExcluir != null) {
					produtos.remove(produtoExcluir);
					System.out.println("Produto excluído com sucesso!");
				} else {
					System.out.println("Produto não encontrado.");
				}
				
				break;

			case 0:
				System.out.println("Saindo");
				break;

			default:
				System.out.println("Opção inválida!");
			}
		}
		sc.close();
	}
}