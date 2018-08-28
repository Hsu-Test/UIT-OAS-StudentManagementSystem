<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
<script type="text/javascript">
function ClickSave()
{
	//alert("saved");
	var form = document.getElementById("save");
	form.method = "post";
	form.action = "${pageContext.request.contextPath}/Edit.do";
	form.submit();
}
function ClickBack()
{
	var form = document.getElementById("save");
	form.method = "post";
	form.action = "${pageContext.request.contextPath}/studentList.do";
	form.submit();
}
</script>
</head>
<body>

	<form name="form" id="save">
	<h2>Edit Student Information</h2>
	<table>
	<tr>
	<td>Student Name</td>
	<td><input type="text" name="StName" id="StName" value="${sname}">
	</td>
	</tr>
	<tr>
	<td>Address</td>
	<td><input type="text" name="StAddress" id="StAddress">
	</td>
	</tr>
	<tr>
	<td>Phone Number</td>
	<td><input type="text" name="StPhoneNum" id="StPhoneNum">
	</td>
	</tr>
	<tr>
	<td>Year</td>
	<td><select id="StYear">
	<option value="FYear" selected>First Year</option>
	<option value="SYear">Second Year</option>
	<option value="TYear">Third Year</option>
	<option vlaue="FourthYear">Fourth Year</option>
	<option value="FifthYear">Fifth Year</option>
	</select>
	</td>
	</tr>
	<tr>
	<td>Major</td>
	<td><select id ="StMajor">
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
	<td><input type="text" name="email" id="StEmail">
	</td>
	</tr>
	<tr>
	<td>D.O.B</td>
	<td><input type="text" name="dob" id="StDOB">
	</td>
	</tr>
	<tr>
	<td>Gender</td>
	<td><input type="radio" name="gender" id="gender">Male
	<input type="radio" name="gender" id="gender">Female
	</td>
	</tr>
	<tr>
	<td>Father Name</td>
	<td><input type="text" name="fatherName" id="StFather">
	</td>
	</tr>
	<tr>
	<td>NRC</td>
	<td><input type="text" name="nrc" id="StNRC">
	</td>
	</tr>
	</table>
	<input type="button" value="Save" onclick="ClickSave()">
	<input type="button" value="Back" onclick="ClickBack()">
	</form>
</body>
</html>