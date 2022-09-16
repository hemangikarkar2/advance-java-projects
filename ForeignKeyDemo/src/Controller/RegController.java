package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import VO.RegVO;
import VO.UserVO;
import DAO.RegDAO;

/**
 * Servlet implementation class RegController
 */
@WebServlet("/RegController")
public class RegController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	//	response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String firstname=request.getParameter("fn");
		String lastname=request.getParameter("ln");
		String username=request.getParameter("un");
		String password=request.getParameter("pwd");
		
		
		UserVO v=new UserVO();
		v.setUn(username);
		v.setPwd(password);
		
		RegDAO d1=new RegDAO();
		d1.insertUSer(v);

		RegVO vo=new RegVO();
		vo.setFn(firstname);
		vo.setLn(lastname);
		vo.setUserVO(v);
		
		RegDAO d=new RegDAO();
		d.insertRegister(vo);
	
		response.sendRedirect("Registration.jsp");

	}

}
