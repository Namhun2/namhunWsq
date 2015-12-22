<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<script type="text/javascript">

var count = 0;


	function addForm() {
		
		var writeModify = document.getElementById("writeModify");
		
		var str = '수정 내용 : ' + '<input name="id" /> ' + 
		' <a onclick="delForm('+count+')"><input type="submit" value="취소"/></a>' +
		' <a onclick:""><input type="submit" value="완료"/></a>';
		
		if(count < 1){
		var addedDiv = document.createElement("div"); // 폼 생성
		
		addedDiv.innerHTML = str; // 폼 Div안에 HTML삽입
		addedDiv.setAttribute("id", "keyword_Frm"+count);
		writeModify.appendChild(addedDiv); // 삽입할 DIV에 생성한 폼 삽입
		count++;
		
		}else {
			alert("1개 이상 수정은 아니되어요.");
		}
		
	}
	
	function delForm(thisCount) {	
	//이 부분에는 추가될 부분의 div 이름을 넣으시면 됩니당
		var writeModify = document.getElementById("writeModify");
		var thisDiv = document.getElementById("keyword_Frm"+(thisCount));
		
		//document.writeModify.reset(); // 폼 내용 삭제
		writeModify.removeChild(thisDiv); // 폼 삭제 
		
		count--;
		/* if (count > 0) {
			// 마지막으로 생성된 폼의 ID를 통해 Div객체를 가져옴
		} else {
		} */

	}
</script>

<main id="main">
<h2 id="debate">Debate Topics</h2>
<div id="debate-comment">
	<a href="/WSQPrj/wsqdebate/debateList">목록이동</a>
</div>
<div id="debate-name">${debate.title}</div>
<div id="debate-name">
	<fmt:formatDate pattern="yyyy-MM-dd" value="${debate.regDate}" />
</div>
<div id="debate-image">${debate.hit}</div>
<div id="debate-versus"></div>
<div id="debate-content">${debate.contents}</div>

<!-- <div style="border: 2px solid #e9e9e9 ; width: 500px; height: 300px;">
		<iframe id="iframe" style="width: 100%; height: 100%" src="frame.html"></iframe>
	</div> -->

<div id="debate-comment">
	~댓글~
	<%-- <iframe id="iframe" style="width: 100%; height: 100%" src="comment?c=${debate.code}"> --%>
		
	<c:forEach var="co" items="${comments}">
	<%-- <c:if test="${co.id == null}"><p>등록된 댓글이 없습니다.</p></c:if> --%>
				
		<!-- 찬성 댓글 -->
		<c:if test="${co.opinion == true}">
			<div style="padding-right: 150px;">
				<font color="blue">찬성</font> / <fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${co.regDate}" />
				/ id:${co.id} / context:${co.context} &nbsp;&nbsp; 
				
				<a onclick="addForm()"><input type="submit" value="수정"/></a>&nbsp;
				<!-- <a onclick="delForm(0)"><input type="submit" value="수정삭제"/></a>&nbsp; -->
				
				<a href="debateDelete?c=${co.debateCode}&code=${co.code}"> 
				<input type="submit" value="삭제" /></a>
			</div>
		</c:if>
		
		<!-- 반대 댓글 -->
		<c:if test="${co.opinion == false}">
			<div style="padding-left: 150px;">
				<a onclick="addForm()"><input type="submit" value="수정"/></a>&nbsp;
				<a href="debateDelete?c=${co.debateCode}&code=${co.code}"> 
				<input type="submit" value="삭제"/></a>
				&nbsp;&nbsp;<fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${co.regDate}" />
				/ id:${co.id} / context:${co.context} / <font color="red">반대</font>  
			</div>			
		</c:if>
</c:forEach>
			<div id="writeModify"></div>
<!-- </iframe> -->
</div>


<%-- <table>
	<c:forEach var="co" items="${comments}">
		<tr>
			<th>test</th>
			<th>${co.debateCode}</th>
			<th>${co.id}</a></th>
			<th>${co.context}</th>
			<th><fmt:formatDate pattern="yyyy-MM-dd" value="${c.regDate}" /></th>
		</tr>
	</c:forEach>
</table> --%>

<form action="debate?c=${debate.code}" method="post">
	<!-- encType="multipart/form-data" -->
	<div>
		<input type="radio" name="opinion" value="True"> 찬성 
		<input type="radio" name="opinion" value="False"> 반대

		<dl>
			<dt>아이디</dt>
			<dd>
				&nbsp;<input name="id" />
			</dd>
		</dl>

		<div>
			<p>내용</p>
			<textarea id="txtContent" class="txtContent" name="context"
				style="width: 400px; height: 18px;"></textarea>
			

			<input type="submit" value="댓글 등록" /> <a class="btn-cancel button"
				href="">취소</a>

		</div>
	</div>

</form>


</main>