package com.example.musicbox

import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.musicbox.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = DataBindingUtil.setContentView(this,
        R.layout.activity_main)


    var playButton = binding.playButton

        playButton.setOnClickListener {
            createSongText()
       }
    }

    /**
     * diese Funktion gibt den Wert des ausgewählten RadioButtons zurück
     **/
    fun getGenreFromRadios(): Int {
    var genre = binding.musicTypeRadio.checkedRadioButtonId
        return genre
    }

    /**
     * diese Funktion gibt den Wert des Sliders zurück
     **/
    fun getSongLength(): Float {
    var songLength = binding.songTextSlider.value
        return songLength
    }


    /**
     * Diese Funktion liest die EditText Felder aus und gibt den Wert zurück
     **/
    fun getStringFromInput(editViewId: Int): String {
        // TODO speichere die Texteingabe des InputFelds in einer Variable
        //  und gib diese im return Statement zurück
        //  nutze hierfür die .text des Inputfelds (vergiss nicht .toString())
        var str = findViewById<EditText>(tvId).text.toString()
        return str
    }

    /**
     * Diese Funktion  führt Verse und Refrain zusammen und wiederholt je nach songLength
     **/
    fun createSongString(genreVerse: String, genreChorus: String, songLength: Int): String {
        //TODO Füge Verse und Refrain zusammen und wiederhole den Songtext (songLength) - mal
        // mittels .repeat(ANZAHL) kann ein String wiederholt werden

        // TODO speichere einen zusammengesetzten String in einer Variable und gib dies
        //  im return Statement zurück
        //  der String setzt sich wie folgt zusammen (verse + chorus.repeat(3)).repeat(length)
        //  mittels .repeat(Int) lässt sich ein String wiederholen

        return ((genreVerse) + genreChorus.repeat(3)).repeat(songLength)
    }


    /**
     * diese Funktion führ die vorher implementierten Funktionen aus, um die Infos asuzulesen und zusammenzuführen
     * Außerdem wird der erstellte songString in der entsprechenden View dargestellt
     **/
    fun createSongText() {
        var t1 = getStringFromInput(R.id.firstText)
        var t2 = getStringFromInput(R.id.secondText)
        var t3 = getStringFromInput(R.id.thirdText)
        var genre = getGenreFromRadios()
        var songLength = getSongLength()
        var songString: String = ""
        var sV = findViewById<TextView>(R.id.song_text_tv)
        sV.SetmovementMethod(ScrollingMovementMethod))
        var songVerse: String = ""
        var songChorus: String = ""

        when (genre){
            R.id.radio_rap-> {
            songVerse = getString(R.string.rap_verse, t1, t2, t3)
                    songChorus = getString(R.string.rap_chorus)
        }
        R.id.radio_pop -> {
            songVerse = getString(R.string.pop_verse, t1, t2, t3)
            songChorus = getString(R.string.pop_chorus)
        }
        R.id.radio_volk -> {
            songVerse = getString(R.string.volk_verse, t1, t2)
            songChorus = getString(R.string.volk_chorus, t3)
        }
        else -> {
            songVerse = getString(R.string.genre_error)
        }
    }
    songString = createSongString(songVerse, songChorus, songLength.toInt())
    sV.text = songString
}
        }

        // TODO Lese die Textfelder aus und speichere die Strings in  Variablen

        // TODO Lese das Genre aus speichere den String in einer Variable
        //  (getGenreFromRadios())

        // TODO Lese die Songlänge aus speichere den Integer in einer Variable
        //  (getSongLength())

        // TODO speichere je nach Genre die richtigen Strings in Variablen für verse und chorus
        //  erstelle hierfür eine when Bedingung und lade je nach RadioButtonId die richtigen Strings mittels getString(STRINGID)



        //TODO nun kannst du createSongString mit verse, chorus und length füttern und das
        // Ergebniss in einer Variable speichern
        // createSongString()


        // TODO zu guter letzt setze die .text deiner Ausgabe TextView auf den den SongString


        // nutzte <TextView>.setMovementMethod(ScrollingMovementMethod()), um TextView scrollable zu machen
        // Achtung: im Layout  muss folgendes in der Textview enthalten sein
        //        android:scaleType="fitXY"
        //        android:scrollbars="vertical"

    }
}
