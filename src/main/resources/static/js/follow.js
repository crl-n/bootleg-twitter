function followUser(currentUserId, profileUserId) {
    if (currentUserId == profileUserId) {
        alert("Error: You can't follow yourself.");
        return;
    }

    var data = new FormData();
    data.append("currentUserId", currentUserId);
    data.append("profileUserId", profileUserId);

    xhr = new XMLHttpRequest();
    xhr.open("POST", "/follow");
    xhr.onreadystatechange = function () {
       if (xhr.readyState === 4) {
              console.log(xhr.status);
              console.log(xhr.responseText);
       }
    };
    xhr.send(data);

    window.location.reload();
}