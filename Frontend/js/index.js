
var myBtn = document.getElementById("btnLogin");
myBtn.addEventListener("click", () => changePage("tasks.html"));



function collapseBurgerMenu() {
  var x = document.getElementById("burgerMenu");
  if (x.style.display === "block") {
    x.style.display = "none";
  } else {
    x.style.display = "block";
  }
}

function changePage(page) {
  window.location = page;
}