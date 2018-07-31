package su.petrowich.jad_d3_threescreens

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonA = findViewById<Button>(R.id.buttonA)
        val editText = findViewById<EditText>(R.id.editText)

        enableButton(editText, buttonA)

        buttonA.setOnClickListener {
            val intent = Intent(this, BActivity::class.java).apply { putExtra("TextFromA", editText.text.toString()) }
            startActivity(intent)
        }

        editText.addTextChangedListener(object : TextWatcher { //в интернетах пишут только про такой способ проверки изменения текстового поля
            //ещё я видел способ, при котором не нужно переопрелять сразу все методы TextWatcherа, но я так и не понял, как его прикрутить в моём случае
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                enableButton(editText, buttonA)
            }

            override fun afterTextChanged(s: Editable) {
            }
        })
    }

    fun enableButton(editText: EditText, button: Button) {

        button.isEnabled = editText.text.isNotEmpty()

        if (button.isEnabled)
            button.setTextColor(android.graphics.Color.RED)
        else
            button.setTextColor(android.graphics.Color.GRAY)
    }
}
