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
		System.out.println("0 - Sair");
		System.out.println("Escolha uma opção");
		
		op = sc.nextInt();
		
		switch (op) {
		
		case 1:
			System.out.println("Digite o código do produto: ");
			int codigo = sc.nextInt();
			
			System.out.println("Digite o nome do produto: ");
			String nome = sc.next();
			
			System.out.println("Digite o preço do produto: ");
			double preco = sc.nextDouble();
			
			System.out.println("Digite a quantidade: ");
			int quantidadeEstoque = sc.nextInt();
			
			break;
			
		case 2:
			System.out.println("Listar produtos");
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