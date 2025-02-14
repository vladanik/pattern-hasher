# Pattern Hasher Library

[![JitPack](https://jitpack.io/v/vladanik/pattern-hasher.svg)](https://jitpack.io/#vladanik/pattern-hasher)
[![Build Status](https://github.com/vladanik/pattern-hasher/actions/workflows/ci-cd.yml/badge.svg)](https://github.com/vladanik/pattern-hasher/actions)

A lightweight and efficient **string hashing library** using a custom character pattern.

---

## 🚀 Features

- 🔒 **Custom hashing algorithm** with pattern-based transformation
- 🎯 **Fixed-length hashed output** (configurable)
- ⚡ **Fast and lightweight**, optimized with `StringBuilder`
- 🔗 **Compatible with Java projects, Spring Boot, and microservices**
- 📦 **Published via JitPack for easy integration**
- 🌍 **No external dependencies**

---

## 📥 Installation

### **Using Gradle**
1. **Add JitPack repository** in `settings.gradle`:
```gradle
dependencyResolutionManagement {
    repositories {
        mavenCentral()
        maven { url 'https://jitpack.io' }
    }
}
```
2. **Add the dependency** in `build.gradle`:
```gradle
dependencies {
    implementation 'com.github.vladanik:pattern-hasher:1.0.0'
}
```

---

### **Using Maven**
1. **Add JitPack repository** in `pom.xml`:
```xml
<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>
```
2. **Add the dependency**:
```xml
<dependency>
    <groupId>com.github.vladanik</groupId>
    <artifactId>pattern-hasher</artifactId>
    <version>1.0.0</version>
</dependency>
```

---

## 🎯 Usage

### **1️⃣ Hashing a String**
```java
import com.ict.hasher.Hasher;

public class HashExample {
    public static void main(String[] args) {
        String input = "HelloWorld";
        String pattern = "securePattern";

        String hashed = Hasher.hash(input, pattern);
        System.out.println("Hashed Output: " + hashed);
    }
}
```

---

### **2️⃣ Comparing a Hash**
```java
boolean isMatch = Hasher.equals(storedHash, "HelloWorld", "securePattern");
System.out.println("Hash Matches: " + isMatch);
```

---

## 📌 API Reference

### **1️⃣ `Hasher` (Public API)**
A **simplified interface** for generating and comparing hashes.

| Method | Description |
|--------|------------|
| `static String hash(String input, String pattern)` | Hashes the input using a given pattern. |
| `static boolean equals(String hash, String input, String pattern)` | Compares an input string's hash with a stored hash. |

---

### **2️⃣ `HasherService` (Internal Class)**
A **low-level hashing utility** that applies a custom algorithm.

| Method | Description |
|--------|------------|
| `HasherService(String pattern)` | Initializes the hasher with a custom pattern. |
| `String hash(String input)` | Generates a hash using the defined pattern. |

📌 **Note:** This class is **package-private** and **cannot be accessed externally**.

---

### **3️⃣ `Const` (Internal Constants)**
A utility class storing **configuration constants**.

| Constant | Value | Description |
|----------|-------|-------------|
| `TEN` | `10` | Used in hash calculations. |
| `ASCII_DIFF` | `32` | ASCII transformation difference. |
| `MAX_HASH_LENGTH` | `255` | Maximum output length for hashes. |

---

## ⚡ **Spring Boot Integration**
If you're using **Spring Boot**, you can inject `Hasher` into a microservice.

### **1️⃣ Create a Hashing Service**
```java
import org.springframework.stereotype.Service;
import com.ict.hasher.Hasher;

@Service
public class HashingService {
    public String generateHash(String input, String pattern) {
        return Hasher.hash(input, pattern);
    }

    public boolean verifyHash(String hash, String input, String pattern) {
        return Hasher.equals(hash, input, pattern);
    }
}
```

### **2️⃣ Expose a REST API**
```java
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hash")
public class HashController {
    private final HashingService hashingService;

    public HashController(HashingService hashingService) {
        this.hashingService = hashingService;
    }

    @GetMapping("/generate")
    public String generateHash(@RequestParam String input, @RequestParam String pattern) {
        return hashingService.generateHash(input, pattern);
    }

    @GetMapping("/verify")
    public boolean verifyHash(@RequestParam String hash, @RequestParam String input, @RequestParam String pattern) {
        return hashingService.verifyHash(hash, input, pattern);
    }
}
```

### **3️⃣ Run and Test**
Start the Spring Boot app:
```sh
mvn spring-boot:run
```
Then test in Postman or a browser:
```
http://localhost:8080/hash/generate?input=HelloWorld&pattern=securePattern
```

---

## 🚀 Deployment to Docker & Kubernetes
To use this library inside **Docker & Kubernetes**, just include it as a dependency in your microservice.

### **Example: Dockerfile**
```dockerfile
FROM openjdk:17
WORKDIR /app
COPY target/microservice.jar microservice.jar
ENTRYPOINT ["java", "-jar", "microservice.jar"]
```
Then build and run:
```sh
docker build -t hasher-microservice .
docker run -p 8080:8080 hasher-microservice
```

---

## 👥 Contributing
Want to improve Pattern Hasher? Contributions are welcome!

### **1️⃣ Fork the repository**
Click the **"Fork"** button at the top of [GitHub](https://github.com/vladanik/pattern-hasher).

### **2️⃣ Clone your fork**
```sh
git clone https://github.com/vladanik/pattern-hasher.git
cd pattern-hasher
```

### **3️⃣ Create a feature branch**
```sh
git checkout -b feature-your-change
```

### **4️⃣ Make changes & commit**
```sh
git add .
git commit -m "Added new feature"
```

### **5️⃣ Push to GitHub & create a Pull Request**
```sh
git push origin feature-your-change
```
Then open a **Pull Request** from your fork!

---

## 🛠️ License
This project is licensed under the **MIT License**.

---

## 🌍 Stay Connected
- **GitHub:** [vladanik/pattern-hasher](https://github.com/vladanik/pattern-hasher)
- **Website:** [ICT](https://ict-udanik.vercel.app)
- **Email:** udanik@proton.me
