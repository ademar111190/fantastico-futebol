package fantastic.football

import fantastic.football.interactor.AllVersusAllHomeAndAwayChampionshipGenerator
import fantastic.football.interactor.PlayMatch
import fantastic.football.model.Round
import fantastic.football.model.Team

fun main(args: Array<String>) {
    val paulista = AllVersusAllHomeAndAwayChampionshipGenerator().generate("Paulistão", listOf(
        Team("Corinthians"),
        Team("Palmeiras"),
        Team("Santos"),
        Team("São Paulo")
    ))
    val playMatch = PlayMatch()
    println("Starting $paulista")
    while (!paulista.completed()) {
        val nextRound = paulista.nextRound()
        println("to play [${nextRound.futureMatches().map { "${it.home.name} x ${it.visitor.name}" }}]")
        val finishedRound = Round(nextRound.futureMatches().map {
            val match = playMatch.execute(it)
            println("result ${match.home.name} ${match.homeScore} X ${match.visitorScore} ${match.visitor.name}")
            match
        })
        paulista.swapRound(nextRound, finishedRound)
        println("Actual $paulista")
    }
    println("Finished $paulista")
}
