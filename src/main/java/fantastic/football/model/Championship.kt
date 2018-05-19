package fantastic.football.model

class Championship(
    val name: String,
    val teams: List<Team>,
    val futureMatches: MutableList<FutureMatch> = mutableListOf(),
    val matches: ArrayList<Match> = arrayListOf()
) {

    fun addMatch(match: Match) {
        matches += match
        futureMatches.removeIf { it.home == match.home && it.visitor == match.visitor }
    }

    override fun toString(): String {
        val stringBuilder = StringBuilder("Campeonato: ").append(name).append('\n')
            .append("Pos").append('\t')
            .append("Teams           ").append('\t')
            .append("Fav").append('\t')
            .append("Aga").append('\t')
            .append("Bal").append('\t')
            .append("Points").append('\n')
        val points = hashMapOf<Team, Int>()
        val favorScore = hashMapOf<Team, Int>()
        val againstScore = hashMapOf<Team, Int>()
        teams.forEach { team ->
            matches.filter { it.home == team || it.visitor == team }.forEach {
                val (favor, against) = if (it.home == team) {
                    it.homeScore to it.visitorScore
                } else {
                    it.visitorScore to it.homeScore
                }
                points[team] = points.getOrDefault(team, 0) + when {
                    favor > against -> 3
                    favor == against -> 1
                    else -> 0
                }
                favorScore[team] = favorScore.getOrDefault(team, 0) + favor
                againstScore[team] = againstScore.getOrDefault(team, 0) + against
            }
        }
        teams.sortedWith(Comparator { left, right ->
            val leftScore = points.getOrDefault(left, 0)
            val rightScore = points.getOrDefault(right, 0)
            val leftFavorGoal = favorScore.getOrDefault(left, 0)
            val rightFavorGoal = favorScore.getOrDefault(right, 0)
            val leftGoalBalance = leftFavorGoal - againstScore.getOrDefault(left, 0)
            val rightGoalBalance = rightFavorGoal - againstScore.getOrDefault(right, 0)
            when {
                leftScore > rightScore -> -1
                leftScore < rightScore -> 1
                leftGoalBalance > rightGoalBalance -> -1
                leftGoalBalance < rightGoalBalance -> 1
                leftFavorGoal > rightFavorGoal -> -1
                leftFavorGoal < rightFavorGoal -> 1
                else -> 0
            }
        }).forEachIndexed { position, team ->
            val score = points.getOrDefault(team, 0)
            val favor = favorScore.getOrDefault(team, 0)
            val against = againstScore.getOrDefault(team, 0)
            val balance = favor - against
            stringBuilder.append(position + 1).append('º').append('\t')
                .append(team.name)
                .append((0..Math.max(0, 15 - team.name.length)).map { ' ' }.joinToString(separator = ""))
                .append('\t')
                .append(favor).append('\t')
                .append(against).append('\t')
                .append(balance).append('\t')
                .append(score).append('\n')
        }
        return stringBuilder.toString()
    }

}
