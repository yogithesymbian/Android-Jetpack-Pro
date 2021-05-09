package id.scodeid.yorebahanmovie.entity

data class TvShowEntity(
        var tvShowId: String,
        var title: String,
        var description: String,
        var deadline: String,
        var bookmarked: Boolean = false,
        var imagePath: String
)
