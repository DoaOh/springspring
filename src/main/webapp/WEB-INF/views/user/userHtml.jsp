<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>  
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


name<input type="text" id="name" readonly="readonly"  value="${userVo.name}"/><br>
alias<input type="text" id="alias" readonly="readonly"  value="${userVo.name}"/><br>
birth<input type="text" id="alias" readonly="readonly"  value="<fmt:formatDate value="${userVo.birth }" pattern="yyyy-MM-dd"/>"/>
