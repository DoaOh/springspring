<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>

$(document).ready(function() {
	$("#DownGOGO").on("click", function() {
		$("#frm").submit();
	})
	
	
})


</script>


</head>
<body>




<form  id="frm" action="${cp }/user/userListExcel" method="get">

<button id="DownGOGO" type="button"> 다운로드 </button>

</form>
		
				


</body>
</html>