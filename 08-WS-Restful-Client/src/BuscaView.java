import java.util.Scanner;

import br.com.fiap.ws.TO.Produto;
import br.com.fiap.ws.service.ProdutoService;

public class BuscaView {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Digite o c�digo");
		int codigo = sc.nextInt();
		
		ProdutoService service = new ProdutoService();
		
	try {
		
		Produto produto = service.pesquisar(codigo);
		System.out.println(produto.getNome());
		System.out.println(produto.getPreco());
		System.out.println(produto.isDisponivel());
	}catch (Exception e) {
		System.err.println(e.getMessage());
	}
		
		
		sc.close();
		

	}

}