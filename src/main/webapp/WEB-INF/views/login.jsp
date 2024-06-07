<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ page import="java.io.PrintWriter" %>
<script src="https://apis.google.com/js/platform.js" async defer></script>
<meta name="google-signin-client_id" content="974054440102-e0chrlbdbu4ms27d51jp9e61jjd25sn3.apps.googleusercontent.com">
<%@include file="header.jsp" %>
<script src="js/loginStatus.js"></script>
<script type="text/javascript">
    function onSignIn(googleUser) {
        var profile = googleUser.getBasicProfile();
        var id = profile.getId();
        var username = profile.getName();
        var img = profile.getImageUrl();
        var email = profile.getEmail();
        alert('로그인 완료');

        console.log("ID: " + id);
        console.log("Name: " + username);
        console.log("Image URL: " + img);
        console.log("Email: " + email);

            post_to_url( "/login",
            {'id': id, 'username': username, 'email': email, 'img': img})
    }
    function post_to_url(path, params, method='post') {
        const form = document.createElement('form');
        form.method = method;
        form.action = path;

        for(const key in params) {
            if(params.hasOwnProperty(key)) {
                const hiddenField = document.createElement('input');
                hiddenField.type = 'hidden';
                hiddenField.name = key;
                hiddenField.value = params[key];
                form.appendChild(hiddenField);
            }
        }
        document.body.appendChild(form);
        form.submit();
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
                            <form class="user" action="/login.do" method="post">
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
                                <input type="submit" class="btn btn-primary btn-user btn-block" value="Login"/>
                                <hr>
                                <%-- 구글 소셜로그인 --%>
<%--                                <div class="g-signin2" onclick='onSignIn()'></div>--%>
                                <div class="g-signin2" data-onsuccess="onSignIn"></div>
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
