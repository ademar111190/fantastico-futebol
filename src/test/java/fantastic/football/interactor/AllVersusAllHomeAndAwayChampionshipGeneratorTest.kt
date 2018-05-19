package fantastic.football.interactor

import fantastic.football.model.FutureMatch
import fantastic.football.model.Team
import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations.initMocks

class AllVersusAllHomeAndAwayChampionshipGeneratorTest {

    @Mock private lateinit var mockTeam1: Team
    @Mock private lateinit var mockTeam2: Team
    @Mock private lateinit var mockTeam3: Team
    @Mock private lateinit var mockTeam4: Team
    @Mock private lateinit var mockTeam5: Team
    @Mock private lateinit var mockTeam6: Team

    @Before
    fun setUp() {
        initMocks(this)
    }

    @Test
    fun testAllVersusAllHomeAndAway_empty() {
        val championship = AllVersusAllHomeAndAwayChampionshipGenerator().generate(NAME, listOf())
        assertThat(championship.name).isEqualTo(NAME)
        assertThat(championship.teams).isEmpty()
        assertThat(championship.matches).isEmpty()
        assertThat(championship.futureMatches).isEmpty()
    }

    @Test
    fun testAllVersusAllHomeAndAway_1Team() {
        val championship = AllVersusAllHomeAndAwayChampionshipGenerator().generate(NAME, listOf(mockTeam1))
        assertThat(championship.name).isEqualTo(NAME)
        assertThat(championship.teams).containsExactly(mockTeam1)
        assertThat(championship.matches).isEmpty()
        assertThat(championship.futureMatches).isEmpty()
    }

    @Test
    fun testAllVersusAllHomeAndAway_2Teams() {
        val championship = AllVersusAllHomeAndAwayChampionshipGenerator().generate(NAME, listOf(mockTeam1, mockTeam2))
        assertThat(championship.name).isEqualTo(NAME)
        assertThat(championship.teams).containsExactly(mockTeam1, mockTeam2)
        assertThat(championship.matches).isEmpty()
        assertThat(championship.futureMatches).containsExactly(
            FutureMatch(mockTeam1, mockTeam2),
            FutureMatch(mockTeam2, mockTeam1))
    }

    @Test
    fun testAllVersusAllHomeAndAway_3Teams() {
        val championship = AllVersusAllHomeAndAwayChampionshipGenerator().generate(NAME, listOf(mockTeam1, mockTeam2, mockTeam3))
        assertThat(championship.name).isEqualTo(NAME)
        assertThat(championship.teams).containsExactly(mockTeam1, mockTeam2, mockTeam3)
        assertThat(championship.matches).isEmpty()
        assertThat(championship.futureMatches).containsExactly(
            FutureMatch(mockTeam2, mockTeam3),
            FutureMatch(mockTeam1, mockTeam3),
            FutureMatch(mockTeam1, mockTeam2),
            FutureMatch(mockTeam3, mockTeam2),
            FutureMatch(mockTeam3, mockTeam1),
            FutureMatch(mockTeam2, mockTeam1))
    }

    @Test
    fun testAllVersusAllHomeAndAway_4Teams() {
        val championship = AllVersusAllHomeAndAwayChampionshipGenerator().generate(NAME, listOf(mockTeam1, mockTeam2, mockTeam3, mockTeam4))
        assertThat(championship.name).isEqualTo(NAME)
        assertThat(championship.teams).containsExactly(mockTeam1, mockTeam2, mockTeam3, mockTeam4)
        assertThat(championship.matches).isEmpty()
        assertThat(championship.futureMatches).containsExactly(
            FutureMatch(mockTeam1, mockTeam4),
            FutureMatch(mockTeam2, mockTeam3),
            FutureMatch(mockTeam1, mockTeam3),
            FutureMatch(mockTeam4, mockTeam2),
            FutureMatch(mockTeam1, mockTeam2),
            FutureMatch(mockTeam3, mockTeam4),
            FutureMatch(mockTeam4, mockTeam1),
            FutureMatch(mockTeam3, mockTeam2),
            FutureMatch(mockTeam3, mockTeam1),
            FutureMatch(mockTeam2, mockTeam4),
            FutureMatch(mockTeam2, mockTeam1),
            FutureMatch(mockTeam4, mockTeam3))
    }

    @Test
    fun testAllVersusAllHomeAndAway_5Teams() {
        val championship = AllVersusAllHomeAndAwayChampionshipGenerator().generate(NAME, listOf(mockTeam1, mockTeam2, mockTeam3, mockTeam4, mockTeam5))
        assertThat(championship.name).isEqualTo(NAME)
        assertThat(championship.teams).containsExactly(mockTeam1, mockTeam2, mockTeam3, mockTeam4, mockTeam5)
        assertThat(championship.matches).isEmpty()
        assertThat(championship.futureMatches).containsExactly(
            FutureMatch(mockTeam2, mockTeam5),
            FutureMatch(mockTeam3, mockTeam4),
            FutureMatch(mockTeam1, mockTeam5),
            FutureMatch(mockTeam2, mockTeam3),
            FutureMatch(mockTeam1, mockTeam4),
            FutureMatch(mockTeam5, mockTeam3),
            FutureMatch(mockTeam1, mockTeam3),
            FutureMatch(mockTeam4, mockTeam2),
            FutureMatch(mockTeam1, mockTeam2),
            FutureMatch(mockTeam4, mockTeam5),
            FutureMatch(mockTeam5, mockTeam2),
            FutureMatch(mockTeam4, mockTeam3),
            FutureMatch(mockTeam5, mockTeam1),
            FutureMatch(mockTeam3, mockTeam2),
            FutureMatch(mockTeam4, mockTeam1),
            FutureMatch(mockTeam3, mockTeam5),
            FutureMatch(mockTeam3, mockTeam1),
            FutureMatch(mockTeam2, mockTeam4),
            FutureMatch(mockTeam2, mockTeam1),
            FutureMatch(mockTeam5, mockTeam4))
    }

    @Test
    fun testAllVersusAllHomeAndAway_6Teams() {
        val championship = AllVersusAllHomeAndAwayChampionshipGenerator().generate(NAME, listOf(mockTeam1, mockTeam2, mockTeam3, mockTeam4, mockTeam5, mockTeam6))
        assertThat(championship.name).isEqualTo(NAME)
        assertThat(championship.teams).containsExactly(mockTeam1, mockTeam2, mockTeam3, mockTeam4, mockTeam5, mockTeam6)
        assertThat(championship.matches).isEmpty()
        assertThat(championship.futureMatches).containsExactly(
            FutureMatch(mockTeam1, mockTeam6),
            FutureMatch(mockTeam2, mockTeam5),
            FutureMatch(mockTeam3, mockTeam4),
            FutureMatch(mockTeam1, mockTeam5),
            FutureMatch(mockTeam6, mockTeam4),
            FutureMatch(mockTeam2, mockTeam3),
            FutureMatch(mockTeam1, mockTeam4),
            FutureMatch(mockTeam5, mockTeam3),
            FutureMatch(mockTeam6, mockTeam2),
            FutureMatch(mockTeam1, mockTeam3),
            FutureMatch(mockTeam4, mockTeam2),
            FutureMatch(mockTeam5, mockTeam6),
            FutureMatch(mockTeam1, mockTeam2),
            FutureMatch(mockTeam3, mockTeam6),
            FutureMatch(mockTeam4, mockTeam5),
            FutureMatch(mockTeam6, mockTeam1),
            FutureMatch(mockTeam5, mockTeam2),
            FutureMatch(mockTeam4, mockTeam3),
            FutureMatch(mockTeam5, mockTeam1),
            FutureMatch(mockTeam4, mockTeam6),
            FutureMatch(mockTeam3, mockTeam2),
            FutureMatch(mockTeam4, mockTeam1),
            FutureMatch(mockTeam3, mockTeam5),
            FutureMatch(mockTeam2, mockTeam6),
            FutureMatch(mockTeam3, mockTeam1),
            FutureMatch(mockTeam2, mockTeam4),
            FutureMatch(mockTeam6, mockTeam5),
            FutureMatch(mockTeam2, mockTeam1),
            FutureMatch(mockTeam6, mockTeam3),
            FutureMatch(mockTeam5, mockTeam4))
    }

}

private const val NAME = "A Championship Name"
