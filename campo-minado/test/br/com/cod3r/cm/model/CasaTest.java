package br.com.cod3r.cm.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CasaTest {
	
	private Casa casa;
	
	@BeforeEach
	void iniciarCasa() {
		casa = new Casa(3,3);
	}
	
	@Test
	void testeVizinhoDistanciaCima() {
		Casa vizinho = new Casa(2,3);
		boolean resultado = casa.addVizinho(vizinho);
		assertTrue(resultado);
	}
	
	@Test
	void testeVizinhoDistanciaBaixo() {
		Casa vizinho = new Casa(4,3);
		boolean resultado = casa.addVizinho(vizinho);
		assertTrue(resultado);
	}
	
	@Test
	void testeVizinhoDistanciaEsquerda() {
		Casa vizinho = new Casa(3,2);
		boolean resultado = casa.addVizinho(vizinho);
		assertTrue(resultado);
	}
	
	@Test
	void testeVizinhoDistanciaDireita() {
		Casa vizinho = new Casa(3,4);
		boolean resultado = casa.addVizinho(vizinho);
		assertTrue(resultado);
	}
	
	@Test
	void testeVizinhoDistanciaDiagonal() {
		Casa vizinho = new Casa(2,2);
		boolean resultado = casa.addVizinho(vizinho);
		assertTrue(resultado);
	}
	
	@Test
	void testeNaoVizinho() {
		Casa vizinho = new Casa(1,1);
		boolean resultado = casa.addVizinho(vizinho);
		assertFalse(resultado);
	}
}