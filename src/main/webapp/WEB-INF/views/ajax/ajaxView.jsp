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














