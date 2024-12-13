console.log('Attendance.js loaded');


document.addEventListener('DOMContentLoaded', function () {
    const calendar = document.querySelector('.calendar');
    const currentMonthEl = document.getElementById('current-month');
    const attendanceMessage = document.getElementById('attendance-message');

    let currentDate = new Date();
    let attendanceData = {}; // Store attendance details for the student

    // Fetch attendance data from the server
    function fetchAttendanceData() {
        fetch('/studentAttendanceData')
            .then(response => response.json())
            .then(data => {
                attendanceData = data.reduce((acc, record) => {
                    acc[record.date] = record.status; // Map date to status
                    return acc;
                }, {});
				console.log('Fetched attendance data:', attendanceData); // Debugging line
                renderCalendar(currentDate); // Re-render calendar with attendance data
            })
            .catch(error => console.error('Error fetching attendance data:', error));
    }

    // Function to render the calendar
    function renderCalendar(date) {
        const year = date.getFullYear();
        const month = date.getMonth();

        // Get the first day of the month and total days in the month
        const firstDay = new Date(year, month, 1).getDay();
        const totalDays = new Date(year, month + 1, 0).getDate();

        // Update the header with the current month and year
        currentMonthEl.textContent = date.toLocaleString('default', { month: 'long', year: 'numeric' });

        // Clear the existing calendar
        calendar.innerHTML = `
            <div class="day">Sun</div>
            <div class="day">Mon</div>
            <div class="day">Tue</div>
            <div class="day">Wed</div>
            <div class="day">Thu</div>
            <div class="day">Fri</div>
            <div class="day">Sat</div>
        `;

        // Add blank spaces before the first day of the month
        for (let i = 0; i < firstDay; i++) {
            const blank = document.createElement('div');
            blank.classList.add('date');
            calendar.appendChild(blank);
        }

        // Add the days of the month
        for (let day = 1; day <= totalDays; day++) {
            const dateEl = document.createElement('div');
            dateEl.classList.add('date');
            dateEl.textContent = day;

            const fullDate = `${year}-${String(month + 1).padStart(2, '0')}-${String(day).padStart(2, '0')}`;
            dateEl.dataset.date = fullDate;

            // Highlight dates with attendance
            if (attendanceData[fullDate]) {
                dateEl.classList.add(attendanceData[fullDate].toLowerCase()); // Add class like 'present', 'absent', etc.
            }

            calendar.appendChild(dateEl);

            // Attach click event for each date
			dateEl.addEventListener('click', () => {
			    console.log('Clicked date:', fullDate); // Debugging the clicked date
			    console.log('Status:', attendanceData[fullDate]); // Debugging the status for the clicked date
			    if (attendanceData[fullDate]) {
			        attendanceMessage.textContent = `Student was ${attendanceData[fullDate]} on ${fullDate}`;
			    } else {
			        attendanceMessage.textContent = `No attendance recorded for ${fullDate}`;
			    }
			});

        }
    }

    // Add event listeners for month navigation
    document.getElementById('prev-month').addEventListener('click', () => {
        currentDate.setMonth(currentDate.getMonth() - 1);
        renderCalendar(currentDate);
    });

    document.getElementById('next-month').addEventListener('click', () => {
        currentDate.setMonth(currentDate.getMonth() + 1);
        renderCalendar(currentDate);
    });

    // Fetch attendance data and render the initial calendar
    fetchAttendanceData();
});
