package fantastic.football.presenter.home

class HomePresenter {

    private var state: HomeState = INITIAL

    var view: HomeView? = null
        set(value) {
            value?.bind(state)
            field = value
        }

    fun action(action: HomeAction) {
        when (action) {
            is StartNewGame -> {
                state = state.newGame()
                view?.bind(state)
            }
        }
    }

}
