package br.com.amawebinterface.cdp;

import br.com.amawebinterface.util.excecoes.DadoInvalidoException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AgenteSaude extends Paciente {

    private String inscricao;
    private int enum_registro;
    private List<Consulta> consultasAgente;
    private String estado;

    //Constutor
    public AgenteSaude(int _id, String _cpf, String _senha, Date _dataNascimento,
            String _nome, String _email, int _enum_usuario, int _enum_sexo, String _inscricao) {

        super(_id, _senha, _cpf, _dataNascimento, _nome, _email, _enum_usuario, _enum_sexo);
        this.inscricao = _inscricao;
        this.consultasAgente = new ArrayList<>();

    }

    public AgenteSaude() {

    }

    //Métodos
    public String getInscricao() {
        return inscricao;
    }

    public void setInscricao(String inscricao) {
        this.inscricao = inscricao;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public List<Consulta> getConsultasAgente() {
        return consultasAgente;
    }

    public void adicionarConsultaAgente(Consulta consultaAgente) {
        this.consultasAgente.add(consultaAgente);
    }

    public int getEnum_registro() {
        return enum_registro;
    }

    public void setEnum_registro(int enum_registro) {
        this.enum_registro = enum_registro;
    }

    public boolean validaAgenteSaude() {
        if (this.validaPaciente()) {
            if (this.inscricao == null) {
                throw new DadoInvalidoException("O campo Inscricao está inválido.");
            }
            if (this.estado == null) {
                throw new DadoInvalidoException("O campo Estado está inválido.");
            }
            if (this.enum_registro == 0) {
                throw new DadoInvalidoException("O campo Registro está inválido.");
            }
            return true;
        }
        return false;
    }

}
