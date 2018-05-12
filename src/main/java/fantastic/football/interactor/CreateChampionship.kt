package fantastic.football.interactor

import fantastic.football.model.Championship
import fantastic.football.model.FutureMatch
import fantastic.football.model.Team

class CreateChampionship {

    fun allVersusAllHomeAndAway(name: String, teams: List<Team>): Championship {
        val futureMatches = arrayListOf<FutureMatch>()
        teams.forEach { home ->
            teams.forEach { visitor ->
                if (home != visitor) {
                    futureMatches += FutureMatch(home, visitor)
                }
            }
        }
        return Championship(name, teams, futureMatches, arrayListOf())
    }

}
