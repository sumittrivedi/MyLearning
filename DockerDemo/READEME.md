# DockerDemo – Spring Boot + Docker POC

This project is a **hands-on POC** to understand how a **Spring Boot application** can be containerized using **Docker** and run successfully with a consistent Java version.

The goal of this POC is to:
- Learn Docker fundamentals
- Package and run a Spring Boot app inside a Docker container

---

## 🚀 Tech Stack

- **Java:** 25
- **Spring Boot:** 3.x
- **Build Tool:** Maven
- **Containerization:** Docker
- **Base Image:** Eclipse Temurin JDK 25

---

## Steps

1. **Create a simple Spring Boot project**
    - Add a basic REST endpoint (for example, `/hello`) to verify the application is running.

2. **Download, install, and start Docker Desktop**
    - Ensure Docker is running (Docker icon should be green).
    - Verify installation:
      ```bash
      docker --version
      ```

3. **Create a `Dockerfile` in the project root (`DockerDemo/Dockerfile`)**
    - This file defines how the Spring Boot application is packaged and executed inside a Docker container.

4. **Build the Spring Boot JAR**
    - Run the following command from the project root:
      ```bash
      mvn clean package
      ```
    - This generates the application JAR file inside the `target/` directory.

5. **Build the Docker image**
    - Run:
      ```bash
      docker build -t dockerdemo:v1 .
      ```
    - Explanation:
        - `dockerdemo` → Docker image name
        - `v1` → Image version (tag)
        - `.` → Current directory (Docker build context containing the `Dockerfile` and `target/` folder)

6. **Run the Docker container**
    - Start a container from the image:
      ```bash
      docker run -p 8080:8080 dockerdemo:v1
      ```
    - This maps port `8080` of the container to port `8080` on the host machine.

7. **Verify the application**
    - Open a browser and access:
      ```
      http://localhost:8080/hello
      ```
    - The Spring Boot application should respond successfully.

8. **View the running container**
    - The running container will be visible in Docker Desktop.
    - You can stop, restart, or view logs directly from the Docker Desktop UI.

---

### Notes
- Docker image names and versions are independent of the Spring Boot project name.
- Docker images are immutable; any code or configuration change requires building a new image version.
- The Java version used to compile the application must be compatible with the Java version used in the Docker image.


