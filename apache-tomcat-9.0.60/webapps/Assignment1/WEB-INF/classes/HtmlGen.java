public class HtmlGen {
    public String head(String heading) {
        String html = "<head>";
        html += "<title>" + heading + "</title>"; 
        html += "<script src=\"/Assignment1/js/ForumPage.js\"></script>"; 
        html += "<link rel=\"stylesheet\" href=\"ForumPage.css\">";
        html += "</head>";

        return html;
    }

    public String h1(String content) {
        return "<h1>" + content + "</h1>";
    }

    public String mainTable() {
        String html = "";
        return html;
    }

    public String messageTable() {
        String html = "";
        return html;
    }

    public String form() {
        String html = "<form action=\"ForumPage\" method=\"post\">";
        html += "<label for=\"userName\">User Name</label>";
        html += "<input type=\"text\" name=\"userName\" id=\"userName\" /><br>";
        html += "<label for=\"msgTitle\">Title</label>";
        html += "<input type=\"text\" name=\"msgTitle\" id=\"msgTitle\" /><br>";
        html += "<label for=\"msgContent\">Content</label>";
        html += "<input type=\"text\" name=\"msgContent\" id=\"msgContent\" /><br>";
        html += "<input type=\"submit\" value=\"Post\" /></form>";
        
        return html;
    }
}