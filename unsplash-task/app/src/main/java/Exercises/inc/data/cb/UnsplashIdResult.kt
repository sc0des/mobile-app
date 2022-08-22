package Exercises.inc.data.cb

import Exercises.inc.model.UnsplashSearch


interface UnsplashIdResult {

    fun onDataFetchedSuccessId(images: UnsplashSearch)

    fun onDataFetchedFailedId()
}