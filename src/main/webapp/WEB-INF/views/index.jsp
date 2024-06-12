<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ page import="java.io.PrintWriter" %>

<%@include file="header.jsp" %>
<div class="container-fluid">

    <div class="row">
        <%-- 단어 추천 --%>
        <div class="card shadow mb-4 mr-4 ml-4">
            <div class="card-header py-3">
                <h6 class="m-0 font-weight-bold text-primary">오늘의 단어</h6>
            </div>
            <div class="card-body">

            </div>
        </div>
        <%-- 책 추천 --%>
        <div class="card shadow mb-4 mr-4 ml-4">
            <div class="card-header py-3">
                <h6 class="m-0 font-weight-bold text-primary">오늘의 책</h6>
            </div>
            <div class="card-body">
                <a href="/readBook?bookId=${bookInfo.bookId}" style="margin:1%">
                    <div class="card bookImage" style="width: 18rem; ">
                        <img src="/assets/img/${bookInfo.bookName}.png" class="card-img-top" alt="...">
                        <div class="card-body">
                            <p class="card-text">${bookInfo.bookName}</p>
                        </div>
                    </div>
                </a>
            </div>
        </div>

    </div>
</div>

<%@include file="footer.jsp" %>