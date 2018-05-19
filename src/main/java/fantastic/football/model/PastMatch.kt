package fantastic.football.model

data class PastMatch(
    val home: Team,
    val visitor: Team,
    val homeScore: Int,
    val visitorScore: Int
)
