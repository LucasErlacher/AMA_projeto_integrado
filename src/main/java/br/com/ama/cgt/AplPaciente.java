package br.com.ama.cgt;

import br.com.ama.cdp.ESexo;
import br.com.ama.cdp.Paciente;
import br.com.ama.cgd.DAO.PacienteDAO;
import br.com.ama.util.Excecoes.DadoInvalidoException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import org.postgresql.util.PSQLException;

public class AplPaciente {

    private Paciente paciente;
    private PacienteDAO pacienteDAO = new PacienteDAO();

    public void setPaciente(Paciente _paciente) {
        this.paciente = _paciente;
    }

    public int cadastrarPaciente(Paciente _paciente) {
        if(validaPaciente(_paciente)){
            try {
                validaPaciente(_paciente);
                 return pacienteDAO.insert(_paciente);            
            } catch (Exception e) {
                e.getMessage();
            }
        }        
        return 0;        
    }


public Paciente consultarPacienteCPF(Paciente _paciente) {
        System.out.println("Entrou no metodo da aplicacao e o CPF = " + _paciente.getCpf());
        Paciente pacientePeloCPF = pacienteDAO.getByCPF(_paciente.getCpf());
        return pacientePeloCPF;
    }

    public Paciente consultarPacienteLogineSenha(Paciente _paciente) {
        Paciente pacientePeloLogineSenha = pacienteDAO.getByLoginAndSenha(_paciente.getCpf(), _paciente.getSenha());
        return pacientePeloLogineSenha;
    }

    public int alteraDadosPaciente(Paciente _paciente) {
        return pacienteDAO.update(_paciente);
    }

    public void listarDados(Paciente paciente) {
        paciente = pacienteDAO.getByCPF(paciente.getCpf());
        System.out.println("Seu nome eh: " + paciente.getNome());
        System.out.println("Seu email eh: " + paciente.getEmail());
        System.out.println("Seu cpf eh: " + paciente.getCpf());
        System.out.println("Sua senhaeh: " + paciente.getSenha());        
        Date date = paciente.getDataNascimento();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String full = sdf.format(date);
        System.out.println("Sua data de nascimento eh: " + full);
    }

    public boolean validaPaciente(Paciente _paciente) {
        if (_paciente.getCpf() == null) {
            throw new DadoInvalidoException("O campo Cpf está inválido.");
        }
        if (_paciente.getDataNascimento() == null) {
            throw new DadoInvalidoException("O campo Data Nascimento está inválido.");
        }
        if (_paciente.getNome() == null) {
            throw new DadoInvalidoException("O campo Nome está inválido.");
        }
        if (_paciente.getEmail() == null) {
            throw new DadoInvalidoException("O campo Email está inválido.");
        }
        if (_paciente.getSenha() == null) {
            throw new DadoInvalidoException("O campo Senha está inválido.");
        }        
        ArrayList<ESexo> sexos = new ArrayList<>();
        sexos.addAll(Arrays.asList(ESexo.values()));
        if (!sexos.contains(ESexo.getByCodigo(_paciente.getTipoSexo()))) {
            throw new DadoInvalidoException("O campo Sexo está inválido.");
        }
        return true;
    }
}
