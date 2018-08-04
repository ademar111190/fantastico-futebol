package fantastic.football

import fantastic.football.ext.FXML.HOME
import fantastic.football.ext.load
import javafx.application.Application
import javafx.application.Application.launch
import javafx.fxml.FXMLLoader
import javafx.scene.Scene
import javafx.scene.layout.AnchorPane
import javafx.stage.Stage

fun main(args: Array<String>) {
    launch(App::class.java)
}

class App : Application() {

    override fun start(primaryStage: Stage) {
        primaryStage.apply {
            scene = Scene(with(FXMLLoader()) {
                location = load(HOME)
                load<AnchorPane>()
            })
            show()
        }
    }

}
