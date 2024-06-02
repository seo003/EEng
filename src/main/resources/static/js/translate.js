document.getElementById('text-to-translate').addEventListener('click', function (event) {
    const text = event.target.innerText; //문장 저장

    fetch('/translate', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json' //json 데이터 전송
        },
        body: JSON.stringify({ text: text })
    })
        .then(response => response.json())
        .then(data => {
            const translatedText = data.translatedText;
            const translatedElement = document.createElement('p');
            translatedElement.className = 'translated';
            translatedElement.innerText = translatedText;
            document.getElementById('translated-texts').appendChild(translatedElement);
        })
        .catch(error => console.error('Error:', error));
});
