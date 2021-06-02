
var burger = document.getElementById("mainMenu");
burger.style.display = "none";

function toggleBurgerMenu() {
    if (burger.style.display === "none")
        {  burger.style.display = "flex";}
    else
        { burger.style.display = "none";}
}