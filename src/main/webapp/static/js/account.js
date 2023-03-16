function validPassword() {
    let password = $("#password").text();

    const sqlRegex = /[\\"'%;()&+/*=<>]/;
    return !sqlRegex.test(password);
}