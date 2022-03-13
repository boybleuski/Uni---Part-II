import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/BookSeat")
public class BookSeat extends HttpServlet
{
   @Override
   protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException
      {
      }

   @Override
   protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException
      {
         response.setContentType("text/html");
         PrintWriter out = response.getWriter();

         String userID = request.getParameter("userID");
         String phone = request.getParameter("phone");
         String address = request.getParameter("address");
         String email = request.getParameter("email");
         String security = request.getParameter("security");
      }
}
