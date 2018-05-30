package fantastic.football

import fantastic.football.interactor.AllVersusAllHomeAndAwayChampionshipGenerator
import fantastic.football.interactor.GetTeams
import fantastic.football.interactor.PlayMatch
import fantastic.football.model.Round

fun main(args: Array<String>) {
    val playMatch = PlayMatch()

    GetTeams().byLocation().forEach { location, teams ->
        println("Starting ${location.name}")
        val estadual = AllVersusAllHomeAndAwayChampionshipGenerator().generate(location.name, teams)
        while (!estadual.completed()) {
            val nextRound = estadual.nextRound()
            println("to play [${nextRound.futureMatches().map { "${it.home.name} x ${it.visitor.name}" }}]")
            val finishedRound = Round(nextRound.futureMatches().map {
                val match = playMatch.execute(it)
                println("result ${match.home.name} ${match.homeScore} X ${match.visitorScore} ${match.visitor.name}")
                match
            })
            estadual.swapRound(nextRound, finishedRound)
            println("Actual $estadual")
        }
        println("Finished ${location.name}")
    }

    val brasileirao = AllVersusAllHomeAndAwayChampionshipGenerator().generate("Brasileirão", GetTeams().all())
    println("Starting $brasileirao")
    while (!brasileirao.completed()) {
        val nextRound = brasileirao.nextRound()
        println("to play [${nextRound.futureMatches().map { "${it.home.name} x ${it.visitor.name}" }}]")
        val finishedRound = Round(nextRound.futureMatches().map {
            val match = playMatch.execute(it)
            println("result ${match.home.name} ${match.homeScore} X ${match.visitorScore} ${match.visitor.name}")
            match
        })
        brasileirao.swapRound(nextRound, finishedRound)
        println("Actual $brasileirao")
    }
    println("Finished $brasileirao")
}
