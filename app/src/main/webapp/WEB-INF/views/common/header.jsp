<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
         
<link rel="stylesheet" href="/css/common/header.css">
<script defer src="/js/common/header.js"></script>

<header>
    <div>1</div>
    <div>2</div>
    <% 
    if(session.getAttribute("loginMemberVo")==null){%>
        <div class="user-area">
            <input type="text" name="id" placeholder="아이디">
            <input type="password" name="pw" placeholder="비밀번호">
            <div>
                <button onclick="login();">로그인</button>
                <button onclick="location.href=`/member/join`">회원가입</button>
            </div>
        </div>
    <%}else{%>
        <div class="user-info-area">
            <a href="/member/mypage">
                <img 
                src="http://192.168.20.151:5500/member/${loginMemberVo.profileChangeName}" 
                alt="${loginMemberVo.profileOriginName}"
                width="100px"
                height="100px"
                >
            </a>
            <div>
                <span>${loginMemberVo.nick}</span>
                <button onclick="location.href=`/member/logout`">로그아웃</button>
            </div>
        </div>
    <%}%>
</header>

<nav>
    <div><a href="/board/list/1">게시판</a></div>
    <div>02</div>
    <div>03</div>
    <div>04</div>
</nav>