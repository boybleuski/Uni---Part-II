
function clock()
{
  var now = new Date();
  document.getElementById('clock').innerHTML =
    now.getDate() + "-" + (now.getMonth()+1) + "-" + now.getFullYear() + " " +
    (("0"+now.getHours()).slice(-2)) + ":" + (("0"+now.getMinutes()).slice(-2)) + ":" + (("0"+now.getSeconds()).slice(-2));
  time = setTimeout('clock()', 1000);
}

function generateCode()
{
  var code = "";
  var choice = "abcdefghijklmnopqrstuvwxyz0123456789"
  for (var i=0; i<6; i++)
  {
    code += choice.charAt(Math.floor(Math.random() * choice.length));
  }
  return code;
}

function tableLink()
{
  var table = document.getElementById("table"), rIndex, cIndex;
  var rowNo = 0;
  var colNo = 0;

  for (var i=1; i<table.rows.length; i++)
  {
    for (var j=1; j<table.rows[i].cells.length; j++)
    {
      table.rows[i].cells[j].onclick = function()
      {
         rowNo = this.parentElement.rowIndex;
         colNo = this.cellIndex;
         window.location.replace("booking.jsp");
         storeCode(code);
      };
    }
  }
}

function goHome()
{
  window.location.replace("main.jsp");
}

function validate()
{
  var userID = document.getElementById("userID");
  var phone = document.getElementById("phone");
  var address = document.getElementById("address");
  var email = document.getElementById("email");
  var security = document.getElementById("security");
  var resultStatus = true;
  var errorStr = "Error(s):\n";

  if(!userID)
  {
    resultStatus = false;
    errorStr += "UserID is a required field.\n";
  }
  if(!email)
  {
    resultStatus = false;
    errorStr += "Email is a required field.\n";
  }
  if(email.includes("@") == false)
  {
    resultStatus = false;
    errorStr += "Email must contain an \"@\" symbol.\n";
  }
  if(!resultStatus)
  {
    alert(errorStr);
  }
  return resultStatus;
}

function formFill()
{
  code = generateCode();
  var confirmCode = document.getElementById("code");
  confirmCode.textContent += code;
}
