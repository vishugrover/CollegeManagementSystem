package servelets;

import java.io.IOException;
import java.lang.Thread.State;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DBConnection.ConnectionProvider;

import java.sql.*;

@WebServlet("/ADMIN_updateMarks")
public class ADMIN_updateMarks extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session=request.getSession();
		String uname=(String)session.getAttribute("uname");
		String course=(String)session.getAttribute("course");
		System.Out.Println("Hello");
		try
		{	
			Connection con=ConnectionProvider.provideConnection();
			String query="insert into marks_"+course+"(uname,sub1,sub2,sub3,sub4,sub5,sub6) values('"+uname+"',0,0,0,0,0,0)";
			Statement st=con.createStatement();
			int c=st.executeUpdate(query);
			if(c==1)
			{
				response.sendRedirect("ADMIN_successful.jsp");
			}
			session.removeAttribute("uname");
		}
		catch(Exception e)
		{
			
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
