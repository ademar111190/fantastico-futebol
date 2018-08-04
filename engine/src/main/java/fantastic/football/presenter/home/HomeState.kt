package fantastic.football.presenter.home

data class HomeState(
        val title: String,
        val showWelcome: Boolean,
        val welcome: String,
        val showCallToFirstGame: Boolean,
        val callToFirstGame: String,
        val showNewGame: Boolean,
        val newGame: String,
        val showDeleteGame: Boolean,
        val deleteGame: String,
        val showLoadGame: Boolean,
        val loadGame: String,
        val showSavedGames: Boolean,
        val savedGames: List<HomeGameItem>,
        val showFocusedGame: Boolean,
        val focusedGame: HomeGameItem?
) {

    fun newGame() = copy(
            showCallToFirstGame = false,
            showNewGame = false,
            showDeleteGame = false,
            showLoadGame = false,
            showSavedGames = false,
            showFocusedGame = false,
            focusedGame = null)

}

data class HomeGameItem(
        val name: String
)

val INITIAL = HomeState(
        "Home",
        true,
        "Fantastico Futebol!",
        true,
        "Start a new game!",
        false,
        "New",
        false,
        "Delete",
        false,
        "Load",
        false,
        emptyList(),
        false,
        null
)
