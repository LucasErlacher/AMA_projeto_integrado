package br.com.ama.testes;

import static org.junit.jupiter.api.Assertions.*;

import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import br.com.ama.api.BuscaCep;

class TesteBuscaCep {

	@Test
	void TesteCidade() {
		JSONObject json = BuscaCep.getLocal("29104583");
		assertEquals("Vila Velha",json.getString("cidade"));		
	}
	
	@Test
	void TesteBairro() {
		JSONObject json = BuscaCep.getLocal("29104583");
		assertEquals("Jardim Colorado",json.getString("bairro"));		
	}
	@Test
	void TesteEstado() {
		JSONObject json = BuscaCep.getLocal("29104583");
		assertEquals("ES",json.getString("estado"));		
	}

}
