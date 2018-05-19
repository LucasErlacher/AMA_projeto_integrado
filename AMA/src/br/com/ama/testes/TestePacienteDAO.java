package br.com.ama.testes;

import java.sql.SQLException;
import java.util.List;

import br.com.ama.dao.PacienteDAO;
import br.com.ama.modelo.Paciente;
/*Alteração feita para teste de integracao com GitHub*/

public class TestePacienteDAO {
	public static void main(String[] args) throws SQLException {
		System.out.println("Houve uma conexao");
		PacienteDAO pacienteDAO = new PacienteDAO();
		List<Paciente> nomesPacientes = pacienteDAO.getAll();
		for(Paciente p: nomesPacientes) {
			System.out.println(p.getNome());
		}
	}
}
