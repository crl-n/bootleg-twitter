const searchBar = document.querySelector("#search-bar");

function findUserKeyUp() {
    if (event.key === 'Enter') {
        let query = document.getElementById('search-input').value;
        window.location.href = "/profiles/" + query;
    }
}

function findUserClick() {
    let query = document.getElementById('search-input').value;
    window.location.href = "/profiles/" + query;
}