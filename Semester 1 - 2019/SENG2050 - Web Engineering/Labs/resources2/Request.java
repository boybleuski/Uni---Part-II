String value = request.getParameter("parameterName");

if (value == null) {
	//the parameter wasn't passed
} else if (value.equals("someValue")) {
	//the parameter was an expected value
} else {	
	//some other value was found
}