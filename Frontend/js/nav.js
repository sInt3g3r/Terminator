

function toggleBurgerMenu() {
    var burger = document.getElementById("mainMenu");
    console.log(burger);
    if (burger.style === "flex")
        { burger.style.display = "none"
          console.log = "1"}
    else
        { burger.style.display = "flex"
          console.log = "2"}
}