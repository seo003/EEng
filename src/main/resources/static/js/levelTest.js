/*** 보기 문항 ***/
var preCardDiv = null;
function selectRBtn(rBtn, cardDiv, color) {
    var radioButton = document.getElementById(rBtn);

    if (preCardDiv != null){
        preCardDiv.style.backgroundColor = '';
    }

    if (!radioButton.checked) {
        radioButton.checked = true;
        cardDiv.style.backgroundColor = color;
    }else {
        radioButton.checked = false;
    }

    preCardDiv = cardDiv;
}

/*** 레벨테스트 데이터 가져오기 ***/
var ltList1 = document.getElementById("ltList1").getAttribute("data-id");
var ltList2 = document.getElementById("ltList2").getAttribute("data-id");
var ltList3 = document.getElementById("ltList3").getAttribute("data-id");
var ltcList = document.getElementById("ltcList").getAttribute("data-id");

var question = document.getElementById("question");
var level = document.getElementById("level");

var lv1 = getTwoDArray(ltList1);

question.innerText = lv1[0].question;
level.innerText = "레벨 " + lv1[0].lv;


console.log(ltList1);
console.log(lv1);




/*** LevelTestD: String -> 이차원 배열 ***/
function getTwoDArray(str) {
    var matches = str.match(/LevelTestD\([^)]+\)/g);

    var result = matches.map(function (match) {
        var obj = {};
        match.replace(/(\w+)=([^,]+)(?:,|$)/g, function (_, key, value) {
            obj[key.trim()] = value.trim(); // key, value를 추출하여 객체에 할당
        });

        // type 속성의 값만 숫자로 추출하여 저장
        obj.type = parseInt(obj.type.match(/\d+/)[0]);

        return obj; // 완성된 객체를 배열에 추가
    });

    return result;
}





