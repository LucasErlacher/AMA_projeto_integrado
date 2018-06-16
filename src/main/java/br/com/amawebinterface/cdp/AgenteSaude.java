package br.com.amawebinterface.cdp;

import java.util.Calendar;
import java.util.Date;

public class AgenteSaude extends Paciente {

    private String inscricao;
    private int enum_registro;

    public int getEnum_registro() {
        return enum_registro;
    }

    public void setEnum_registro(int enum_registro) {
        this.enum_registro = enum_registro;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }
    private String especialidade;

    //Constutor
    public AgenteSaude(int _id, String _cpf, String _senha, Date _dataNascimento,
            String _nome, String _email, int _enum_usuario, int _enum_sexo,String _inscricao) {

        super(_id, _senha, _cpf, _dataNascimento, _nome, _email, _enum_usuario, _enum_sexo);
        this.inscricao = _inscricao;

    }

    //Métodos
    public String getInscricao() {
        return inscricao;
    }

    public void setInscricao(String inscricao) {
        this.inscricao = inscricao;
    }
}
