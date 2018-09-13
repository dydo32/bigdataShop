<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<script type="text/javascript"
	src="/bigdataShop/resources/common/js/Chart.js"></script>
<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.4/jquery.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	/* var context = document.getElementbyId('myChart').getContext('2d'); */
	var iplist = [];
	var countlist = [];
	<c:forEach var="result" items="${resultlist}">
	ip = "${result.content}";
	iplist.push(ip);
	count = "${result.count}";
	countlist.push(count);
	</c:forEach>
	var myChart = new Chart("myChart",{
		type : 'pie',
		data : {
			labels : iplist,
			datasets : [{
			 	backgroundColor : ["#2ecc71","#3498db"],
				hoverBackgroundColor : ["#A6A6A6", "#D1B2FF"], 
				data :countlist
			}]
		},
		options : {responsive:false}
	});
	

});


	/* $(document).ready(function() {
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
	}) */
</script>
</head>
<body>
	<h1>로그분석</h1>
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
				<c:forEach var="result" items="${resultlist}">
					<tr>
						<td>${result.content}</td>
						<td>${result.count}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<div class="col-md-6">
		<canvas id="myChart" width="400" height="400">
	</canvas>
	</div>
	
	<div>
	<canvas id="ctg" width="400" height="400">
	</canvas>
	</div>

</body>
</html>













