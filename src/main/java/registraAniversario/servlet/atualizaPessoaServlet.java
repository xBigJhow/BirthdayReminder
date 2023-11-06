package registraAniversario.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import registraAniversario.dao.PessoaDAO;
import registraAniversario.model.Pessoa;

/**
 * Servlet implementation class atualizaPessoaServlet
 */
@WebServlet("/atualizar")
public class atualizaPessoaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    PessoaDAO pessoaDAO = new PessoaDAO();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public atualizaPessoaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));

        Pessoa pessoa = pessoaDAO.selecionaPessoaPorId(id);
        
        request.setAttribute("pessoa", pessoa);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/atualizaPessoa.jsp");
        dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}	
	

}
