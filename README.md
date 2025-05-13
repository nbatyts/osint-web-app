# 🕵️‍♀️ osint-web-app

**An OSINT web application built with Spring Boot** for identifying:

- 🔍 User accounts by username (GitHub, Reddit, Twitter, etc.)
- 📬 Checking email breaches using Hunter.io and custom search

---

## 🚀 Features

- Look up for user accounts across popular platforms
- Check email leaks via Hunter.io and Google search
- Combined results via (`/api/combined/verify-and-search`)
- JSON-based responses for easy integration

---

## 📦 Technologies

- Java 17+
- Spring Boot
- Hunter.io API
- Jackson (for JSON parsing)
- Apache HttpClient (for external requests)
- Swagger UI (for interactive API testing)

---

## 📲 How to Use

1. **Clone the repository:**

```bash
git clone https://github.com/<your-username>/osint-web-app.git
