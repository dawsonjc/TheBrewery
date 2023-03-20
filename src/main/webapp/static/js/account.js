function validPassword() {
    let password = $("#password").text();

    const sqlRegex = /[\\"'%;()&+/*=<>]/;
    return !sqlRegex.test(password);
}

function validateInformation() {

}

$(document).ready(function() {

});