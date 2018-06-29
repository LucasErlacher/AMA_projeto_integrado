package br.com.amawebinterface.cgt;

import br.com.amawebinterface.cdp.ESexo;
import br.com.amawebinterface.cdp.Paciente;
import br.com.amawebinterface.cgd.dao.PacienteDAO;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AplPaciente {

    private final PacienteDAO pacienteDAO = new PacienteDAO();
    private static AplPaciente instance;

    public static AplPaciente getInstance() {
        if (instance == null) {
            instance = new AplPaciente();
        }
        return instance;
    }

    private AplPaciente() {
    }

    ;
    
    public void cadastrarPaciente(Paciente paciente) {
        if ((paciente.validaPaciente())) {
            this.pacienteDAO.insert(paciente);
        }
    }

    public Paciente consultarPacienteCPF(Paciente paciente) {
        return this.pacienteDAO.getByCPF(paciente.getCpf());
    }

    public Paciente consultarPacienteLogineSenha(Paciente paciente) {
        return this.pacienteDAO.getByLoginAndSenha(paciente.getCpf(), paciente.getSenha());
    }

    public void alteraDadosPaciente(Paciente paciente) {
        if (paciente.validaPaciente()) {
            this.pacienteDAO.update(paciente);
        }
    }

    public void listarDados(Paciente paciente) {
        paciente = this.pacienteDAO.getByCPF(paciente.getCpf());
        System.out.println("Seu nome eh: " + paciente.getNome());
        System.out.println("Seu email eh: " + paciente.getEmail());
        System.out.println("Seu cpf eh: " + paciente.getCpf());
        Date date = paciente.getDataNascimento();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String full = sdf.format(date);
        System.out.println("Sua data de nascimento eh: " + full);
        System.out.println("Sexo: " + ESexo.getByCodigo(paciente.getEnum_sexo()).toString());
    }
}
