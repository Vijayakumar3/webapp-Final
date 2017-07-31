import java.io.*;  
import java.sql.*;  
import java.sql.Connection;
import javax.servlet.ServletException;  
import javax.servlet.http.*;  
import javax.servlet.annotation.*; 
import connection.DB_connect;
import javax.servlet.RequestDispatcher;
@WebServlet("/search")
public class Search extends HttpServlet
{
         public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
        {  
            try {
           response.setContentType("text/html");
            PrintWriter pw = response.getWriter();
            
           String reqBlood=request.getParameter("blood");
                       //pw.println(reqBlood);     
                       
           Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bloodbank", "root", "");
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("Select * from view where blood="+reqBlood);
              pw.println("<table border=1>");
            while (rs.next()) {
                pw.println("<tr><td>" + rs.getString(1) + "<td>" + rs.getString(2)+ "<td>" + rs.getString(3)+"<td>"+ rs.getString(4)+ "<td>"+rs.getString(5) + "</tr>");
            }
            pw.println("</table>");
                          pw.println("<html>"+"<body>"+"<form action='/logout' method='POST'>"+"<button type='submit'> Logout </button>"+"</form>");

            pw.close();
           }
catch (Exception ex) 
{
    System.out.println(ex);
}  
        }
}
