function toggleMenu() {
    const menu = document.getElementById('menu');
    if (!menu) return;
    if (menu.style.display === 'block') {
        menu.style.display = 'none';
    } else {
        menu.style.display = 'block';
    }
}

function goToComanda() {
    // Fostă pagină statică; direcționăm către lista de buchete
    window.location.href = '/buchete';
}

function gotoHome() {
    window.location.href = '/';
}

function gotoLogin() {
    window.location.href = '/login';
}

function gotoCart() {
    window.location.href = '/cart';
}

document.addEventListener('DOMContentLoaded', () => {
    const titleElement = document.querySelector('.buchet-title');
    if (titleElement) {
        const urlParams = new URLSearchParams(window.location.search);
        const titleId = urlParams.get('id');
        if (titleId) {
            const decodedTitle = decodeURIComponent(titleId);
            titleElement.textContent = decodedTitle;
        }
    }
});