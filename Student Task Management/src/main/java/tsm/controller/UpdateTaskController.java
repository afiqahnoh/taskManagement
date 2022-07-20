package tsm.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tsm.dao.TaskDAO;
import tsm.model.task;

/**
 * Servlet implementation class UpdateTaskController
 */
@WebServlet("/UpdateTaskController")
public class UpdateTaskController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TaskDAO dao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateTaskController() {
        super();
        dao = new TaskDAO();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int task_ID = Integer.parseInt(request.getParameter("task_ID"));
		request.setAttribute("t", TaskDAO.getTaskById(task_ID));
		RequestDispatcher view = request.getRequestDispatcher("updateTask.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		task t = new task();
		t.setTask_ID(Integer.parseInt(request.getParameter("task_ID")));
		t.setTask_Name(request.getParameter("task_Name"));
		t.setDue_Date(Date.valueOf(request.getParameter("due_Date")));
		t.setTask_State(request.getParameter("task_State"));

		
		dao.updateTask(t);
		request.setAttribute("tasks", TaskDAO.getAllTask());
		RequestDispatcher view = request.getRequestDispatcher("listTask.jsp");
		view.forward(request, response);
	}
}
