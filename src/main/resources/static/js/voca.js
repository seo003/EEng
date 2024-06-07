// 단어장 페이지
// JSON 문자열을 파싱하여 배열로 변환
var voca = JSON.parse(document.getElementById("voca").getAttribute("data-id"));
var currentIndex = 0;

var wordDiv = document.getElementById("vocaWord");
var wordMeaningDiv = document.getElementById("vocaMeaning");
var checkbox = document.getElementById("onlyWordCheckbox");

// 요소 업데이트
function updateVoca(index) {
    // 인덱스가 범위를 벗어나면 무시
    if (index < 0 || index >= voca.length) {
        return;
    }
    wordDiv.innerText = voca[index].voca;
    wordMeaningDiv.innerText = voca[index].vocaMean;
}

// 이벤트 핸들러
document.getElementById("prevButton").addEventListener("click", function (event) {
    event.preventDefault(); // 기본 링크 동작 막기
    if (currentIndex > 0) {
        currentIndex--;
        updateVoca(currentIndex);
    }
});

document.getElementById("nextButton").addEventListener("click", function (event) {
    event.preventDefault(); // 기본 링크 동작 막기
    if (currentIndex < voca.length - 1) {
        currentIndex++;
        updateVoca(currentIndex);
    }
});

// 초기 voca 설정
updateVoca(currentIndex);


// 단어만 보기
function onlyWord() {
    if (checkbox.checked) {
        // 체크박스가 체크된 경우
        wordMeaningDiv.style.display = "none"; // 뜻을 감춤
    } else {
        // 체크박스가 체크 해제된 경우
        wordMeaningDiv.style.display = ""; // 뜻을 다시 표시
    }
}

// 단어 뜻 표시 여부
var meaningVisible = false;

// 단어 클릭 시 뜻 표시 및 숨김
function showMean() {
    var wordMeaningDiv = document.getElementById("vocaMeaning");

    if (meaningVisible) {
        // 뜻이 표시되어 있는 경우
        wordMeaningDiv.style.display = "none"; // 뜻을 숨김
        meaningVisible = false; // 플래그를 false로 변경
    } else {
        // 뜻이 숨겨져 있는 경우
        wordMeaningDiv.style.display = ""; // 뜻을 표시
        meaningVisible = true; // 플래그를 true로 변경
    }
}


// 단어 목록 페이지

// 단어만 보기
function onlyWordList() {
    var tableRows = document.querySelectorAll("#dataTable tbody tr");
    tableRows.forEach(function(row) {
        var meaningCell = row.querySelector(".vocaMeaning");
        if (onlyWordListCheckbox.checked) {
            meaningCell.style.visibility = "hidden"; // 뜻 숨기기
        } else {
            meaningCell.style.visibility = "visible"; // 뜻 보이기
        }
    });
}


