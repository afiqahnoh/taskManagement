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
 * Servlet implementation class DeleteTaskController
 */
@WebServlet("/DeleteTaskController")
public class DeleteTaskController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TaskDAO dao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteTaskController() {
        super();
        dao = new TaskDAO();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int task_ID = Integer.parseInt(request.getParameter("task_ID"));
		dao.deleteTask(task_ID);
		request.setAttribute("tasks", TaskDAO.getAllTask());
		RequestDispatcher view = request.getRequestDispatcher("listTask.jsp");
		view.forward(request, response);
	}

}
