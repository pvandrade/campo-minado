package br.com.cod3r.cm;

import br.com.cod3r.cm.model.Tabuleiro;

public class Aplication {
	
	public static void main(String[] args) {
		Tabuleiro tabuleiro = new Tabuleiro(6, 6, 6);
		
		tabuleiro.abrir(3, 3);
		tabuleiro.marcar(4, 4);
		tabuleiro.marcar(4, 5);		
		
		System.out.println(tabuleiro);
	}
}
