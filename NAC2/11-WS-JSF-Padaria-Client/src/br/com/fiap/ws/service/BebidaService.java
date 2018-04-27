package br.com.fiap.ws.service;

import java.util.Arrays;
import java.util.List;

import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import br.com.fiap.ws.to.Bebida;

public class BebidaService {
	
	private Client client = Client.create();
	
	private static final String URL ="htttp://localhost:8080/09-WS-Restful-Padaria-Server/rest/bebida/";

	//Listar
	public List<Bebida> list() throws Exception{
		
		//Cria o acesso ao WebService com a URl
		WebResource resource = client.resource(URL);

		ClientResponse response = resource
				//Formato de dados que ser� enviado ao ws
				.type(MediaType.APPLICATION_JSON)
				//Faz um POST enviando os dados
				.post(ClientResponse.class, bebida);

		//Valida se cadastrou HTTP Status 201 created
		if(response.getStatus() != 200) {
			throw new Exception("Erro: "  + response.getStatus());
		}
		//Recupera as sele��es e retorna
		return Arrays.asList(response.getEntity(Bebida[].class));

	}
		

		
	
	//Cadastrar
	public void cadastrar(Bebida bebida) throws Exception{
		WebResource resource = client.resource(URL);
		
		ClientResponse response = resource
				//Formato de dados que ser� enviado ao ws
				.type(MediaType.APPLICATION_JSON)
				//Faz um POST enviando os dados
				.post(ClientResponse.class, bebida); //coloca o parametro no post e put...
		//.....cadastrar e no atualizar
				
		//Valida se cadastrou HTTP Status 201 created
		if(response.getStatus() != 201) {
			throw new Exception("Erro: "  + response.getStatus());
		}
		
	}
	
	
	//Buscar
	public Bebida buscar(int codigo) throws Exception{
		
		WebResource resource = client.resource(URL)
				.path(String.valueOf(codigo));
		
		ClientResponse response = resource
				//Formato de dados que ser� enviado ao ws
				.accept(MediaType.APPLICATION_JSON)
				//Faz um POST enviando os dados
				.get(ClientResponse.class);
				
		//Valida se cadastrou HTTP Status 201 created
		if(response.getStatus() != 200) {
			throw new Exception("Erro: "  + response.getStatus());
		}
		//Recupera a Sele��o
		return response.getEntity(Bebida.class);
		
	}
	
	
	//Atualizar
	
	//Remover
	
	

}
