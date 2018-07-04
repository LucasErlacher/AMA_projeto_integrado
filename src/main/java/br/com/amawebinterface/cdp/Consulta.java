package br.com.amawebinterface.cdp;

import java.util.Date;

public class Consulta extends Observavel{

    private Paciente paciente;
    private AgenteSaude agenteSaude;
    private LocalAtendimento localAtendimento;
    private Date inicioAtendimento;
    private int enumStatus;

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public AgenteSaude getAgenteSaude() {
        return agenteSaude;
    }

    public void setAgenteSaude(AgenteSaude agenteSaude) {
        this.agenteSaude = agenteSaude;
    }

    public LocalAtendimento getLocalAtendimento() {
        return localAtendimento;
    }

    public void setLocalAtendimento(LocalAtendimento localAtendimento) {
        this.localAtendimento = localAtendimento;
    }

    public Date getInicioAtendimento() {
        return inicioAtendimento;
    }

    public void setInicioAtendimento(Date inicioAtendimento) {
        this.inicioAtendimento = inicioAtendimento;
    }

    public int getEnumStatus() {
        return enumStatus;
    }

    public void setEnumStatus(int enumStatus) {
        this.enumStatus = enumStatus;
    }

}
