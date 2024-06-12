<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ page import="java.io.PrintWriter" %>

<%@include file="header.jsp" %>
<div class="container-fluid">

    <h1 class="h3 mb-2 text-gray-800">${userId}의 단어장</h1>
    <br>
    <br><br>
    <div class="table-responsive">
        <table class="k_table table table-bordered" id="dataTable" width="100%" cellspacing="0">
            <thead>
            <tr>
                <th style="width: 35%">Voca</th>
                <th style="width: auto">Mean</th>
                <th style="width: 5%">Delete</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="voca" items="${userVocaList}">
                <tr>
                    <td class="vocaWord">${voca.getVoca()}</td>
                    <td class="vocaMeaning">${voca.getVocaMean()}</td>
                    <td class="btn-outline-primary" onclick="vocaDelete(${voca.getVocaId()});">삭제</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>

</div>
<%@include file="footer.jsp" %>
