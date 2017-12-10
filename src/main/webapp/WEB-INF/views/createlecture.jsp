<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>수강 신청</title>
</head>
<body>

<form method="post" action="${pageContext.request.contextPath}/docreate">
	
	<table>
		<tr> <td> 년도 : </td>  <td><input type="text" name="year"></td> </tr>
		<tr> <td> 학기 : </td>  <td><input type="text" name="semester"></td> </tr>
		<tr> <td> 과목코드 : </td>  <td><input type="text" name="subject_code"></td> </tr>
		<tr> <td> 과목명 : </td>  <td><input type="text" name="subject_name"></td> </tr>
		<tr> <td> 구분 : </td>  <td><input type="text" name="classification"></td> </tr>	
		<tr> <td> 학점 : </td>  <td><input type="text" name="credit"></td> </tr>	
		<tr> <td></td> <td><input type="submit" value="수강 신청"></td> </tr>
	</table> 
		
</form>
</body>
</html>