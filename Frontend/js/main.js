function collapseBurgerMenu() {
    var x = document.getElementById("burgerMenu");
    if (x.style.display === "block") {
      x.style.display = "none";
    } else {
      x.style.display = "block";
    }
  }