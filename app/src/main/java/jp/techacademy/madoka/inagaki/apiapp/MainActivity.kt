package jp.techacademy.madoka.inagaki.apiapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private  val viewPagerAdapter by lazy{ViewPagerAdapter(this)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //viewpager2初期化
        viewPager2.apply{
            adapter = viewPagerAdapter
            orientation = ViewPager2.ORIENTATION_HORIZONTAL
            offscreenPageLimit =viewPagerAdapter.itemCount //保持する画面数
        }

        //tablayout初期化してviewpager2と紐づけ　textを指定
        TabLayoutMediator(tabLayout, viewPager2){ tab, position ->
            tab.setText(viewPagerAdapter.titleIds[position])
        }.attach()
    }
}