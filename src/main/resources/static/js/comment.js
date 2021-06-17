function sendComment(id, element) {
    var content = element.parentElement.parentElement.children[0].value;

    var data = new FormData();
    data.append("content", content);
    data.append("id", id); // This is the post id

    var xhr = new XMLHttpRequest();
    xhr.open("POST", "/comment");

    xhr.onreadystatechange = function () {
       if (xhr.readyState === 4) {
          console.log(xhr.status);
          console.log(xhr.responseText);
       }
    };

    xhr.send(data);


    window.location.reload();
}