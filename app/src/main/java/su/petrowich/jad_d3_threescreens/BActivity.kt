package su.petrowich.jad_d3_threescreens

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class BActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_b)

        val extra = intent.extras
        val textFromA = extra.getString("TextFromA")

        val buttonB = findViewById<Button>(R.id.buttonB)
        buttonB.setOnClickListener {
            val intent = Intent(this, CActivity::class.java).apply { putExtra("TextFromA", textFromA) }
            startActivity(intent)
        }
    }
}
