function discussionClick(s) {
    let commentsContainer = document.getElementById(s);
    if (commentsContainer.style.height != "auto") {
        commentsContainer.style.height = 'auto';
        commentsContainer.style.visibility = 'visible';
    } else {
        commentsContainer.style.height = '0';
        commentsContainer.style.visibility = 'collapse';
    }

}


function likeClick() {
    alert("It works");
}

function retweetClick() {
    alert("It works");
}
