package id.scodeid.yorebahanmovie.data.source.local.entity

data class MovieEntity(
    var movieId: String,
    var bookmarked: Boolean = false,
    var imgPath: Int,
    var title: String,

    var rating: String,
    var date: String,
    var genre: String,
    var videoTime: String,

    var description: String,
    var cuanValue: String,
    var videoScore: String,
    var status: String,
    var director: String,

    var language: String,
    var budget: String,
    var income: String,
    var adult: Boolean = false,
)