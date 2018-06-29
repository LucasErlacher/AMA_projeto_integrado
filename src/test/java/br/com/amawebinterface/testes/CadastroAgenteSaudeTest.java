package br.com.amawebinterface.testes;

import br.com.amawebinterface.cdp.AgenteSaude;
import br.com.amawebinterface.cgt.AplAgenteSaude;
import br.com.amawebinterface.util.excecoes.DadoInvalidoException;
import br.com.amawebinterface.util.excecoes.DadoRepetidoException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import org.junit.Assert;

public class CadastroAgenteSaudeTest {

    private AgenteSaude agente;
    private final AplAgenteSaude aplAgenteSaude = AplAgenteSaude.getInstance();
    private String dadoAntigo;

    @Given("^Eu sou um agentesaude nao cadastrado\\.$")
    public void euSouUmAgentesaudeNaoCadastrado() throws Throwable {
        this.agente = new AgenteSaude();
    }

    @When("^Eu entro com dados de agente de saude validos\\.$")
    public void euEntroComDadosDeAgenteDeSaudeValidos() throws Throwable {
        Random gerador = new Random();
        String dadoNovo = "" + gerador.nextInt(90000);
        this.agente.setCpf(dadoNovo);
        String target = "2000-01-01";
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date result = df.parse(target);
        this.agente.setDataNascimento(result);
        this.agente.setEmail("userTest" + dadoNovo + "@xmail.com");
        this.agente.setSenha("admin");
        this.agente.setNome("Doctor Created by Teste" + dadoNovo);
        this.agente.setEnum_sexo(gerador.nextInt(1) + 1);
        this.agente.setEnum_usuario(1);
        this.agente.setInscricao(dadoNovo);
        this.agente.setEstado("Acre");
        this.agente.setEnum_registro(gerador.nextInt(1) + 1);
    }

    @Then("^Eu agente recebo uma mensagem de sucesso\\.$")
    public void euAgenteReceboUmaMensagemDeSucesso() throws Throwable {
        aplAgenteSaude.cadastrarAgenteSaude(this.agente);
        Assert.assertNotEquals("Cadastro feito com sucesso", 0, agente.getId());
    }

    @When("^Eu entro com dados de agente de saude incorretos\\.$")
    public void euEntroComDadosDeAgenteDeSaudeIncorretos() throws Throwable {

    }

    @Then("^Eu agente recebo uma mensagem de alerta\\.$")
    public void euAgenteReceboUmaMensagemDeAlerta() throws Throwable {
        boolean result = false;
        try {
            aplAgenteSaude.cadastrarAgenteSaude(agente);
        } catch (DadoInvalidoException e) {
            result = true;
        }
        Assert.assertTrue("Não foi possivel cadastrar com os dados apresentados", result);
    }

    @Given("^Eu sou um agentesaude cadastrado\\.$")
    public void euSouUmAgentesaudeCadastrado() throws Throwable {
        this.agente = new AgenteSaude();
        this.agente.setCpf("13989292714");
        this.agente = aplAgenteSaude.consultarAgenteCPF(this.agente);
    }

    @When("^Eu entro com dados de agente de saude registrados\\.$")
    public void euEntroComDadosDeAgenteDeSaudeRegistrados() throws Throwable {
        this.agente.setCpf("13989292714");
        this.agente.setEmail("DoctorsChengeEmail55673@xmail.com");
    }

    @Then("^Eu agente recebo uma mensagem de alerta informando que ja tenho acesso\\.$")
    public void euAgenteReceboUmaMensagemDeAlertaInformandoQueJaTenhoAcesso() throws Throwable {
        boolean result = false;
        try {
            aplAgenteSaude.cadastrarAgenteSaude(agente);
        } catch (DadoRepetidoException e) {
            result = true;
        }
        Assert.assertTrue("Não foi possivel cadastrar com os dados apresentados", result);
    }

    @When("^Eu entro com dados de agente de saude  novos\\.$")
    public void euEntroComDadosDeAgenteDeSaudeNovos() throws Throwable {
        Random gerador = new Random();
        String dadoNovo = "" + gerador.nextInt(90000);
        dadoAntigo = agente.getEmail();
        agente.setEmail("DoctorsChengeEmail" + dadoNovo + "@xmail.com");
        agente.setSenha("admin1234");
    }

    @Then("^Eu agente recebo uma mensagem de sucesso informando que os dados foram alterados\\.$")
    public void euAgenteReceboUmaMensagemDeSucessoInformandoQueOsDadosForamAlterados() throws Throwable {
        aplAgenteSaude.alteraDadosAgente(agente);
        Assert.assertNotEquals("Dados alterados com sucesso", agente.getEmail(), dadoAntigo);
    }

    @When("^Eu entro na tela de informacoes do agente\\.$")
    public void euEntroNaTelaDeInformacoesDoAgente() throws Throwable {

    }

    @Then("^Eh exibido uma tela com minhas informacoes de agente de saude\\.$")
    public void ehExibidoUmaTelaComMinhasInformacoesDeAgenteDeSaude() throws Throwable {
        aplAgenteSaude.listarDados(this.agente);
        Assert.assertNotNull(this.aplAgenteSaude);
    }

}
