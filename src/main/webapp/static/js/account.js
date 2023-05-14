function validPassword() {
    let password = $("#password").text();

    const sqlRegex = /[\\"'%;()&+/*=<>]/;
    return !sqlRegex.test(password);
}

function validateInformation() { return 3; }


$(document).ready(function() {

});