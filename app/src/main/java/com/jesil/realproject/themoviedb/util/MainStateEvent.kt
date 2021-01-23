package com.jesil.realproject.themoviedb.util

sealed class MainStateEvent {
    object GetMoviesEvent : MainStateEvent()
    object None : MainStateEvent()
}