// var wrap = $("#wrap");
//
// wrap.on("scroll", function(e) {
//
//     if (this.scrollTop > 147) {
//         wrap.addClass("fix-search");
//     } else {
//         wrap.removeClass("fix-search");
//     }
//
// });



    window.onscroll = function() {myFunction()};

    var header = document.getElementById("navbar");
    var sticky = header.offsetTop;

    function myFunction() {
    if (window.pageYOffset > sticky) {
    header.classList.add("nav");
} else {
    header.classList.remove("nav");
}
}
