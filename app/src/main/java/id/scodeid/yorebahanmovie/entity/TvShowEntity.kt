package id.scodeid.yorebahanmovie.entity

data class TvShowEntity(
        var tvShowId: String,
        var bookmarked: Boolean = false,
        var imgPath: Int,
        var title: String,

        var videoPlus: String,
        var date: String,
        var genre: String,
        var videoTime: String,

        var description: String,
        var cuanValue: String,
        var rating: String,
        var status: String,
        var director: String,

        var language: String,
        var budget: String,
        var income: String,
        var adult: Boolean = false,
)
