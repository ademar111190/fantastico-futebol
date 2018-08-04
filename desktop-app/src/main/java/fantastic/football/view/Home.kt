package fantastic.football.view

import com.jfoenix.controls.JFXButton
import fantastic.football.ext.waitState
import fantastic.football.presenter.home.HomePresenter
import fantastic.football.presenter.home.HomeState
import fantastic.football.presenter.home.HomeView
import fantastic.football.presenter.home.StartNewGame
import javafx.fxml.FXML
import javafx.fxml.Initializable
import javafx.scene.control.Label
import javafx.scene.control.ScrollPane
import javafx.scene.layout.AnchorPane
import javafx.scene.layout.VBox
import javafx.stage.Stage
import java.net.URL
import java.util.*

class Home : HomeView, Initializable {

    private val presenter = HomePresenter()

    private lateinit var stage: Stage

    @FXML lateinit var content: AnchorPane
    @FXML lateinit var btnFirstGame: JFXButton
    @FXML lateinit var btnDelete: JFXButton
    @FXML lateinit var btnLoad: JFXButton
    @FXML lateinit var btnNew: JFXButton
    @FXML lateinit var scrollPane: ScrollPane
    @FXML lateinit var emptyState: VBox
    @FXML lateinit var txtTitle: Label

    override fun initialize(location: URL?, resources: ResourceBundle?) {
        content.waitState {
            stage = it
            stage.minWidth = content.minWidth
            stage.minHeight = content.minHeight
            content.requestFocus()
            presenter.view = this
        }
    }

    fun onFirstGameClick() {
        presenter.action(StartNewGame())
    }

    fun onDeleteClick() {
        println("onDeleteClick")
    }

    fun onLoadClick() {
        println("onLoadClick")
    }

    fun onNewClick() {
        println("onNewClick")
    }

    override fun bind(state: HomeState) {
        stage.title = state.title
        txtTitle.isVisible = state.showWelcome
        txtTitle.text = state.welcome
        emptyState.isVisible = state.showCallToFirstGame
        btnFirstGame.text = state.callToFirstGame
        btnNew.isVisible = state.showNewGame
        btnNew.text = state.newGame
        btnDelete.isVisible = state.showDeleteGame
        btnDelete.text = state.deleteGame
        btnLoad.isVisible = state.showLoadGame
        btnLoad.text = state.loadGame
        scrollPane.isVisible = state.showSavedGames
        // TODO show saved games and focused game
    }

}
