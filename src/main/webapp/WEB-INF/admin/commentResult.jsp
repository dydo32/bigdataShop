<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">

<link rel="stylesheet" type="text/css"
	href="/bigdataShop/resources/common/css/cmt/jqcloud.css" />
<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.4/jquery.min.js"></script>
<script type="text/javascript"
	src="/bigdataShop/resources/common/js/cloud/jqcloud-1.0.4.js"></script>
<title>Insert title here</title>
<script type="text/javascript">
	$(document).ready(function() {
		var word_list = [];
		//resultList
		<c:forEach var="result" items="${tableList2}">
			var value = new Object();
			value.text = "${result.content}"
			value.weight = "${result.count}"
			word_list.push(value);
		</c:forEach>
		//db에서 조회한 결과 wordcloud가 제작될 수 있도록 작업
		$("#comments").jQCloud(word_list);
	})
</script>
</head>
<body>
	<h1>상품댓글분석</h1>
	<hr />
	<div class="col-md-4">
		<table class="table">
			<thead>
				<tr>
					<th>키워드</th>
					<th>반복횟수</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="result" items="${tableList}">
					<tr>
						<td>${result.content}</td>
						<td>${result.count}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<div class="col-md-6">
		<div id="comments"
			style="width: 550px; height: 350px; border: 1px solid #ccc;"></div>
	</div>
</body>
</html>













