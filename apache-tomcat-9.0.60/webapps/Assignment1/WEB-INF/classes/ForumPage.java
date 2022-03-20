import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;

@WebServlet(urlPatterns = {"/ForumPage"})
public class ForumPage extends HttpServlet {
    private final String FILE_LOCATION = "../webapps/Assignment1/WEB-INF/";
    private List<String> messageList = new ArrayList<String>();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        FileReader fReader = new FileReader(FILE_LOCATION + "ForumPage.html");
        BufferedReader bReader = new BufferedReader(fReader);
        StringBuilder htmlContent = new StringBuilder(1024);
        String str = "";

        if (request.getParameter("userName") != null) {
            messageList.add(buildMessage(request.getParameter("userName"), request.getParameter("msgTitle"), request.getParameter("msgContent")));
        }

        System.out.println(messageList);
        while((str=bReader.readLine()) != null) {
            htmlContent.append(str);
            if (str.contains("messageList") && messageList.size() > 0) {
                htmlContent.append(outputMessageList(messageList));
            }
        } 
        
        PrintWriter out = response.getWriter();
        out.println(htmlContent);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        FileReader fReader = new FileReader(FILE_LOCATION + "ForumPage.html");
        BufferedReader bReader = new BufferedReader(fReader);
        StringBuilder htmlContent = new StringBuilder(1024);
        String str = "";

        if (request.getParameter("userName") != null) {
            messageList.add(buildMessage(request.getParameter("userName"), request.getParameter("msgTitle"), request.getParameter("msgContent")));
        }

        System.out.println(messageList);
        while((str=bReader.readLine()) != null) {
            htmlContent.append(str);
            if (str.contains("messageList") && messageList.size() > 0) {
                htmlContent.append(outputMessageList(messageList));
            }
        } 
        
        PrintWriter out = response.getWriter();
        out.println(htmlContent);
    }

    public String buildMessage(String userName, String msgTitle, String msgContent) {
        // add link.
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
        String msgDate = format.format(new Date()); 
        String msgHtml = "<a href=\"MessagePage?userName=" + userName + "&msgTitle=" + msgTitle + "&msgContent=" + msgContent + "&msgDate=" + msgDate + "\">";

        msgHtml += "<table>";
        msgHtml += "<tr><td>Name:</td><td>" + userName + "</td></tr>";
        msgHtml += "<tr><td>Title:</td><td>" + msgTitle + "</td></tr>";
        msgHtml += "<tr><td>Time:</td><td>" + msgDate + "</td></tr>";
        msgHtml += "</table></a>";

        return msgHtml;
    }

    public String outputMessageList(List<String> msgList) {
        String listAsString = "";

        for (int index = 0; index < msgList.size(); index++) {
            listAsString += msgList.get(index);
        }

        return listAsString;
    }
}