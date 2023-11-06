package registraAniversario.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import registraAniversario.smtp.EnviaEmail;

/**
 * Servlet implementation class EnviarEmailServlet
 */
@WebServlet("/enviar")
public class EnviarEmailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    EnviaEmail enviaEmail = new EnviaEmail();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EnviarEmailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		enviaEmail.enviarEmail();
		RequestDispatcher dispatcher = request.getRequestDispatcher("/views/formRegistraPessoa.jsp");
		dispatcher.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */

}
