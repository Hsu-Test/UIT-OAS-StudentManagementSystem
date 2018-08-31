<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
fieldset {
    display: block;
    width:250px;
    padding-top: 0.35em;
    padding-bottom: 0.625em;
    padding-left: 0.75em;
    padding-right: 0.75em;
    border: 2px groove (internal value);
}
input{
margin-bottom:10px;
width:230px;
height:50px;
position:center;
}
input:hover{
color:red;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<script type="text/javascript">
	function submitEvent1() {
		var form = document.getElementById("welcome");
		form.method = "get";
		form.action = "db.do";
		form.submit();
	}
	function submitEvent2() {
		var form = document.getElementById("welcome");
		form.method = "get";
		form.action = "studentList.do";
		form.submit();
	}
</script>
</head>
<body>
	<div align="center">
		<form id="welcome">
			<fieldset>
			<legend>Student Management System</legend>
				<input type="button" value="Register" onclick="submitEvent1();"><br>
				<input type="button" value="Student List" onclick="submitEvent2();">
			</fieldset>
		</form>
	</div>
</body>
</html>