<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

view.jsp

<form action ="/main/process" method="post">
<input type="text"  name="userId"  value="cony">
<input type="text"  name="userId"  value="moon">



<input type="text"  name="name"  value="코니">
<input type="text"  name="name"  value="문">



addr<input type="text"  name="addr[0].addr1"  value="대전 중구">
addr<input type="text"  name="addr[0].addr2"  value="대흥동">



addr<input type="text"  name="addr[1].addr1"  value="대전 서구">
addr<input type="text"  name="addr[1].addr2"  value="복수동">

<input type="submit"  value="전송">




</form>

</body>
</html>