package br.com.cod3r.cm.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.cod3r.cm.exception.ExplosionException;

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
	
	@Test
	void valorPadraoAtributoMarcadaTest() {
		assertFalse(casa.isMarcada());
	}
	
	@Test
	void addMarcacaoTest1() {
		casa.addMarcacao();
		assertTrue(casa.isMarcada());
	}
	
	@Test
	void addMarcacaoTest2() {
		casa.addMarcacao();
		casa.addMarcacao();
		assertFalse(casa.isMarcada());
	}
	
	@Test
	void abrirNaoMinadaNaoMarcadaTest() {
		assertTrue(casa.abrir());
	}
	
	@Test
	void abrirNaoMinadaMarcadaTest() {
		casa.addMarcacao();
		assertFalse(casa.abrir());
	}
	
	@Test
	void abrirMinadaMarcadaTest() {
		casa.addMarcacao();
		casa.minar();
		assertFalse(casa.abrir());
	}
	
	@Test
	void abrirMinadaNaoMarcadaTest() {
		casa.minar();
		assertThrows(ExplosionException.class, () -> {
			casa.abrir();
		});
	}
	
	@Test
	void abrirComVizinhosTest1() {

		Casa casa1x1 = new Casa(1,1);
		
		Casa casa2x2 = new Casa(2,2);
		casa2x2.addVizinho(casa1x1);
		
		casa.addVizinho(casa2x2);
		casa.abrir();
		
		assertTrue(casa2x2.isAberta() && casa1x1.isAberta());
	}
	
	@Test
	void abrirComVizinhosTest2() {

		Casa casa1x1 = new Casa(1,1);
		Casa casa1x2 = new Casa(1,1);
		casa1x2.minar();
		
		Casa casa2x2 = new Casa(2,2);
		casa2x2.addVizinho(casa1x1);
		casa2x2.addVizinho(casa1x2);
		
		casa.addVizinho(casa2x2);
		casa.abrir();
		
		assertTrue(casa2x2.isAberta() && !casa1x1.isAberta());
	}
}