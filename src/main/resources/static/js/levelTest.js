/*** 보기 문항: type==0 ***/
var preCardDiv = null;

function selectRBtn(rBtn, cardDiv, color) {
    var radioButton = document.getElementById(rBtn);

    if (preCardDiv != null) {
        preCardDiv.style.backgroundColor = '';
    }

    if (!radioButton.checked) {
        radioButton.checked = true;
        cardDiv.style.backgroundColor = color;
    } else {
        radioButton.checked = false;
    }

    preCardDiv = cardDiv;

    // 사용자 선택값 전달
    setAnswer(radioButton.value);
}


/*** 보기 문항: type==1 ***/
var userAnswer = [];

function selectCBtn(card) {
    var card = event.currentTarget;
    card.classList.toggle("selected");

    var button = card.querySelector("button");
    var choiceValue = button.value;

    var userAnswerDiv = document.getElementById("userAnswerField");
    var index = userAnswer.indexOf(choiceValue);

    if (index === -1) {
        userAnswer.push(choiceValue);
        button.classList.add("selected");
    } else {
        userAnswer.splice(index, 1);
        button.classList.remove("selected");
    }

    button.style.fontWeight = card.classList.contains("selected") ? "bold" : "normal";

    userAnswerDiv.innerText = userAnswer.join(' ');

    // 사용자 선택값 전달
    setAnswer(userAnswerDiv.innerText);
}


/*** 레벨테스트 데이터 가져오기 ***/
var ltList = document.getElementById("ltList").getAttribute("data-id");
var ltcList = document.getElementById("ltcList").getAttribute("data-id");
var numOrder = document.getElementById("num").getAttribute("data-id");

//ltList 데이터 가공
var lt = getDataArray(ltList);

console.log("ltList: " + ltList)
console.log("lt: %o", lt)

//ltcList 데이터 가공
var num = lt[numOrder].num;
console.log("ltcList: " + ltcList);
console.log("num: " + num);

//질문
var questionDiv = document.getElementById("question");
questionDiv.append(lt[numOrder].question);

//레벨
document.getElementById('lv').value = lt[numOrder].lv;

//문제 넘버
var numDiv = document.getElementById("numOrder");
numDiv.innerText = Number(numOrder) + 1 + "번";

//보기
var type = lt[numOrder].type;
divByType(type);

//문장 뜻
var sentenceDiv = document.getElementById("sentence");
var sentence = lt[numOrder].sentence;
if (type === 0) {
    sentenceDiv.remove();
} else {
    sentenceDiv.append(sentence);
}

// 정답
var answer = lt[numOrder].answer;
document.getElementById('answer').value = answer;
document.getElementById("answerField").innerText = "정답: " + answer;


/*** ltcList에서 num에 맞는 choices 가져오기 ***/
function getChoiceByNum(ltcList, num) {
    var dataArray = [];

    var regex = new RegExp("num=" + num + ", choice=[a-zA-Z가-힣]*", "g");
    var items = ltcList.match(regex);

    items.forEach(function (item) {
        var choice = item.split("=")[2];

        dataArray.push(choice);
    });

    // 배열을 랜덤으로 섞음
    for (var i = dataArray.length - 1; i > 0; i--) {
        // 무작위 인덱스 j를 생성
        // Math.random(): 0(포함)에서 1(불포함) 사이의 부동 소수점 숫자를 반환
        // (i + 1)로 곱하면 0(포함)부터 i(포함)까지의 무작위 숫자가 생성
        // Math.floor()은 이 숫자를 가장 가까운 정수로 내림
        var j = Math.floor(Math.random() * (i + 1));
        [dataArray[i], dataArray[j]] = [dataArray[j], dataArray[i]];
    }

    return dataArray;
}


/*** LevelTestD: String -> 객체로 구성된 배열 ***/
function getDataArray(str) {
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


/*** 문제 Type에 맞춰 다른 div 출력 ***/
function divByType(type) {
    var choiceDiv = document.getElementById("choices");
    var choices = getChoiceByNum(ltcList, num);

    //console.log("choices: " + choices);

    var html = "";

    if (type === 0) {
        html = `
    <!-- 보기: 타입이 0일때 -->
            <div class="row">
                <!-- 1번 -->
                <div class="col-xl-3 col-md-6 mb-4">
                    <div class="card border-left-primary shadow h-100 py-2"
                         onclick="selectRBtn('rBtn1', this, 'rgb(170,180,234)')">
                        <div class="card-body">
                            <div class="row no-gutters align-items-center">
                                <div class="col mr-2">
                                    <div class="h5 mb-0 text-gray-900">
                                        <input type="radio" value="${choices[0]}" name="answer" id="rBtn1" onclick="setAnswer('${choices[0]}')" />
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
                         onclick="selectRBtn('rBtn2', this, 'rgb(190,230,206)')">
                        <div class="card-body">
                            <div class="row no-gutters align-items-center">
                                <div class="col mr-2">
                                    <div class="h5 mb-0 text-gray-900">
                                        <input type="radio" value="${choices[1]}" name="answer" id="rBtn2"/>
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
                         onclick="selectRBtn('rBtn3', this, 'rgb(185,220,236)')">
                        <div class="card-body">
                            <div class="row no-gutters align-items-center">
                                <div class="h5 mb-0 text-gray-900">
                                    <input type="radio" value="${choices[2]}" name="answer" id="rBtn3"/>
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
                                <div class="h5 mb-0 text-gray-900">
                                    <input type="radio" value="${choices[3]}" name="answer" id="rBtn4"/>
                                    ${choices[3]}
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        `;
    } else if (type === 1) {
        html = `<div class="row">`;
        for (var i = 0; i < choices.length; i++) {
            html += `
                <div class="col-xl-2 col-md-6 mb-4">
                    <div class="card border-left-primary shadow h-100 py-2" onclick="selectCBtn(this)">
                        <div class="card-body">
                            <div class="row no-gutters align-items-center">
                                <div class="col mr-2">
                                    <div class="h5 mb-0 font-weight-bold text-gray-900">
                                         <button type="button" value="${choices[i]}">
                                        ${choices[i]}
                                        </button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            `;
        }
        html += `</div>`;
    }
    choiceDiv.innerHTML = html;
}

// 사용자 정답 button -> value에 넣기
function setAnswer(value) {
    document.getElementById('userAnswerInput').value = value;
}