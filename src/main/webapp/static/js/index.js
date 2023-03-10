// JQUERY DEPENDENT SCRIPT
$(document).ready(function() {
    $("#beer-button").click(function() {
        console.log("beer");
    });
    $("#wine-button").click(function() {
        console.log("wine");
    });
    $("#whiskey-button").click(function() {
        console.log("whiskey");
    });

    $('[data-toggle="popover"]').popover({
        container: 'body',
        trigger: 'click'
    });
    $('.dropdown').on('hidden.bs.dropdown', function () {
        $('[data-toggle="popover"]').popover('hide');
    });
});
