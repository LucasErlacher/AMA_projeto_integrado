package br.com.ama.testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import br.com.ama.enums.EUsuario;

class TesteEnumTipoUsuario {

	@Test
	void TesteAgentedeSaude() {
		assertEquals(1,EUsuario.AGENTESAUDE.getCodigo());
	}
	
	@Test
	void TestePaciente() {
		assertEquals(2,EUsuario.PACIENTE.getCodigo());
	}
}
