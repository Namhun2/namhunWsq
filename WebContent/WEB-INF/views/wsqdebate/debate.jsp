<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	
	<main id="main">
		<h2 id="debate">Debate Topics</h2>
			<div id="debate-comment"><a href="/WSQPrj/wsqdebate/debateList">목록이동</a></div>
			<div id="debate-name">${debate.title}</div>
			<div id="debate-image">${debate.hit}</div>
			<div id="debate-versus"><!-- 토론 여론 --></div>
			<div id="debate-content">${debate.contents}</div>
			<div id="debate-comment"><!-- 댓글 --></div>
			
	</main>