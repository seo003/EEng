<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ page import="java.io.PrintWriter" %>
<script src="https://apis.google.com/js/platform.js" async defer></script>
<meta name="google-signin-client_id" content="974054440102-e0chrlbdbu4ms27d51jp9e61jjd25sn3.apps.googleusercontent.com">
<%@include file="header.jsp" %>
<script src="js/loginStatus.js"></script>
<script>
    function validateForm() {
        const userId = document.forms["signupForm"]["userId"].value;
        const userName = document.forms["signupForm"]["userName"].value;
        const userPw = document.forms["signupForm"]["userPw"].value;
        const userPwCheck = document.forms["signupForm"]["userPwCheck"].value;
        const userBirth = document.forms["signupForm"]["userBirth"].value;
        const userPhone = document.forms["signupForm"]["userPhone"].value;

        if (!userId || !userName || !userPw || !userPwCheck || !userBirth || !userPhone) {
            alert("모든 필드를 입력하세요.");
            return false;
        }

        if (userPw !== userPwCheck) {
            alert("비밀번호가 일치하지 않습니다.");
            return false;
        }

        return true;
    }

</script>
<div class="container-fluid">

    <div class="col-xl-10 col-lg-12 col-md-9">
        <div class="card o-hidden border-0 shadow-lg my-5">
            <div class="card-body p-0">
                <div class="row">
                    <div class="col-lg-6 d-none d-lg-block">
                        <img src="/assets/img/loginImage.jpg" id="login_Image">
                    </div>
                    <div class="col-lg-6">
                        <div class="p-5">
                            <div class="text-center">
                                <h1 class="h4 text-gray-900 mb-4">Welcome!</h1>
                            </div>
                            <form name="signupForm" class="user" action="/register.do" method="post" onsubmit="return validateForm()">
                                <div class="form-group">
                                    <input type="text" name="userId"
                                           class="form-control form-control-user"
                                           placeholder="ID">
                                </div>
                                <div class="form-group">
                                    <input type="text" name="userName"
                                           class="form-control form-control-user"
                                           placeholder="NAME">
                                </div>
                                <div class="form-group">
                                    <input type="password" name="userPw"
                                           class="form-control form-control-user"
                                           placeholder="Password">
                                </div>
                                <div class="form-group">
                                    <input type="password" name="userPwCheck"
                                           class="form-control form-control-user"
                                           placeholder="PasswordCheck">
                                </div>
                                <div class="form-group">
                                    <input type="date" name="userBirth"
                                           class="form-control form-control-user"
                                           placeholder="BIRTH(8자리)">
                                </div>
                                <div class="form-group">
                                    <input type="email" name="userEmail"
                                           class="form-control form-control-user"
                                           placeholder="EMAIL">
                                </div>
                                <div class="form-group">
                                    <input type="text" name="userPhone"
                                           class="form-control form-control-user"
                                           placeholder="PHONE(-제외)">
                                </div>
                                <input type="submit" class="btn btn-primary btn-user btn-block" value="signup"/>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </div>

</div>

<%@include file="footer.jsp" %>
