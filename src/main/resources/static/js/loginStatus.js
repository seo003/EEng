function getQueryParam(param) {
    var urlParams = new URLSearchParams(window.location.search);
    return urlParams.get(param);
}

window.onload = function () {
    // var errorMessage = getQueryParam("errorMessage");
    // if (errorMessage === "loginRequired")
        alert("로그인이 필요합니다.");
}
