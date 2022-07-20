package tsm.controller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.*;
import java.sql.Date;
import java.sql.SQLException;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import tsm.model.Subject;
import tsm.dao.TaskDAO;
import tsm.model.task;
import tsm.dao.SubjectDAO;


/**
 * Servlet implementation class AddTaskController
 */
@WebServlet("/AddTaskController")
public class AddTaskController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TaskDAO dao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddTaskController() {
        super();
        dao = new TaskDAO();
        // TODO Auto-generated constructor stub
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		task t = new task();
		t.setTask_Name(request.getParameter("task_Name"));
		t.setDue_Date(Date.valueOf(request.getParameter("due_Date")));
		t.setTask_State(request.getParameter("task_State"));
		
		dao.addTask(t);
		request.setAttribute("tasks", TaskDAO.getAllTask());
		RequestDispatcher view = request.getRequestDispatcher("list-Task.jsp");
		view.forward(request, response);
		
	}


}


