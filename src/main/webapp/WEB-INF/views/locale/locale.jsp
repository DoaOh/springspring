<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 





<script>


$(document).ready(function(){
	
	if("${param.lang }" == ""){
		$("#lang").val("ko");
		$("#frm").submit();
		
	}else{
		$("#lang").val("${param.lang }");
	}

	
	$("#lang").on("change",function(){
		console.log("select box changed");
		$("#frm").submit();
	});
	
});




// $(document).ready(function(){
	
// 	if("${param.lang }" == ""){
// 		$("#lang").val("ko");
// 		$("#frm").submit();
		
// 	}else{
// 		$("#lang").val("${param.lang }");
// 	}

	
// 	$("#lang").on("change",function(){
// 		console.log("select box changed");
// 		$("#frm").submit();
// 	});
	
// });
	
</script>











<!-- $(document).ready(function() {

		/*   $("#selectLocationbtn").on("click",function(){
		$("#frm").submit();     		   		
		}); 
		 */

		/* $(".selectLocation").on('change',function(){
		    $("#frm").submit();     		   		
			}); */

		$("#selectLocation").change(function() {
			/* var selectLocation=this.val(); */

			var selectLocation = $('#selectLocation option:selected').val();
			console.log("selectLocation");

			// $("#selectOption").val(selectLocation);

			$("#frm").submit();
		});

		/* 	 	$(".selectLocationO").on("change",function(){
		
		 //사용자 아이디를 $userId 값으로 설정해줌 
		 var select = $(this).text();
		 console.log("select");
		
		 $("#select").val(select);
		 //frm 을 이용하여 submmit

		 $("#frm").submit();	
		 });
		 */

	}) -->









<!-- <script>

$(document).ready(function(){
	 
	 if("${param.lang}" == ""){
		 $("select[name=lang]").val("ko");
	 }else{
		 $("select[name=lang]").val("${param.lang}");
	 }
	$("select[name=lang]").val("${param.lang}");
	 $("select[name=lang]").on("change",function(){
		$("select[name=lang]").parent().submit();
	});
	 
});


</script> -->


<%-- $(document).ready(function(){
	
	$('#lang').val("${param.lang}");
	$("#lang").on("change",function(){
		$('fm').submit();
	});
});
 --%>

<%-- $(document).ready(function(){
		
 		$("select[name=lang]").val("${param.lang}");
		
		 $("select[name=lang]").on("change",function(){
			$("select[name=lang]").parent().submit();
		});
	});
 --%>
 

lang : ${param.lang}
<form  id ="frm" action="/locale/view" method="post">
    
		<select id="lang" name="lang">
			<option value="ko">한국어</option>
			<option value="en">English</option>
			<option value="ja">日本言</option>
		</select>
    </form>
    
 <spring:message code="GREETING"/> <br>
 <spring:message code="VISITOR"> <br>
 <spring:argument value="brown"/>
 </spring:message>
