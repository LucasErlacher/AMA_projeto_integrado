package br.com.amawebinterface.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class InterceptorApplication extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object controller) throws Exception {

        if (request.getSession().getAttribute("pacienteLogado") != null) {
            return true;
        }
        response.sendRedirect("Paciente/LoginPaciente.jsp");
        return false;
    }
}
