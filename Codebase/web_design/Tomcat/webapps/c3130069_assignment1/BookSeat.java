package c3130069_assignment1;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/BookSeat")
public class BookSeat extends HttpServlet
{
   @Override
   protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException
      {
         response.setContentType("text/jsp");
         PrintWriter out = response.getWriter();

         String userID = request.getParameter("userID");
         String phone = request.getParameter("phone");
         String address = request.getParameter("address");
         String email = request.getParameter("email");
         String security = request.getParameter("security");
         showMessageDialog(null, userID);
      }

   @Override
   protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException
      {
      }
}
