document.addEventListener('DOMContentLoaded', function () {
    // 모든 번역할 문장 선택
    const textElements = document.querySelectorAll('[id^="text-to-translate-"]');

    // 각 문장에 클릭 이벤트 추가
    textElements.forEach(function (element) {
        element.addEventListener('click', function (event) {
            const text = event.target.innerText; // 문장 저장
            const sentenceId = event.target.id.split('-')[3]; // 문장 ID 추출
            const translatedContainer = document.getElementById('translated-texts-' + sentenceId);

            // 번역된 텍스트가 이미 있는지 확인
            if (translatedContainer.innerHTML.trim() !== "") {
                // 번역된 텍스트가 있으면 삭제
                translatedContainer.innerHTML = "";
            } else {
                // 번역된 텍스트가 없으면 번역 요청 보내기
                fetch('/translate.do', {
                    method: 'POST',
                    headers: {
                        'Content-Type': 'application/json' // JSON 데이터 전송
                    },
                    body: JSON.stringify({text: text})
                })
                    .then(response => response.json())
                    .then(data => {
                        const translatedText = data.translatedText;
                        const translatedElement = document.createElement('p');
                        translatedElement.className = 'translated';
                        translatedElement.innerText = translatedText;
                        translatedContainer.appendChild(translatedElement);
                    })
                    .catch(error => console.error('Error:', error));
            }
        });

        // 각 문장에 우클릭 이벤트 추가
        element.addEventListener('contextmenu', function (event) {
            event.preventDefault(); // 기본 우클릭 메뉴 방지
            const text = event.target.innerText; // 문장 저장
            pollySpeech(text); // Polly를 사용해 문장 읽기
        });
    });

    // vocaWord 가져오기
    const vocaWordElement = document.getElementById('vocaWord');

    // vocaWord 우클릭 이벤트 추가
    vocaWordElement.addEventListener('contextmenu', function (event) {
        event.preventDefault(); // 기본 우클릭 메뉴 방지
        const text = event.target.innerText; // 단어 저장
        pollySpeech(text); // Polly를 사용해 단어 발음
    });
});

function pollySpeech(text) {
    fetch('/speech.do', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({ text: text }),
    })
        .then(response => response.blob())
        .then(blob => {
            const url = URL.createObjectURL(blob);
            const audio = new Audio(url);
            audio.play();
        })
        .catch(error => console.error('Error:', error));
}