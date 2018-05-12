package fantastic.football.interactor

import fantastic.football.model.FutureMatch
import fantastic.football.model.Match

class PlayMatch(
    private val scorer: Scorer = Scorer()
) {

    fun execute(futureMatch: FutureMatch) = Match(
        futureMatch.home,
        futureMatch.visitor,
        scorer.execute(futureMatch.home, futureMatch.visitor),
        scorer.execute(futureMatch.visitor, futureMatch.home))

}
