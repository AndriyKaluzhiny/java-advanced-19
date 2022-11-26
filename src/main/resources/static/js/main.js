function createStudent(file) {
    let firstName = $('#firstName').val();
    let lastName = $('#lastName').val();
    let age = $('#age').val();

    let studentCard = document.getElementsByClassName("studentCard");

    let formData = new FormData();

    formData.append("firstName", firstName);
    formData.append("lastName", lastName);
    formData.append("age", age);
    formData.append("file", file);

    let xhr = new XMLHttpRequest();
    xhr.open("POST", "/create");
    xhr.setRequestHeader("ContentType", "multipart/form-data");
    xhr.onload = function() {
        console.log(xhr.responseText);
        var response = JSON.parse(xhr.responseText);
        if (xhr.status == 200) {
            $("#createStudentForm").css("display", "none");
            studentCard[0].innerHTML = " <p>Name: </p><p>" + response.name + " " + response.lastName + "</p> " +
                "<p>" + "Age: " + response.age + "</p>" +
                "<p>Photo donwload url: " +
                "<p><a href='" +
                response.uri +
                "' target='_blank'>" +
                response.uri + "</a></p>";
            $('.studentCard').css("display", "flex");
            $('.studentCard').css("flex-direction", "column");
        }
    };
    xhr.send(formData);


}


$("#createStudentForm")[0].addEventListener('submit', function(event) {
    let file = document.getElementById('file').files[0];

    createStudent(file);
    event.preventDefault();
});