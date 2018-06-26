package br.com.amawebinterface.cgt;

import br.com.amawebinterface.cdp.AgenteSaude;
import br.com.amawebinterface.cdp.ETipoRegistro;
import br.com.amawebinterface.cgd.dao.AgenteSaudeDAO;

public class AplAgenteSaude extends AplPaciente{

    private final AgenteSaudeDAO agenteDAO = new AgenteSaudeDAO();

    public void cadastrarAgenteSaude(AgenteSaude agente) {
        if (agente.validaAgenteSaude()) {
            this.agenteDAO.insert(agente);
        }
    }

    public AgenteSaude consultarAgenteCPF(AgenteSaude agente) {
        AgenteSaude agentePeloCPF = this.agenteDAO.getByCPF(agente.getCpf());
        return agentePeloCPF;
    }
    
    public void alteraDadosAgente(AgenteSaude agente){
        if(agente.validaAgenteSaude())this.alteraDadosPaciente(agente);
    }
    
    public void listarDados(AgenteSaude agente) {
        agente = this.agenteDAO.getByCPF(agente.getCpf());
        super.listarDados(agente);
        System.out.println("ID : " +agente.getId());
        System.out.println("Possui Inscricao : " +agente.getInscricao());
        System.out.println("Do Estado: " + agente.getEstado());
        System.out.println("Possui Registro de : " + ETipoRegistro.getByCodigo(agente.getEnum_registro()).toString());        
    }

}
