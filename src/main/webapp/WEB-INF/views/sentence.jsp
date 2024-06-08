<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ page import="java.io.PrintWriter" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@include file="header.jsp" %>

<div id="sent" data-id="${fn:escapeXml(bookContent.sent)}"></div>
<div id="sentTrans" data-id="${fn:escapeXml(bookContent.sentTrans)}"></div>

<!-- Content Wrapper -->
<div id="content-wrapper" class="d-flex flex-column">

    <!-- Begin Page Content -->
    <div class="container-fluid">

        <!-- Page Heading -->
        <div class="d-sm-flex align-items-center justify-content-between mb-4">
            <h1 class="h3 mb-0 text-gray-800">Let's practice putting sentences together! </h1>
        </div>

        <%--  form tag로 사용자 정답 제출  --%>
        <form method="post" action="/sentence/checkSentence.do">
            <!-- 문제 -->
            <div class="row">
                <!-- Area Chart -->
                <div class="col-xl-12 col-lg-7">
                    <div class="card shadow mb-4 nohover">
                        <!-- Card Header - Dropdown -->
                        <div class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
                            <%-- 책 제목 출력 --%>
                            <h6 class="m-0 font-weight-bold text-primary">${bookName} 中</h6>
                            <div class="dropdown no-arrow yeshover">
                                <input class="btn btn-primary" type="submit" value="정답 확인"/>
                            </div>
                        </div>
                        <!-- Card Body -->
                        <div class="card-body">
                            <div class="h5 mb-0 text-gray-900">
                                뜻을 보고 영어 문장을 입력하세요.
                            </div>
                            <br><br>
                            <div class="h5 mb-0 text-gray-900 font-weight-bold">
                                <!-- 문장 뜻 출력 -->
                                <svg xmlns="http://www.w3.org/2000/svg" width="26" height="26" fill="currentColor"
                                     class="bi bi-chat-right-quote" viewBox="0 0 16 16">
                                    <path d="M2 1a1 1 0 0 0-1 1v8a1 1 0 0 0 1 1h9.586a2 2 0 0 1 1.414.586l2 2V2a1 1 0 0 0-1-1zm12-1a2 2 0 0 1 2 2v12.793a.5.5 0 0 1-.854.353l-2.853-2.853a1 1 0 0 0-.707-.293H2a2 2 0 0 1-2-2V2a2 2 0 0 1 2-2z"/>
                                    <path d="M7.066 4.76A1.665 1.665 0 0 0 4 5.668a1.667 1.667 0 0 0 2.561 1.406c-.131.389-.375.804-.777 1.22a.417.417 0 1 0 .6.58c1.486-1.54 1.293-3.214.682-4.112zm4 0A1.665 1.665 0 0 0 8 5.668a1.667 1.667 0 0 0 2.561 1.406c-.131.389-.375.804-.777 1.22a.417.417 0 1 0 .6.58c1.486-1.54 1.293-3.214.682-4.112z"/>
                                </svg>
                                <span id="koreanSentence"></span>
                            </div>
                            <br>
                            <div class="h5 mb-0 text-gray-900" id="userAnswerField">
                                <!-- 사용자 답변 출력 -->
                            </div>
                            <input type="hidden" name="userAnswer" id="userAnswerInput" value="">
                            <input type="hidden" name="answer" id="answer" value="">
                            <input type="hidden" name="sentTrans" value="${fn:escapeXml(bookContent.sentTrans)}">
                            <input type="hidden" name="bookName" value="${bookName}">
                            <hr>
                        </div>
                    </div>
                </div>
            </div>
        </form>

        <div id="choices">
            <!-- 단어 선택지 -->
        </div>
        <!-- /.container-fluid -->

    </div>
    <!-- End of Main Content -->

    <script src="js/sentence.js"></script>
    <%@include file="footer.jsp" %>
