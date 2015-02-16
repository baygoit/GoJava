function validateForm() {
    var x = document.article.author.value;
    var regexp = /^[A-Za-z]+$/;
    if (x == null || x == "") {
        alert("incorrect name");
        return false;
    }
    alert("Yahoo!!!!!!");
}