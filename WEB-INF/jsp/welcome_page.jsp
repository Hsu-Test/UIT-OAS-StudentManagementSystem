<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!--  link type="text/css" rel="stylesheet" href="css/materialize.min.css"  media="screen,projection"/-->
<style>
fieldset {
	width: 300px;
}

form {
	line-height: 40px;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<script type="text/javascript">
		function register() {

			var form = document.getElementById("reg");
			form.method = "post";
			form.action = "db.do";
			form.submit();
		}
		function back() {

			var form = document.getElementById("reg");
			form.method = "get";
			form.action = "welcome.do";
			form.submit();
		}
	</script>
	<form id="reg">
		<fieldset>
			<legend>Student Registration Form</legend>
			<table>
				<tr>
					<td>StudentID :</td>
					<td><input type="text" name="sid" value=${sid}></td>
				</tr>
				<tr>
					<td>Name :</td>
					<td><input type="text" name="name" value=${name}></td>
				</tr>

				<tr>
					<td>Address :</td>
					<td><input type="text" name="address" value=${address}></td>
				</tr>

				<td>Phone Number :</td>
				<td><input type="text" name="phone" value=${phone}></td>
				</tr>

				<td>Year :</td>
				<td><input type="text" name="acyear" value=${acyear}></td>
				</tr>

				<td>Major :</td>
				<td><input type="text" name="major" value=${major}></td>
				</tr>

				<td>Email :</td>
				<td><input type="email" name="email" value=${email}></td>
				</tr>

				<td>D.O.B :</td>
				<td><input type="text" name="dob" value=${dob}></td>
				</tr>

				<td>Gender :</td>
				<td>Male <input type="radio" name="gender" value="Male">
					Female <input type="radio" name="gender" value="Female"></td>
				</tr>

				<td>Father Name :</td>
				<td><input type="text" name="fname" value=${fname}></td>
				</tr>

				<td>NRC :</td>
				<td><input type="text" name="nrc" value=${nrc}></td>
				</tr>

				<tr>
					<td></td>
					<td><input type="submit" value="Save" onclick="register()">
						<input type="button" value="Back" onclick="history.back()"></td>
				</tr>
			</table>
		</fieldset>
	</form>
	<form method="post" action="delete.do">
		<input type="submit" value="Delete">
	</form>
</body>
</html>