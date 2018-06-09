
package br.com.amawebinterface.controllers;

import br.com.ama.cdp.Paciente;
import br.com.ama.cgt.AplPaciente;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.CustomNumberEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class PacienteController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "index";
    }
    
    @RequestMapping(value = "/LoginPaciente")
    public String LoginPaciente() {
        return "Paciente/LoginPaciente";
    }

    @RequestMapping(value = "/CadastroPaciente", method = RequestMethod.GET)
    public String formularioCadastro() {
        return "Paciente/CadastroPaciente";
    }

    @RequestMapping(value = "/adicionarPaciente", method = RequestMethod.POST)
    public String adicionarPaciente(Paciente _paciente) {
        AplPaciente aplPaciente = new AplPaciente();
                aplPaciente.cadastrarPaciente(_paciente);
        return "index";
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setLenient(true);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
        binder.registerCustomEditor(Integer.class, new CustomNumberEditor(Integer.class, true));
    }
}

