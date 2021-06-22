package id.scodeid.yorebahanmovie.di

import android.content.Context
import id.scodeid.yorebahanmovie.data.source.YoMovieRepository
import id.scodeid.yorebahanmovie.data.source.remote.RemoteDataSource
import id.scodeid.yorebahanmovie.utils.JsonHelper

object Injection {
    fun provideRepository(context: Context): YoMovieRepository {

        val remoteDataSource = RemoteDataSource.getInstance(JsonHelper(context))

        return YoMovieRepository.getInstance(remoteDataSource)
    }
}