# Simple web-service 

---

Hello and welcome. This is primitive implementation of web-service in scala. 
It just returns a current date for a GET-method in /date endpoint.
Plain and simple.

---

### Tech-stack:
- scala 2.13.5
- akka-http
- docker
- scala-logging
- logback-classic

### Plugins:
- hairyfotr linter 
- scalastyle 
- sbt-assembly 

---

Usage:
  Terminal =>   sbt assembly
                docker build -t _namespace_ .
                docker run -p 8080:8080 --name _namespace2_ _namespace_ 

Route: http://0.0.0.0:8080/date
