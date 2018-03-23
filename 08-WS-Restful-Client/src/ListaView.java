import java.util.List;

import br.com.fiap.ws.TO.Produto;
import br.com.fiap.ws.service.ProdutoService;

public class ListaView {
	
	public static void main(String[] args) {
		
		ProdutoService service = new ProdutoService();
		
		try {
		List<Produto> lista = service.listar();
		for (Produto produto : lista) {
			System.out.println(produto.getCodigo());
			System.out.println(produto.getPreco());
			System.out.println(produto.isDisponivel());
			System.out.println("******************");
			}
		}catch (Exception e) {
			System.err.println(e.getMessage());
		}
		
	}

}
