# Popular Movies (Stage I)

Created as a part of Udacity's [Android Developer Nanodegree Program](https://in.udacity.com/course/android-developer-nanodegree-by-google--nd801) by Google

## Project Overview
Most of us can relate to kicking back on the couch and enjoying a movie with friends and family. In this project, I built an app to allow users to discover the most popular movies playing. We will split the development of this app in two stages.

In this stage (Stage-I) I built the core experience of my movies app.

## My app does/have the following:

- Presents the user with a grid arrangement of movie posters upon launch.
- Allows user to change sort order via a setting:
- The sort order can be by most popular or by highest-rated
- Allows the user to tap on a movie poster and transition to a details screen with additional - information such as:
- original title
- movie poster image thumbnail
- A plot synopsis (called overview in the api)
- user rating (called vote_average in the api)
- release date

## Why this Project?
An Android Developer must know how to bring particular mobile experiences to life. Specifically, they need to know how to build clean and compelling user interfaces (UIs), fetch data from network services, and optimize the experience for various mobile devices. This project was aimed at honing this skill

My aim to build this app was to demonstrate my understanding of the foundational elements of programming for Android. Your app will communicate with the Internet and provide a responsive and delightful user experience.

## Rubric
(This project had to meet all rubric requirements in order to get accepted.)

   - **Common Project Requirements**

     - MEETS SPECIFICATIONS
        
        - [x] App is written solely in the Java Programming Language.
        - [x] Movies are displayed in the main layout via a grid of their corresponding movie poster thumbnails.
        - [x] UI contains an element (i.e a spinner or settings menu) to toggle the sort order of the movies by: most popular, highest rated.
        - [x] UI contains a screen for displaying the details for a selected movie.
        - [x] Movie details layout contains title, release date, movie poster, vote average, and plot synopsis.

   - **User Interface - Function**

     - MEETS SPECIFICATIONS

        - [x] When a user changes the sort criteria (“most popular and highest rated”) the main view gets updated correctly.

        - [x] When a movie poster thumbnail is selected, the movie details screen is launched.

   - **Network API Implementation**

     - MEETS SPECIFICATIONS
        
        - [x] In a background thread, app queries the /movie/popular or /movie/top_rated API for the sort criteria specified in the settings menu.

   - **General Project Guidelines**

     - MEETS SPECIFICATIONS
     
        - [x] App conforms to common standards found in the Android Nanodegree General Project Guidelines (NOTE: For Stage 1 of the Popular Movies App, it is okay if the app does not restore the data using onSaveInstanceState/onRestoreInstanceState)