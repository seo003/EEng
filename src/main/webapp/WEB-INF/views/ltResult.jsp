<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="kr.kro.eeng.levelTest.LevelTestD" %>

<%@include file="header.jsp" %>

<!-- Content Wrapper -->
<div id="content-wrapper" class="d-flex flex-column">

    <!-- Begin Page Content -->
    <div class="container-fluid">

        <!-- Page Heading -->
        <div class="d-sm-flex align-items-center justify-content-between mb-4">
            <h1 class="h3 mb-0 text-gray-800">Check my English level!</h1>
        </div>
        <a href="/" class="btn btn-primary btn-icon-split">
            <span class="text">학습하러 가기</span>
        </a>
        <br><br>
            <div class="row">
                <!-- Area Chart -->
                <div class="col-xl-12 col-lg-7">
                    <div class="card shadow mb-4 nohover">
                        <!-- Card Header - Dropdown -->
                        <div class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
                            <h6 class="m-0 font-weight-bold text-primary">수고하셨습니다!</h6>

                        </div>
                        <!-- Card Body -->
                        <div class="card-body">
                            <div class="h5 mb-0 text-gray-900">
                                레벨테스트가 모두 끝났습니다.
                            </div>
                            <br><br>
                            <div class="h5 mb-0 text-gray-900 font-weight-bold">
                                <svg xmlns="http://www.w3.org/2000/svg" width="26" height="26" fill="currentColor"
                                     class="bi bi-chat-right-quote" viewBox="0 0 16 16">
                                    <path d="M2 1a1 1 0 0 0-1 1v8a1 1 0 0 0 1 1h9.586a2 2 0 0 1 1.414.586l2 2V2a1 1 0 0 0-1-1zm12-1a2 2 0 0 1 2 2v12.793a.5.5 0 0 1-.854.353l-2.853-2.853a1 1 0 0 0-.707-.293H2a2 2 0 0 1-2-2V2a2 2 0 0 1 2-2z"/>
                                    <path d="M7.066 4.76A1.665 1.665 0 0 0 4 5.668a1.667 1.667 0 0 0 2.561 1.406c-.131.389-.375.804-.777 1.22a.417.417 0 1 0 .6.58c1.486-1.54 1.293-3.214.682-4.112zm4 0A1.665 1.665 0 0 0 8 5.668a1.667 1.667 0 0 0 2.561 1.406c-.131.389-.375.804-.777 1.22a.417.417 0 1 0 .6.58c1.486-1.54 1.293-3.214.682-4.112z"/>
                                </svg>
                                ${sessionScope.userId}님의 점수는 ${score}점입니다.
                            </div>
                            <br>
                        </div>
                    </div>
                </div>
            </div>
    </div>
    <!-- End of Main Content -->

<%@include file="footer.jsp" %>