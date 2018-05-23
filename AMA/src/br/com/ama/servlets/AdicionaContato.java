package br.com.ama.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AdicionaContato
 */
@WebServlet("/AdicionaContato")
public class AdicionaContato extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        String nome = request.getParameter("nome");
        
        out.println("<html>");
        out.println("<head>");
        out.println("<title>AMA</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h2>Olá," + nome + "</h2>");
        out.println("</body>");
        out.println("</html>");
    }
}