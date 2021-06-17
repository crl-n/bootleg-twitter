function tweetboxClick() {

    var content = document.getElementById("tweet-content-input").value;

    var data = new FormData();
    data.append("content", content);

    var xhr = new XMLHttpRequest();
    xhr.open("POST", "/post");

    xhr.onreadystatechange = function () {
       if (xhr.readyState === 4) {
          console.log(xhr.status);
          console.log(xhr.responseText);
       }
    };
    xhr.send(data);

    location.reload(); // NOT WORKING :(
}