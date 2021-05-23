package id.scodeid.yorebahanmovie.entity


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
        var userScore: String,
        var status: String,
        var director: String,

        var language: String,
        var budget: String,
        var income: String,
        var adult: Boolean = false,
)