document.addEventListener('DOMContentLoaded', () => {
    document.querySelector('.search-but').addEventListener('click', function(event) {
        event.preventDefault();
        submitForm();
    });

    document.querySelector('.clear-but').addEventListener('click', function(event) {
        event.preventDefault();
        document.querySelector('#search-water-tax-id').reset();
        document.getElementById('search-results').innerHTML = '';
    });
});

function submitForm() {
    const form = document.getElementById('search-water-tax-id');
    const formData = new FormData(form);

    const waterId = formData.get('water_id');
    const ward = formData.get('Ward');
    const zone = formData.get('Zone');
    const username = formData.get('Username');
    const mobileNo = formData.get('mobile_no');
    const oldConId = formData.get('old_con_id');
    const address = formData.get('address');

    const queryParams = new URLSearchParams();

    if (waterId) queryParams.append('water_id', waterId);
    if (ward) queryParams.append('Ward', ward);
    if (zone) queryParams.append('Zone', zone);
    if (username) queryParams.append('Username', username);
    if (mobileNo) queryParams.append('mobile_no', mobileNo);
    if (oldConId) queryParams.append('old_con_id', oldConId);
    if (address) queryParams.append('address', address);

    if (!queryParams.toString()) {
        document.getElementById('search-results').innerHTML = '<p class="error">Please enter at least one search criterion.</p>';
        return;
    }

    console.log('Searching with params:', queryParams.toString()); // For debugging purposes

    fetch(`http://localhost:8080/api/dataconfig/search?${queryParams.toString()}`, {
        method: 'GET',
        headers: {
            'Content-Type': 'application/json'
        }
    })
    .then(response => {
        if (!response.ok) {
            throw new Error('Network response was not ok');
        }
        return response.json();
    })
    .then(data => {
        console.log('Search results:', data);
        displayResults(data); // Call the function to display the results
    })
    .catch(error => {
        console.error('Error:', error);
        document.getElementById('search-results').innerHTML = '<p class="error">An error occurred while searching. Please try again.</p>';
    });
}

function displayResults(data) {
    const resultsDiv = document.getElementById('search-results');
    resultsDiv.innerHTML = ''; // Clear previous results

    if (data.length === 0) {
        resultsDiv.innerHTML = '<p>No results found.</p>';
    } else {
        const table = document.createElement('table');
        table.classList.add('results-table');
        const headerRow = table.insertRow();
        const headers = ['WaterId', 'Username', 'Ward', 'Zone', 'Address', 'MobileNo', 'OldConId'];

        headers.forEach(header => {
            const th = document.createElement('th');
            th.textContent = header;
            headerRow.appendChild(th);
        });

        data.forEach(item => {
            const row = table.insertRow();
            Object.values(item).forEach(value => {
                const cell = row.insertCell();
                cell.textContent = value;
            });
        });

        resultsDiv.appendChild(table);
    }
}
