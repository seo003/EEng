<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ page import="java.io.PrintWriter" %>

<%@include file="header.jsp" %>
<div class="container-fluid">

    <!-- title -->
    <h1 class="h3 mb-2 text-gray-800">Let's Read Book!</h1>
    <p class="mb-4">좌클릭 : 문장 뜻 보기<br>우클릭 : 문장 발음 듣기</p>

    <!-- content -->
    <div class="card shadow mb-4">
        <div class="card-header py-3">
            <h6 class="m-0 font-weight-bold text-primary">${bookInfo.getBookName()}</h6>
        </div>
        <div class="card-body">
            <c:forEach var="sentence" items="${bookContent}">
<%--                <a href="#"><p id="text-to-translate" class="text-gray-800">${sentence.getSent()}</p></a>--%>
<%--                <div id="translated-texts"></div>--%>
                <a href="#"><p id="text-to-translate-${sentence.getSentNo()}" class="text-gray-800">${sentence.getSent()}</p></a>
                <div id="translated-texts-${sentence.getSentNo()}"></div>
            </c:forEach>
        </div>
    </div>

    <!-- paging -->
    <div class="pagination">
        <c:if test="${currentPage > 0}">
            <a href="readBook.do?bookId=${bookInfo.bookId}&page=${currentPage - 1}" class="btn btn-primary btn-icon-split">
                <span class="text"><</span>
            </a>
        </c:if>
        <c:forEach begin="0" end="${totalPages - 1}" var="i">
            <c:if test="${i == currentPage}">
                <a class="btn btn-info btn-icon-split">
                    <span class="text">${i+1}</span>
                </a>
            </c:if>
            <c:if test="${i != currentPage}">
                <a href="readBook.do?bookId=${bookInfo.bookId}&page=${i}" class="btn btn-primary btn-icon-split">
                    <span class="text">${i+1}</span>
                </a>
            </c:if>
        </c:forEach>
        <c:if test="${currentPage < totalPages - 1}">
            <a href="readBook.do?bookId=${bookInfo.bookId}&page=${currentPage + 1}" class="btn btn-primary btn-icon-split">
                <span class="text">></span>
            </a>
        </c:if>
    </div>
    <br>
</div>
<%@include file="footer.jsp" %>