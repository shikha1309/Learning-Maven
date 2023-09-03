<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register here</title>
</head>
<body> 

<form  action = "./RegForm" method="post"> 
      Name:<input type="text"  name ="name"/> <br>
      Email:<input type="text" name ="email"/> <br>
      Password:<input type="password"  name ="password"/> <br>
       Gender: <input type="radio"  name ="gender1"/> Male 
               <input type="radio" name = "gender1" /> Female <br>
      City: <select name="city"> 
        <option>Lucknow</option>
        <option>Kanpur</option>
        <option>Allahabad</option>
        <option>Jhansi</option> 
        <option>Faizabad</option>
       </select> <br> <br>
      <input type="submit" value="register"/>
 
</form>

</body>
</html>