import java.io.*;  
import java.sql.*;  
import java.sql.Connection;
import javax.servlet.ServletException;  
import javax.servlet.http.*;  
import javax.servlet.annotation.*; 
import connection.DB_connect;
@WebServlet("/show")
public class Table extends HttpServlet
 {
     Connection con=DB_connect.getCon(); 
     public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
        {  
            PrintWriter pw=response.getWriter();
    response.setContentType("text/html");
   String Fullname=request.getParameter("Fullname");
        String Email=request.getParameter("Email");
        String Place=request.getParameter("Place");
            try
                {  
                     Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Symposium", "root", "");
            Statement st = conn.createStatement();
            String sql="insert into Register(Fullname,Email,Place)values(?,?,?)";
            PreparedStatement pr=conn.prepareStatement(sql);
            pr.setString(1,Fullname);
            pr.setString(2,Email);
            pr.setString(3,Place);
            
            int result=pr.executeUpdate();
            ResultSet rs = st.executeQuery("Select * from Register");
        {
            String url="<a href=edit?Fullname="+rs.getString(1)+"&"+"Email="+rs.getString(2)+"&"+"Place="+rs.getString(3)+">Edit</a>";
            pw.println("<tr><td>"+rs.getString("Fullname")+"</td><td>"+rs.getString("Email")+"</td><td>"+rs.getString("Place")+"</td><td>"+"<a href=delete?id="+rs.getString(1)+">Delete</a>"+"</td><td>"+url);
        }
        pw.println("</table>");
        pw.close();
}
catch (Exception ex) 
{
    System.out.println(ex);
}  
          
}  
  
 }