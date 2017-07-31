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

@WebServlet("/Donate")
 public class Donate extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();
        String fullname=request.getParameter("fullname");
        String email=request.getParameter("email");
         String blood=request.getParameter("blood");
          String mobileno=request.getParameter("mobileno");
        String place=request.getParameter("place");
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bloodbank", "root", "");
            Statement st = conn.createStatement();
            String sql="insert into view(fullname,email,blood,mobileno,place)values(?,?,?,?,?)";
            PreparedStatement pr=conn.prepareStatement(sql);
            pr.setString(1,fullname);
            pr.setString(2,email);
            pr.setString(3,blood);
            pr.setString(4,mobileno);
            pr.setString(5,place);
            int result=pr.executeUpdate();
            ResultSet rs = st.executeQuery("Select * from view");

            pw.println("<table border=1>");
            while (rs.next()) {
                pw.println("<tr><td>" + rs.getString(1) + "<td>" + rs.getString(2)+ "<td>" + rs.getString(3)+"<td>"+ rs.getString(4)+ "<td>"+rs.getString(5) + "</tr>");
            }
            pw.println("</table>");
            pw.println("<html>"+"<body>"+"<form action='/logout' method='POST'>"+"<button type='submit'> Logout </button>"+"</form"+"</body>"+"</html>");
            pw.close();
        }

        catch (Exception e) {
            e.printStackTrace();
        }

    }
}