package br.com.ama.testes;

import br.com.ama.cdp.Endereco;
import br.com.ama.cgt.AplEndereco;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class CadastroEnderecoTest {

    private Endereco endereco;
    private final AplEndereco aplendereco = new AplEndereco();

    @Given("^Um endereco nao cadastrado$")
    public void umEnderecoNaoCadastrado() throws Throwable {
        this.endereco = new Endereco();
    }

    @Given("^Um endereco cadastrado$")
    public void umEnderecoCadastrado() throws Throwable {
        //defnido pegar o endercod e id 10
        this.endereco = this.aplendereco.consultaEndereco(10);
    }

    @When("^Entro com dados validos$")
    public void entroComDadosValidos() throws Throwable {
        this.endereco.setCep("29090380");
        this.endereco.setLogradouro("rus teste");
        this.endereco.setBairro("Bairro teste");
        this.endereco.setCidade("Vila Velha");
        this.endereco.setEstado("ES");
        this.endereco.setComplemento("longe pra carai");
        this.endereco.setNumero("199");
    }

    @When("^Entro com dados invalidos$")
    public void entroComDadosInvalidos() throws Throwable {
        //cep invalido
        this.endereco.setCep(null);
        this.endereco.setLogradouro("rus teste");
        this.endereco.setBairro("Bairro teste");
        this.endereco.setCidade("City teste");
        this.endereco.setEstado("ES");
        this.endereco.setComplemento("longe pra carai");
        this.endereco.setNumero("199");
    }

    @When("^Entro com dados novos$")
    public void entroComDadosNovos() throws Throwable {
        aplendereco.alterarDadosEndereco(this.endereco, "199", "502");
        this.endereco = aplendereco.consultaEndereco(this.endereco.getIdendereco());
        System.out.println(this.endereco.getNumero());
    }

    @When("^Entro na tela de informacoes$")
    public void entroNaTelaDeInformacoes() throws Throwable {
        //clica no botao de exibir informacoes
    }

    @When("^Seleciono a opcao para excluir$")
    public void selecionoAOpcaoParaExcluir() throws Throwable {
        aplendereco.excluirEndereco(this.endereco);
        //clica no botao de excluir endereco
    }

    @Then("^Recebo uma mensagem de sucesso$")
    public void receboUmaMensagemDeSucesso() throws Throwable {
        boolean resultExpect = aplendereco.cadastrarEndereco(this.endereco);
        Assert.assertEquals(true, resultExpect);
    }

    @Then("^Recebo uma mensagem de erro nos dados$")
    public void receboUmaMensagemDeErroNosDados() throws Throwable {
        boolean resultExpect = aplendereco.cadastrarEndereco(this.endereco);
        Assert.assertEquals(false, resultExpect);
    }

    @Then("^Recebo uma mensagem informando que os dados foram alterados$")
    public void receboUmaMensagemInformandoQueOsDadosForamAlterados() throws Throwable {
        boolean result = false;
        if ("199".equals(this.endereco.getNumero()) && "502".equals(this.endereco.getComplemento())) {
            result = true;
        }
        Assert.assertEquals(false, result);
    }

    @Then("^E exibido as informacoes do endereco$")
    public void eExibidoAsInformacoesDoEndereco() throws Throwable {
        aplendereco.exibirDados(this.endereco);
        Assert.assertNotNull(endereco);
    }

    @Then("^Recebo uma mensagem informando que o endereco foi excluido$")
    public void receboUmaMensagemInformandoQueOEnderecoFoiExcluido() throws Throwable {
        this.endereco = aplendereco.consultaEndereco(this.endereco.getIdendereco());
        Assert.assertNotNull("Endereco excluido", this.endereco);
    }
}
//teste