package tsm.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tsm.dao.TaskDAO;

/**
 * Servlet implementation class ListTaskController
 */
@WebServlet("/ListTaskController")
public class ListTaskController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TaskDAO dao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListTaskController() {
        super();
        dao = new TaskDAO();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setAttribute("tasks", TaskDAO.getAllTask());
		RequestDispatcher view = request.getRequestDispatcher("listTask.jsp");
		view.forward(request, response);
	}
}
