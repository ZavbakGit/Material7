package `fun`.gladkikh.material7.bottomactivity

import `fun`.gladkikh.material7.R
import `fun`.gladkikh.material7.tabactivity.Fragment1
import `fun`.gladkikh.material7.tabactivity.Fragment2
import `fun`.gladkikh.material7.tabactivity.Fragment3
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_bottom.*

class BottomActivity : AppCompatActivity() {


    private val onNavigationItemSelectedListener =
        BottomNavigationView.OnNavigationItemSelectedListener { item ->

            when (item.itemId) {
                R.id.fragment1 -> {
                    replaseFragment(item.itemId)
                    return@OnNavigationItemSelectedListener true
                }
                R.id.fragment2 -> {
                    replaseFragment(item.itemId)
                    return@OnNavigationItemSelectedListener true
                }
                R.id.fragment3 -> {
                    replaseFragment(item.itemId)
                    return@OnNavigationItemSelectedListener true
                }
            }

            true
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom)
        bottomNavigationView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)
        replaseFragment(R.id.fragment1)
    }

    private fun replaseFragment(itemId: Int) {
        val tag = itemId.toString()
        val fragment = supportFragmentManager.findFragmentByTag(tag) ?: when (itemId) {
            R.id.fragment1 -> {
                Fragment1()
            }
            R.id.fragment2 -> {
                Fragment2()
            }
            R.id.fragment3 -> {
                Fragment3()
            }
            else -> {
                null
            }
        }
        if (fragment != null) {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragmentContainer, fragment, tag)
                .commit()
        }
    }
}
