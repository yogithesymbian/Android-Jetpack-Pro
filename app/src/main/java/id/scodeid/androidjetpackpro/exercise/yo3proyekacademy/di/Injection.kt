package id.scodeid.androidjetpackpro.exercise.yo3proyekacademy.di

import android.content.Context
import id.scodeid.androidjetpackpro.exercise.yo3proyekacademy.data.AcademyRepository
import id.scodeid.androidjetpackpro.exercise.yo3proyekacademy.data.source.local.LocalDataSource
import id.scodeid.androidjetpackpro.exercise.yo3proyekacademy.data.source.local.room.AcademyDatabase
import id.scodeid.androidjetpackpro.exercise.yo3proyekacademy.data.source.remote.RemoteDataSource
import id.scodeid.androidjetpackpro.exercise.yo3proyekacademy.utils.AppExecutors
import id.scodeid.androidjetpackpro.exercise.yo3proyekacademy.utils.JsonHelper

object Injection {
    fun provideRepository(context: Context): AcademyRepository {
        val database = AcademyDatabase.getInstance(context)

        val remoteDataSource = RemoteDataSource.getInstance(JsonHelper(context))

        val localDataSource = LocalDataSource.getInstance(database.academyDao())
        val appExecutors = AppExecutors()

        return AcademyRepository.getInstance(remoteDataSource, localDataSource, appExecutors)
    }
}