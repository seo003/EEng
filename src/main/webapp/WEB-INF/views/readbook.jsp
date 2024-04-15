<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ page import="java.io.PrintWriter" %>

<%@include file="header.jsp" %>
<div class="container-fluid">

    <!-- title -->
    <h1 class="h3 mb-2 text-gray-800">Let's Read Book!</h1>
    <p class="mb-4">좌클릭 : 문장 뜻 보기<br>우클릭 : 단어 뜻 보기</p>
    <!-- Basic Card Example -->
    <div class="card shadow mb-4">
        <div class="card-header py-3">
            <h6 class="m-0 font-weight-bold text-primary">${bookInfo.getBookName()}</h6>
        </div>
        <div class="card-body">
            <c:forEach var="sentence" items="${bookContent}">
                <p>${sentence.getSent()}</p><%--8문장씩 페이징처리--%>
            </c:forEach>
        </div>
    </div>

</div>
<%@include file="footer.jsp" %>