<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ page import="java.io.PrintWriter" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="kr">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>EENG</title>
    <!-- Custom fonts for this template-->
    <link href="/assets/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link
            href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
            rel="stylesheet">
    <!-- Custom styles for this template-->
    <link href="/css/index.css" rel="stylesheet">
    <link href="/css/k_custom.css" rel="stylesheet">
    <link href="/css/g_custom.css" rel="stylesheet">
</head>
<body id="page-top">
<!-- Page Wrapper -->
<div id="wrapper">
    <!-- Sidebar -->
    <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">
        <!-- Sidebar - Brand -->
        <a class="sidebar-brand d-flex align-items-center justify-content-center" href="/">
            <div class="sidebar-brand-icon rotate-n-15">
                <i class="fas fa-laugh-wink"></i>
            </div>
            <div class="sidebar-brand-text mx-3">EENG</div>
        </a>

        <!-- Divider -->
        <hr class="sidebar-divider my-0">

        <!-- Nav 단어장 -->
        <li class="nav-item active">
            <a class="nav-link" href="/myVocaList">
                <i class="fas fa-fw fa-solid fa-book"></i>
                <span>내 단어장</span></a>
        </li>
        <!-- Nav Item - Pages Collapse Menu -->
        <li class="nav-item active">
            <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseTwo"
               aria-expanded="true" aria-controls="collapseTwo">
                <i class="fas fa-fw fa-solid fa-book"></i>
                <span>단어장</span>
            </a>
            <div id="collapseTwo" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
                <div class="bg-white py-2 collapse-inner rounded">
                    <h6 class="collapse-header">단계</h6>

                    <a class="collapse-item" href="/voca?lv=1">LV 1<c:if test="${userLv == 1}"> 추천!</c:if></a>
                    <a class="collapse-item" href="/voca?lv=2">LV 2<c:if test="${userLv == 2}"> 추천!</c:if></a>
                    <a class="collapse-item" href="/voca?lv=3">LV 3<c:if test="${userLv == 3}"> 추천!</c:if></a>
                </div>
            </div>
        </li>


        <!-- Divider -->
        <hr class="sidebar-divider">

        <li class="nav-item active">
            <a class="nav-link" href="/booklist">
                <i class="fas fa-fw fa-solid fa-book-open"></i>
                <span>영어책</span></a>
        </li>
        <li class="nav-item active">
            <a class="nav-link" href="/sentence">
                <i class="fas fa-fw fa-solid fa-pen"></i>
                <span>문장 배열 연습</span></a>

        </li>
        <!-- Divider -->
        <hr class="sidebar-divider">

    </ul>
    <!-- End of Sidebar -->

    <!-- Content Wrapper -->
    <div id="content-wrapper" class="d-flex flex-column">

        <!-- Main Content -->
        <div id="content">

            <!-- Topbar -->
            <nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">

                <!-- Sidebar Toggle (Topbar) -->
                <button id="sidebarToggleTop" class="btn btn-link d-md-none rounded-circle mr-3">
                    <i class="fa fa-bars"></i>
                </button>

                <!-- Topbar Navbar -->
                <ul class="navbar-nav ml-auto">

                    <!-- Nav Item - Search Dropdown (Visible Only XS) -->
                    <li class="nav-item dropdown no-arrow d-sm-none">
                        <a class="nav-link dropdown-toggle" href="#" id="searchDropdown" role="button"
                           data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            <i class="fas fa-search fa-fw"></i>
                        </a>
                        <!-- Dropdown - Messages -->
                        <div class="dropdown-menu dropdown-menu-right p-3 shadow animated--grow-in"
                             aria-labelledby="searchDropdown">
                            <form class="form-inline mr-auto w-100 navbar-search">
                                <div class="input-group">
                                    <input type="text" class="form-control bg-light border-0 small"
                                           placeholder="Search for..." aria-label="Search"
                                           aria-describedby="basic-addon2">
                                    <div class="input-group-append">
                                        <button class="btn btn-primary" type="button">
                                            <i class="fas fa-search fa-sm"></i>
                                        </button>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </li>
                    <c:set var="loginUser" value="${sessionScope.userId}"/>
                    <c:choose>
                        <c:when test="${loginUser eq null}">

                        </c:when>
                        <c:otherwise>
                            <!-- Login 후 프론트 -->
                            <div class="topbar-divider d-none d-sm-block"></div>

                            <li class="nav-item dropdown no-arrow">
                                <a class="nav-link dropdown-toggle" href="#" role="button"
                                   data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    <span class="mr-2 d-none d-lg-inline text-gray-600 small">${loginUser}님 환영합니다</span>
                                </a>
                                <!-- 사용자 정보 dropdown -->
                                <div class="dropdown-menu dropdown-menu-right shadow animated--grow-in"
                                     aria-labelledby="userDropdown">
                                    <a class="dropdown-item" href="/level-test">
                                        <i class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></i>
                                        레벨테스트 다시하기
                                    </a>
                                    <div class="dropdown-divider"></div>
                                    <a class="dropdown-item" href="/logout" data-toggle="modal"
                                       data-target="#logoutModal">
                                        <i class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>
                                        Logout
                                    </a>
                                </div>
                            </li>
                        </c:otherwise>
                    </c:choose>
                </ul>
            </nav>
