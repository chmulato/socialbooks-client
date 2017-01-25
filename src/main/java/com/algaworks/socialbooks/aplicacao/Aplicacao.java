package com.algaworks.socialbooks.aplicacao;

import java.net.URI;

import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class Aplicacao {
	
	public static void main(String[] args) {
		
		RestTemplate restTemplate = new RestTemplate();
		
		//     user: chmulato
		// password: caracore
		// chmulato:caracore
		RequestEntity<Void> request = RequestEntity
				.get(URI.create("http://localhost:8080/livros"))
				.header("Authorization", "Basic Y2htdWxhdG86Y2FyYWNvcmU=").build();

		ResponseEntity<Livro[]> response = restTemplate.exchange(request, Livro[].class);

		for(Livro livro : response.getBody()) {
			System.out.println("Livro: " + livro.getNome());
		}
		
	}

}
