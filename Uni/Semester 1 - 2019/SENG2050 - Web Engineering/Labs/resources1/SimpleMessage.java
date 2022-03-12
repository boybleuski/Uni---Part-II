import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet(urlPatterns = {"/SimpleMessage"})
public class SimpleMessage extends HttpServlet
{
  public void doGet(HttpServletRequest request, HttpServletResponse response)
	   throws ServletException, IOException
     {
		    PrintWriter out = response.getWriter();
		    out.println("Put a simple man here...");
	   }
}
