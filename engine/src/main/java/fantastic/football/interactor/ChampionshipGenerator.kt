package fantastic.football.interactor

import fantastic.football.model.Championship
import fantastic.football.model.Team

interface ChampionshipGenerator {

    fun generate(name: String, teams: List<Team>): Championship

}
