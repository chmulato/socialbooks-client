package com.algaworks.socialbooks.aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import com.algaworks.socialbooks.client.LivrosClient;
import com.algaworks.socialbooks.client.domain.Livro;

public class Aplicacao {
	public static void main(String[] args) throws ParseException {
		
		LivrosClient client = new LivrosClient();
		
		List<Livro> listarLivros = client.listar();

		for(Livro livro : listarLivros) {
			System.out.println("Livro: " + livro.getNome());
		}
		
		Livro livro = new Livro();
		livro.setNome("Git passo-a-passo");
		livro.setEditora("AlgaWorks");
		
		SimpleDateFormat publicacao = new SimpleDateFormat("dd/MM/yyyy");
		livro.setPublicacao(publicacao.parse("01/01/2017"));
		
		livro.setResumo("Este livro aborda técnicas de desenvolvimento de APIs.");
		
		String localizacao = client.salvar(livro);
		
		System.out.println("URI do livro salvo: " + localizacao);
	}
}
