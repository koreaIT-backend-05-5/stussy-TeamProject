const menuLi = document.querySelector('.category');
const subbox = document.querySelector('.subbox');

menuLi.onmouseover = () => {
    subbox.style.display = "block";
}
subbox.onmouseleave = () => {
    subbox.style.display = "none";
}
