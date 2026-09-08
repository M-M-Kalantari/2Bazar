# 2Bazar

### Second-Hand Marketplace Platform

**2Bazar** is a full-stack second-hand marketplace platform inspired by classified advertising applications such as Divar.

The project consists of a modern **Android application** and a **Spring Boot backend**, designed with a focus on clean architecture, modularity, maintainability, security, and scalable application development.

> 🚧 **Status:** In Development

---

## 📱 Platform

* Android Application
* RESTful Backend API
* MySQL Database

---

## ✨ Features

* User registration and authentication
* JWT-based authentication
* Create and manage advertisements
* Browse advertisements
* Advertisement details
* Categories
* Search and filtering
* Product images
* Favorites
* User profile
* Communication with backend through REST API
* Local data persistence
* Secure storage of sensitive user data

---

## 🛠️ Technology Stack

### Android

* **Kotlin**
* **Jetpack Compose**
* **MVI**
* **Clean Architecture**
* **Multi-Module Architecture**
* **Kotlin Coroutines**
* **Kotlin Flow**
* **Hilt / Dependency Injection**
* **Retrofit**
* **OkHttp**
* **Room Database**
* **EncryptedSharedPreferences**

### Backend

* **Kotlin**
* **Spring Boot**
* **RESTful API**
* **Spring Security**
* **JWT**
* **JPA / Hibernate**
* **DTO**
* **Clean Architecture**
* **Use Case Pattern**

### Database

* **MySQL**
* **JPA / Hibernate**
* Relational Database Design

### Testing & Development

* **JUnit**
* **Mockito**
* **Postman**
* **Git**
* **GitHub**

---

## 🏗️ Architecture

The Android application follows **Clean Architecture** with a **Multi-Module** structure and **MVI** for predictable state and event management.

The backend is also organized around clean separation of responsibilities and use-case-driven business logic.

### High-Level Architecture

```text
┌─────────────────────────────┐
│        Android App          │
│                             │
│ Kotlin + Jetpack Compose    │
│ MVI + Clean Architecture    │
│ Multi-Module                │
└──────────────┬──────────────┘
               │
               │ REST API
               │
┌──────────────▼──────────────┐
│       Spring Boot API       │
│                             │
│ Kotlin + Spring Security    │
│ JWT + JPA                   │
└──────────────┬──────────────┘
               │
               │
┌──────────────▼──────────────┐
│           MySQL             │
└─────────────────────────────┘
```

---

## 📂 Project Structure

```text
2Bazar/
│
├── android/       # Android application
│
├── backend/       # Spring Boot backend
│
├── docs/          # Project documentation
│
├── README.md
└── .gitignore
```

---

## 🔐 Authentication & Security

The application uses a secure authentication flow based on:

* Spring Security
* JWT
* Encrypted local storage
* Secure handling of authentication data
* Protected REST endpoints

---

## 🌐 API Communication

The Android application communicates with the backend through RESTful APIs.

The networking layer uses:

* Retrofit
* OkHttp
* Kotlin Coroutines
* Flow
* JSON

API endpoints are tested and verified using **Postman**.

---

## 💾 Data Management

### Remote Data

The backend uses:

* MySQL
* JPA / Hibernate
* DTOs
* Relational database relationships

### Local Data

The Android application uses:

* Room Database
* EncryptedSharedPreferences

for local persistence and secure storage where required.

---

## 🧪 Testing

Testing is an important part of the project.

The project includes:

* Unit Testing
* Repository Testing
* Service Testing
* Mockito
* API Testing with Postman

---

## 🎯 Project Goals

The main goals of 2Bazar are:

* Building a real-world Android application
* Practicing modern Android development
* Applying Clean Architecture in a real project
* Working with Multi-Module projects
* Implementing MVI-based state management
* Building a production-style REST API
* Learning Android–Backend integration
* Implementing authentication and application security
* Working with relational databases
* Improving testing and maintainable code practices

---

## 🚀 Future Improvements

Planned improvements may include:

* Real-time chat
* Push notifications
* Advanced search and filtering
* Location-based advertisements
* Image optimization and compression
* Admin panel
* Improved caching
* More comprehensive automated testing

---

## 👨‍💻 Development

This project is being developed as a practical full-stack project to strengthen Android and backend development skills through building a real-world marketplace application.

---

## 📄 License

This project is created for educational and portfolio purposes.