package com.fiap.inventario;

import java.util.Arrays;
import java.util.List;

import org.apache.axis2.AxisFault;

import com.fiap.inventario.EstoqueBOStub.Listar;
import com.fiap.inventario.EstoqueBOStub.ListarResponse;
import com.fiap.inventario.EstoqueBOStub.ProdutoTO;

public class ListarView {

	public static void main(String[] args) {
		
		try {
			EstoqueBOStub stub = new EstoqueBOStub();
			Listar params = new Listar();
			ListarResponse resp = stub.listar(params);
			
			ProdutoTO[] array = resp.get_return();
			
			//transformar Array em LISTA
			List<ProdutoTO> lista = Arrays.asList(array);
			
			
			for(ProdutoTO p : lista) {
				System.out.println(p.getNome());
				System.out.println(p.getPreco());
				System.out.println(p.getQuantidade());
				System.out.println("*****************");
				
			}
			
			
		} catch (Exception e) {
			
			System.err.println(e.getMessage());
		}
		

	}

}