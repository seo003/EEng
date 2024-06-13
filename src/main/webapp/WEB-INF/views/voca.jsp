<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ page import="java.io.PrintWriter" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<%@include file="header.jsp" %>

<!-- voca JSON 데이터를 data-id 속성에 전달 -->
<div id="voca" data-id="${fn:escapeXml(voca)}"></div>

<div class="container-fluid">

    <h1 class="h3 mb-2 text-gray-800">LV ${lv}</h1>

    <p class="mb-4">우클릭하면 단어의 발음을 들을 수 있어요!</p>
    <div class="dropdown no-arrow">
        <a href="/vocaList?lv=${lv}" class="btn btn-primary btn-icon-split">
            <span class="text">단어 목록보기</span>
        </a>
    </div>
    <div class="dropdown no-arrow">
        <label style="float: right; font-size: medium; font-weight: bold; color: black;">
            <input type="checkbox" id="onlyWordCheckbox" onclick="onlyWord()">단어만 보기(단어를 클릭하면 뜻이 나와요!)
        </label>
    </div>
    <br><br>
    <form action="addVoca.do" method="post">
    <div class="card border-primary mb-8">
        <div class="card-header d-flex justify-content-between">
            <a href="#" class="btn btn-outline-primary" id="prevButton">이전</a>
            <a href="#" class="btn btn-outline-primary" id="nextButton">다음</a>
        </div>
        <div class="card-body text-center" style="margin: 3%">
            <h5 class="card-title" id="vocaWord" onclick="showMean()" style="font-size: xxx-large; font-weight: bold; color: black;"></h5>
            <p class="card-text" id="vocaMeaning" style="font-size: x-large; font-weight: bold; color: black;"></p>
        </div>
        <div class="card-footer text-center">
            <a href="#" class="btn btn-primary" id="addWord">내 단어장에 추가</a>
        </div>
    </div>
    </form>
    <br>
</div>
<%@include file="footer.jsp" %>