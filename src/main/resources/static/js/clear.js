let btnClear = document.querySelector('button');
let inputs = document.querySelectorAll('input');
btnClear.addEventListener('click', () => {
    inputs.forEach(input => input.value = '');
});