package br.com.amawebinterface.controllers;

import br.com.amawebinterface.cdp.Paciente;
import br.com.amawebinterface.cgt.AplPaciente;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.http.HttpSession;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.CustomNumberEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PacienteController {

    private AplPaciente aplPaciente = new AplPaciente();

    @RequestMapping(value = "/Paciente/EfetuarLoginPaciente")
    public String LoginPaciente() {
        return "Paciente/LoginPaciente";
    }

    @RequestMapping(value = "/Paciente/CadastrarPaciente")
    public String CadastroPaciente() {
        return "Paciente/CadastrarPaciente";
    }

    @RequestMapping(value = "/Paciente/adicionarPaciente", method = RequestMethod.POST)
    public String adicionarPaciente(Paciente _paciente) {
        this.aplPaciente.cadastrarPaciente(_paciente);
        return "Paciente/LoginPaciente";
    }

    @RequestMapping(value = "/Paciente/realizarLoginPaciente", method = RequestMethod.POST)
    public String realizarLoginPaciente(Paciente _paciente, HttpSession session) {
        if (this.aplPaciente.consultarPacienteLogineSenha(_paciente) != null) {
            session.setAttribute("usuarioLogado", _paciente);
            return "Paciente/HomePagePaciente";
        }
        return "Paciente/LoginPaciente";
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setLenient(true);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
        binder.registerCustomEditor(Integer.class, new CustomNumberEditor(Integer.class, true));
    }
}
