package su.petrowich.jad_d3_threescreens

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class CActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_c)

        val extra = intent.extras

        val textView = findViewById<TextView>(R.id.textView)

        textView.text = extra.getString("TextFromA")
    }
}
