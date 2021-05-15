# Terminator
Web Termin Planer

# Setup

  * Docker
  * Docker Compose
  * JDK >= 11
  
# How to run

  * Start backend services in `docker` folder
    * `cd docker; docker-compose up -d;`
  * Start `teminator` with gradle wrapper
    * `./gradlew bootRun` (Linux)
    * `gradlew.bat bootRun` (Windows)

# How to use

Webbrowser (case sensitive) :

http://localhost:8080/api/getRoles
http://localhost:8080/api/getTasks
http://localhost:8080/api/getUsers
http://localhost:8080/api/getNotes


