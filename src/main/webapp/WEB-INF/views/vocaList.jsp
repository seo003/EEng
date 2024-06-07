<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ page import="java.io.PrintWriter" %>

<%@include file="header.jsp" %>
<div class="container-fluid">

    <h1 class="h3 mb-2 text-gray-800">LV ${lv}</h1>
        <br>
    <div class="dropdown no-arrow">
        <a href="#" class="btn btn-primary btn-icon-split">
            <span class="text">단어 공부하러 가기</span>
        </a>
    </div>
        <br>
    <div class="table-responsive">
        <table class="k_table table table-bordered" id="dataTable" width="100%" cellspacing="0">
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
<%@include file="footer.jsp" %>