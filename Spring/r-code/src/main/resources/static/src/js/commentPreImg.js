window.onload = function () {
    var files = document.querySelectorAll("input[type=file]");
    
    files[1].addEventListener("change", function (e) {
        if (this.files && this.files[1]) {
            var reader = new FileReader();
            reader.onload = function (e) {
                document.getElementById("prev").setAttribute("src", e.target.result);
            }
            reader.readAsDataURL(this.files[1]);
        }
    });
}