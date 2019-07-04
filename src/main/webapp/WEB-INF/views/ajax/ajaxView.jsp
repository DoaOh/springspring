<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script>
	$(document).ready(function() {


		$("#requestData").on("click", function() {
			$.ajax({
				url : "/ajax/requestData",
				method : "post",
				success : function(data) {
					$("#page").text(data.pageVo.page);
					$("#pageSize").text(data.pageVo.pageSize);

				}

			});

		});
		
		
		
		
		
		
		

		$("#requestDataResponseBody").on("click", function() {
			$.ajax({
				url : "/ajax/requestDataResponseBody",
				method : "post",
				success : function(data) {
					console.log(data);
					$("#pageResponseBody").text(data.page);
					$("#pageSizeResponseBody").text(data.pageSize);

				}

			});

		});

		
		
		

		
		$("#user").on("click", function() {
			$.ajax({
				url : "/ajax/user",
				method : "post",
				data:"userId=" + $("#userId").val(),
				success : function(data) {
					console.log(data);
					
					/*
					name<input type="text" id="name" readonly="readonly"/><br>
alias<input type="text" id="alias" readonly="readonly"/><br>
birth<input type="text" id="birth" readonly="readonly"/><br>

					*/
					
					 var html ="";
					html += "name : <input type=\"text\" id=\"name\" readonly value =\"" +data.userVo.name+"\" /> ";
					html += "alias : <input type=\"text\" id=\"name\" readonly value =\"" +data.userVo.alias+"\" /> ";
					html += "birth : <input type=\"text\" id=\"name\" readonly value =\"" +data.userVo.birth+"\" /> ";
					
					$("#userJsonInfo").html(html);
					/*
					$("#alias").val(data.userVo.alias);
					$("#name").val(data.userVo.name);
					$("#birth").val(data.userVo.birthStr);
					*/
				}

			});

		});

		
		$("#userHtml").on("click", function() {
			$.ajax({
				url : "/ajax/userHtml",
				method : "post",
				data: $("#frm").serialize(),
				success : function(data) {
					$("#userInfo").html(data);
				}
			});
		});
		
		
		
		
		
		
		//전송할 json객체를 준비 
	//  public class UserVo(){
	//		private String UserId;
	//	}
		//var user2 = new Object();
		//JSON.stringify 자바스트립트 객체를 문자열로 생성
		//JSON.parse  json 문자열을 자바스크립트 객체로 변경
		var user ={userId:"brown",pass:"brown1234"};
		$("#userFormString").text("userId=brown&pass=brown1234");
		$("#userJsonString").text(JSON.stringify(user));
		
		
		
		
		$("#userJsonStringBtn").on("click", function() {
		$.ajax({
			url:"/ajax/requestBody",
			method:"post",
			contentType:"application/json",
			dataType:"json",
			//dataType:"xml",
			data:JSON.stringify(user),
			success:function(data){
			
				//$("#userJsonResult .userId").text(data.getElementsByTagName("userId")[0].childNodes[0].textContent);
			//	$("#userJsonResult .pass").text(data.getElementsByTagName("pass")[0].childNodes[0].textContent);	
				
			$(".userId").text(data.userId);
			$(".pass").text(data.pass);
			}
		});
		});
		
	});
	

</script>

<h2>ajax 데이터요청</h2>
<a id="requestData">데이터 가져오기</a>
page <span id="page"></span>
pageSize <span id="pageSize"></span>
<br>
<br>
<br>
<a id="user">ajaxuser데이터 가져오기</a><br>
userId<input type="text" id="userId" value="podopodo" /><br>
<div id="userJsonInfo"></div>

<br>
<br>
<a id="userHtml"> ajaxHtmlUser데이터 가져오기</a>
<form id="frm">
userId<input type="text" id="userIdHtml" name="userId" value="podopodo" />
</form>
<div id="userInfo"></div>







<h2>ajax 데이터요청 requestDataResponseBody</h2>
<a id="requestDataResponseBody">데이터 가져오기</a>
page <span id="pageResponseBody"></span>
pageSize <span id="pageSizeResponseBody"></span>
<br>






<h2> ajax json 데이터 보내기</h2>
요청보내는 데이터 
<a id="userJsonStringBtn">데이터 보내기</a>
기존<div id="userFormString"></div>
변경<div id="userJsonString"></div>
받는데이터
<div id="userJsonResult">
userId<span class="userId"></span>
pass<span class="pass"></span>
</div>









