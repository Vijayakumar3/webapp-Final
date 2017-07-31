




import java.io.IOException;
import java.io.PrintWriter;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;

@WebServlet("/register")
 public class Register extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        response.setContentType("text/html");
       
       PrintWriter pw = response.getWriter();
       // pw.println("<html><body>Hello</body></html>");
       String username=request.getParameter("username");
        String password=request.getParameter("password");
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Login", "root", "");
            Statement st = conn.createStatement();
            String sql="insert into Details(username,password)values(?,?)";
            PreparedStatement pr=conn.prepareStatement(sql);
            pr.setString(1,username);
            pr.setString(2,password);           
            int result=pr.executeUpdate();
            ResultSet rs = st.executeQuery("Select * from Details");
            pw.print("<html>"+"<body>"+"<h1>"+username+"!! Register Successfully"+"</h1>");
            pw.print("<a href='Mainservlet' target='_blank'><button type='submit' class='btn btn-success but1'>Send mail</button></a>");
            
            //request.getRequestDispatcher("Mainservlet").include(request,response);

            pw.close();
        }

        catch (Exception e) {
            e.printStackTrace();
        }

    }
}