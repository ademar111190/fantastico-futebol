package fantastic.football

import fantastic.football.FXML.HOME
import javafx.application.Application
import javafx.fxml.FXMLLoader
import javafx.scene.Scene
import javafx.scene.layout.AnchorPane
import javafx.stage.Stage


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
