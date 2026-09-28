# 📱 Practical 7 – Retrieve JSON Data and Store in SQLite Database

## 📌 Aim

**Develop an Android application that retrieves person data in JSON format from an internet API and stores the retrieved data in an SQLite database.**

This practical is developed as part of the **Mobile Application Development (MAD)** course. The application demonstrates how an Android application can retrieve data from an internet API in **JSON format**, parse the received data, and store it locally using an **SQLite database**.

---

## 🎯 Objectives

The main objectives of this practical are:

* Understand how Android applications communicate with an Internet API.
* Retrieve person data in **JSON format**.
* Parse JSON data in an Android application.
* Understand the concept of **REST API**.
* Store retrieved data in an **SQLite database**.
* Understand SQLite database operations in Android.
* Display the stored person data.
* Understand the flow of data from an API to local storage.

---

## 🛠️ Technologies Used

* **IDE:** Android Studio
* **Language:** Kotlin
* **UI:** XML
* **Platform:** Android
* **Database:** SQLite
* **Data Format:** JSON
* **API:** Internet / REST API
* **Build System:** Gradle

---

# 🌐 What is an API?

An **API (Application Programming Interface)** allows an application to communicate with another system or service and retrieve data.

In this practical, the Android application sends a request to an Internet API and receives **person data in JSON format**.

### Basic API Flow

```text
Android Application
        ↓
    Internet API
        ↓
   JSON Response
        ↓
   Parse JSON Data
        ↓
   SQLite Database
```

---

# 📄 What is JSON?

**JSON (JavaScript Object Notation)** is a lightweight data format commonly used for exchanging data between applications and servers.

Person information can be represented in JSON format such as:

```json
{
    "id": 1,
    "name": "John",
    "email": "john@example.com"
}
```

The Android application reads the JSON response and extracts the required information.

---

# 1️⃣ Retrieve Data from Internet API

The application connects to an Internet API and retrieves person information.

### Working

```text
Application
     ↓
API Request
     ↓
Internet API
     ↓
JSON Response
```

The received JSON data is then processed by the Android application.

---

# 2️⃣ Parse JSON Data

After receiving the response, the JSON data is parsed to extract individual person details.

### Working

```text
JSON Response
      ↓
JSON Parsing
      ↓
Person Details
      ↓
ID / Name / Email / Other Data
```

The extracted information can then be stored in the local database.

---

# 3️⃣ SQLite Database

**SQLite** is a lightweight relational database available in Android.

It allows applications to store data locally on the device.

In this practical, SQLite is used to store the person data retrieved from the Internet API.

### Database Flow

```text
API
 ↓
JSON Data
 ↓
JSON Parsing
 ↓
SQLite Database
 ↓
Stored Person Data
```

---

# 4️⃣ Database Operations

The application can perform basic database operations such as:

* **Create** database/table
* **Insert** person data
* **Read** stored data
* **Update** data
* **Delete** data

These operations help manage the person records stored locally.

---

# 🔄 Overall Working of Application

The complete working of the application can be represented as:

```text
User
 ↓
Android Application
 ↓
Internet API
 ↓
JSON Response
 ↓
JSON Parsing
 ↓
SQLite Database
 ↓
Person Data Stored
 ↓
Display Data
```

---

# 📱 Application Demonstration

The application demonstrates the complete process of retrieving and storing person information.

### Step 1 – Retrieve Data

```text
Android Application
        ↓
    API Request
        ↓
   JSON Response
```

### Step 2 – Parse Data

```text
JSON Response
      ↓
  JSON Parsing
      ↓
Person Information
```

### Step 3 – Store Data

```text
Person Information
       ↓
 SQLite Database
       ↓
 Stored Records
```

### Step 4 – Display Data

```text
SQLite Database
      ↓
 Read Records
      ↓
Android Application
      ↓
Display Person Data
```

---

# 🔗 API and SQLite Data Flow

The complete data flow is:

```text
        INTERNET
           │
           ↓
      REST API
           │
           ↓
     JSON Response
           │
           ↓
      JSON Parser
           │
           ↓
    Person Objects
           │
           ↓
    SQLite Database
           │
           ↓
     Stored Data
           │
           ↓
    Android UI
```

---

# 🗄️ SQLite Database

The SQLite database is used to maintain the person records locally.

### Example Table

| **Field**    | **Description**               |
| ------------ | ----------------------------- |
| ID           | Unique person identifier      |
| Name         | Person's name                 |
| Email        | Person's email address        |
| Other Fields | Additional person information |

The exact fields depend on the data returned by the API.

---

# 🔄 Difference Between API and SQLite

| **Feature**            | **Internet API**     | **SQLite Database** |
| ---------------------- | -------------------- | ------------------- |
| Location               | Internet / Server    | Local device        |
| Purpose                | Retrieve data        | Store data locally  |
| Data Source            | Remote               | Local               |
| Format                 | JSON response        | Database records    |
| Internet Required      | Yes                  | No for stored data  |
| Used in this practical | Retrieve person data | Store person data   |

---

# 📂 Project Structure

```text
24012021039_Pr_7_MAD/
│
├── app/
│   └── src/
│       └── main/
│           ├── java/
│           │   └── ...
│           │
│           ├── res/
│           │   ├── drawable/
│           │   ├── mipmap/
│           │   ├── values/
│           │   └── layout/
│           │       └── ...
│           │
│           └── AndroidManifest.xml
│
├── gradle/
├── build.gradle.kts
├── gradle.properties
├── gradlew
├── gradlew.bat
├── settings.gradle.kts
└── README.md
```

The repository contains the Android application module and standard Gradle project files.

---

# ▶️ How to Run

1. Clone the repository:

```bash
git clone https://github.com/jiyapatel02/24012021039_Pr_7_MAD.git
```

2. Open **Android Studio**.
3. Select **Open** and choose the cloned project folder.
4. Allow Gradle to sync.
5. Connect an Android device or start an Android Emulator.
6. Click the **Run ▶** button.
7. Make sure the device has an Internet connection.
8. Run the application.
9. Retrieve the person data from the API.
10. Check the retrieved data stored in the SQLite database.

---

# 🧪 Practical Testing

## Test 1 – API Data Retrieval

**Action:** Run the application and request person data.

**Expected Result:**

```text
Application
     ↓
Internet API
     ↓
JSON Response
```

The application successfully receives person data in JSON format.

---

## Test 2 – JSON Parsing

**Action:** Process the received JSON response.

**Expected Result:**

```text
JSON Response
      ↓
JSON Parsing
      ↓
Person Details
```

The JSON response is successfully converted into usable person information.

---

## Test 3 – SQLite Storage

**Action:** Store the retrieved person data.

**Expected Result:**

```text
Person Data
     ↓
SQLite Database
     ↓
Data Stored Successfully
```

The retrieved person information is stored in the SQLite database.

---

## Test 4 – Display Stored Data

**Action:** Read the stored records from SQLite.

**Expected Result:**

```text
SQLite Database
      ↓
Read Data
      ↓
Display Person Information
```

The stored person data is displayed in the application.

---

# 📚 Concepts Covered

| **No.** | **Concept**             |
| ------- | ----------------------- |
| 1       | Android Application     |
| 2       | Internet API            |
| 3       | REST API                |
| 4       | JSON                    |
| 5       | JSON Parsing            |
| 6       | SQLite Database         |
| 7       | SQLiteOpenHelper        |
| 8       | Database Operations     |
| 9       | Internet Data Retrieval |
| 10      | Local Data Storage      |

---

# 🎓 Learning Outcome

After completing this practical, we understand:

* What an Internet API is.
* How an Android application retrieves data from an API.
* What JSON is and how it is structured.
* How to parse JSON data in Android.
* How to create and use an SQLite database.
* How to insert retrieved API data into SQLite.
* How to read stored data from SQLite.
* How Internet data can be stored locally on an Android device.
* How API, JSON, and SQLite work together in an Android application.

---

# 👩‍💻 Author

**Jiya Patel**

**B.Tech – Information Technology**

**Mobile Application Development (MAD)**

---

## 🔗 GitHub Repository

[24012021039_Pr_7_MAD – GitHub Repository](https://github.com/jiyapatel02/24012021039_Pr_7_MAD)

---

## ⭐ Conclusion

This practical provides an understanding of **Internet API, JSON data, JSON parsing, and SQLite database** in Android.

By developing this application, we learn how to retrieve person data from an Internet API, process the JSON response, and store the retrieved information in an SQLite database.

The practical demonstrates the complete flow of data from a **remote API to local SQLite storage** in an Android application.
