package com.fiap.inventario;

import java.util.Scanner;

import org.apache.axis2.AxisFault;

import com.fiap.inventario.EstoqueBOStub.ConsultarProduto;
import com.fiap.inventario.EstoqueBOStub.ConsultarProdutoResponse;
import com.fiap.inventario.EstoqueBOStub.ProdutoTO;

public class TerminalConsulta {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		try {
			EstoqueBOStub stub = new EstoqueBOStub();
			ConsultarProduto params = new ConsultarProduto(); // metodo para acessar e enviar para o servidor 
			System.out.println("Digie o codigo do produto");
			params.setCodigo(sc.nextInt());
			
			ConsultarProdutoResponse resp = 
					stub.consultarProduto(params); //Recebe o produto devolta com o Response
			
			ProdutoTO produto = resp.get_return();
			System.out.println(produto.getNome());
			System.out.println(produto.getPreco());
			System.out.println(produto.getQuantidade());
			
			
		} catch (Exception e) { // trata as duas exce�oes ao mesmo tempo
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
		
		sc.close();

	}

}