package solutions.mckee.jfuguefx

import javafx.stage.Modality
import org.jfugue.pattern.Pattern
import org.jfugue.player.Player
import tornadofx.*

class JFugueFXForm : View() {
    override val root = Form()

    val playerProperties = PlayerProperties()

    init {
        title = "JFugue-FX"

        with(root) {
            fieldset("Song Details") {
                field("Tempo (\u2669 =)") {
                    textfield().bind(playerProperties.tempoProperty())
                }

                field("Staccato") {
                    textarea().bind(playerProperties.staccatoProperty())
                    button("?") {
                        setOnAction {
                            dialog("Staccato Reference", Modality.NONE) {
                                text("""E = E note
                                       |Eb = E Flat
                                       |G# = G Sharp
                                       |R = Rest
                                       |C3 = C in third octave; C5 is middle C; 5 is default octave
                                       |C3w = Whole note duration (${"\uD834\uDD5D"})
                                       |E4h = Half note duration (${"\uD834\uDD5E"})
                                       |A6q = Quarter note duration (${"\u2669"}); Quarter note duration is default.
                                       |G4i = Eighth note duration (${"\u266A"})
                                       |Bs = Sixteenth note duration (${"\uD834\uDD61"})
                                       |D4t = Thirty-second note duration (${"\uD834\uDD62"})
                                       |Fqq = Two quarter note duration (same as half note)
                                       |Eq. = Dotted quarter note duration (same as 'Eqs')
                                       |Rt = Thirty-second rest (all durations can be used on rests)
                                """.trimMargin())
                            }
                        }
                    }
                }
            }

            button("Play") {

                setOnAction {
                    val player = Player()
                    val pattern = Pattern(Regex("\\r?\\n").replace(playerProperties.staccato, " "))
                    pattern.setTempo(playerProperties.tempo)

                    player.play(pattern)
                }

            }
        }
    }
}
