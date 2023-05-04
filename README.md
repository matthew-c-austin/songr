# songr
Code Fellows 401 Labs 11 - 15

## Instructions

- Build from the command line inside the `songr` directory with `./gradlew bootRun`
  - Set up a Postgres server with a database named "songr" and a table called "album".
  - The `src/main/resources/application.properties` file contains user/name password resources change these to match your Postgres server username and password.

### Root Route

While the app is running direct your web browser to [localhost:8080](http://localhost:8080). This will load the homepage for Songr. Follow the links at the top for home/albums/songs.

### Albums

The Album link in the top navigation points to the [/albums](http://localhost:8080/albums) route.

#### Album Details

Each album in the "albums" route links to an album details page that lists album details including songs. This route uses the album's ID to build the details page.

- Clicking album details will bring out a form for adding new songs to the database and linking them to the specific album allowing them to display on the details page.
- Adding songs overwrites the album total length to be a sum of all the songs added to the album.


### Songs

Each song in the database will be displayed in a table at [/songs](http://localhost:8080/songs)

## Early Testing Routes

- The [/hello](http://localhost:8080/hello) route will conduct a "Hello World".
  - If text is added after the address e.g. "localhost:8080/hello/name" then the page will conditionally render either "Hello World!" or "Hello name!" depending on whether text was supplied or not.
  - Added integration testing for this route with MockMVC.
- The [/capitalize](http://localhost:8080/capitalize/test) route will capitalize the text after the route name in the addess (the link shows "TEST").
  - Added integration testing for this route with MockMVC.



