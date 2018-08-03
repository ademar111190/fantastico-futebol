package fantastic.football.model

data class PastMatch(
    override val home: Team,
    override val visitor: Team,
    val homeScore: Int,
    val visitorScore: Int
) : Match
