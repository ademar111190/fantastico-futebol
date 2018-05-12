package fantastic.football.model

data class Match(
    val home: Team,
    val visitor: Team,
    val homeScore: Int,
    val visitorScore: Int
)
