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
import br.com.ama.cgt.AplPaciente;
import br.com.ama.util.Excecoes.DadoInvalidoException;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import java.util.Calendar;
import java.util.Date;
import org.junit.Assert;

/**
 *
 * @author Tarcisio
 */

public class CadastroPacienteTest {
    private Paciente paciente;
    private AplPaciente aplPaciente = new AplPaciente();
    
@Given("^Eu sou um paciente nao cadastrado\\.$")
public void euSouUmPacienteNaoCadastrado() throws Throwable {
    this.paciente = new Paciente();
    aplPaciente.consultarPacienteCPF(paciente);    
}

@When("^Eu entro com dados validos\\.$")
public void euEntroComDadosValidos() throws Throwable {
    
    this.paciente.setCpf("16787776543");
    Calendar _dataNascimento = Calendar.getInstance();
    this.paciente.setDataNascimento(_dataNascimento);
    this.paciente.setEmail("tste@teste.om.br");
    this.paciente.setSenha("admin");
    this.paciente.setNome("Teste");
    this.paciente.setTipoUsuario(EUsuario.PACIENTE);
    this.paciente.setTipoSexo(ESexo.MASCULINO);
    
}

@Then("^Eu recebo uma mensagem de sucesso\\.$")
public void euReceboUmaMensagemDeSucesso() throws Throwable {
    int resultExpect = aplPaciente.cadastrarPaciente(paciente);   
    Assert.assertEquals("Cadastro feito com sucesso",1, resultExpect);
}

@When("^Eu entro com dados incorretos\\.$")
public void euEntroComDadosIncorretos() throws Throwable {
        
}

@Then("^Eu recebo uma mensagem de alerta\\.$")
public void euReceboUmaMensagemDeAlerta() throws Throwable {
    boolean result = false;
    try {
            int resultExpect = aplPaciente.cadastrarPaciente(paciente);   
            } catch (DadoInvalidoException e) {
                result = true;
         }
      Assert.assertTrue("Não foi possivel cadastrar com os dados apresentados",result);      
}

@Given("^Eu sou um paciente cadastrado\\.$")
public void euSouUmPacienteCadastrado() throws Throwable {
    paciente = new Paciente();
    paciente.setCpf("14805897724");
    paciente=aplPaciente.consultarPacienteCPF(paciente);
}

@When("^Eu entro com dados registrados\\.$")
public void euEntroComDadosRegistrados() throws Throwable {
        paciente.setCpf("14805897724");
        paciente.setSenha("123456");
}

@Then("^Eu recebo uma mensagem de alerta informando que ja tenho acesso\\.$")
public void euReceboUmaMensagemDeAlertaInformandoQueJaTenhoAcesso() throws Throwable {
    paciente = aplPaciente.consultarPacienteLogineSenha(paciente);   
    Assert.assertNotNull("Feito login com suesso", paciente);
}

@When("^Eu entro com dados novos\\.$")
public void euEntroComDadosNovos() throws Throwable {
    paciente.setEmail("tarcisio@hotmail.google.com");
    }

@Then("^Eu recebo uma mensagem de sucesso informando que os dados foram alterados\\.$")
public void euReceboUmaMensagemDeSucessoInformandoQueOsDadosForamAlterados() throws Throwable {
        int resultExpect = aplPaciente.alteraDadosPaciente(paciente);
        Assert.assertEquals("Dados alterados com sucesso",1, resultExpect);    
}

@When("^Eu entro na tela de informacoes\\.$")
public void euEntroNaTelaDeInformacoes() throws Throwable {
    
}

@Then("^Eu eh exibido uma tela com minhas informacoes$")
public void euEhExibidoUmaTelaComMinhasInformacoes() throws Throwable {
    aplPaciente.listarDados(paciente);
    Assert.assertNotNull(paciente);
}
}
