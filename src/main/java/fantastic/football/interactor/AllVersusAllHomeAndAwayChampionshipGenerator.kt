package fantastic.football.interactor

import fantastic.football.model.Championship
import fantastic.football.model.FutureMatch
import fantastic.football.model.Team

class AllVersusAllHomeAndAwayChampionshipGenerator : ChampionshipGenerator {

    override fun generate(name: String, teams: List<Team>): Championship {
        return Championship(name, teams, createFutureMatches(teams), arrayListOf())
    }

    private fun createFutureMatches(teams: List<Team>): MutableList<FutureMatch> {
        var teamsSize = teams.size

        if (teamsSize < 2) {
            return mutableListOf()
        }

        val mockTeam = Team("mock$this${Math.random()}")
        val futureMatches = mutableListOf<FutureMatch>()
        var j: Int
        val local = ArrayList(teams)
        if (teamsSize % 2 == 1) {
            teamsSize++
            local.add(mockTeam)
        }

        do {
            for (i in 0 until teamsSize) {
                j = teamsSize - 1 - i
                if (j <= i) {
                    break
                }
                val home = local[i]
                val visitor = local[j]
                if (home != mockTeam && visitor != mockTeam) {
                    futureMatches += FutureMatch(home, visitor)
                }
            }
            local.add(1, local.removeAt(local.size - 1))
        } while (
            if (local.contains(mockTeam)) {
                local.lastIndex != local.indexOf(mockTeam)
            } else {
                local != teams
            }
        )

        futureMatches.addAll(futureMatches.map { FutureMatch(it.visitor, it.home) })

        return futureMatches
    }

}
