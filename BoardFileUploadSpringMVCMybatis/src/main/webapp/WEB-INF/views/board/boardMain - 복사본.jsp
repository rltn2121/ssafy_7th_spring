<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import = "com.mycom.myboard.dto.*, java.util.*" %>

<%
	String contextPath = request.getContextPath();
	UserDto userDto = (UserDto) session.getAttribute("userDto");
%>

<%--
	eclipse BoardWebFileUpload 비교
	- SpringMVC
		WebContent => resources/static
	- REST API
		URL Mapping
	- Mybatis
	- Aspect
		LogAspect
	- Login Check
		Filter => Interceptor
	
 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
	<title>Board</title>
	<!-- Bootstrap 5 버전 -->
	<!-- https://getbootstrap.com/docs/5.0/getting-started/introduction/ -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
	<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
	
	<!-- No jQuery -->

	<script src="//cdn.jsdelivr.net/npm/alertifyjs@1.12.0/build/alertify.min.js"></script>
	<link rel="stylesheet" href="//cdn.jsdelivr.net/npm/alertifyjs@1.12.0/build/css/alertify.min.css"/>
	<link rel="stylesheet" href="//cdn.jsdelivr.net/npm/alertifyjs@1.12.0/build/css/themes/default.min.css"/>
	
	<!-- New for FileUpload, CKEditor -->
	<link rel="stylesheet" href="<%= contextPath %>/resources/static/css/common.css">
	<script src="https://cdn.ckeditor.com/ckeditor5/19.0.0/classic/ckeditor.js"></script>
	<!-- / New for FileUpload, CKEditor -->
</head>
<body>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <div class="container-fluid">
	  <a class="navbar-brand" href="#"><img src="<%= contextPath%>/resources/static/<%=userDto.getUserProfileImageUrl() %>" alt="Logo" style="width:24px; height: 24px; border-radius: 50%;"></a>
	  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
	    <span class="navbar-toggler-icon"></span>
	  </button>
	  <div class="collapse navbar-collapse" id="collapsibleNavbar">
	    <ul class="navbar-nav">
	      <li class="nav-item">
	        <a class="nav-link" href="<%= contextPath%>/board">게시판</a>
	      </li>
	      <li class="nav-item">
	        <a class="nav-link" href="#">Link</a>
	      </li>  
	    </ul>
	  </div>  
  </div>
</nav>

<br>
<div class="container">

  	<h4 class="text-center mb-3">게시판 - Main</h4>       
  
	<div class="input-group mb-3">
	  <input id="inputSearchWord" type="text" class="form-control" placeholder="Search">
	  <button id="btnSearchWord" class="btn btn-success" type="button">Search</button>
	</div>
	
	<table class="table table-hover">
		<thead>
       		<tr>
				<th>#</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일시</th>
				<th>조회수</th>
			</tr>
     	</thead>
     	<tbody id="boardTbody">
     	</tbody>
   	</table>
   
	<div id="paginationWrapper"></div>

	<button class="btn btn-sm btn-primary" id="btnInsert">글쓰기</button>
</div>

<!-- modal begin ------------------------------------------------------------------------->
				<!-- Modal insert-->
				<div class="modal" id="boardInsertModal">
					<div class="modal-dialog modal-lg">
						<div class="modal-content">
							<!-- Modal Header -->
					      	<div class="modal-header">
					        	<h4 class="modal-title">글쓰기</h4>
					        	<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
					      	</div>
							<div class="modal-body">
							
								<div class="mb-3">
								  <label for="titleInsert" class="form-label">제목</label>
								  <input type="text" class="form-control" id="titleInsert">
								</div>
								<div class="mb-3">
								  <label for="contentInsert" class="form-label">내용</label>
								  
								  <!-- New for FileUpload, CKEditor -->
										<div id=divEditorInsert></div>
								  <!-- / New for FileUpload, CKEditor -->
								</div>
								<div class="mb-3">
									<div class="form-check">
									  <input class="form-check-input" type="checkbox" value="" id="chkFileUploadInsert">
									  <label class="form-check-label" for="chkFileUploadInsert">파일 추가</label>
									</div>
								</div>
								<div class="mb-3" style="display:none;" id="imgFileUploadInsertWrapper">
									<input type="file" id="inputFileUploadInsert" multiple>
									<div id="imgFileUploadInsertThumbnail" class="thumbnail-wrapper"></div>
								</div>
								<button id="btnBoardInsert" class="btn btn-sm btn-primary btn-outline float-end" data-bs-dismiss="modal" type="button">등록</button>
							</div>
						</div>
					</div>
				</div>
				<!-- End Modal -->
				
				<!-- Modal detail-->
				<div class="modal fade" id="boardDetailModal">
					<div class="modal-dialog modal-lg">
						<div class="modal-content">
							<!-- Modal Header -->
					      	<div class="modal-header">
					        	<h4 class="modal-title">글 상세</h4>
					        	<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
					      	</div>
					      	
							<div class="modal-body">
							
				                <div class="example table-responsive">
				                    <table class="table">
				                      <tbody>
				                        <tr><td>글번호</td><td id="boardIdDetail">#</td></tr>
				                        <tr><td>제목</td><td id="titleDetail">#</td></tr>
				                        <tr><td>내용</td><td id="contentDetail">#</td></tr>
				                        <tr><td>작성자</td><td id="userNameDetail">#</td></tr>
				                        <tr><td>작성일시</td><td id="regDtDetail">#</td></tr>
				                        <tr><td>조회수</td><td id="readCountDetail">#</td></tr>
				                        <!-- New for FileUpload -->
				                        <tr><td colspan="2">첨부파일</td></tr>
				                        <tr><td colspan="2" id="fileListDetail">#</td></tr>
				                        <!-- / New for FileUpload -->
				                      </tbody>
				                    </table>
				             	</div>
								<button id="btnBoardUpdateForm" class="btn btn-sm btn-primary btn-outline" data-bs-dismiss="modal" type="button">글 수정하기</button>
								<button id="btnBoardDeleteConfirm" class="btn btn-sm btn-warning btn-outline" data-bs-dismiss="modal" type="button">글 삭제하기</button>

							</div>
						</div>
					</div>
				</div>
				<!-- End Modal -->
				
				<!-- Modal update-->
				<div class="modal fade" id="boardUpdateModal">
					<div class="modal-dialog modal-lg">
						<div class="modal-content">
							<!-- Modal Header -->
					      	<div class="modal-header">
					        	<h4 class="modal-title">글수정</h4>
					        	<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
					      	</div>
							<div class="modal-body">

								<div class="mb-3">
								  <label for="titleUpdate" class="form-label">제목</label>
								  <input type="text" class="form-control" id="titleUpdate">
								</div>
								<div class="mb-3">
									<!-- New for FileUpload, CKEditor -->
									<div id=divEditorUpdate></div>
									<!-- New for FileUpload -->
								</div>
								<div class="mb-3">
									첨부파일 : <span id="fileListUpdate"></span>
								</div>
								<div class="mb-3">
									<div class="form-check">
									  <input class="form-check-input" type="checkbox" value="" id="chkFileUploadUpdate">
									  <label class="form-check-label" for="chkFileUploadUpdate">파일 변경</label>
									</div>
								</div>
								<div class="mb-3" style="display:none;" id="imgFileUploadUpdateWrapper">
									<input type="file" id="inputFileUploadUpdate" multiple>
									<div id="imgFileUploadUpdateThumbnail" class="thumbnail-wrapper"></div>
								</div>
								<button id="btnBoardUpdate" class="btn btn-sm btn-primary btn-outline float-end" data-bs-dismiss="modal" type="button">수정</button>

							</div>
						</div>
					</div>
				</div>
				<!-- End Modal -->
<!-- modal end --------------------------------------------------------------------------->

<script src="<%=contextPath%>/resources/static/js/util.js"></script>		
<script>

var LIST_ROW_COUNT = 10;	//limit
var OFFSET = 0;
var SEARCH_WORD = "";

/* New for FileUpload, CKEditor */
var CKEditorInsert;
var CKEditorUpdate;
/* / New for FileUpload, CKEditor */

var PAGE_LINK_COUNT = 10;	// pagination link 갯수
var TOTAL_LIST_ITEM_COUNT = 0;
var CURRENT_PAGE_INDEX = 1;


const SUCCESS = 1;

window.onload = function(){
	/* New for FileUpload, CKEditor */
	ClassicEditor
		.create( document.querySelector( '#divEditorInsert' ) ) // .create( $('#divEditorInsert')[0] )
		.then( editor => {
			CKEditorInsert = editor;
	    } )
		.catch( err => {
	    	console.error( err.stack );
		} );

	ClassicEditor
		.create( document.querySelector( '#divEditorUpdate' ) ) // .create( $('#divEditorUpdate')[0] )
		.then( editor => {
			CKEditorUpdate = editor;
	    } )
		.catch( err => {
	    	console.error( err.stack );
		} );
	
	/* / New for FileUpload, CKEditor */
	
	boardList();
	
	// 검색어 검색 
	document.querySelector("#btnSearchWord").onclick = function(){
		SEARCH_WORD = document.querySelector("#inputSearchWord").value;
		// 처음 페이지로 초기화
		OFFSET = 0;
		CURRENT_PAGE_INDEX = 1;
		
		boardList();
	}
	
	// 글 등록
	document.querySelector("#btnInsert").onclick = function(){
		document.querySelector("#titleInsert").value = "";
		CKEditorInsert.setData("")
		
		// New for FileUpload
		document.querySelector("#chkFileUploadInsert").checked = false;
		document.querySelector("#inputFileUploadInsert").value = "";
		document.querySelector("#imgFileUploadInsertThumbnail").innerHTML = "";
		document.querySelector("#imgFileUploadInsertWrapper").style.display = "none";
		// bootstrap 5 show modal
		let modal = new bootstrap.Modal(document.querySelector("#boardInsertModal"), {  keyboard: false } )
		modal.show();
	}
	
	// insert
	document.querySelector("#btnBoardInsert").onclick = function(){
		
		if( validateInsert() ){
			boardInsert();
		}
	};
	
	// New for FileUpload
	// insert file upload change
	document.querySelector("#chkFileUploadInsert").onchange = function(){
		if( this.checked ){
			document.querySelector("#imgFileUploadInsertWrapper").style.display = "block";
		}else{
			document.querySelector("#inputFileUploadInsert").value = "";
			document.querySelector("#imgFileUploadInsertThumbnail").innerHTML = "";
			document.querySelector("#imgFileUploadInsertWrapper").style.display = "none";
		}
	};
	
	// New for FileUpload
	// insert file upload change image load
	document.querySelector("#inputFileUploadInsert").onchange = function(e){

		if( this.files && this.files.length > 0 ){

			for( var i=0; i<this.files.length; i++ ){
				
				var reader = new FileReader();
				reader.readAsDataURL(this.files[i]);
				reader.onload = function(e){
					let thumbnailHTML = `<img src="\${e.target.result}">`;
					document.querySelector("#imgFileUploadInsertThumbnail").insertAdjacentHTML('beforeend', thumbnailHTML);
				}
			}
		}	
	}
	
	// update
	document.querySelector("#btnBoardUpdateForm").onclick = function(){
		
		var boardId = document.querySelector("#boardDetailModal").getAttribute("data-boardId");
		document.querySelector("#boardUpdateModal").setAttribute("data-boardId", boardId);
		
		document.querySelector("#titleUpdate").value = document.querySelector("#titleDetail").innerHTML;
		
		// changes CKEditor
		// $("#contentUpdate").val( $("#contentDetail").html() );
		CKEditorUpdate.setData( document.querySelector("#contentDetail").innerHTML );
		
		let fileListHTML = ``;
		document.querySelectorAll("#fileListDetail .fileName").forEach( el => {
			fileListHTML += `<div class="fileName">\${el.innerHTML}</div>`;
		})
		
		document.querySelector("#fileListUpdate").innerHTML = fileListHTML;

		document.querySelector("#chkFileUploadUpdate").checked = false;
		document.querySelector("#inputFileUploadUpdate").value = "";
		document.querySelector("#imgFileUploadInsertThumbnail").innerHTML = "";
		document.querySelector("#imgFileUploadUpdateWrapper").style.display = "none";

		// bootstrap 5 show modal
		let detailModal = new bootstrap.Modal(document.querySelector("#boardDetailModal"), {  keyboard: false } )
		detailModal.hide();
		let updateModal = new bootstrap.Modal(document.querySelector("#boardUpdateModal"), {  keyboard: false } )
		updateModal.show();
	};

	// update
	document.querySelector("#btnBoardUpdate").onclick = function(){
		
		if( validateUpdate() ){
			boardUpdate();
		}
	};
	
	// New for FileUpload
	// update file upload change image load
	document.querySelector("#chkFileUploadUpdate").onchange = function(){
		if( this.checked ){
			document.querySelector("#imgFileUploadUpdateWrapper").style.display = "block";
		}else{
			document.querySelector("#inputFileUploadUpdate").value = "";
			document.querySelector("#imgFileUploadUpdateThumbnail").innerHTML = "";
			document.querySelector("#imgFileUploadUpdateWrapper").style.display = "none";
		}
	};

	// New for FileUpload
	// update file upload change image load
	document.querySelector("#inputFileUploadUpdate").onchange = function(e){

		if( this.files && this.files.length > 0 ){
			
			for( var i=0; i<this.files.length; i++ ){

				var reader = new FileReader();
				reader.readAsDataURL(this.files[i]);
				reader.onload = function(e){
					let thumbnailHTML = `<img src="\${e.target.result}">`;
					document.querySelector("#imgFileUploadUpdateThumbnail").insertAdjacentHTML('beforeend', thumbnailHTML);
				}
			}
		}	
	}

	
/* 	$("#inputFileUploadUpdate").change(function(e){

		if( this.files && this.files.length > 0 ){
			
			for( var i=0; i<this.files.length; i++ ){

				var reader = new FileReader();
				reader.readAsDataURL(this.files[i]);
				reader.onload = function(e){
					$("#imgFileUploadUpdateThumbnail").append('<img src="' + e.target.result +'">'); // e.target : reader
				}
			}
		}
	}); */
	
	// delete
	document.querySelector("#btnBoardDeleteConfirm").onclick = function(){
		 alertify.confirm('삭제 확인', '이 글을 삭제하시겠습니까?',
 			function() {
				boardDelete();
 			},
			function(){
 				console.log('cancel');
			}
		);
	};
}


// list
function boardList(){
    
	let fetchOptions = {
      	headers: {
    	  'async': 'true'
      	},
    }
	
	var url = '<%=contextPath%>/boards';
  	var urlParams = `?limit=\${LIST_ROW_COUNT}&offset=\${OFFSET}&searchWord=\${SEARCH_WORD}`;

    
    fetch(url + urlParams, fetchOptions)
    	.then( response => response.json())
    	.then( json => {
    		if( json.result == "login" ){
    			window.location.href="<%=contextPath%>/login";
    		}else if( json.result == SUCCESS ){
    			makeListHtml(json.list);
    		   	TOTAL_LIST_ITEM_COUNT = json.count;
    		   	addPagination();
    		}else{
    			alertify.error('글 조회 과정에 문제가 생겼습니다.');
    		}
    	})
    	.catch( error => {
    		console.error( error );
    		alertify.error('글 조회 과정에 문제가 생겼습니다.');
    	});
}

function makeListHtml(list){
	console.log(list);
	
	let listHTML = ``;
	
	list.forEach( el => {
		let boardId = el.boardId;
		let userName = el.userName;
		let title = el.title;
		let content = el.content;
		let regDt = el.regDt;	// javascript of parsed from LocalDateTime
		// for Jackson Format Of LocalDateTime
		// var regDtStr = regDt;		
		// for Gson Format Of LocalDateTime
		let regDtStr = makeDateStr(regDt.date.year, regDt.date.month, regDt.date.day, '.'); 
		let readCount = el.readCount;
		
		listHTML += `<tr style="cursor:pointer" data-boardId=\${boardId}><td>\${boardId}</td><td>\${title}</td><td>\${userName}</td><td>\${regDtStr}</td><td>\${readCount}</td></tr>`;
	});
	

	document.querySelector("#boardTbody").innerHTML = listHTML

	makeListHtmlEventHandler();

	//boardListTotalCnt(); <== removed
}

function makeListHtmlEventHandler(){
	document.querySelectorAll("#boardTbody tr").forEach( el => {
		el.onclick = function(){
			var boardId = this.getAttribute("data-boardId");
			boardDetail(boardId);
		}
	});
}



// list total
// function boardListTotalCnt(){} <== removed


function addPagination(){

	makePaginationHtml(LIST_ROW_COUNT, PAGE_LINK_COUNT, CURRENT_PAGE_INDEX, TOTAL_LIST_ITEM_COUNT, "paginationWrapper" );
}

function movePage(pageIndex){
	OFFSET = (pageIndex - 1) * LIST_ROW_COUNT;
	CURRENT_PAGE_INDEX = pageIndex;
	boardList();
}



function validateInsert(){
	var isTitleInsertValid = false;
	var isContentInsertValid = false;

	var titleInsert = document.querySelector("#titleInsert").value;
	var titleInsertLength = titleInsert.length;
	
	if( titleInsertLength > 0 ){
		isTitleInsertValid = true;
	}
	
	// changes CKEditor
	// var contentInsertValue = $("#contentInsert").val();
	var contentInsertValue = CKEditorInsert.getData();
	
	var contentInsertLength = contentInsertValue.length;
	
	if( contentInsertLength > 0 ){
		isContentInsertValid = true;
	}

	if(	isTitleInsertValid && isContentInsertValid ){
		return true;
	}else{
		return false;
	}
}

// insert
// headers 에 content-type 을 multipart/form-data 로 주면 boundary 를 찾지 못하는 오류 발생 (mdn 문서와 다른다.)
function boardInsert(){

	var formData = new FormData();
	//formData.append("userSeq", '<%=userDto.getUserSeq()%>');
	formData.append("title", document.querySelector("#titleInsert").value);
	formData.append("content", CKEditorInsert.getData());	
	// file upload
	var cnt = document.querySelector("#inputFileUploadInsert").files.length;
	for (var i = 0; i < cnt; i++) {
		formData.append("file", document.querySelector("#inputFileUploadInsert").files[i]);
	}
	
	let fetchOptions = {
      	method: 'POST',
      	headers: {
    	  'async': 'true'
      	},
      	body: formData
    }

    fetch('<%= contextPath%>/boards', fetchOptions)
    	.then( response => response.json())
    	.then( json => {
    		if( json.result == "login" ){
    			window.location.href="<%=contextPath%>/login";
    		}else if( json.result == SUCCESS ){
    			alertify.success('글이 등록되었습니다.');
        		boardList();
    		}else{
    			alertify.error('글 등록 과정에 문제가 생겼습니다.');
    		}
    	})
       .catch( error => {
    		console.error( error );
    		alertify.error('글 등록 과정에 문제가 생겼습니다.');
    	});
}

// detail
// No userSeq In Client Code <-- userSeq In Server Using HttpSession
function boardDetail(boardId){

	let fetchOptions = {
      	headers: {
    	  'async': 'true'
      	},
    }
	
	var url = '<%=contextPath%>/boards/' + boardId;
    
    fetch(url, fetchOptions)
    	.then( response => response.json())
    	.then( json => {
    		if( json.result == "login" ){
    			window.location.href="<%=contextPath%>/login";
    		}else if( json.result == SUCCESS ){
    			makeDetailHtml(json.dto);
    		}else{
    			alertify.error('글 상세 조회 과정에 문제가 생겼습니다.');
    		}
    	})
    	.catch( error => {
    		console.error( error );
    		alertify.error('글 상세 조회 과정에 문제가 생겼습니다.');
    	});
}

function makeDetailHtml(detail){

	var boardId = detail.boardId;
	var userSeq = detail.userSeq;
	var userName = detail.userName;
	var title = detail.title;
	var content = detail.content;
	var regDt = detail.regDt;
console.log(regDt)
	var regDtStr = makeDateStr(regDt.date.year, regDt.date.month, regDt.date.day, '.') + ' ' + makeTimeStr(regDt.time.hour, regDt.time.minute, regDt.time.second, ':'); // for Gson Format Of LocalDateTime
	//regDtStr = regDt; // refactorig later
	
	
	var readCount = detail.readCount;
	var sameUser = detail.sameUser;
	
	var fileList = detail.fileList;
	
	document.querySelector("#boardDetailModal").setAttribute("data-boardId", boardId);
	document.querySelector("#boardIdDetail").innerHTML = "#" + boardId;
	document.querySelector("#titleDetail").innerHTML = title;
	document.querySelector("#contentDetail").innerHTML = content;
	document.querySelector("#userNameDetail").innerHTML = userName;
	document.querySelector("#regDtDetail").innerHTML = regDtStr;
	document.querySelector("#readCountDetail").innerHTML = readCount;
	
	//FileList
	document.querySelector("#fileListDetail").innerHTML = "";
	
	var fileListDetailHtml = '';
	if( fileList.length > 0 ){
		for(var i=0; i<fileList.length; i++){
			var fileId = fileList[i].fileId;
			var fileName = fileList[i].fileName;
			var fileUrl = fileList[i].fileUrl;

			fileListDetailHtml += 
				`
				<div>
					<span class="fileName">\${fileName}</span>
					&nbsp;&nbsp;
					<a type="button" class="btn btn-outline btn-default btn-xs" data-fileId="\${fileId}" href="<%=contextPath%>/resources/static/\${fileUrl}" download="\${fileName}">내려받기</a>	
				</div>
				`;
		}
		
		document.querySelector("#fileListDetail").innerHTML = fileListDetailHtml;
	}

	if( sameUser ){
		document.querySelector("#btnBoardUpdateForm").style.display = "inline-block";
		document.querySelector("#btnBoardDeleteConfirm").style.display = "inline-block";
	}else{
		document.querySelector("#btnBoardUpdateForm").style.display = "none";
		document.querySelector("#btnBoardDeleteConfirm").style.display = "none";
	}

	// bootstrap 5 show modal
	let modal = new bootstrap.Modal(document.querySelector("#boardDetailModal"), {  keyboard: false } )
	modal.show();
}

// update
function validateUpdate(){
	var isTitleUpdateValid = false;
	var isContentUpdateValid = false;

	var titleUpdate = document.querySelector("#titleUpdate").value;
	var titleUpdateLength = titleUpdate.length;
	
	if( titleUpdateLength > 0 ){
		isTitleUpdateValid = true;
	}
	
	// changes CKEditor
	// var contentUpdateValue = $("#contentUpdate").val();
	var contentUpdateValue = CKEditorUpdate.getData();
	
	var contentUpdateLength = contentUpdateValue.length;
	
	if( contentUpdateLength > 0 ){
		isContentUpdateValid = true;
	}

	if(	isTitleUpdateValid && isContentUpdateValid ){
		return true;
	}else{
		return false;
	}
}

// headers 에 content-type 을 multipart/form-data 로 주면 boundary 를 찾지 못하는 오류 발생 (mdn 문서와 다른다.)
function boardUpdate(){
	
	var boardId = document.querySelector("#boardUpdateModal").getAttribute("data-boardId");
	var formData = new FormData();
	// formData.append("_method", "PUT");
	formData.append("boardId", boardId);
	//formData.append("userSeq", '<%=userDto.getUserSeq()%>');
	formData.append("title", document.querySelector("#titleUpdate").value);
	formData.append("content", CKEditorUpdate.getData());
	
	// file upload
	var cnt = document.querySelector("#inputFileUploadUpdate").files.length;
	for (var i = 0; i < cnt; i++) {
		formData.append("file", document.querySelector("#inputFileUploadUpdate").files[i]);
	}

	var url = '<%=contextPath%>/boards/' + boardId;
	
	let fetchOptions = {
      	method: 'POST',
      	headers: {
    	  'async': 'true'
      	},
      	body: formData
    }
	
    fetch(url, fetchOptions)
		.then( response => response.json())
		.then( json => {
			if( json.result == "login" ){
				window.location.href="<%=contextPath%>/login";
			}else if( json.result == SUCCESS ){
				alertify.success('글이 수정되었습니다.');
	    		boardList();
			}else{
				alertify.error('글 수정 과정에 문제가 생겼습니다.');
			}
		})
	   .catch( error => {
			console.error( error );
			alertify.error('글 수정 과정에 문제가 생겼습니다.');
		});
}

// delete
function boardDelete(){
	
	var boardId = document.querySelector("#boardDetailModal").getAttribute("data-boardId");
	var url = '<%=contextPath%>/boards/' + boardId;

	let fetchOptions = {
      	method: 'DELETE',
      	headers: {
    	  'async': 'true'
      	},
    }
	
	fetch(url, fetchOptions)
		.then( response => response.json())
		.then( json => {
			if( json.result == "login" ){
				window.location.href="<%=contextPath%>/login";
			}else if( json.result == SUCCESS ){
				alertify.success('글이 삭제되었습니다.');
	    		boardList();
			}else{
				alertify.error('글 삭제 과정에 문제가 생겼습니다.');
			}
		})
	   .catch( error => {
			console.error( error );
			alertify.error('글 삭제 과정에 문제가 생겼습니다.');
		});

}
</script>

</body>
</html>