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
 * Servlet implementation class AddSubjectController
 */
@WebServlet("/AddSubjectController")
public class AddSubjectController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SubjectDAO dao; 
    /**
     * @see HttpServlet#HttpServlet()
     */
	public AddSubjectController() {
        super();
        dao= new SubjectDAO();
        // TODO Auto-generated constructor stub
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Subject s = new Subject();
		s.setSubject_Code(request.getParameter("subject_Code"));
		s.setSubject_Name(request.getParameter("subject_Name"));

		
		
		dao.addSubject(s);
		
		request.setAttribute("subjects", SubjectDAO.getAllSubject());
		RequestDispatcher view = request.getRequestDispatcher("subject-list.jsp");
		view.forward(request, response);
	}

}
