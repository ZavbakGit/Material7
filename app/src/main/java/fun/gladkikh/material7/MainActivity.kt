package `fun`.gladkikh.material7

import `fun`.gladkikh.material7.bottomactivity.BottomActivity
import `fun`.gladkikh.material7.tabactivity.TabActivity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar)

        btTabActivity.setOnClickListener {
            startActivity(Intent(this, TabActivity::class.java))
        }

        btBottomActivity.setOnClickListener {
            startActivity(Intent(this, BottomActivity::class.java))
        }
    }
}
