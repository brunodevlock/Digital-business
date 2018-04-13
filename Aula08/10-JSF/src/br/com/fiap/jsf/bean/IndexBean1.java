package br.com.fiap.jsf.bean;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class IndexBean1 {
	
	
	private String login;
	private String senha;
	
	
	//Método de validação de Login
	public void logar() {
		if (login.equals("FIAP") && senha.equals("FIAP2018")){
				System.out.println("Usuario logado");
	} else {
		System.out.println("Usuario e senha incorreta");
	}
	}
	
	// gets e sets
public String getLogin() {
	return login;
}
public void setLogin(String login) {
	this.login = login;
}
public String getSenha() {
	return senha;
}
public void setSenha(String senha) {
	this.senha = senha;
}

}


