package fantastic.football

import fantastic.football.interactor.CreateChampionship
import fantastic.football.interactor.PlayMatch
import fantastic.football.model.Team

fun main(args: Array<String>) {
    val paulista = CreateChampionship().allVersusAllHomeAndAway("Paulistão", listOf(
        Team("Corinthians"),
        Team("Palmeiras"),
        Team("Santos"),
        Team("São Paulo")
    ))
    val playMatch = PlayMatch()
    println("Starting $paulista")
    while (paulista.futureMatches.isNotEmpty()) {
        val futureMatch = paulista.futureMatches.first()
        println("to play $futureMatch")
        val match = playMatch.execute(futureMatch)
        println("result $match")
        paulista.addMatch(match)
        println("Actual $paulista")
    }
    println("Finished $paulista")
}
