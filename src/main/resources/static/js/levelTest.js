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