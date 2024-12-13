// Show toast message on success
$(document).ready(function () {
    const toastMessage = document.getElementById('toastMessage');
    if (toastMessage && toastMessage.getAttribute('data-message')) {
        const message = toastMessage.getAttribute('data-message');
        $('#toastMessage .toast-body').text(message);
        $('#toastMessage').toast({ delay: 3000 });
        $('#toastMessage').toast('show');
    }
});
