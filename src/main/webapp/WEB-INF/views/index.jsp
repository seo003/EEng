<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ page import="java.io.PrintWriter" %>

<%@include file="header.jsp" %>

<div class="container-fluid">

    <div class="row">
        <div class="col-lg-4 mb-4">
            <!-- 학습 진행률 -->
            <div class="card shadow mb-4">
                <div class="card-header py-3">
                    <h6 class="m-0 font-weight-bold text-primary">학습 진행률</h6>
                </div>
                <div class="card-body">
                    <h4 class="small font-weight-bold">단어 학습률<span
                            class="float-right">50개</span></h4>
                    <div class="progress mb-4">
                        <div class="progress-bar bg-warning" role="progressbar" style="width: 40%"
                             aria-valuenow="40" aria-valuemin="0" aria-valuemax="100"></div>
                    </div>
                    <h4 class="small font-weight-bold">책 학습<span
                            class="float-right">10개</span></h4>
                    <div class="progress mb-4">
                        <div class="progress-bar bg-warning" role="progressbar" style="width: 40%"
                             aria-valuenow="40" aria-valuemin="0" aria-valuemax="100"></div>
                    </div>
                    <h4 class="small font-weight-bold">영상 시청<span
                            class="float-right">2개</span></h4>
                    <div class="progress mb-4">
                        <div class="progress-bar bg-warning" role="progressbar" style="width: 40%"
                             aria-valuenow="40" aria-valuemin="0" aria-valuemax="100"></div>
                    </div>
                </div>
            </div>
            <%-- 단어 추천 --%>
            <div class="card shadow mb-4">
                <div class="card-header py-3">
                    <h6 class="m-0 font-weight-bold text-primary">오늘의 단어</h6>
                </div>
                <div class="card-body">

                </div>
            </div>
            <%-- 책 추천 --%>
            <div class="card shadow mb-4">
                <div class="card-header py-3">
                    <h6 class="m-0 font-weight-bold text-primary">오늘의 책</h6>
                </div>
                <div class="card-body">

                </div>
            </div>
        </div>

        <div class="row">
            <div class="col-lg-12 mb-4">
                <!-- 영상 추천 1 -->
                <div class="card shadow mb-4">
                    <div class="card-header py-3">
                        <h6 class="m-0 font-weight-bold text-primary">영상 추천</h6>
                    </div>
                    <div class="card-body">

                    </div>
                </div>

                <!-- 영상 추천 2 -->
                <div class="card shadow mb-4">
                    <div class="card-header py-3">
                        <h6 class="m-0 font-weight-bold text-primary">영상 추천</h6>
                    </div>
                    <div class="card-body">

                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<%@include file="footer.jsp" %>