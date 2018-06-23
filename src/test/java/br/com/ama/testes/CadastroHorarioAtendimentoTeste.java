package br.com.ama.testes;

import br.com.ama.cdp.AgenteSaude;
import br.com.ama.cdp.ESexo;
import br.com.ama.cdp.EUsuario;
import br.com.ama.cdp.HorarioAtendimento;
import br.com.ama.cgd.DAO.HorarioAtendimentoDAO;
import br.com.ama.cgt.AplCadastrarHorarioAtendimento;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;

public class CadastroHorarioAtendimentoTeste {
    private AplCadastrarHorarioAtendimento aplication = new AplCadastrarHorarioAtendimento();

    private ArrayList<HorarioAtendimento> lst_horarioAtendimento;
    private HorarioAtendimentoDAO haDAO = new HorarioAtendimentoDAO();
    private HorarioAtendimento horarioAtendimentoAtual;
    private HorarioAtendimento horarioAtendimentoFuturo;
    private ArrayList<AgenteSaude> lst_agenteSaude;
    private AgenteSaude agenteSaude;

    @Given("^Um agente de saude cadastrado$")
    public void um_agente_de_saude_cadastrado() throws Throwable {
        Calendar cal = Calendar.getInstance();
        cal.set(1997,04,12);

        this.agenteSaude = new AgenteSaude(1,"14805897724","admin1234",cal,
        "Tarcisio Bruni", "testChanged25273@xmail.com", EUsuario.AGENTESAUDE, ESexo.MASCULINO,"101010");
    }

    @Given("^Um horario de atendimento$")
    public void um_horario_de_atendimento() throws Throwable {
        this.horarioAtendimentoAtual = new HorarioAtendimento();
        this.horarioAtendimentoAtual.setHoraInicio("13:00:00");
        this.horarioAtendimentoAtual.setHoraFinal("22:00:00");
        this.horarioAtendimentoAtual.setIntervalo("00:30:00");
        this.horarioAtendimentoAtual.setDiaSemana("Segunda-feira");
    }

    @When("^Concluo o cadastro$")
    public void concluo_o_cadastro() throws Throwable {}

    @Then("^Recebo uma mensagem de sucesso$")
    public void recebo_uma_mensagem_de_sucesso() throws Throwable {
        aplication.cadastraHorarioAtendimento(agenteSaude, horarioAtendimentoAtual);
        Assert.assertNotEquals("Horario cadastrado com sucesso", 0, haDAO.getIdHorarioAtendimento(horarioAtendimentoAtual));
    }

    @Given("^Existe um horario de atendimento com conflito$")
    public void existe_um_horario_de_atendimento_com_conflito() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^Recebo uma mensagem de erro informando que ja existe um horario de atendimento registrado nesse dia da semana$")
    public void recebo_uma_mensagem_de_erro_informando_que_ja_existe_um_horario_de_atendimento_registrado_nesse_dia_da_semana() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^Entro com novo horario de atendimento$")
    public void entro_com_novo_horario_de_atendimento() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^Recebo uma mensagem informando que o horario foi alterado$")
    public void recebo_uma_mensagem_informando_que_o_horario_foi_alterado() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Given("^Um horario de atendimento ja cadastrado$")
    public void um_horario_de_atendimento_ja_cadastrado() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^Seleciono a opcao para excluir$")
    public void seleciono_a_opcao_para_excluir() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^Recebo uma mensagem informando que o horario de atendimento foi excluido$")
    public void recebo_uma_mensagem_informando_que_o_horario_de_atendimento_foi_excluido() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }
}
