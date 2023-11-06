package registraAniversario.servlet;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import registraAniversario.dao.PessoaDAO;
import registraAniversario.model.Pessoa;

/**
 * Servlet implementation class RegistraPessoaServlet
 */
@WebServlet("/registro")
public class RegistraPessoaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    PessoaDAO pessoaDAO = new PessoaDAO();
    /**
     * @see HttpServlet#HttpServlet()
     */
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/views/formRegistraPessoa.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nome = request.getParameter("nome");
		Date dataNascimento = null;
		String dataNascimentoSTR = (String) request.getParameter("dataNascimento");
		try {
			dataNascimento = Date.valueOf(dataNascimentoSTR);
		} catch(IllegalArgumentException e) {
			e.printStackTrace();
		}
		String obs = request.getParameter("obs");
		
		Pessoa novaPessoa = new Pessoa(nome, dataNascimento, obs);
		if(nome != null && dataNascimento != null) {

			try {
				pessoaDAO.criaPessoa(novaPessoa);
				RequestDispatcher dispatcher = request.getRequestDispatcher("views/pessoaRegistradaSucesso.jsp");
				dispatcher.forward(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				RequestDispatcher dispatcher = request.getRequestDispatcher("views/erroAoRegistrar.jsp");
				dispatcher.forward(request, response);
			}
		} else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("views/erroAoRegistrar.jsp");
			dispatcher.forward(request, response);
		}
		
	}

}
