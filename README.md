 Incident Tracker Backend

This is a REST API built with **Spring Boot** and **PostgreSQL** to log, track, and manage security incidents or system breaches in real-time. I built this to practice clean architecture, handle data validation, and set up a solid global error-handling system.

Key Features

* **Clean DTO Layers:** Separates the database models from what the user sees. It uses specific Request and Response objects to keep things clean and secure.
* **Global Error Handling:** If a user looks for an ID that doesn't exist or sends a bad request, the application catches it globally and returns a clear error message instead of a huge system crash.
* **Auto-Formatted Dates:** Timestamps are automatically cleaned up when data leaves the API, dropping the messy milliseconds and "T" separators so humans can actually read it (`YYYY-MM-DD HH:MM`).
* **Input Validation:** Uses validation rules to block empty titles or bad inputs before they ever reach the PostgreSQL database.


 Tools Used

* **Language:** Java 17
* **Framework:** Spring Boot 3 (Web, Data JPA)
* **Database:** PostgreSQL
* **Validation:** Jakarta Validation
* **Testing:** IntelliJ HTTP Client

 Core Endpoints

### 1. Log a New Incident
* **Route:** `POST /incidents`
* **Send this JSON:**
```json
{
  "title": "Unauthorized SSH Login Attempt",
  "severity": "HIGH",
  "status": "OPEN"
}
