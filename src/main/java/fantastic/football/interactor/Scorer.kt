package fantastic.football.interactor

import fantastic.football.model.Team
import java.util.*

class Scorer(
    private val random: Random = Random()
) {

    fun execute(attack: Team, defense: Team) = random.nextInt(10)

}
