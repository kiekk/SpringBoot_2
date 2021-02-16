<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div style="width:80%; margin:0 auto;">
	<h2>상세 보기</h2>
	<form method="post" action="/board/remove" id="removeForm">
		<div class="row gtr-uniform">
			<input type="hidden" name="pageNum"	value="${cri.pageNum} "/>
			<input type="hidden" name="amount" value="${cri.amount} "/>
			<input type="hidden" name="type" value="${cri.type}" />
			<input type="hidden" name="keyword" value="${cri.keyword}" />
			<h4 style="width:100%">NO</h4>
			<div class="col-6 col-12-small">
				<input type="text" name="bno" id="name" value="${board.bno }" placeholder="Title" readonly/>
			</div>
			<h4 style="width:100%;">Title</h4>
			<div class="col-6 col-12-small">
				<input type="text" name="title" id="name" value="${board.title }" placeholder="Title" readonly/>
			</div>
			<h4 style="width:100%;">Content</h4>
			<div class="col-12">
				<textarea name="content" id="message" placeholder="Enter your message" rows="6" readonly>${board.content }</textarea>
			</div>
			<h4 style="width:100%;">Writer</h4>
			<div class="col-6 col-12-small">
				<input type="text" name="writer" id="name" value="${board.writer }" placeholder="Name" readonly/>
			</div>
			
			<div style="width:100%;"></div>
			<c:forEach var="file" items="${files}">
				<a class="file" href="${file.filePath}">${file.fileName}</a>
			</c:forEach>
			<div class="col-12">
				<ul class="actions">
					<a href="/board/modify${cri.makeQuery()}&bno=${board.bno}" class="button primary small write">Modify</a>
					<input type="submit" class="button primary small write" value="삭제"/>
					<a href="/board/list${cri.makeQuery()}" class="button small">목록</a>
					<a href="/board/register${cri.makeQuery()}&groupNo=${board.groupNo}&depth=${board.depth}" class="button small">답글</a>
					<a href="${board.bno}" class="boardLike">
						<span class="material-icons" style="font-size: 26px; vertical-align: middle; margin-left: 10px;">
							<c:choose>
								<c:when test="${empty board.likeclick}">
									favorite_border
								</c:when>
								<c:otherwise>
									favorite
								</c:otherwise>
							</c:choose>
						</span> 							
						<span class="likeCount"> 
							${board.likecount}
						</span>
					</a>
				</ul>
			</div>
		</div>
		<ul class="icons">
			<li style="display: block">
				<span class="icon solid fa-envelope"></span> 
				<strong>댓글</strong>
			</li>
		</ul>
		<a href="#" style="width: 100%" class="button primary small register">댓글 등록</a>
		<div class="fields register-form" style="display: none">
			<div class="field">
				<h4>작성자</h4>
				<input name="replyer" placeholder="Replyer" type="text" />
			</div>
			<div class="field">
				<h4>댓글</h4>
				<textarea name="reply" rows="6" placeholder="Reply" style="resize: none"></textarea>
			</div>
			<div style="text-align: center" class="field regBtn">
				<a href="#" class="button primary small finish">등록</a> 
				<a href="#" class="button primary small cancel">취소</a>
			</div>
		</div>
		<ul class="icons" style="margin-top:10px;">
			<li style="display: block">
				<span class="icon solid fa-envelope"></span> 
				<strong>등록된 댓글</strong>
			</li>
		</ul>
		<ul class="replies" style="list-style:none;">
			
		</ul>		
		<div class="big-width" style="text-align:center;">
			
		</div>
	</form>
	<h4 style="width:100%;">다음글</h4>
	<c:choose>
		<c:when test="${empty nextBoard}">
			<span>다음 게시글이 없습니다.</span>
		</c:when>
		<c:otherwise>
			<a href="${nextBoard.bno}" class="goGet">${nextBoard.title}</a>
		</c:otherwise>
	</c:choose>
	<h4 style="width:100%;">이전글</h4>	
	<c:choose>
		<c:when test="${empty prevBoard}">
			<span>이전 게시글이 없습니다.</span>
		</c:when>
		<c:otherwise>
			<a href="${prevBoard.bno}" class="goGet">${prevBoard.title}</a>
		</c:otherwise>
	</c:choose>
	<form action="/board/fileDownload" id="fileForm">
		<input type="hidden" name="fileName" value=""/>
		<input type="hidden" name="filePath" value=""/>
	</form>
	
	<form id="actionForm" action="/board/get" method="GET">
		<input type="hidden" name="pageNum" value="${cri.pageNum}" />
		<input type="hidden" name="amount" value="${cri.amount}" />
		<input type="hidden" name="type" value="${cri.type}" />
		<input type="hidden" name="keyword" value="${cri.keyword}" />
	</form>
</div>