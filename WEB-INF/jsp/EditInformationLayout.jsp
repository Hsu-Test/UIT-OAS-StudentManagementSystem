<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
function ClickSave()
{
	var form = document.getElementById("save");
	form.method = "post";
	form.action = '/StudentManagement/Edit.do';
	form.submit();

}
function ClickBack()
{
	location.replace('/StudentManagement/studentList.do');
}


</script>
</head>
<body>

	<form name="form" id="save">
	<h2>Edit Student Information</h2>
	<input type="hidden" name="StID" id="StID" value="${studid1}">

	<table>
	<tr>
	<td>Student Name</td>
	<td><input type="text" name="StName" id="StName" value="${sname}">
	</td>
	</tr>
	<tr>
	<td>Address</td>
	<td><input type="text" name="StAddress" id="StAddress" value="${saddress}">
	</td>
	</tr>
	<tr>
	<td>Phone Number</td>
	<td><input type="text" name="StPhoneNum" id="StPhoneNum" value="${sphoneno}">
	</td>
	</tr>
	<tr>
	<td>Year</td>
	<td><select name="StYear" value="${syear}">
	<option value="FYear" selected>First Year</option>
	<option value="SYear">Second Year</option>
	<option value="TYear">Third Year</option>
	<option value="FourthYear">Fourth Year</option>
	<option value="FifthYear">Fifth Year</option>
	</select>
	</td>
	</tr>
	<tr>
	<td>Major</td>
	<td><select id="major" name="StMajor" value="${smajor}">
	<option value="none" selected>None(1st and 2nd year)</option>
    <option value="SE" >Software Engineering</option>
    <option value="BIS">Business Information System</option>
    <option value="KE">Knowledge Engineering</option>
    <option value="HPC">High Performance Computing</option>
    <option value="CSystem">Computer System</option>
    <option value="CN">Computer Networking</option>
    <option value="ES">Embedded System</option>
    <option value="CT">Computer Technology(3rd Year Students only)</option>
    <option value="CS">Computer Science(3rd Year Students only)</option>
    </select>
	</td>
	</tr>
	<tr>
	<td>Email</td>
	<td><input type="text" name="email" id="email" value="${semail}">
	</td>
	</tr>
	<tr>
	<td>D.O.B</td>
	<td><input type="text" name="dob" id="dob" value="${sdob}">
	</td>
	</tr>
	<tr>
	<td>Gender</td>
	<td><input type="radio" name="gender" id="male" value="Male">Male
	<input type="radio" name="gender" id="female" value="Female">Female
	<input type="hidden" id="gender" value="${sgender}"></td>
	</tr>
	<tr>
	<td>Father Name</td>
	<td><input type="text" name="fatherName" id="fatherName" value="${sfather}">
	</td>
	</tr>
	<tr>
	<td>NRC</td>
	<td><input type="text" name="nrc" id="nrc" value="${snrc}">
	</td>
	</tr>
	</table>
	<input type="button" value="Save" onclick="ClickSave()">
	<input type="button" value="Back" onclick="ClickBack()">
	</form>


	<script type="text/javascript">
	//alert(document.getElementById("gender").value);
	if(document.getElementById("gender").value==="Female"){
		document.getElementById("female").checked = true;
	}
	else if(document.getElementById("gender").value==="Male"){
		//alert('enter');
		document.getElementById("male").checked = true;
	}
	</script>
</body>
</html>