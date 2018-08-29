<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Single Single</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="/single/common/styles/layout.css"
	type="text/css" media="all">
<link rel="stylesheet" href="/single/common/styles/mediaqueries.css"
	type="text/css" media="all">
<link rel='stylesheet' href='/bigdataShop/resources/common/css/cmt/thumbnail.css?ver=5.3.9'
	type='text/css' media='all' />
<link rel='stylesheet' href='/bigdataShop/resources/common/css/cmt/comments.css?ver=4.4.4'
	type='text/css' media='all' />

</head>
<body>
	<div class="wrapper row2">
		<div id="container">
			<div id="kboard-document">
				<div id="kboard-thumbnail-document">
					<div class="kboard-document-wrap">
						<div class="kboard-title">
							<h1>${board.title }</h1>
						</div>
						<div class="kboard-detail">
							<div class="detail-attr detail-writer">
								<div class="detail-name">작성자</div>
								<div class="detail-value">${board.id }</div>
							</div>
							<div class="detail-attr detail-date">
								<div class="detail-name">작성일</div>
								<div class="detail-value">${board.reg_dtm }</div>
							</div>
							<div class="detail-attr detail-view">
								<div class="detail-name">조회</div>
								<div class="detail-value">${board.hit }</div>
							</div>
						</div>
						<div class="kboard-content">
							<div class="content-view">
								<p style="text-align: center;">
									<br/>
									<a href="/bigdataShop/board/download.do?fileName=${fileName.get(0)}&path=${path}">${fileName.get(0)}</a> 
									${board.text }
								</p>
							</div>
						</div>
					</div>
							</div>
						</div>
					</div>
					<div class="kboard-comments-area">
		<div id="kboard-comments-1851" class="kboard-comments-default">
			<div class="kboard-comments-wrap">
				<div class="comments-header">
					<div class="comments-count">
						전체 <span class="comments-total-count" id="cmtcount"><%-- ${fn:length(prdcmtlist)} --%></span>
					</div>
					<hr/>
				</div>
				<div class="comments-list" id="cmtlist">
				<c:forEach var="prdcmt" items="${prdcmtlist }">
					<ul>
						<li class="kboard-comments-item">
							<div class="comments-list-username">${prdcmt.mem_id }</div>
							<div class="comments-list-create">${prdcmt.writedate }</div>
							<div class="comments-list-content">${prdcmt.pro_comment }</div>
							
							<div class="comments-list-controller">
							<div class="right">
								<a type="button" class="deletebtn" href="#">삭제</a>
								<input type="hidden" id="cmt_no" value="${prdcmt.prdcmt_no }"/>
							</div>
						</div>
						</li>
					</ul>
					</c:forEach>
					</div>
				<form id="cmtform" method="post">
					<div class="kboard-comments-form">
						<div class="comments-field">
							<textarea name="pro_comment" id="pro_comment" placeholder="댓글을 입력하세요." style="color: black;" ></textarea>
						</div>
						<div class="comments-submit-button">
							<input class="btn" type="button" value="입력" id="insertcmt">
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
						<div class="right">
							<a
								href="/single/fr/read.do?no=글번호&action=modify"
								class="kboard-thumbnail-button-small">글수정</a> <a
								href="/single/fr/delete.do?no=글번호"
								class="kboard-thumbnail-button-small"
								onclick="return confirm('삭제 하시겠습니까?');">글삭제</a>
						</div>
					</div>
			<br />
</body>
</html>