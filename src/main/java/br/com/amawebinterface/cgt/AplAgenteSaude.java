package br.com.amawebinterface.cgt;

import br.com.amawebinterface.cdp.AgenteSaude;
import br.com.amawebinterface.cdp.ETipoRegistro;
import br.com.amawebinterface.cgd.dao.AgenteSaudeDAO;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AplAgenteSaude {

    private final AgenteSaudeDAO agenteDAO = new AgenteSaudeDAO();
    private static AplAgenteSaude instance;
    private final AplPaciente aplPaciente = AplPaciente.getInstance();
    private static final Logger logger = Logger.getLogger(AplAgenteSaude.class.getName());

    public static AplAgenteSaude getInstance() {
        if (instance == null) {
            instance = new AplAgenteSaude();
        }
        return instance;
    }

    private AplAgenteSaude() {
    }

    ;
    
    public void cadastrarAgenteSaude(AgenteSaude agente) {
        if (agente.validaAgenteSaude()){this.agenteDAO.insert(agente);}
    }

    public AgenteSaude consultarAgenteCPF(AgenteSaude agente) {
        return this.agenteDAO.getByCPF(agente.getCpf());
    }

    public void alteraDadosAgente(AgenteSaude agente) {
        if (agente.validaAgenteSaude()) {
            this.aplPaciente.alteraDadosPaciente(agente);
        }
    }

    public void listarDados(AgenteSaude agente) {
        agente = this.agenteDAO.getByCPF(agente.getCpf());
        this.aplPaciente.listarDados(agente);
        logger.log(Level.SEVERE, "ID : {0}", agente.getId());
        logger.log(Level.SEVERE, "Possui Inscricao : {0}", agente.getInscricao());
        logger.log(Level.SEVERE, "Do Estado: {0}", agente.getEstado());
        logger.log(Level.SEVERE, "Possui Registro de : {0}", ETipoRegistro.getByCodigo(agente.getEnum_registro()).toString());
    }

}
