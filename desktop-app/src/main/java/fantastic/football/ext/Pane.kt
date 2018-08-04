package fantastic.football.ext

import javafx.beans.value.ChangeListener
import javafx.beans.value.ObservableValue
import javafx.scene.Scene
import javafx.scene.layout.Pane
import javafx.stage.Stage
import javafx.stage.Window

fun Pane.waitState(listener: (Stage) -> Unit) {
    sceneProperty().addListener(object : ChangeListener<Scene> {
        override fun changed(observable: ObservableValue<out Scene>?, oldScene: Scene?, newScene: Scene?) {
            if (oldScene == null && newScene != null) {
                newScene.windowProperty().addListener(object : ChangeListener<Window> {
                    override fun changed(observable: ObservableValue<out Window>?, oldWindow: Window?, newWindow: Window?) {
                        if (oldWindow == null && newWindow != null) {
                            listener(newWindow as Stage)
                            newScene.windowProperty().removeListener(this)
                        }
                    }
                })
                sceneProperty().removeListener(this)
            }
        }
    })
}
