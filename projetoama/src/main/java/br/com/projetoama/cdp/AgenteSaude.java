package br.com.projetoama.cdp;

import br.com.projetoama.cdp.ESexo;
import br.com.projetoama.cdp.EUsuario;

import java.util.Calendar;

public class AgenteSaude extends Paciente {

    private String inscricao;
    //private Estado estadoInsricao;
    
    //Constutor
    public AgenteSaude(int _id, String _cpf, String _senha, Calendar _dataNascimento,
            String _nome, String _email, EUsuario _tipousuario, ESexo _tipoSexo,
            String _inscricao) {

        super(_id, _senha, _cpf, _dataNascimento, _nome, _email, _tipousuario, _tipoSexo);
        this.inscricao = _inscricao;

    }

    //Métodos
    public String getInscricao() {
        return inscricao;
    }

    public void setInscricao(String inscricao) {
        this.inscricao = inscricao;
    }
    
//	public Estado getEstadoInsricao() {
//		return estadoInsricao;
//	}
//	public void setEstadoInsricao(Estado estadoInsricao) {
//		this.estadoInsricao = estadoInsricao;
//	}

}
