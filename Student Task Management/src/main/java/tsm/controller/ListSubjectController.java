package tsm.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tsm.dao.SubjectDAO;

/**
 * Servlet implementation class ListSubjectController
 */
@WebServlet("/ListSubjectController")
public class ListSubjectController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SubjectDAO dao;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListSubjectController() {
        super();
        dao= new SubjectDAO();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setAttribute("subjects", SubjectDAO.getAllSubject());
		RequestDispatcher view = request.getRequestDispatcher("subject-list.jsp");
		view.forward(request, response);
	}

}
