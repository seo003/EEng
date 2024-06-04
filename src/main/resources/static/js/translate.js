// document.getElementById('text-to-translate').addEventListener('click', function (event) {
//     const text = event.target.innerText; //문장 저장
//
//     fetch('/translate', {
//         method: 'POST',
//         headers: {
//             'Content-Type': 'application/json' //json 데이터 전송
//         },
//         body: JSON.stringify({ text: text })
//     })
//         .then(response => response.json())
//         .then(data => {
//             const translatedText = data.translatedText;
//             const translatedElement = document.createElement('p');
//             translatedElement.className = 'translated';
//             translatedElement.innerText = translatedText;
//             document.getElementById('translated-texts').appendChild(translatedElement);
//         })
//         .catch(error => console.error('Error:', error));
// });

// 문서가 로드된 후 이벤트 리스너를 추가합니다.
document.addEventListener('DOMContentLoaded', function() {
    // 모든 번역할 문장을 선택합니다.
    const textElements = document.querySelectorAll('[id^="text-to-translate-"]');

    // 각 문장에 클릭 이벤트를 추가합니다.
    textElements.forEach(function(element) {
        element.addEventListener('click', function (event) {
            const text = event.target.innerText; // 문장 저장
            const sentenceId = event.target.id.split('-')[3]; // 문장 ID 추출

            fetch('/translate', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json' // JSON 데이터 전송
                },
                body: JSON.stringify({ text: text })
            })
                .then(response => response.json())
                .then(data => {
                    const translatedText = data.translatedText;
                    const translatedElement = document.createElement('p');
                    translatedElement.className = 'translated';
                    translatedElement.innerText = translatedText;
                    document.getElementById('translated-texts-' + sentenceId).appendChild(translatedElement);
                })
                .catch(error => console.error('Error:', error));
        });
    });
});
