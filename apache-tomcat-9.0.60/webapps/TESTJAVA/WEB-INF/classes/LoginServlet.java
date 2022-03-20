import java.io.IOException;
import java.io.PrintWriter;
 
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
@WebServlet(urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {
    private final String FILE_LOCATION = "../webapps/TESTJAVA/WEB-INF/";
 
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        FileReader fReader = new FileReader(FILE_LOCATION + "LoginServlet.html");
        BufferedReader bReader = new BufferedReader(fReader);
        StringBuilder htmlContent = new StringBuilder(1024);
        String str = "";
        while((str=bReader.readLine()) != null) {
            htmlContent.append(str);
        } 
        PrintWriter out = response.getWriter();
        out.println(htmlContent);
    }

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
         
        // read form fields
        String username = request.getParameter("username");
        String password = request.getParameter("password");
         
        System.out.println("username: " + username);
        System.out.println("password: " + password);
 
        // do some processing here...
         
        // get response writer
        PrintWriter writer = response.getWriter();
         
        // build HTML code
        String htmlRespone = "<html>";
        htmlRespone += "<h2>Your username is: " + username + "<br/>";      
        htmlRespone += "Your password is: " + password + "</h2>";    
        htmlRespone += "</html>";
         
        // return response
        writer.println(htmlRespone);
         
    }
}