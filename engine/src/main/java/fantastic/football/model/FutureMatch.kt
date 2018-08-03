package fantastic.football.model

data class FutureMatch(
    override val home: Team,
    override val visitor: Team
) : Match
