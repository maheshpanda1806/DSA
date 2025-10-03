<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Video Call Conference Form</title>
<link rel="stylesheet" href="tkp1.css">
</head>
<body>
<div class="container">
<h1>Video Connect</h1>
<form id="conferenceForm">
<label for="name">Your Name:</label>
<input type="text" id="name" required>
<label for="platform">Preferred Platform:</label>
<input type="text" id="platform" required>
<label for="topic">Meeting Topic:</label>
<input type="text" id="topic" required>
<label for="time">Preferred Time:</label>
<input type="datetime-local" id="time" required>
<label for="storageMethod">Choose Storage Method:</label>
<select id="storageMethod">
<option value="cookies">Cookies</option>
<option value="localStorage">LocalStorage</option>
<option value="sessionStorage">SessionStorage</option>
<option value="indexedDB">IndexedDB</option>
</select>
<button type="submit">Submit</button>
</form>
</div>
<script src="tkp2.js"></script>
</body>
</html>



document.getElementById('conferenceForm').addEventListener('submit', function(event) {
    event.preventDefault();
    const name = document.getElementById('name').value;
    const platform = document.getElementById('platform').value;
    const topic = document.getElementById('topic').value;
    const time = document.getElementById('time').value;
    const storageMethod = document.getElementById('storageMethod').value;

    const conferenceData = {
        name,
        platform,
        topic,
        time
    };

    switch (storageMethod) {
        case 'cookies':
            document.cookie = `conferenceData=${JSON.stringify(conferenceData)}; path=/; max-age=3600`;
            break;
        case 'localStorage':
            localStorage.setItem('conferenceData', JSON.stringify(conferenceData));
            break;
        case 'sessionStorage':
            sessionStorage.setItem('conferenceData', JSON.stringify(conferenceData));
            break;
        case 'indexedDB':
            saveToIndexedDB(conferenceData);
            break;
    }

    // Redirect to display page
    window.location.href = 'tkp3.html';
});

function saveToIndexedDB(conferenceData) {
    const request = indexedDB.open('ConferenceDatabase', 1);
    request.onupgradeneeded = function(event) {
        const db = event.target.result;
        db.createObjectStore('conferences', { keyPath: 'name' });
    };
    request.onsuccess = function(event) {
        const db = event.target.result;
        const transaction = db.transaction(['conferences'], 'readwrite');
        const store = transaction.objectStore('conferences');
        store.put(conferenceData);
    };
}



<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Conference Details</title>
<link rel="stylesheet" href="tkp1.css">
</head>
<body>
<div class="container" id="outputContainer">
<h1>Conference Details</h1>
<div id="output"></div>
</div>
<script src="tkp4.js"></script>
</body>
</html>





window.onload = function() {
    let conferenceData;
    const storageMethod = document.referrer.includes('indexedDB') ? 'indexedDB' : document.cookie
        ? 'cookies' : (localStorage.getItem('conferenceData') ? 'localStorage' : 'sessionStorage');
    switch (storageMethod) {
        case 'cookies':
            const cookies = document.cookie.split('; ').find(row => row.startsWith('conferenceData='));
            conferenceData = cookies ? JSON.parse(cookies.split('=')[1]) : null;
            break;
        case 'localStorage':
            conferenceData = JSON.parse(localStorage.getItem('conferenceData'));
            break;
        case 'sessionStorage':
            conferenceData = JSON.parse(sessionStorage.getItem('conferenceData'));
            break;
        case 'indexedDB':
            fetchFromIndexedDB();
            return; // Exit to avoid rendering null data
    }
    displayOutput(conferenceData);
};

function fetchFromIndexedDB() {
    const request = indexedDB.open('ConferenceDatabase', 1);
    request.onsuccess = function(event) {
        const db = event.target.result;
        const transaction = db.transaction(['conferences'], 'readonly');
        const store = transaction.objectStore('conferences');
        const userRequest = store.getAll();
        userRequest.onsuccess = function(event) {
            displayOutput(event.target.result[0]);
        };
    };
}

function displayOutput(conferenceData) {
    if (conferenceData) {
        const outputDiv = document.getElementById('output');
        outputDiv.innerHTML = `
            <p><strong>Name:</strong> ${conferenceData.name}</p>
            <p><strong>Preferred Platform:</strong> ${conferenceData.platform}</p>
            <p><strong>Meeting Topic:</strong> ${conferenceData.topic}</p>
            <p><strong>Preferred Time:</strong> ${conferenceData.time}</p>
        `;
    } else {
        document.getElementById('output').innerHTML = '<p>No data found.</p>';
    }
}
