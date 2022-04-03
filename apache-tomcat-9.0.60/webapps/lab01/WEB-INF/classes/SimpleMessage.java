package lab01;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet (urlPatterns={"/SimpleMessage"})
public class SimpleMessage extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String html = "<!DOCTYPE html><html><head></head><body><p>Put a simple message here...</p></body></html>";

        out.println(html);
    }
}