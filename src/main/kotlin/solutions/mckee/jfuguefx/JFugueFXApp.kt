package solutions.mckee.jfuguefx

import javafx.application.Application
import tornadofx.App
import tornadofx.importStylesheet

class JFugueFXApp : App() {
    override val primaryView = JFugueFXForm::class

    init {
        importStylesheet(Styles::class)
    }
}

fun main(args: Array<String>) {
    Application.launch(JFugueFXApp::class.java, *args)
}
