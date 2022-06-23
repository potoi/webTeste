document.querySelectorAll("aside .menu li ul").forEach(ul => {

    ul.parentElement.querySelector('a').addEventListener('click', event => {
        event.preventDefault();
        ul.classList.toggle('open');
    })

});
