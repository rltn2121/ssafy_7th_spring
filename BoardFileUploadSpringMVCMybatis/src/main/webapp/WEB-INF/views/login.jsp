<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String contextPath = request.getContextPath();
%>
<%-- 
Bootstrap 5
No jQuery
fetch
post with urlencoded

server response ResponseEntity : 성공 실패 여부를 httpRequest.status 로 체크

게시판 이동은 HomeController 로
--%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
	<!-- Bootstrap 5 버전 -->
	<!-- https://getbootstrap.com/docs/5.0/getting-started/introduction/ -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
	<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>

	<script src="//cdn.jsdelivr.net/npm/alertifyjs@1.12.0/build/alertify.min.js"></script>
	<link rel="stylesheet" href="//cdn.jsdelivr.net/npm/alertifyjs@1.12.0/build/css/alertify.min.css"/>
	<link rel="stylesheet" href="//cdn.jsdelivr.net/npm/alertifyjs@1.12.0/build/css/themes/default.min.css"/>
	<title>Login</title>
</head>
<body>
<br>
<br>
	<div class="container">
		<div class="mb-3 d-flex justify-content-center">
	  		<h1 class="display-4">삐따기 세상</h1>
		</div>
		<div class="mb-3">
			<h2>Login</h2>
		</div>
		<div class="mb-3">
		  <label for="userEmail" class="form-label">Email</label>
		  <input type="email" class="form-control" id="userEmail" name="userEmail" value="dskim@my.com">
		</div>
		<div class="mb-3">
		  <label for="userPassword" class="form-label">제목</label>
		  <input type="password" class="form-control" id="userPassword" name="userPassword" value="1234">
		</div>
		<div>
			<button id="btnLogin" class="btn btn-primary">로그인</button>
			<a href="<%=contextPath%>/register" class="btn btn-success">회원가입</a><!-- eclipse 와 다른 부분 -->
		</div>	
	    
	</div>

<script>
window.onload = function(){
	document.querySelector("#btnLogin").onclick = function(){

		if( validate() ){
			login();
		}
	}
}

function validate(){
	var isUserEmailValid = false;
	var isUserPasswordValid = false;

	var userEmailValue = document.querySelector("#userEmail").value;
	var userEmailLength = userEmailValue.length;
	
	if( userEmailLength > 0 ){
		isUserEmailValid = true;
	}
	
	var userPasswordValue = document.querySelector("#userPassword").value;
	var userPasswordLength = userPasswordValue.length;
	
	if( userPasswordLength > 0 ){
		isUserPasswordValid = true;
	}

	if(	isUserEmailValid && isUserPasswordValid ){
		return true;
	}else{
		return false;
	}
}



// pure javascript ajax
// no alertify
async function login(){

	var userEmail = document.querySelector("#userEmail").value;
	var userPassword = document.querySelector("#userPassword").value;	
	
	let urlParams = new URLSearchParams({
		userEmail: userEmail,
		userPassword: userPassword,
    });
	
	let fetchOptions = {
        method: "POST",
        body: urlParams,
    }
	
    let response = await fetch("<%=contextPath%>/login", fetchOptions);
    console.log(response);
    let data = await response.json();
    if( data.result == "success" ){
    	window.location.href="<%=contextPath%>/board"; // HomeController
    }else if( data.result == "fail" ){
		alert("아이디 또는 비밀번호가 올바르지 않습니다.");
	}
}
</script>
</body>
</html>