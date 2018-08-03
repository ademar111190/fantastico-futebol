package fantastic.football

import fantastic.football.interactor.AllVersusAllHomeAndAwayChampionshipGenerator
import fantastic.football.interactor.GetTeams
import fantastic.football.interactor.PlayMatch
import fantastic.football.model.Round
import javafx.fxml.FXML
import javafx.scene.control.Label

class Home {

    @FXML
    lateinit var outLabel: Label

    fun onClick() {
        outLabel.text = ""
        val playMatch = PlayMatch()

        GetTeams().byLocation().forEach { location, teams ->
            outLabel.text += "\nStarting ${location.name}"
            val estadual = AllVersusAllHomeAndAwayChampionshipGenerator().generate(location.name, teams)
            while (!estadual.completed()) {
                val nextRound = estadual.nextRound()
                outLabel.text += "\nto play [${nextRound.futureMatches().map { "${it.home.name} x ${it.visitor.name}" }}]"
                val finishedRound = Round(nextRound.futureMatches().map {
                    val match = playMatch.execute(it)
                    outLabel.text += "\nresult ${match.home.name} ${match.homeScore} X ${match.visitorScore} ${match.visitor.name}"
                    match
                })
                estadual.swapRound(nextRound, finishedRound)
                outLabel.text += "\nActual $estadual"
            }
            outLabel.text += "\nFinished ${location.name}"
        }

        val brasileirao = AllVersusAllHomeAndAwayChampionshipGenerator().generate("Brasileirão", GetTeams().all())
        outLabel.text += "\nStarting $brasileirao"
        while (!brasileirao.completed()) {
            val nextRound = brasileirao.nextRound()
            outLabel.text += "\nto play [${nextRound.futureMatches().map { "${it.home.name} x ${it.visitor.name}" }}]"
            val finishedRound = Round(nextRound.futureMatches().map {
                val match = playMatch.execute(it)
                outLabel.text += "\nresult ${match.home.name} ${match.homeScore} X ${match.visitorScore} ${match.visitor.name}"
                match
            })
            brasileirao.swapRound(nextRound, finishedRound)
            outLabel.text += "\nActual $brasileirao"
        }
        outLabel.text += "\nFinished $brasileirao"
    }

}