function openImage(imageId) {
    alert('this works' + imageId);
}

function openFullScreenImage(src) {
    document.getElementById('overlay-image').src = src;
    document.getElementById("overlay-screen").style.width = "100%";

}

function closeFullScreenImage() {
    document.getElementById("overlay-screen").style.width = "0%";
}