<html>
   <title></title>
   <head>
      <script src="script.js"></script>
      <link rel="stylesheet" src="style.css">
   </head>

   <body onload="formFill()">
      <h2>Seating confirmation</h2>
      <p id="seat">Seat number: </p>
      <p id="code">Security code: </p>

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
