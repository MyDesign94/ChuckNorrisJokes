# Chuck Norris Jokes App
<p align="center">
  <img src="https://icndb.com/wp-content/uploads/2011/01/icndb_logo2.png">
</p>

This is application that displays jokes about Chuck Noris on one screen and the WebView of the Api documentation on another.
- [Api documentation](http://www.icndb.com/api/)

## **Screen shots**

![Screens](https://github.com/MyDesign94/ChuckNorrisJokes/blob/master/ScreenShots.png)

## **Features**

- Architecture MVI
    - Data (for dto, API).
    - Domain (for use case, repositories).
    - Screens (for for UI logic, viewModels, viewStates end events)
- Dependency injection with [Hilt](https://developer.android.com/training/dependency-injection/hilt-android).
- Reactive programming with [kotlin coroutines](https://kotlinlang.org/docs/coroutines-overview.html).
- Networking with [Retrofit](https://square.github.io/retrofit/)
- [Jetpack Compose](https://developer.android.com/jetpack/compose) for UI.

## **Application architecture MVI**
<p align="center">
  <img src="https://github.com/MyDesign94/ChuckNorrisJokes/blob/master/MVI.jpg">
</p>
