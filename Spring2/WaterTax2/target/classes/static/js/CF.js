document.getElementById('complaint-form').addEventListener('submit', function(e) {
    e.preventDefault();
    alert('Complaint submitted successfully!');
    // Add logic to handle form submission, e.g., sending data to the server
});

document.getElementById('feedback-form').addEventListener('submit', function(e) {
    e.preventDefault();
    alert('Feedback submitted successfully!');
    // Add logic to handle form submission, e.g., sending data to the server
});

document.getElementById('track-form').addEventListener('submit', function(e) {
    e.preventDefault();
    const statusDiv = document.getElementById('complaint-status');
    statusDiv.innerHTML = 'Your complaint is currently being processed.'; // Update this line to display real status
});

document.addEventListener('DOMContentLoaded', function () {
    const fileInputs = document.querySelectorAll('input[type="file"]');

    fileInputs.forEach((input) => {
        input.addEventListener('change', function () {
            const tickMark = this.nextElementSibling;
            if (this.files.length > 0) {
                tickMark.style.display = 'inline-block';
            } else {
                tickMark.style.display = 'none';
            }
        });
    });
});
