package br.com.fiap.ws.service;

import java.util.Arrays;
import java.util.List;

import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import br.com.fiap.ws.TO.Produto;

public class ProdutoService {
	
	private Client client = Client.create();
	private static final String URL = "http://localhost:8080/07-WS-Restful-Server/rest/produto/";
	
	
	//Atualizar
	
	public void atualizar(Produto produto) throws Exception {
		WebResource w = client.resource(URL)
				.path(String.valueOf(produto.getCodigo()));
		
			ClientResponse response = w
				//Tipo de dados JSON
				.type(MediaType.APPLICATION_JSON)
				.put(ClientResponse.class, produto); //put � pra atualizar o produto
		
			//Status 200 OK
			if(response.getStatus() != 200) {
				throw new Exception("Erro" + response.getStatus());
			}
			
	}

		
	//Cadastrar
	public void cadastrar(Produto produto) throws Exception {
		
		WebResource w = client.resource(URL);
		
		ClientResponse response = w
				//Tipo de dados que ser�o enviados
				.type("application/json")  //type � para mandar
				.post(ClientResponse.class, produto);   // , o produto que quero cadastrar
		
		
		//201 Created
		if (response.getStatus() != 201) {
			throw new Exception("Erro" + response.getStatus());
			}
		
	}
	
	
	
	
	//Listar
	public List<Produto>listar() throws Exception{
				
		WebResource w = client.resource(URL);
		ClientResponse response = w
				
				.accept(MediaType.APPLICATION_JSON)
				.get(ClientResponse.class);
		
		if (response.getStatus() != 200){
			throw new Exception("Erro" 
						+ response.getStatus());
		}
			
						
			return Arrays.asList(
				response.getEntity(Produto[].class));
		
	}
	
		
	//M�todo Pesquisar
	public Produto pesquisar(int codigo) throws Exception {
		WebResource w = client.resource(URL)
				.path(String.valueOf(codigo));
		ClientResponse response = w
			
			//Recebe JSON
			.accept(MediaType.APPLICATION_JSON)
			.get(ClientResponse.class); // � o resultado que o server envia para n�s
		
		//Valida se n�o foi OK
		if(response.getStatus() != 200) {
			throw new Exception("Erro" + response.getStatus());
		}
		//Retorna o produto encontrado
		return response.getEntity(Produto.class);
		
	}
	
	
	
	//Remover
	public void remover(int codigo) throws Exception {
		WebResource w = client.resource(URL)
				.path(String.valueOf(codigo));
					
			ClientResponse response = w.delete(ClientResponse.class);
			
			//204 - No Content
			if(response.getStatus() != 204) {
				throw new Exception("Erro" + response.getStatus());
			}
		
	}

}
