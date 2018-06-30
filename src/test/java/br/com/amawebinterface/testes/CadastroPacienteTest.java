package br.com.amawebinterface.testes;

import br.com.amawebinterface.cdp.Paciente;
import br.com.amawebinterface.cgt.AplPaciente;
import br.com.amawebinterface.util.excecoes.DadoRepetidoException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import org.junit.Assert;

public class CadastroPacienteTest {

    private Paciente paciente;
    private final AplPaciente aplPaciente = AplPaciente.getInstance();
    private String dadoAntigo;

    @Given("^Eu sou um paciente nao cadastrado\\.$")
    public void euSouUmPacienteNaoCadastrado() throws Throwable {
        this.paciente = new Paciente();
    }

    @Given("^Eu sou um paciente cadastrado\\.$")
    public void euSouUmPacienteCadastrado() throws Throwable {
        this.paciente = new Paciente();
        this.paciente.setCpf("14805897724");
        this.paciente = aplPaciente.consultarPacienteCPF(paciente);
    }

    @When("^Eu entro com dados validos\\.$")
    public void euEntroComDadosValidos() throws Throwable {
        Random gerador = new Random();
        String dadoNovo = "" + gerador.nextInt(90000);
        this.paciente.setCpf(dadoNovo);
        String target = "2000-01-01";
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date result = df.parse(target);
        this.paciente.setDataNascimento(result);
        this.paciente.setEmail("userTest" + dadoNovo + "@xmail.com");
        this.paciente.setSenha("admin");
        this.paciente.setNome("User Created by Teste" + dadoNovo);
        this.paciente.setEnum_sexo(gerador.nextInt(1) + 1);
        this.paciente.setEnum_usuario(1);
    }

    @When("^Eu entro com dados incorretos\\.$")
    public void euEntroComDadosIncorretos() throws Throwable {
    }

    @When("^Eu entro com dados registrados\\.$")
    public void euEntroComDadosRegistrados() throws Throwable {
        paciente.setCpf("13989292714");
    }

    @When("^Eu entro com dados novos\\.$")
    public void euEntroComDadosNovos() throws Throwable {
        Random gerador = new Random();
        String dadoNovo = "" + gerador.nextInt(90000);
        dadoAntigo = paciente.getEmail();
        paciente.setEmail("testChanged" + dadoNovo + "@xmail.com");
        paciente.setSenha("admin1234");
    }

    @When("^Eu entro na tela de informacoes\\.$")
    public void euEntroNaTelaDeInformacoes() throws Throwable {
    }

    @Then("^Eu recebo uma mensagem de sucesso\\.$")
    public void euReceboUmaMensagemDeSucesso() throws Throwable {
        aplPaciente.cadastrarPaciente(this.paciente);
        Assert.assertNotEquals("Cadastro feito com sucesso", 0, paciente.getId());
    }

    @Then("^Eu recebo uma mensagem de alerta\\.$")
    public void euReceboUmaMensagemDeAlerta() throws Throwable {
        boolean result = false;
        try {
            aplPaciente.cadastrarPaciente(paciente);
        } catch (Exception e) {
            result = true;
        }
        Assert.assertTrue("Não foi possivel cadastrar com os dados apresentados", result);
    }

    @Then("^Eu recebo uma mensagem de alerta informando que ja tenho acesso\\.$")
    public void euReceboUmaMensagemDeAlertaInformandoQueJaTenhoAcesso() throws Throwable {
        boolean result = false;
        try {
            aplPaciente.cadastrarPaciente(this.paciente);
        } catch (DadoRepetidoException e) {
            result = true;
        }
        Assert.assertTrue("Não foi possivel cadastrar com os dados apresentados", result);
    }

    @Then("^Eu recebo uma mensagem de sucesso informando que os dados foram alterados\\.$")
    public void euReceboUmaMensagemDeSucessoInformandoQueOsDadosForamAlterados() throws Throwable {
        aplPaciente.alteraDadosPaciente(paciente);
        Assert.assertNotEquals("Dados alterados com sucesso", paciente.getEmail(), dadoAntigo);
    }

    @Then("^Eu eh exibido uma tela com minhas informacoes$")
    public void euEhExibidoUmaTelaComMinhasInformacoes() throws Throwable {
        aplPaciente.listarDados(paciente);
        Assert.assertNotNull(paciente);
    }
}
