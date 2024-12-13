document.querySelectorAll('.explore-btn').forEach(button => {
    button.addEventListener('click', function () {
        const card = this.closest('.card');
        const content = card.getAttribute('data-content');
        
        // Display the modal
        const modal = document.getElementById('modal');
        const modalText = document.getElementById('modalText');
        modalText.textContent = content;
        modal.style.display = 'flex';
    });
});

// Close modal
document.getElementById('closeBtn').addEventListener('click', function () {
    document.getElementById('modal').style.display = 'none';
});

// Close modal on clicking outside
window.addEventListener('click', function (event) {
    const modal = document.getElementById('modal');
    if (event.target === modal) {
        modal.style.display = 'none';
    }
});
