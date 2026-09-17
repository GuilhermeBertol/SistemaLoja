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
		System.out.println("0 - Sair");
		System.out.println("Escolha uma opção");
		
		op = sc.nextInt();
		
		switch (op) {
		
		case 1:
			System.out.println("Digite o código do produto: ");
			int codigo = sc.nextInt();
			
			sc.nextLine();
			
			System.out.println("Digite o nome do produto: ");
			String nome = sc.nextLine();
			
			System.out.println("Digite o preço do produto: ");
			double preco = sc.nextDouble();
			
			System.out.println("Digite a quantidade: ");
			int quantidadeEstoque = sc.nextInt();
			
			Produto produto = new Produto(codigo, nome, preco, quantidadeEstoque);
			produtos.add(produto);
			
			System.out.println("Produto cadastrado com sucesso");
			break;
			
		case 2:
			if (produtos.isEmpty()) {
				System.out.println("Nenhum item cadastrado.");
				
			}else {
				System.out.println("O sistema tem um total de " + produtos.size() + " produto(s).");
				for (Produto p : produtos) {
					System.out.println(p);
			}
			}
			break;
			
		case 3:
			System.out.println("Digite o código do produto: ");
		    int codigoBusca = sc.nextInt();
			break;
			
		case 0:
			System.out.println("Saindo");
			break;
			
		default:
			System.out.println("Opção inválida!");
		}
	}
	}
}