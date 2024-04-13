<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="kr.kro.eeng.levelTest.LevelTestD" %>

<%@include file="header.jsp" %>


<div id="ltList1" data-id="${ltList1}"></div>
<div id="ltList2" data-id="${ltList2}"></div>
<div id="ltList3" data-id="${ltList3}"></div>
<div id="ltcList" data-id="${ltcList}"></div>


<!-- Content Wrapper -->
<div id="content-wrapper" class="d-flex flex-column">

    <!-- Begin Page Content -->
    <div class="container-fluid">

        <!-- Page Heading -->
        <div class="d-sm-flex align-items-center justify-content-between mb-4">
            <h1 class="h3 mb-0 text-gray-800">Check my English level!</h1>
        </div>

        <!-- 문제 -->
        <div class="row">
            <!-- Area Chart -->
            <div class="col-xl-12 col-lg-7">
                <div class="card shadow mb-4">
                    <!-- Card Header - Dropdown -->
                    <div class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
                        <h6 class="m-0 font-weight-bold text-primary" id="level"></h6>
                        <div class="dropdown no-arrow">
                            <a href="#" class="btn btn-primary btn-icon-split">
                                <span class="text">확인</span>
                                <span class="icon text-white-500">
                                    <i class="fas fa-check"></i>
                                </span>
                            </a>
                        </div>
                    </div>
                    <!-- Card Body -->
                    <div class="card-body">
                        <div class="chart-area" id="question">

                        </div>
                    </div>
                </div>
            </div>
        </div>

        <div>
            <!-- 보기: 타입이 0일때 -->
            <div class="row">
                <!-- 1번 -->
                <div class="col-xl-3 col-md-6 mb-4">
                    <div class="card border-left-primary shadow h-100 py-2"
                         onclick="selectRBtn('rBtn1', this, 'rgb(170,180,234')">
                        <div class="card-body">
                            <div class="row no-gutters align-items-center">
                                <div class="col mr-2">
                                    <div class="h5 mb-0 font-weight-bold text-gray-900">
                                        <input type="radio" value="1" name="answer" id="rBtn1"/>
                                        ${choices[0]}
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <!-- 2번 -->
                <div class="col-xl-3 col-md-6 mb-4">
                    <div class="card border-left-success shadow h-100 py-2"
                         onclick="selectRBtn('rBtn2', this, 'rgb(190,230,206')">
                        <div class="card-body">
                            <div class="row no-gutters align-items-center">
                                <div class="col mr-2">
                                    <div class="h5 mb-0 font-weight-bold text-gray-900">
                                        <input type="radio" value="2" name="answer" id="rBtn2"/>
                                        ${choices[1]}
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <!-- 3번 -->
                <div class="col-xl-3 col-md-6 mb-4">
                    <div class="card border-left-info shadow h-100 py-2"
                         onclick="selectRBtn('rBtn3', this, 'rgb(185,220,236')">
                        <div class="card-body">
                            <div class="row no-gutters align-items-center">
                                <div class="h5 mb-0 font-weight-bold text-gray-900">
                                    <input type="radio" value="3" name="answer" id="rBtn3"/>
                                    ${choices[2]}
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <!-- 4번 -->
                <div class="col-xl-3 col-md-6 mb-4">
                    <div class="card border-left-warning shadow h-100 py-2"
                         onclick="selectRBtn('rBtn4', this, 'rgb(240,220,160)')">
                        <div class="card-body">
                            <div class="row no-gutters align-items-center">
                                <div class="h5 mb-0 font-weight-bold text-gray-900">
                                    <input type="radio" value="4" name="answer" id="rBtn4"/>
                                    ${choices[3]}
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>


    </div>
    <!-- /.container-fluid -->

</div>
<!-- End of Main Content -->

<%@include file="footer.jsp" %>