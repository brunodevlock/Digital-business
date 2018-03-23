import java.util.Scanner;

import br.com.fiap.ws.TO.Produto;
import br.com.fiap.ws.service.ProdutoService;

public class CadastrarView {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Produto produto = new Produto();
		
		System.out.println("Nome: ");
		produto.setNome(sc.next() + sc.nextLine());
		
		System.out.println("Preço: ");
		produto.setPreco(sc.nextDouble());
		
		System.out.println("Disponivel: ");
		produto.setDisponivel(sc.nextBoolean());
		
		
		ProdutoService service = new ProdutoService();
		try {
			service.cadastrar(produto);
			System.out.println("Cadastrado");
		}catch (Exception e) {
			System.err.println(e.getMessage());
		}
		
		sc.close();

	}

}
