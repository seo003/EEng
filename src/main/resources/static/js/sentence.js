var userAnswer = [];

// 사용자 정답 button -> value에 넣기
function setAnswerB(value) {
    document.getElementById('userAInput').value = value;
}

function selectBtn(card, index) {
    // var card = event.currentTarget;
    // card.classList.toggle("selected");
    //
    // var button = card.querySelector("button");
    // var choiceValue = button.value + "-" + index; // 고유 식별자 추가

    var card = event.currentTarget;
    card.classList.toggle("selected");

    var button = card.querySelector("button");
    var choiceValue = button.getAttribute("data-value") + "-" + index; // data-value 사용

    var userADiv = document.getElementById("userAField");
    var userAnswerIndex = userAnswer.findIndex(item => item === choiceValue);

    if (userAnswerIndex === -1) {
        userAnswer.push(choiceValue);
        button.classList.add("selected");
    } else {
        userAnswer.splice(userAnswerIndex, 1);
        button.classList.remove("selected");
    }
    console.log("userAnswer: " + userAnswer);
    button.style.fontWeight = card.classList.contains("selected") ? "bold" : "normal";

    // 사용자에게 보여줄 단어 목록 (식별자 제거)
    var displayAnswer = userAnswer.map(item => item.split("-")[0]).join(' ');
    userADiv.innerText = displayAnswer;

    // 사용자 선택값 전달 (식별자 제거)
    setAnswerB(displayAnswer);
}

/*** 책 문장 데이터 가져오기 ***/
// 영어문장
var sent = document.getElementById("sent").getAttribute("data-id");
// 한국어문장
var sentTrans = document.getElementById("sentTrans").getAttribute("data-id");

// 문장 뜻 출력
var sentenceTransDiv = document.getElementById("koreanSentence");
sentenceTransDiv.innerText = sentTrans;

// 정답
document.getElementById('answerB').value = sent;

var choices = sent.split(" ");
randChoice(choices);

// 보기 생성
var choiceDiv = document.getElementById("choicesB");
var html = `<div class="row">`;

for (var i = 0; i < choices.length; i++) {
    html += `
            <div class="col-xl-2 col-md-6 mb-4">
                <div class="card border-left-primary shadow h-100 py-2" onclick="selectBtn(this, ${i})">
                    <div class="card-body">
                        <div class="row no-gutters align-items-center">
                            <div class="col mr-2">
                                <div class="h5 mb-0 font-weight-bold text-gray-900">
                                     <button type="button" id="word-${i}" data-value="${escapeHTML(choices[i])}">
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
choiceDiv.innerHTML = html;

console.log("*******************************************************************************")
console.log("sent: " + sent);
console.log("choices: " + choices);


/*** 보기 랜덤 ***/
function randChoice(choices) {
    // 배열을 랜덤으로 섞음
    for (var i = choices.length - 1; i > 0; i--) {
        var j = Math.floor(Math.random() * (i + 1));
        [choices[i], choices[j]] = [choices[j], choices[i]];
    }
    return choices;
}
function escapeHTML(html) {
    var escapeMap = {
        '&': '&amp;',
        '<': '&lt;',
        '>': '&gt;',
        '"': '&quot;',
        "'": '&#39;'
    };
    return html.replace(/[&<>"']/g, function (char) {
        return escapeMap[char];
    });
}
