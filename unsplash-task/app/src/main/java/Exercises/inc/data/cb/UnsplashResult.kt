package Exercises.inc.data.cb

import Exercises.inc.model.UnsplashItem

interface UnsplashResult {

    fun onDataFetchedSuccess(images: List<UnsplashItem>)

    fun onDataFetchedFailed()


}