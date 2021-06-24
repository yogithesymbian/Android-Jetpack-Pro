package id.scodeid.yorebahanmovie.utils

import android.annotation.SuppressLint
import android.content.Context
import id.scodeid.yorebahanmovie.data.source.remote.response.*
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException

class JsonHelper(private val context: Context) {

    private fun parsingFileToString(fileName: String): String? {
        return try {
            val `is` = context.assets.open(fileName)
            val buffer = ByteArray(`is`.available())
            `is`.read(buffer)
            `is`.close()
            String(buffer)

        } catch (ex: IOException) {
            ex.printStackTrace()
            null
        }
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    fun loadMovies(): List<MovieResponse> {
        val list = ArrayList<MovieResponse>()
        try {
            val responseObject = JSONObject(parsingFileToString("MovieResponses.json").toString())
            val listArray = responseObject.getJSONArray("movies")
            for (i in 0 until listArray.length()) {
                val listArr = listArray.getJSONObject(i)

                val movieId = listArr.getString("movieId")
                val bookmarked = listArr.getBoolean("bookmarked")

                val imgFullStr = listArr.getString("imgPath")
                val imgName = imgFullStr.split(".").toTypedArray()[2]
                val imgPathId =
                    context.resources.getIdentifier(imgName, "drawable", context.packageName)

                val title = listArr.getString("title")
                val rating = listArr.getString("rating")
                val date = listArr.getString("date")
                val genre = listArr.getString("genre")
                val videoTime = listArr.getString("videoTime")
                val description = listArr.getString("description")
                val cuanValue = listArr.getString("cuanValue")
                val videoScore = listArr.getString("videoScore")
                val status = listArr.getString("status")
                val director = listArr.getString("director")
                val language = listArr.getString("language")
                val budget = listArr.getString("budget")
                val income = listArr.getString("income")
                val adult = listArr.getBoolean("adult")

                val movieResponse = MovieResponse(
                    movieId, bookmarked,
                    imgPathId, title,
                    rating, date,
                    genre, videoTime,
                    description, cuanValue,
                    videoScore, status,
                    director, language,
                    budget, income,
                    adult
                )
                list.add(movieResponse)
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }

        return list
    }

    fun loadTvShow(): List<TvShowResponse> {
        val list = ArrayList<TvShowResponse>()
        try {
            val responseObject = JSONObject(parsingFileToString("TvShowResponses.json").toString())
            val listArray = responseObject.getJSONArray("tvshow")
            for (i in 0 until listArray.length()) {
                val listArr = listArray.getJSONObject(i)

                val tvShowId = listArr.getString("tvShowId")
                val bookmarked = listArr.getBoolean("bookmarked")

                val imgFullStr = listArr.getString("imgPath")
                val imgName = imgFullStr.split(".").toTypedArray()[2]
                val imgPathId =
                    context.resources.getIdentifier(imgName, "drawable", context.packageName)

                val title = listArr.getString("title")
                val rating = listArr.getString("rating")
                val date = listArr.getString("date")
                val genre = listArr.getString("genre")
                val videoTime = listArr.getString("videoTime")
                val description = listArr.getString("description")
                val cuanValue = listArr.getString("cuanValue")
                val videoScore = listArr.getString("videoScore")
                val status = listArr.getString("status")
                val creator = listArr.getString("creator")
                val language = listArr.getString("language")
                val type = listArr.getString("type")
                val adult = listArr.getBoolean("adult")

                val tvShowResponse = TvShowResponse(
                    tvShowId, bookmarked,
                    imgPathId, title,
                    rating, date,
                    genre, videoTime,
                    description, cuanValue,
                    videoScore, status,
                    creator, language,
                    type, adult,
                )
                list.add(tvShowResponse)
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }

        return list
    }
}