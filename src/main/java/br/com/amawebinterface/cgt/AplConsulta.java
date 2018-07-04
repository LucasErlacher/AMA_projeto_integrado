package br.com.amawebinterface.cgt;

import br.com.amawebinterface.cdp.Consulta;

public class AplConsulta {
    public void cadastrarConsulta(Consulta consulta){
        consulta.add(consulta.getAgenteSaude());
        consulta.add(consulta.getPaciente());
    }

    public void cancelarConsulta(Consulta consulta){
        consulta.notifyObservers();
    }
}
