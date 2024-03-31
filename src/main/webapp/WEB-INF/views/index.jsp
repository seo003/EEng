<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ page import="java.io.PrintWriter" %>

<%@include file="header.jsp" %>

<div class="container-fluid">

    <div class="col-xl-10 col-lg-12 col-md-9">
        <div class="card o-hidden border-0 shadow-lg my-5">
            <div class="card-body p-0">
                <div class="row">
                    <div class="col-lg-6 d-none d-lg-block bg-login-image"></div>
                    <div class="col-lg-6">
                        <div class="p-5">
                            <div class="text-center">
                                <h1 class="h4 text-gray-900 mb-4">Welcome!</h1>
                            </div>
                            <form class="user" action="/login" method="post">
                                <div class="form-group">
                                    <input type="text" name="userId"
                                           class="form-control form-control-user"
                                           id="exampleInputEmail" aria-describedby="emailHelp"
                                           placeholder="ID">
                                </div>
                                <div class="form-group">
                                    <input type="password" name="userPw"
                                           class="form-control form-control-user"
                                           id="exampleInputPassword" placeholder="Password">
                                </div>
                                <div class="form-group">
                                    <div class="custom-control custom-checkbox small">
                                        <input type="checkbox" class="custom-control-input" id="customCheck">
                                        <label class="custom-control-label" for="customCheck">Remember
                                            Me</label>
                                    </div>
                                </div>
                                <button type="submit" class="btn btn-primary btn-user btn-block">Login</button>
                                <hr>
                                <a href="index.html" class="btn btn-google btn-user btn-block">
                                    <i class="fab fa-google fa-fw"></i> Login with Google
                                </a>
                            </form>
                            <hr>
                            <div class="text-center">
                                <a class="small" href="forgot-password.jsp">Forgot Password?</a>
                            </div>
                            <div class="text-center">
                                <a class="small" href="register.jsp">Create an Account!</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </div>

</div>

<%@include file="footer.jsp" %>