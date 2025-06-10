package member;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MemberController
 */
@WebServlet("/mcontrol")
public class MemberController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    MemberDAO dao;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        dao = new MemberDAO();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        String view = "";
        if (action == null) {
            getServletContext().getRequestDispatcher("/mcontrol?action=list").forward(req, resp);
        } else {
            switch (action) {
                case "list": view = list(req, resp); break;
                case "insert": view = insert(req, resp); break;
            }
            getServletContext().getRequestDispatcher(view).forward(req, resp);
        }
    }

	private String insert(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		return null;
	}

	private String list(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		return null;
	}

public String list1(HttpServletRequest req, HttpServletResponse resp) {
    req.setAttribute("memberlist", dao.getAll());
    return "/memberinfo.jsp";
}

public String insert1(HttpServletRequest req, HttpServletResponse resp) {
    Member m = new Member();
    m.setUsername(req.getParameter("username"));
    m.setCompany(req.getParameter("company"));
    m.setEmail(req.getParameter("email"));
    dao.insert(m);
    return list(req, resp);
}

/**
 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
 */
protected void doGet(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {
    // TODO Auto-generated method stub
    response.getWriter().append("Served at: ").append(request.getContextPath());
}

/**
 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
 */
protected void doPost(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {
    // TODO Auto-generated method stub
    doGet(request, response);
}

}