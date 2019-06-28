<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="kr.or.ddit.user.model.UserVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>
<!DOCTYPE html>
<html lang="en">


<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				

<div class="blog-header">
	<h1 class="blog-title">Main</h1>
	<p class="lead blog-description">Jsp / Spring.</p>
</div>

<div class="row">

	<div class="col-sm-8 blog-main">

		<div class="blog-post">
			<h2 class="blog-post-title">JSP</h2>
			<p id="p1" class="blog-post-meta">
			<%
				Date date = new Date();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			%>
				<%=sdf.format(date) %>, room 204
			<!-- Date를 el형식으로 어찌 바꾸지??? -->
			</p>

			<p>jsp를 통한 웹 프로그래밍 학습</p>
			<hr>
			
			<h3>상세내역</h3>
			<p>JSP과정에서는 다음과 같은 내용을 학습한다.</p>
				
			
			<ul>
				<li>${userVo}</li>
				<li>servlet 동작원리</li>
				<li>jsp와 servlet의 관계</li>
				<li>jsp 스크립틀릿 요소</li>
				<li>jsp action tag (standard)</li>
				<li>jstl</li>
				<li>db pooling</li>
				<li>페이지 모듈화</li>
			
				
				
			</ul>
		</div>
	</div>
	
</div>	</div>


</html>
