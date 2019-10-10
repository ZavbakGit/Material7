package `fun`.gladkikh.material7.tabactivity

import `fun`.gladkikh.material7.R
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.toolbar
import kotlinx.android.synthetic.main.activity_tab.*

class TabActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tab)
        setSupportActionBar(toolbar)

        val adapter = MyFragmentAdapter(supportFragmentManager)
        adapter.addFragment(Fragment1(), "Фрагмент 1")
        adapter.addFragment(Fragment2(), "Фрагмент 2")
        adapter.addFragment(Fragment3(), "Фрагмент 3")
        viewPager.adapter = adapter

        tabLayout.setupWithViewPager(viewPager)
    }


    class MyFragmentAdapter(fragmentManager: FragmentManager) : FragmentPagerAdapter(
        fragmentManager,
        BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT
    ) {
        private val fragments = LinkedHashMap<Fragment, String>()

        override fun getItem(position: Int): Fragment {
            return fragments.keys.elementAt(position)
        }

        override fun getCount(): Int {
            return fragments.keys.size
        }

        fun addFragment(fragment: Fragment, title: String) {
            fragments[fragment] = title
        }

        override fun getPageTitle(position: Int): CharSequence {
            return fragments.values.elementAt(position)
        }
    }
}
