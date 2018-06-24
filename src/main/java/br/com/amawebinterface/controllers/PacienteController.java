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
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PacienteController {

    private final AplPaciente aplPaciente = new AplPaciente();

    @RequestMapping(value = "/Paciente/LoginPaciente")
    public String LoginPaciente() {
        return "Paciente/LoginPaciente";
    }
    
    @RequestMapping(value = "/Paciente/LogoutPaciente")
    public String LogoutPaciente(HttpSession session) {
        session.removeAttribute("pacienteLogado");
        return "Paciente/LoginPaciente";
    }

    @RequestMapping(value = "/Paciente//CadastrarPaciente")
    public String CadastroPaciente() {
        return "Paciente/CadastrarPaciente";
    }

    @RequestMapping(value = "/Paciente/NovoPaciente", method = RequestMethod.POST)
    public String adicionarPaciente(Paciente _paciente) {
        this.aplPaciente.cadastrarPaciente(_paciente);
        if(_paciente.getId()!=0){
            return "Paciente/LoginPaciente";
        }
        return "Paciente/LoginPaciente";
        
    }

    @RequestMapping(value = "/Paciente/HomePagePaciente")
    public ModelAndView realizarLoginPaciente(Paciente paciente, HttpSession session) {
        ModelAndView mv;
        paciente = this.aplPaciente.consultarPacienteLogineSenha(paciente);
        if (paciente != null) {
            session.setAttribute("pacienteLogado", paciente);
            mv = new ModelAndView("Paciente/HomePagePaciente");
            mv.addObject("paciente",paciente);
            return mv;
        }
        mv = new ModelAndView("Paciente/LoginPaciente");    
        return mv;
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setLenient(true);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
        binder.registerCustomEditor(Integer.class, new CustomNumberEditor(Integer.class, true));
    }
}
