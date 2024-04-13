<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ page import="java.io.PrintWriter" %>

<%@include file="header.jsp" %>
<div class="container-fluid">
    <c:choose>
        <c:when test="${lv == 1}">
            <c:set var="LV" value="초급단어" />
        </c:when>
        <c:when test="${lv == 2}">
            <c:set var="LV" value="중급단어" />
        </c:when>
        <c:when test="${lv == 3}">
            <c:set var="LV" value="고급단어" />
        </c:when>
    </c:choose>
        <!-- title -->
        <h1 class="h3 mb-2 text-gray-800">${LV}</h1>
        <p class="mb-4">일상생활에서 자주 사용되는 기본적인 단어
        <!-- DataTales Example -->
        <div class="card shadow mb-4">
            <div class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
                <h6 class="m-0 font-weight-bold text-primary">
                    ${LV}
                </h6>
                <div class="dropdown no-arrow">
                    <a href="#" class="btn btn-primary btn-icon-split">
                        <span class="text">단어 공부하러 가기</span>
                    </a>

                </div>
            </div>
            <div class="card-body">
                <div class="table-responsive">
                    <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                        <thead>
                        <tr>
                            <th>Voca</th>
                            <th>Mean</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="voca" items="${vocaListFromLv}">
                            <tr>
                                <td>${voca.getVoca()}</td>
                                <td>${voca.getVocaMean()}</td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>

</div>
<%@include file="footer.jsp" %>