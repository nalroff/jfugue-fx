package solutions.mckee.jfuguefx

import tornadofx.Stylesheet
import tornadofx.box
import tornadofx.px

class Styles : Stylesheet() {

    init {
        s(form) {
            padding = box(25.px)
            prefWidth = 450.px
        }
    }
}
