
function myFunction() {
    var small_menu = document.getElementById("small_menu");
    var navBar = document.getElementById("navBar");
    var img_menu = document.getElementById("img_menu");


    if (small_menu.style.display === "flex") {
        small_menu.style.display = "none";
        navBar.style.backgroundColor = "rgba(0,0,0,0.02)";
        img_menu.src="images/img_mob_menu_false.svg";
    } else {
        small_menu.style.display = "flex";
        navBar.style.backgroundColor = "#5E5E5E";
        img_menu.src="images/img_mob_menu_true.svg";
    }
}
