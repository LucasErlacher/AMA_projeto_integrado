package br.com.ama.cci;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
 

@Controller
public class DefaultController {
    
   @RequestMapping(value = "/")
   public String index(ModelMap map) {
       map.put("msg", "Hello Spring 4 Web MVC!");       
       return "index";
   }
    
}