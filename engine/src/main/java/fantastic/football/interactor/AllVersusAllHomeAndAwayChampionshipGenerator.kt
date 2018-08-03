package fantastic.football.interactor

import fantastic.football.model.*

class AllVersusAllHomeAndAwayChampionshipGenerator : ChampionshipGenerator {

    override fun generate(name: String, teams: List<Team>): Championship {
        return Championship(name, teams, createRounds(teams))
    }

    private fun createRounds(teams: List<Team>): MutableList<Round> {
        var teamsSize = teams.size

        if (teamsSize < 2) {
            return mutableListOf()
        }

        val mockTeam = Team("mock$this${Math.random()}", Location("mock$this${Math.random()}"))
        val rounds = mutableListOf<Round>()
        var j: Int
        val local = ArrayList(teams)
        if (teamsSize % 2 == 1) {
            teamsSize++
            local.add(mockTeam)
        }

        do {
            val matches = mutableListOf<Match>()
            for (i in 0 until teamsSize) {
                j = teamsSize - 1 - i
                if (j <= i) {
                    break
                }
                val home = local[i]
                val visitor = local[j]
                if (home != mockTeam && visitor != mockTeam) {
                    matches += FutureMatch(home, visitor)
                }
            }
            rounds.add(Round(matches))
            local.add(1, local.removeAt(local.size - 1))
        } while (
            if (local.contains(mockTeam)) {
                local.lastIndex != local.indexOf(mockTeam)
            } else {
                local != teams
            }
        )

        rounds.addAll(rounds.map { Round(it.matches.map { FutureMatch(it.visitor, it.home) }) })

        return rounds
    }

}
