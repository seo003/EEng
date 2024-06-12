<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ page import="java.io.PrintWriter" %>

<%@include file="header.jsp" %>
<div class="container-fluid">

    <!-- title -->
    <h1 class="h3 mb-2 text-gray-800">Let's Read Book!</h1>
    <p class="mb-4">원하는 책을 클릭하면 책을 읽을 수 있어요!</p>
    <div>
        <div class="row">
            <c:forEach var="bookInfo" items="${bookInfoList}">
                <a href="/readBook?bookId=${bookInfo.getBookId()}" style="margin:1%">
                        <div class="card bookImage" style="width: 18rem; ">
                            <img src="/assets/img/${bookInfo.getBookName()}.png" class="card-img-top" alt="..."
                                 asdawdas>
                            <div class="card-body">
                                <p class="card-text">${bookInfo.getBookName()}</p>
                            </div>
                        </div>
                </a>
            </c:forEach>
        </div>
    </div>

</div>
<%@include file="footer.jsp" %>