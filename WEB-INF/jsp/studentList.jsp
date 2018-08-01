<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>

table {
    border-collapse: collapse;
    width:100%;
}
th {
    text-align: left;
    background-color: #f1f1f1;

}
td {
    text-align: left;
}

#studentList{
display:none;
}
#year{
display:none;
}

#major{
display:none;
}
</style>

</head>

<body>

<%
Object result = request.getAttribute("results");
String searchKey = (String)request.getAttribute("searchKey");
String specificKey = (String)request.getAttribute("specificKey");
String location = (String)request.getAttribute("location");
System.out.println("JSP"+result);
	%>
<h2>Student Management</h2>
<hr>
<form action="studentList.do" method="post">

<select id = "search_key" name="search_key" style="width:20%" onchange="search_key_function()">
  <option value="name" selected>Student Name</option>
  <option value="year">Academic Year</option>
  <option value="major">Major</option>
</select>



<select id ="year" name="year" style="width:20%">

  <option value="First" selected>First Year</option>
  <option value="Second">Second Year</option>
  <option value="Third">Third Year</option>
  <option value="Fourth">Fourth Year</option>
  <option value="Final">Final Year</option>

</select>

<select id ="major" name="major" style="width:20%">
  <option value="SE" selected>Software Engineering</option>
  <option value="BIS">Business Information System</option>
  <option value="KE">Knowledge Engineering</option>
  <option value="HPC">High Performance Computing</option>
  <option value="CSystem">Computer System</option>
  <option value="CN">Computer Networking</option>
  <option value="ES">Embedded System</option>
  <option value="CT">Computer Technology(3rd Year Students only)</option>
  <option value="CS">Computer Science(3rd Year Students only)</option>

</select>
<input id="name" type="text" name="name" style="width:20%">


<br>
<input type="submit" name="search" value="Search">
<input type="submit" name="showAll" value="Show All">
<input id ="back" type="button" name="back" value="Back" onclick="goBack()">

</form>
<hr>

<div id="studentList" style=" overflow-x:auto">
<h2>Student List</h2>

<table id="studentTable">
         <thead>
                    <tr>
                    <th>#</th>
                    <th>SID</th>
                    <th>Name</th>
                    <th>Address</th>
                    <th>Phone NO.</th>
                    <th>Academic Year</th>
                    <th>Major</th>
                    <th>Email</th>
                    <th>Date of Birth</th>
                    <th>Gender</th>
                    <th>Father's Name</th>
                    <th>NRC</th>
                    <th></th>
                    </tr>
                </thead>
                <tbody>
<c:forEach var="data" items="${results}" varStatus="status">

<c:if test="${status.count != 0}">
                    <tr>

                <c:forEach var="body" items="${data}">
                        <td style="width: 120px;">${body.value}</td>
                </c:forEach>
                <td><form id="edit"><input type="button" value="Edit" onclick="edit()"></form><form id="delete"><input type="button" value="Delete" onclick="deleteStud()"></form></td>
                    </tr>
                    <tr></tr>
</c:if>


</c:forEach>
</tbody>
</table>

<br>
<form id= "add">
<input type="button" value="Add" onclick="add()">
</form>
</div>



<script type="text/javascript">

var s = "<%=searchKey%>";
var k = "<%=specificKey%>";
var loc = "<%=location%>";
//alert(loc);
var value = "<%=result%>";
//alert("result"+value);

if(s!="null" && k!="null"){
document.getElementById('search_key').value=s;
search_key_function();
		switch(s){
        	case "name" :document.getElementById('name').value =k;break;
        	case "year" :document.getElementById('year').value=k;break;
        	case "major" :document.getElementById('major').value=k;break;
        	}

}


    if (value == null || value == "null" ||value.length==0){
    	//alert("result2"+value);
        document.getElementById("studentList").style.display = "none";
    }
   else{
	  // alert("result3"+value);
    document.getElementById("studentList").style.display = "block";
    }


    function search_key_function() {
        var x = document.getElementById("search_key").value;
        //document.getElementById("demo").innerHTML = "You selected: " + x;
        if(x === "name"){
        	document.getElementById("name").style.display = "inline";
        	document.getElementById("year").style.display = "none";
        	document.getElementById("major").style.display = "none";

        }
        else if(x === "year"){
        	document.getElementById("year").style.display = "inline";
        	document.getElementById("major").style.display = "none";
        	document.getElementById("name").style.display = "none";
        }
        else if(x === "major"){
        	document.getElementById("major").style.display = "inline";
        	document.getElementById("name").style.display = "none";
        	document.getElementById("year").style.display = "none";
        }
    }

    function goBack(){
    	var loc = "<%=location%>";
    	if(loc == "welcome"){
    		//document.getElementById("back").location.href = '/StudentManagement/welcome.do;
    		location.replace('/StudentManagement/welcome.do');
    	}
    	else if(loc == "registeration"){
    		//document.getElementById("back").location.href = '/StudentManagement/simple82.do;
    		location.replace('/StudentManagement/welcome.do');
    	}
    }
    function add(){
    	alert("add");
    	var form = document.getElementById('add');
    	form.method="get";
    	form.action='add.do';
    	form.submit();
    }
    function edit(){
    	alert("edit");
    	var form = document.getElementById('edit');
    	form.method="post";
    	form.action='edit.do';
    	form.submit();
    }
    function deleteStud(){
    	alert("delete");
    	var form = document.getElementById('delete');
    	form.method="get";
    	form.action='delete.do';
    	form.submit();
    }

</script>

</body>
</html>