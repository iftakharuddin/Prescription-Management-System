## 🩺 Prescription Management System

A simple, elegant, and doctor-friendly **Prescription Management Web Application** built using **Spring Boot**, **Thymeleaf**, and **Bootstrap**.
It allows doctors to easily **create, view, edit, delete, and manage prescriptions**, as well as generate **daily reports** for record-keeping — all in a clean, intuitive interface.

---

### ✨ Features

✅ **User Authentication** – Secure signup and login pages
✅ **Prescription Management** – Create, view, edit, and delete prescriptions
✅ **Daily Report** – View day-wise prescription summary
✅ **Professional UI** – Clean, minimal, and modern doctor-inspired design
✅ **PDF Export** – Print or save prescriptions as PDF
✅ **User-based Data** – Each user sees only their own prescriptions and reports

---

### 🧰 Tech Stack

| Layer           | Technology              |
| --------------- | ----------------------- |
| Backend         | Spring Boot (Java)      |
| Frontend        | Thymeleaf + Bootstrap 5 |
| Database        | H2 (file based)         |
| Security        | Spring Security         |
| Template Engine | Thymeleaf               |
| Build Tool      | Maven                   |

---

### 🚀 Getting Started

Follow these simple steps to run the project on your local machine.

#### **1️⃣ Clone the repository**

```bash
git clone https://github.com/iftakharuddin/Prescription-Management-System.git
cd Prescription-Management-System
```

#### **2️⃣ Configure the database**

By default, the project uses **H2 Database** (file based), so you can run it instantly without setup.
If you want to use **MySQL**, open the file:

```
src/main/resources/application.properties
```

Uncomment and update the following lines:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/prescriptiondb
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update
```

Make sure MySQL is running and the database `prescriptiondb` exists.

---

#### **3️⃣ Build the project**

Use Maven to build:

```bash
mvn clean install
```

---

#### **4️⃣ Run the project**

You can run it directly using Maven or your IDE (IntelliJ / Eclipse / VS Code):

```bash
mvn spring-boot:run
```

Once started, open your browser and visit:

👉 **[http://localhost:8080](http://localhost:8080)**

---

### 👤 Default User Setup

If you’ve configured sample data or user creation logic, you can log in with a default account such as:

```
Username: admin
Password: admin
```

Otherwise, sign up for a new account from the **Sign Up** page.

---

### 📊 Features Overview

#### 🩹 Prescription Management

* Create new prescriptions with patient details (name, age, gender, diagnosis, medicines, next visit)
* Edit or delete existing prescriptions
* View prescription details in a doctor-style printable format

#### 📆 Day-wise Report

* Automatically aggregates prescription counts by date
* Filtered per logged-in user
* Option to print or download report as PDF

#### 💾 Database Tables

* `users` – stores login credentials
* `prescriptions` – stores prescription details linked to each user

---

### 🧪 Running in Development Mode

You can use **Spring Boot DevTools** for live reload support:

```bash
mvn spring-boot:run -Dspring-boot.run.profiles=dev
```

---

### 🖨️ PDF & Print Feature

* Prescriptions can be printed or downloaded as PDF using JavaScript (html2pdf.js)
* Reports can be printed directly from browser using `window.print()`

---

### 📂 Project Structure

```
prescription-app/
├── src/
│   ├── main/
│   │   ├── java/com/example/prescription/
│   │   │   ├── controller/   # Web Controllers
│   │   │   ├── service/      # Business Logic
│   │   │   ├── repository/   # Database Access
│   │   │   └── model/        # Entity Classes
│   │   └── resources/
│   │       ├── templates/    # Thymeleaf HTML Pages
│   │       └── application.properties
│   └── test/
├── pom.xml
└── README.md
```

---

### 🎨 UI Preview

| Page                           | Description                                   |
| ------------------------------ | --------------------------------------------- |
| 🏠 **Login / Signup**          | Modern, responsive design with validation     |
| 💊 **Prescription List**       | Clean data table with filters and actions     |
| 🧾 **View Prescription**       | Professional printable doctor-style layout    |
| ✏️ **Edit / New Prescription** | Consistent design with smooth inputs          |
| 📅 **Daily Report**            | Simple report table with print/export options |

---

### ⚙️ Requirements

* **Java 17+**
* **Maven 3.8+**
* (Optional) **MySQL 8+** if you prefer persistent storage

---

### 💡 Tips

* You can access the in-memory H2 console at:

  ```
  http://localhost:8080/h2-console
  ```

  (Use the JDBC URL from `application.properties`)

* To reset the DB, just restart the app (for H2) or clear MySQL tables.

---

### 🤝 Contributing

Feel free to fork this repository, open issues, or suggest UI/UX improvements!
Pull requests are warmly welcome ❤️

---

### 📜 License

This project is open-source and available under the **MIT License**.

---

### 🧑‍⚕️ Author

**Iftakhar Uddin**
Department of Computer Science & Engineering, University of Dhaka
💼 Aspiring Backend Engineer | 💬 Java | Spring Boot | Flask | PostgreSQL
