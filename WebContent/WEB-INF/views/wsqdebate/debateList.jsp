<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


		<main class="main">
		<h2>Topic List</h2>
		<table class="mtable">
		
			<tr>
				<th>Code/</th>
				<th>Master_id/ </th>
				<th>Title/ </th>
				<th>Contents/ </th>
				<th>Hit/</th>
				<th>regDate</th>
				
			</tr>
		<c:forEach var="n" items="${list}">
			<tr>
				<td>${n.code}</td>
				<td>${n.master_id}</td>
				<td><a href="debate?c=${n.code}">${n.title}</a></td>
				<td>${n.contents}</td>
				<td>${n.hit}</td>
				<td><fmt:formatDate pattern="yyyy-MM-dd" value="${n.regDate}" /></td>
			</tr>
		</c:forEach>
			
		
		</table>
		</main>