<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<title>Bootstrap Example</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link type="text/css"
	href="/bigdataShop/resources/common/css/master.css" rel="stylesheet"
	media="screen,print" />
<link type="text/css" href="/bigdataShop/resources/common/css/print.css"
	rel="stylesheet" media="print" />
<link type="text/css" href="/bigdataShop/resources/common/css/mall.css"
	rel="stylesheet" media="screen,print" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<!-- css 추가 -->
<link rel='stylesheet' id='kboard-comments-skin-default-css' href='/bigdataShop/resources/common/css/cmt/comments.css?ver=4.4.4'
	type='text/css' media='all' />
<style>
A.applink:hover {
	border: 2px dotted #DCE6F4;
	padding: 2px;
	background-color: #ffff00;
	color: green;
	text-decoration: none
}

A.applink {
	border: 2px dotted #DCE6F4;
	padding: 2px;
	color: #2F5BFF;
	background: transparent;
	text-decoration: none
}

A.info {
	color: #2F5BFF;
	background: transparent;
	text-decoration: none
}

A.info:hover {
	color: green;
	background: transparent;
	text-decoration: underline
}

#sky {
	position: absolute;
	width: 100px;
	left: 50%;
	top: 150px;
	margin-left: 400px;
	background: #ffffff;
	border: solid #ccc;
	height: 200px;
	padding: 30px
}
</style>
<script type="text/javascript">
$(document).ready(function() {
	$("#insertcmt").on("click",function(){
		//alert("${product.prd_no}");
		//alert($("#pro_comment").val());
		 $.ajax({
			url:"/bigdataShop/product/cmtinsert.do",
			type:"get",
			data:{
				"prd_no": "${product.prd_no}",
				"mem_id": "jang",
				"pro_comment": $("#pro_comment").val()
			},
			success:function(prdcmt){
				//alert(prdcmt[0].mem_id);
				prdcmtlist = "";
				for(i=0; i<prdcmt.length; i++){
					prdcmtlist = prdcmtlist + "<ul> "
					+"<li class='kboard-comments-item'> " 
					+"<div class='comments-list-username'>"+prdcmt[i].mem_id+"</div> "
					+"<div class='comments-list-create'>"+prdcmt[i].writedate+"</div> "
					+"<div class='comments-list-content'>"+prdcmt[i].pro_comment+"</div> "
					+"<div class='comments-list-controller'> "
					+"<div class='right'> "
					+"<a type='button' class='deletebtn' href='#'>삭제</a>"
					+"<input type='hidden' id='cmt_no' value='"+prdcmt[i].prdcmt_no+"'/>"
					+"</div>"
					+"</div>"
					+"</li>"
					+"</ul>";
				} 
				//alert("test");
				$("#cmtcount").html(prdcmt.length);
				$("#pro_comment").html("");
				$("#cmtlist").empty(prdcmtlist);
				$("#cmtlist").append(prdcmtlist);
				deletecmt();
			}
		});   
	});
});
function deletecmt(){
	$(".deletebtn").on("click",function(){
		//alert("test");
		 $.ajax({
				url:"/bigdataShop/product/cmtdelete.do",
				type:"get",
				data:{
					"prd_no" : "${product.prd_no}",
					"prdcmt_no": $("#cmt_no").val()
				},
				success:function(prdcmt){
					//alert(prdcmt[0].mem_id);
					prdcmtlist = "";
					for(i=0; i<prdcmt.length; i++){
						prdcmtlist = prdcmtlist + "<ul> "
						+"<li class='kboard-comments-item'> " 
						+"<div class='comments-list-username'>"+prdcmt[i].mem_id+"</div> "
						+"<div class='comments-list-create'>"+prdcmt[i].writedate+"</div> "
						+"<div class='comments-list-content'>"+prdcmt[i].pro_comment+"</div> "
						+"<div class='comments-list-controller'> "
						+"<div class='right'> "
						+"<a type='button' class='deletebtn' href='#'>삭제</a>"
						+"<input type='hidden' id='cmt_no' value='"+prdcmt[i].prdcmt_no+"'/>"
						+"</div>"
						+"</div>"
						+"</li>"
						+"</ul>";
						
					} 
					//alert("test");
					$("#cmtcount").html(prdcmt.length);
					$("#cmtlist").empty(prdcmtlist);
					$("#cmtlist").append(prdcmtlist);
					deletecmt();
				}
			});   
	});
}

/* $(document).ready(function() {
	$("#insertcmt").on("click",function(){
		//alert("${product.prd_no}");
		//alert($("#pro_comment").val());
		 $.ajax({
			url:"/bigdataShop/product/cmtinsert.do",
			type:"get",
			data:{
				"prd_no": "${product.prd_no}",
				"mem_id": "jang",
				"pro_comment": $("#pro_comment").val()
			},
			success:function(prdcmt){
				//alert(prdcmt[0].mem_id);
				prdcmtlist = "";
				for(i=0; i<prdcmt.length; i++){
					prdcmtlist = prdcmtlist + "<ul> "
					+"<li class='kboard-comments-item'> " 
					+"<div class='comments-list-username'>"+prdcmt[i].mem_id+"</div> "
					+"<div class='comments-list-create'>"+prdcmt[i].writedate+"</div> "
					+"<div class='comments-list-content'>"+prdcmt[i].pro_comment+"</div> "
					+"<div class='comments-list-controller'> "
					+"<div class='right'> "
					+"<a type='button' class='deletebtn' href='#'>삭제</a>"
					+"<input type='hidden' id='cmt_no' value='"+prdcmt[i].prdcmt_no+"'/>"
					+"</div>"
					+"</div>"
					+"</li>"
					+"</ul>";
				} 
				//alert("test");
				$("#cmtcount").html(prdcmt.length);
				$("#pro_comment").html("");
				$("#cmtlist").empty(prdcmtlist);
				$("#cmtlist").append(prdcmtlist);
			}
		});   
	});
	$(".deletebtn").on("click",function(){
		alert("test");
		 $.ajax({
				url:"/bigdataShop/product/cmtdelete.do",
				type:"get",
				data:{
					"prd_no" : "${product.prd_no}",
					"prdcmt_no": $("#cmt_no").val()
				},
				success:function(prdcmt){
					//alert(prdcmt[0].mem_id);
					prdcmtlist = "";
					for(i=0; i<prdcmt.length; i++){
						prdcmtlist = prdcmtlist + "<ul> "
						+"<li class='kboard-comments-item'> " 
						+"<div class='comments-list-username'>"+prdcmt[i].mem_id+"</div> "
						+"<div class='comments-list-create'>"+prdcmt[i].writedate+"</div> "
						+"<div class='comments-list-content'>"+prdcmt[i].pro_comment+"</div> "
						+"<div class='comments-list-controller'> "
						+"<div class='right'> "
						+"<a type='button' class='deletebtn' href='#'>삭제</a>"
						+"<input type='hidden' id='cmt_no' value='"+prdcmt[i].prdcmt_no+"'/>"
						+"</div>"
						+"</div>"
						+"</li>"
						+"</ul>";
						
					} 
					//alert("test");
					$("#cmtcount").html(prdcmt.length);
					$("#cmtlist").empty(prdcmtlist);
					$("#cmtlist").append(prdcmtlist);
				}
			});   
	});
});
 */
</script>
</head>
<body>
	<div id="header"></div>
	<!-- /header -->
	<hr />

	<!-- content/-->

	<!-- lyt-main/ -->
	<div class="lyt-main">
		<!-- title -->
		<h2></h2>
		<div class="goodsDetailWrap">
			<div class="leftWrap">
				<!---------------------- 상품사진  ----------------------->
				<div class="photoWrap">
					<div class="photo">
						<!-- 메인사진 -->
						<a href="#"><img
							src="/bigdataShop/resources/images/product/${ product.img_gen_file_nm}"
							alt="썸이미지" /></a>
					</div>
					<div class="zoomBtn">
						<!-- 확대  -->
						<a href="#" onclick="imageZoom( '918' );"><img
							src="/bigdataShop/resources/images/btn_zoom.gif" alt="확대" /></a>
					</div>
				</div>
			</div>
			<!-- leftWrap END-->

			<div class="rightWrap">
				<form name="frm" method="post" action="">
					<!-------------------------- 오른쪽 상품 가격 기타 정보 ------------------------>
					<dl class="goodsDetail">
						<!-- 상품 정보 -->

						<!-- 가격정보처리 -->

						<!-- 가격정보처리 -->
						<dt>상품명</dt>
						<dd>${ product.prd_nm}</dd>

						<dt>판매가</dt>
						<dd>${ product.sell_prc_unit}원</dd>

					</dl>
					<dl class="goodsDetail">
						<dt>공급사</dt>
						<dd>자바나라</dd>
					</dl>

					<dl class="goodsDetail" id="defaultDl">
						<dt>상품코드</dt>
						<dd>${ product.prd_no}</dd>

						<dt>규격</dt>
						<dd>standard</dd>

						<dt>단위/최소구매단위</dt>
						<dd>1EA EA</dd>

						<dt>원산지/제조사</dt>
						<dd>한국 /</dd>
						<!-- 											<dt>배송정보</dt> -->
						<!-- 												<dd>무료 배송상품</dd> -->

						<dt>주문수량</dt>
						<dt>
							<a href="#">가격비교</a>
						</dt>
						<!------------------ 상품상세 일반형  ---------------------->

						<dd>
							<!-- 상품 수량 조절 영역-->
							<div class="gCnt">
								<input type="text" name="v_prbuyea" value="1"
									style="width: 35px; height: 19px;" title="수량입력칸"
									onchange="eaChange( this );" /> <input type="hidden"
									name="h_prcode" value="G4042_F0002_X0004_K0040" /> <input
									type="hidden" name="h_prname" value="FXK-UTM V300" /> <input
									type="hidden" name="h_prmoney" value="8800000" /> <input
									type="hidden" name="h_prstock" value="10000" /> <input
									type="hidden" name="h_prminbuyea" value="1" />
							</div>
							<div class="btns">
								<a href="#" onclick="eaUp( this, 1 ); return false;"><img
									src="/bigdataShop/resources/images/b_up.gif" alt="증가"
									class="al" /></a> <a href="#"
									onclick="eaUp( this, -1 ); return false;"><img
									src="/bigdataShop/resources/images/b_down.gif" alt="감소"
									class="al" /></a>
							</div>
						</dd>

						<div class="delBtn">
							<a href="#" onclick="optionAdd( this, 0 ); return false;"> <img
								src="/bigdataShop/resources/images/btn_icon_plus.gif" alt="추가" />
							</a>
						</div>


						<!------------------ 상품상세 일반형  끝 ---------------------->

						<!-- *선택옵션 -->

						<!-- *입력옵션 -->

					</dl>

					<!-- *옵션추가영역 -->
					<div id="optionAdd"></div>
					<!-- *옵션추가영역 -->

					<dl class="goodsDetail">

						<div class="optionGoods h50 fr">
							<span id="v_prtotmoney" class="sale fl">0 </span><span
								class="sale02 fnt20">원</span>
						</div>

						<!------------------ 상품상세 일반형 끝 ---------------------->
					</dl>

					<ul class="btnArea mgt20">
						<!-- 구매버튼 -->

						<li><a href="#" onclick="dialogOpen('N'); return false;"><img
								src="/bigdataShop/resources/images/btnm_nowBuy.gif" alt="바로구매" /></a></li>
						<li class="marL07"><a href="#"
							onclick="basketIn('N'); return false;"><img
								src="/bigdataShop/resources/images/btnm_cart.gif" alt="장바구니" /></a></li>
						<li class="fl_right marL07"><a href="#"
							onclick="history.back();"><img
								src="/bigdataShop/resources/images/btnm_list.gif" alt="목록" /></a></li>
						<li class="fl_right"><a href="#"
							onclick="productWishIn( 'G4042_F0002_X0004_K0040', 'N' );return false;"><img
								src="/bigdataShop/resources/images/btnm_wish.gif" alt="위시리스트" /></a></li>
						<li class="fl_right"><a
							href="/bigdataShop/resources/proread.do?prdno=&action=UPDATE">업데이트</a></li>

					</ul>
				</form>
			</div>
			<!-- rightWrap : 오른쪽 상품정보 END-->
		</div>
		<!-- goodsDetailWrap : 상품상세정보 전체 END-->

		<img
			src="/bigdataShop/resources/images/product/${product.img_org_file_nm }"
			alt="썸이미지" />
		<div id="sky">
			<img
				src="/bigdataShop/resources/images/product/${product.img_org_file_nm }"
				alt="썸이미지" width="50px" height="50px" />
		</div>
	</div>

	<!-- =================댓글등록화면과 조회화면================================= -->

	<br/>
	<br/>
	<div class="kboard-comments-area">
		<div id="kboard-comments-1851" class="kboard-comments-default">
			<div class="kboard-comments-wrap">
				<div class="comments-header">
					<div class="comments-count">
						전체 <span class="comments-total-count" id="cmtcount">${fn:length(prdcmtlist)}</span>
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
</body>
</html>


