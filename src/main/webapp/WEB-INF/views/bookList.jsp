<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ page import="java.io.PrintWriter" %>

<%@include file="header.jsp" %>
<div class="container-fluid">

    <!-- title -->
    <h1 class="h3 mb-2 text-gray-800">Let's Read Book!</h1>
    <p class="mb-4">원하는 책을 클릭하면 책을 읽을 수 있어요!</p>
        <!-- DataTales Example -->
    <div class="card shadow mb-4">
        <div class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
            <h6 class="m-0 font-weight-bold text-primary">
                Book
            </h6>
        </div>
        <div class="card-body">
            <div class="table-responsive">
                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                    <thead>
                    <tr>
                        <th>No</th>
                        <th>Title</th>
                        <th>Author</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="bookInfo" items="${bookInfoList}">
                        <tr class="bookInfo_click" onclick="location.href='/readBook.do?bookId=${bookInfo.getBookId()}';">
                            <td>${bookInfo.getBookId()}</td>
                            <td>${bookInfo.getBookName()}</td>
                            <c:choose>
                                <c:when test="${bookInfo.getBookAuthor()==null}">
                                    <td>-</td>
                                </c:when>
                                <c:otherwise>
                                    <td>${bookInfo.getBookAuthor()}</td>
                                </c:otherwise>
                            </c:choose>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>

</div>
<%@include file="footer.jsp" %>