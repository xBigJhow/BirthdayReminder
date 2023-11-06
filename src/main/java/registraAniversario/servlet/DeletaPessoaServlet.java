package registraAniversario.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import registraAniversario.dao.PessoaDAO;

/**
 * Servlet implementation class DeletaPessoaServlet
 */
@WebServlet("/deletar")
public class DeletaPessoaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    PessoaDAO pessoaDAO = new PessoaDAO();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeletaPessoaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		try {
			pessoaDAO.deletaPessoa(id);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/views/listaPessoas.jsp");
			dispatcher.forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/views/listaPessoas.jsp");
		dispatcher.forward(request, response);
	}

}
