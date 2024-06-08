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

/*** 책 문장 데이터 가져오기 ***/
var sent = document.getElementById("sent").getAttribute("data-id");
var sentTrans = document.getElementById("sentTrans").getAttribute("data-id");

// 문장 뜻 출력
var sentenceTransDiv = document.getElementById("koreanSentence");
sentenceTransDiv.innerText = sentTrans;

// 정답
var answer = sent;
document.getElementById('answer').value = answer;

// 단어별 보기 생성
divByWords(answer);

/*** 단어별 보기 생성 ***/
function divByWords(sentence) {
    var choiceDiv = document.getElementById("choices");
    var words = sentence.split(" ");

    // 배열을 랜덤으로 섞음
    for (var i = words.length - 1; i > 0; i--) {
        var j = Math.floor(Math.random() * (i + 1));
        [words[i], words[j]] = [words[j], words[i]];
    }
    // console.log("words:", words);

    var html = `<div class="row">`;

    for (var i = 0; i < words.length; i++) {
        html += `
            <div class="col-xl-2 col-md-6 mb-4">
                <div class="card border-left-primary shadow h-100 py-2" onclick="selectCBtn(this)">
                    <div class="card-body">
                        <div class="row no-gutters align-items-center">
                            <div class="col mr-2">
                                <div class="h5 mb-0 font-weight-bold text-gray-900">
                                     <button type="button" value="${words[i]}">
                                    ${words[i]}
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
}

// 사용자 정답 button -> value에 넣기
function setAnswer(value) {
    document.getElementById('userAnswerInput').value = value;
}
