function openFullScreenImage(src, description) {
    document.getElementById('overlay-image').src = src;
    document.getElementById('overlay-description').innerHTML = description;
    document.getElementById("overlay-screen").style.width = "100%";
}

function closeFullScreenImage() {
    document.getElementById("overlay-screen").style.width = "0%";
}

function uploadPicture(currentUserId) {
    var form = document.getElementById("upload-form");
    document.getElementById("upload-user-id").value = currentUserId;
    form.submit();
}

function setAsProfilePicture() {
    alert("it works");
}

function getImage(id) {
    alert(id);
}

// FUNCTIONS FOR PICTURES' LIKE BUTTON

// Change like button color to red if the user already likes the picture.
function redLikeButton(currentUserId, pictureId, thisElement) {
    var data = new FormData();
    data.append("currentUserId", currentUserId);
    data.append("pictureId", pictureId);

    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function () {
        if (xhr.readyState === 4) {
             console.log(xhr.status);
             console.log(xhr.responseText);
             let json = JSON.parse(xhr.responseText);
             alert(json.status);
             if (json.status) {
                 let id = thisElement.id;
                 alert(id);
                 document.getElementById(id).style.color = "red";
             }
        }
    };
    xhr.open("POST", "/picture-liked");
    xhr.send(data);
}

// This function is called when the user clicks the like-button
function likePictureButtonClick(currentUserId, pictureId) {
    // Check if like already exists, remove the like if it does exist
    var data = new FormData();
    data.append("currentUserId", currentUserId);
    data.append("pictureId", pictureId);

    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function () {
        if (xhr.readyState === 4) {
                console.log(xhr.status);
                console.log(xhr.responseText);
                let json = JSON.parse(xhr.responseText);
                if (json.status) {
                    removeLike(currentUserId, pictureId);
                    window.location.reload();
                } else {
                    likePicture(currentUserId, pictureId);
                    window.location.reload();
                }
        }
    };
    xhr.open("POST", "/picture-liked");
    xhr.send(data);
}

function removeLike(currentUserId, pictureId) {
    var data = new FormData();
        data.append("currentUserId", currentUserId);
        data.append("pictureId", pictureId);

        var xhr = new XMLHttpRequest();
        xhr.open("POST", "/unlike-picture")
        xhr.onreadystatechange = function () {
        if (xhr.readyState === 4) {
               console.log(xhr.status);
               console.log(xhr.responseText);
            }
        };
        xhr.send(data);
}

function likePicture(currentUserId, pictureId) {
    // Create form to send with xhr
    var data = new FormData();
        data.append("currentUserId", currentUserId);
        data.append("pictureId", pictureId);

    // Create xhr
    var xhr = new XMLHttpRequest();
    xhr.open("POST", "/like-picture");
    xhr.onreadystatechange = function () {
        if (xhr.readyState === 4) {
           console.log(xhr.status);
           console.log(xhr.responseText);
        }
    };
    xhr.send(data);
}

