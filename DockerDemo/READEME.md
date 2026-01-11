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

## Docker Steps

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

### Notes (Docker)
- Docker image names and versions are independent of the Spring Boot project name.
- Docker images are immutable; any code or configuration change requires building a new image version.
- The Java version used to compile the application must be compatible with the Java version used in the Docker image.


## Kubernetes Steps

1. Enable Kubernetes in Docker Desktop settings.
   - Open Docker Desktop → Settings → Kubernetes
   - Enable Kubernetes and wait until it shows **Kubernetes is running**.

2. Create a `pod.yaml` file.
   - This file contains Pod details such as:
      - Docker image name
      - Container port
      - Labels (used by Service to find the Pod)

3. Create a `service.yaml` file.
   - This file contains Service details such as:
      - Target port of the Pod
      - NodePort to access the application from browser

4. Run the following commands to create Pod and Service:
   ```bash
   kubectl apply -f pod.yaml
   kubectl apply -f service.yaml

   - First command starts the Pod
   - Second command creates the Service for the Pod

5. Access the application in browser:
   http://localhost:30007/hello
   - 30007 is the NodePort defined in service.yaml
   - /hello is the Spring Boot endpoint


### Notes (Kubernetes)
1. Request flow in Kubernetes: 
   - Browser → Service → Pod → Container → App

   
      - Spring Boot App
            ↓
      - Docker Image (dockerdemo:v2)
            ↓
      - Kubernetes Pod
            ↓
      - Kubernetes Service (NodePort)
            ↓
      - Browser (localhost)

2. Useful kubectl commands:
    ```bash
   kubectl get pods
   kubectl get services
   kubectl delete pod dockerdemo-pod
   kubectl delete service dockerdemo-service
