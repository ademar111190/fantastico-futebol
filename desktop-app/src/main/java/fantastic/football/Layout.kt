package fantastic.football

enum class FXML(
        val path: String
) {
    HOME("/home.fxml");
}

fun load(fxml: FXML) = App::class.java.getResource(fxml.path)
        ?: throw IllegalStateException("resource $fxml not found")
