package lab01;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet (urlPatterns={"/LuckyNumbers"})
public class LuckyNumbers extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String html = "<!DOCTYPE html><html><head><title></title></head><body>";
        String value = request.getParameter("name");
        String[] arrNumbers = request.getParameterValues("number");

        if (value==null) { } 
        else {
            html += "<p>" + value + "</p>";
        }

        if (arrNumbers == null) { } 
        else {
            for(int index=0; index<arrNumbers.length; index++) {
                html += "<p>" + arrNumbers[index] + "</p>";
            }
        }

        html += "</body></html>";
        out.println(html);
    }
}