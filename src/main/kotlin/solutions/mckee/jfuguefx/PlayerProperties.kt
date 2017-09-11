package solutions.mckee.jfuguefx

import tornadofx.getProperty
import tornadofx.property

class PlayerProperties {
    var staccato by property<String>()
    fun staccatoProperty() = getProperty(PlayerProperties::staccato)

    var tempo by property(120)
    fun tempoProperty() = getProperty(PlayerProperties::tempo)
}
