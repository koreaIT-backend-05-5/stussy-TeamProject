const menuLi = document.querySelectorAll('.category');
const subbox = document.querySelector('.subbox');

menuLi[0].onmouseover = () => {
    subbox.classList.remove("subbox-visible");
}
subbox.onmouseleave = () => {
    subbox.classList.add("subbox-visible");
}