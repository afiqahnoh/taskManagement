package tsm.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tsm.dao.SubjectDAO;
import tsm.model.Subject;

/**
 * Servlet implementation class UpdateSubjectController
 */
@WebServlet("/UpdateSubjectController")
public class UpdateSubjectController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SubjectDAO dao; 
    /**
     * @see HttpServlet#HttpServlet()
     */
	public UpdateSubjectController() {
        super();
        dao= new SubjectDAO();
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int subject_Id = Integer.parseInt(request.getParameter("subject_Id"));
		request.setAttribute("s", SubjectDAO.getSubjectById(subject_Id));
		RequestDispatcher view = request.getRequestDispatcher("subject-update.jsp");
		view.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Subject s = new Subject();
		s.setSubject_Id(Integer.parseInt(request.getParameter("subject_Id")));
		s.setSubject_Code(request.getParameter("subject_Code"));
		s.setSubject_Name(request.getParameter("subject_Name"));

		
		
		dao.updateSubject(s);
		
		request.setAttribute("subjects", SubjectDAO.getAllSubject());
		RequestDispatcher view = request.getRequestDispatcher("subject-list.jsp");
		view.forward(request, response);
	}
}
