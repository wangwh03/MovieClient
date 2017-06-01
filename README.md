# Project 4 - *GMovie*

**GMovie** is an android app that allows a user to view current movies. The app utilizes [Movie REST API](https://developers.themoviedb.org/3).

Time spent: **12** hours spent in total

## User Stories

The following **required** functionality is completed:

User Stories:

The following user stories are completed:

* User can view a list of movies (title, poster image, and overview) currently playing in theaters from the Movie Database API. (5 points)
* Lists should be fully optimized for performance using the ViewHolder pattern to cache view lookups within the adapter. (2 points)
* Views should be responsive for both landscape/portrait mode. (3 points)
* In portrait mode, the poster image, title, and movie overview is shown.
* In landscape mode, the rotated alternate layout should use the backdrop image instead and show the title and movie overview to the right of it.

The following advanced user stories are completed:

* Display a nice default placeholder graphic for each image during loading (read more about Picasso) (1 point)
* Improve the user interface through styling and coloring (1 to 5 points depending on the difficulty of UI improvements)
* For popular movies (i.e. a movie voted for more than 5 stars), the full backdrop image is displayed. Otherwise, a poster image, the movie title, and overview is listed. Use Heterogenous ListViews and use different ViewHolder layout files for popular movies and less popular ones. (2 points)

## Video Walkthrough

Here's a walkthrough of implemented user stories:

<img src='movie.gif' title='Video Walkthrough' width='' alt='Video Walkthrough' />
<img src='movie_landscape.gif' title='Video Walkthrough' width='' alt='Video Walkthrough' />

GIF created with [LiceCap](http://www.cockos.com/licecap/).

## Open-source libraries used

- [Android Async HTTP](https://github.com/loopj/android-async-http) - Simple asynchronous HTTP requests with JSON parsing
- [Picasso](http://square.github.io/picasso/) - Image loading and caching library for Android

## License

    Copyright [2017] [Weihua Wang]

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.

