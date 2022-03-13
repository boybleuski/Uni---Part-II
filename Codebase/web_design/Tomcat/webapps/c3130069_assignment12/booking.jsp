<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
   <title></title>
   <head>
      <script src="script.js"></script>
      <link rel="stylesheet" src="style.css">
   </head>

   <body onload="formFill()">
      <h2>Seating confirmation</h2>
      <p id="seat">Seat number: </p>
      <p id="code">Security code: </p>
      <h2>JSP Expressions</h2>
      <ul>
        <li>Current time: <%= new java.util.Date() %></li>
        <li>Your hostname: <%= request.getRemoteHost() %> </li>
        <li>Your session ID: <%= session.getId() %> </li>
        <li>Your Parameter is: <%= request.getParameter("testParam") %> </li>
      </ul>

      <form name="bookingForm" method="GET" action="BookSeat" onsubmit="return validate();">
        <p>User ID: <input type="text" name="userID"></p>
        <p>Phone: <input type="text" name="phone"></p>
        <p>Address: <input type="text" name="address"></p>
        <p>Email: <input type="text" name="email"></p>
        <p>Security code: <input type="text" name="security"></p>
        <p><input type="submit" name="submit" value="Submit"></p>
        <p><input type="reset" name="clear" value="Clear"></p>
        <p><input type="button" name="return" value="Go back" onClick=goHome()></p>
      </form>
   </body>
</html>
