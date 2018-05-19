package fantastic.football.model

data class Round(
    val matches: List<Match>
) {

    fun hasFutureMatch() = matches.any { it is FutureMatch }

    fun futureMatches() = matches.filter { it is FutureMatch }.map { it as FutureMatch }

    fun pastMatches() = matches.filter { it is PastMatch }.map { it as PastMatch }

}
