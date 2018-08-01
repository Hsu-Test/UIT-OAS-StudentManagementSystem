<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">

function submitEvent(){
	//alert("enter");
	var form = document.getElementById('welcome');
	form.method="post";
	form.action='welcome.do';
	form.submit();
}
</script>

</head>
<body>
helloworld
<form id="welcome">
	<input type="button" value="Submit" onclick="submitEvent();">
</form>
</body>
</html>