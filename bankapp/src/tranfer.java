

import java.io.IOException;
//import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
//import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class tranfer
 */
@WebServlet("/tranfer")
public class tranfer extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		int amt = Integer.parseInt(request.getParameter("tamt"));
		String user="root"; String password="root";
		 String url="jdbc:mysql://localhost:3306/bankingapp";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, user, password);
			
		 
			String sql="UPDATE accounts SET amount = amount -"+amt+" WHERE accno='ac01' "; 
			
			Statement st = con.createStatement();
			st.executeUpdate(sql);
			String sql2 = "Insert into transactions(accno,type,amount) values('acc01','Transfered',?)";
			PreparedStatement st2 = con.prepareStatement(sql2);
			    st2.setInt(1, amt);
			    st2.executeUpdate(); 	    
			    st.close();
			    con.close();
			    RequestDispatcher rd=request.getRequestDispatcher("/Home.jsp");
				rd.forward(request, response);
			}	    
		
		catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}}}