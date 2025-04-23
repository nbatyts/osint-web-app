# 🕵️‍♀️ osint-web-app

**An OSINT web application built with Spring Boot** for identifying:

- 🔍 User accounts by username (GitHub, Reddit, Twitter, etc.)
- 📬 Email leaks using SerpAPI and Google Dorking techniques

---

## 🚀 Features

- Look up for user accounts across popular platforms
- Search for email leaks using SerpAPI and Google queries
- Combined user intelligence check via a single endpoint (`/api/user/full-check`)
- JSON-based responses for easy integration

---

## 📦 Technologies

- Java 17+
- Spring Boot
- SerpAPI
- Jackson (for JSON parsing)
- Apache HttpClient (for external requests)
- Swagger UI (for interactive API testing)

---

## 📲 How to Use

1. **Clone the repository:**

```bash
git clone https://github.com/<your-username>/osint-web-app.git
