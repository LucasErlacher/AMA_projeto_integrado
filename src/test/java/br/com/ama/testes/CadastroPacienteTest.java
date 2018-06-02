/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ama.testes;

import br.com.ama.cdp.ESexo;
import br.com.ama.cdp.EUsuario;
import br.com.ama.cdp.Paciente;
import br.com.ama.cgd.DAO.PacienteDAO;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Tarcisio
 */
public class CadastroPacienteTest {
    private Paciente paciente = new Paciente();
    private PacienteDAO pacienteDAO = new PacienteDAO();
    
    
@Given("^Eu sou um paciente nao cadastrado\\.$")
public void euSouUmPacienteNaoCadastrado() throws Throwable {
    paciente.setCpf("07010674701");
    Paciente pacienteNaoCadastrado = pacienteDAO.getByCPF(paciente.getCpf());    
}

@When("^Eu entro com dados validos\\.$")
public void euEntroComDadosValidos() throws Throwable {
    this.paciente.setCpf("07010674701");
    Calendar _dataNascimento = Calendar.getInstance();
    this.paciente.setDataNascimento(_dataNascimento);
    this.paciente.setEmail("teste@teste.com.br");
    this.paciente.setSenha("admin");
    this.paciente.setNome("Teste");
    this.paciente.setTipoUsuario(EUsuario.PACIENTE);
    this.paciente.setTipoSexo(ESexo.MASCULINO);
    System.out.println(pacienteDAO.insert(paciente));
}

@Then("^Eu recebo uma mensagem de sucesso\\.$")
public void euReceboUmaMensagemDeSucesso() throws Throwable {
    System.out.println("Cadastro Efetuado com Sucesso");
}

@When("^Eu entro com dados incorretos\\.$")
public void euEntroComDadosIncorretos() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
}

@Then("^Eu recebo uma mensagem de alerta\\.$")
public void euReceboUmaMensagemDeAlerta() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
}

@Given("^Eu sou um paciente cadastrado\\.$")
public void euSouUmPacienteCadastrado() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
}

@When("^Eu entro com dados registrados\\.$")
public void euEntroComDadosRegistrados() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
}

@Then("^Eu recebo uma mensagem de alerta informando que ja tenho acesso\\.$")
public void euReceboUmaMensagemDeAlertaInformandoQueJaTenhoAcesso() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
}

@When("^Eu entro com dados novos\\.$")
public void euEntroComDadosNovos() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
}

@Then("^Eu recebo uma mensagem de sucesso informando que os dados foram alterados\\.$")
public void euReceboUmaMensagemDeSucessoInformandoQueOsDadosForamAlterados() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
}

@When("^Eu entro na tela de informacoes\\.$")
public void euEntroNaTelaDeInformacoes() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
}

@Then("^Eu eh exibido uma tela com minhas informacoes$")
public void euEhExibidoUmaTelaComMinhasInformacoes() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
}
}
