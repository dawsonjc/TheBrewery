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
        trigger: 'click',
        content: function() {
            return $("#popover-content").html();
        },
        html: true
    });
    $('.dropdown').on('hidden.bs.dropdown', function () {
        $('[data-toggle="popover"]').popover('hide');
    });
});
