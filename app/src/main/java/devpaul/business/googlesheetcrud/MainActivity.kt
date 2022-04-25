package devpaul.business.googlesheetcrud

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    var btnRead : Button ? = null
    var btnWrite : Button ? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnRead = findViewById(R.id.btn_read)
        btnWrite = findViewById(R.id.btn_write)

        btnRead?.setOnClickListener {
            val intent = Intent(this,ReadActivity::class.java)
            startActivity(intent)
        }

        btnWrite?.setOnClickListener {
            val intent = Intent(this,WriteActivity::class.java)
            startActivity(intent)
        }
    }
}