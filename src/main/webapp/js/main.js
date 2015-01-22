$("document").ready(function () {

    $("#nav").addClass("js");
    $("#nav").addClass("js").before('<p id="menu">☰</p>');
    $("#menu").click(function () {
        $("#nav").toggle();
    });
    $(window).resize(function () {
        if (window.innerWidth > 1024) {
            $("#nav").removeAttr("style");
        }
    });
});