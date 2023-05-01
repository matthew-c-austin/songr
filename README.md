# songr
Code Fellows 401 Labs 11 - 15

# Songr

Songr is a basic Java webapp using Spring MVC, Spring Boot and Thymeleaf and built with Gradle.


## Instructions

To be added

### Root Route

While the app is running direct your web browser to [localhost:8080](http://localhost:8080). This will load the homepage for Songr. Follow the links at the top for albums.

### Albums

The Album link in the top navigation points to the [/albums](http://localhost:8080/albums) route.

- The menu button will bring out a form for adding new albums to the database and displaying on the page.

## Early Testing Routes

- The [/hello](http://localhost:8080/hello) route will conduct a "Hello World".
    - If text is added after the address e.g. "localhost:8080/hello/name" then the page will conditionally render either "Hello World!" or "Hello name!" depending on whether text was supplied or not.
    - Added integration testing for this route with MockMVC.
- The [/capitalize](http://localhost:8080/capitalize/test) route will capitalize the text after the route name in the addess (the link shows "TEST").
    - Added integration testing for this route with MockMVC.

