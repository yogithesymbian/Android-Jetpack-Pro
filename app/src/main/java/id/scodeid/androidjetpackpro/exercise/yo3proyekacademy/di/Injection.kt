package id.scodeid.androidjetpackpro.exercise.yo3proyekacademy.di

import android.content.Context
import id.scodeid.androidjetpackpro.exercise.yo3proyekacademy.data.source.AcademyRepository
import id.scodeid.androidjetpackpro.exercise.yo3proyekacademy.data.source.remote.RemoteDataSource
import id.scodeid.androidjetpackpro.exercise.yo3proyekacademy.utils.JsonHelper

object Injection {
    fun provideRepository(context: Context) : AcademyRepository {
        val remoteDataSource = RemoteDataSource.getInstance(JsonHelper(context))
        return AcademyRepository.getInstance(remoteDataSource)
    }
}