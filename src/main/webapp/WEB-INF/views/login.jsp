<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ page import="java.io.PrintWriter" %>

<%@include file="header.jsp" %>
<script>
    function handleCredentialResponse(response) {
        // response.credential -> 구글로부터 전달받은 인증토큰
        const responsePayload = parseJwt(response.credential);
        //정보 출력
        console.log("ID: " + responsePayload.sub);
        console.log('Full Name: ' + responsePayload.name);
        console.log('Given Name: ' + responsePayload.given_name);
        console.log('Family Name: ' + responsePayload.family_name);
        console.log("Image URL: " + responsePayload.picture);
        console.log("Email: " + responsePayload.email);
    };

    function parseJwt (token) {
        const base64Url = token.split('.')[1];
        const base64 = base64Url.replace(/-/g, '+').replace(/_/g, '/');
        const jsonPayload = decodeURIComponent(atob(base64).split('').map(function(c) {
            return '%' + ('00' + c.charCodeAt(0).toString(16)).slice(-2);
        }).join(''));

        return JSON.parse(jsonPayload);
    };
</script>
<div class="container-fluid">

    <div class="col-xl-10 col-lg-12 col-md-9">
        <div class="card o-hidden border-0 shadow-lg my-5">
            <div class="card-body p-0">
                <div class="row">
                    <div class="col-lg-6 d-none d-lg-block">
                        <img src="/assets/img/loginImage.jpg" id="login_Image" >
                    </div>
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
                                <%-- 구글 소셜로그인 --%>
                                <script src="https://accounts.google.com/gsi/client" async></script>
                                <div id="g_id_onload"
                                     data-client_id="974054440102-e0chrlbdbu4ms27d51jp9e61jjd25sn3.apps.googleusercontent.com"
                                     data-login_uri="https://localhost:8080/"
                                     data-auto_prompt="false"
                                     data-callback="handleCredentialResponse">
                                </div>
                                <div class="g_id_signin"
                                     data-type="standard"
                                     data-size="large"
                                     data-theme="outline"
                                     data-text="sign_in_with"
                                     data-shape="rectangular"
                                     data-logo_alignment="left">
                                </div>

                            <%--                                <a href="/login" class="btn btn-google btn-user btn-block">--%>
<%--                                    <i class="fab fa-google fa-fw"></i> Login with Google--%>
<%--                                </a>--%>
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