package Student_controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Student_Dao.Studentdao;
import Student_Dto.Studentdto;

@WebServlet("/create")
public class Insert extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// super.doPost(req, resp);
		String id=req.getParameter("id");
		int cid=Integer.parseInt(id);
		String name=req.getParameter("name");
		String pass=req.getParameter("pass");
		String email=req.getParameter("email");
		
		Studentdto dto=new Studentdto();
		dto.setID(cid);
		dto.setName(name);
		dto.setPassword(pass);
		dto.setEmail(email);
		
		Studentdao dao=new Studentdao();
		String msg = dao.insert(dto);
		resp.getWriter().print(msg);
	}
}
