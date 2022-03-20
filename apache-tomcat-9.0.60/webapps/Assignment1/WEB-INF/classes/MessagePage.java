import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;

@WebServlet(urlPatterns = {"/MessagePage"})
public class MessagePage extends HttpServlet {
    private final String FILE_LOCATION = "../webapps/Assignment1/WEB-INF/";
    private List<String> subMessageList = new ArrayList<String>();
    
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        FileReader fReader = new FileReader(FILE_LOCATION + "MessagePage.html");
        BufferedReader bReader = new BufferedReader(fReader);
        StringBuilder htmlContent = new StringBuilder(1024);
        String str = "";
        String userName = request.getParameter("userName");
        String msgTitle = request.getParameter("msgTitle");
        String msgContent = request.getParameter("msgContent");
        String msgDate = request.getParameter("msgDate");
        
        while((str=bReader.readLine()) != null) {
            htmlContent.append(str);
            if (str.contains("messageList")) {
                htmlContent.append(getParentMessage(userName, msgTitle, msgContent, msgDate));
            }
        } 

        PrintWriter out = response.getWriter();
        out.println(htmlContent);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        FileReader fReader = new FileReader(FILE_LOCATION + "MessagePage.html");
        BufferedReader bReader = new BufferedReader(fReader);
        StringBuilder htmlContent = new StringBuilder(1024);
        String str = "";

        while((str=bReader.readLine()) != null) {
            htmlContent.append(str);
            if (str.contains("subMessageList")) {
            }
        } 

        PrintWriter out = response.getWriter();
        out.println(htmlContent);
    }

    public String getParentMessage(String userName, String msgTitle, String msgContent, String msgDate) {
        // add link.
        String msgHtml = "<table>";
        msgHtml += "<tr><td>Name:</td><td>" + userName + "</td></tr>";
        msgHtml += "<tr><td>Title:</td><td>" + msgTitle + "</td></tr>";
        msgHtml += "<tr><td>Content:</td><td>" + msgContent + "</td></tr>";
        msgHtml += "<tr><td>Time:</td><td>" + msgDate + "</td></tr>";
        msgHtml += "</table></a>";

        return msgHtml;
    }
}