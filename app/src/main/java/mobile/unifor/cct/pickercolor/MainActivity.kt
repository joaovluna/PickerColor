package mobile.unifor.cct.pickercolor

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.SeekBar
import android.widget.TextView

class MainActivity : AppCompatActivity(), SeekBar.OnSeekBarChangeListener {
    //receita de bolo
    private lateinit var mColorShow: View
    private lateinit var mColorShowRed:View
    private lateinit var mColorShowGreen:View
    private lateinit var mColorShowBlue:View

    private lateinit var mChooseColorRed: SeekBar
    private lateinit var mChooseColorBlue:SeekBar
    private lateinit var mChooseColorGreen:SeekBar

    private lateinit var mColorHex:TextView
    private lateinit var mColorDecRed:TextView
    private lateinit var mColorDecGreen:TextView
    private lateinit var mColorDecBlue:TextView
    private var red:Int = 0
    private var green =0
    private var blue=0
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mColorShow = findViewById(R.id.main_view_showcolor) //R é uma classe do android studio para dizer que estou manipulando algo q esta na pasta res
        mColorShowRed = findViewById(R.id.main_view_red)
        mColorShowGreen = findViewById(R.id.main_view_green)
        mColorShowBlue = findViewById(R.id.main_view_blue)

        mChooseColorRed = findViewById(R.id.main_seekBar_red)
        mChooseColorGreen = findViewById(R.id.main_seekBar_green)
        mChooseColorBlue = findViewById(R.id.main_seekBar_blue)

        mColorHex = findViewById(R.id.main_textView_colorhex)
        mColorDecRed = findViewById(R.id.main_textView_reddec)
        mColorDecGreen = findViewById(R.id.main_textView_greendec)
        mColorDecBlue = findViewById(R.id.main_textView_bluedec)

        mChooseColorRed.setOnSeekBarChangeListener(this)
        mChooseColorGreen.setOnSeekBarChangeListener(this)
        mChooseColorBlue.setOnSeekBarChangeListener(this)

    }

    override fun onProgressChanged(seekbar: SeekBar?, progress: Int, isUser: Boolean) { //pegar pela id

        "#000000".also { mColorHex.text = it }
        when(seekbar?.id){
            R.id.main_seekBar_red -> {
                changeRed(progress)
            }
            R.id.main_seekBar_green -> {
                changeGreen(progress)
            }
            R.id.main_seekBar_blue -> {
                changeBlue(progress)
            }
        }

//
        mColorShow.setBackgroundColor(Color.rgb(red,green,blue))

        textHexaCode()
    }

    private fun textHexaCode() {
        var hexValueRed = red.toString(16).uppercase()
        var hexValueGreen = green.toString(16).uppercase()
        var hexValueBlue = blue.toString(16).uppercase()
        if (hexValueRed.length == 1) {
            hexValueRed = "0$hexValueRed"
        }
        if (hexValueGreen.length == 1) {
            hexValueGreen = "0$hexValueGreen"
        }
        if (hexValueBlue.length == 1) {
            hexValueBlue = "0$hexValueBlue"
        }
        "#$hexValueRed$hexValueGreen$hexValueBlue".also {
            mColorHex.text = it
        } //mostrar o valor em hexadecimal da cor
    }

    private fun changeBlue(progress: Int) {
        blue = progress
        mColorShowBlue.setBackgroundColor(Color.rgb(0, 0, blue))
        mColorDecBlue.text = blue.toString()
        Log.i("App", "O valor do seekbar é $blue azul")
    }

    private fun changeGreen(progress: Int) {
        green = progress
        mColorShowGreen.setBackgroundColor(Color.rgb(0, green, 0))
        mColorDecGreen.text = green.toString()
        Log.i("App", "O valor do seekbar é $green verde")
    }

    private fun changeRed(progress: Int) {
        red = progress
        mColorShowRed.setBackgroundColor(Color.rgb(red, 0, 0))
        mColorDecRed.text = red.toString()
        Log.i("App", "O valor do seekbar é $red vermelho")
    }

    override fun onStartTrackingTouch(seekbar: SeekBar?) {
        Log.i("App","O usuário pressionou no seekbar")
    }

    override fun onStopTrackingTouch(seekbar: SeekBar?) {
        Log.i("App","O usuário parou de pressionar no seekbar")
    }
}