package com.amir.wikipedia.main_activity

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.amir.wikipedia.R
import com.amir.wikipedia.databinding.ActivityMainBinding
import com.amir.wikipedia.fragment.Fragment_Explore
import com.amir.wikipedia.fragment.Fragment_Photographer
import com.amir.wikipedia.fragment.Fragment_Profile
import com.amir.wikipedia.fragment.Fragment_Trend
import com.google.android.material.snackbar.Snackbar
import taimoor.sultani.sweetalert2.Sweetalert

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setSupportActionBar(binding.ToolBarMain)

        val actionBarDrawerToggle = ActionBarDrawerToggle(
            this,
            binding.drawerlayoutMain,
            binding.ToolBarMain,
            R.string.open_drawer,
            R.string.close_drawer
        )
        binding.drawerlayoutMain.addDrawerListener(actionBarDrawerToggle)
        actionBarDrawerToggle.syncState()


        binding.navigationviewMain.setNavigationItemSelectedListener {

            binding.navigationviewMain.menu.getItem(1).isChecked = false


            when (it.itemId) {
                R.id.menu_writer -> {
                    binding.drawerlayoutMain.closeDrawers()

                    val sweetalert = Sweetalert(this, Sweetalert.SUCCESS_TYPE)

                    sweetalert.cancelText = "cancel"
                    sweetalert.showConfirmButton(true)
                    sweetalert.confirmText = "yeah"
                    sweetalert.titleText = " hello"
                    sweetalert.contentText = "be a writer ?  "
                    sweetalert.setCancelClickListener {
                        sweetalert.dismiss()
                    }


                    sweetalert.setConfirmClickListener {
                        sweetalert.dismiss()
                        Toast.makeText(this, "If you try, you will become a writer", Toast.LENGTH_SHORT).show()
                    }

                    sweetalert.show()

                }


                R.id.menu_photograph -> {


                    val fragment = supportFragmentManager.beginTransaction()
                    fragment.add(R.id.frameLayoutMain, Fragment_Photographer())
                    fragment.addToBackStack(null)
                    fragment.commit()

                    binding.drawerlayoutMain.closeDrawers()
                }


                R.id.menu_videomarker -> {

                    Snackbar
                        .make(binding.root, " a video  crated from project ", Snackbar.LENGTH_INDEFINITE)
                        .setAction("ok ok ok ") { Toast.makeText(this, "ok press", Toast.LENGTH_SHORT).show() }

                        .setBackgroundTint(ContextCompat.getColor(this, R.color.blue))
                        .setActionTextColor(ContextCompat.getColor(this, R.color.black))
                        .setTextColor(ContextCompat.getColor(this, R.color.white))

                        .show()

                    binding.drawerlayoutMain.closeDrawers()
                }


                R.id.menu_translator -> {

                    val intent =Intent(this , MainActivity3::class.java)
                    startActivity(intent)


                }
//   <---------------------------------------------->
                R.id.menu_open_wikipedia -> {
                    val sit_wikipedia ="https://fa.wikipedia.org/wiki/%D8%B5%D9%81%D8%AD%D9%87%D9%94_%D8%A7%D8%B5%D9%84%DB%8C"
                    val open_site= Intent(Intent.ACTION_VIEW , Uri.parse(sit_wikipedia))
                    startActivity(open_site)
                }

                R.id.open_wikipedia -> {
                    val sit_wikimedia ="https://www.wikimedia.org/"
                    val open_sitee= Intent(Intent.ACTION_VIEW , Uri.parse(sit_wikimedia))
                    startActivity(open_sitee)
                }
            }

            true
        }

        firstopen()

        binding.BottomNavigationMain.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.menu_Explore -> {
                    bottomNavigationSelect(Fragment_Explore())
                }

                R.id.menu_Trend -> {
                    bottomNavigationSelect(Fragment_Trend())
                }

                R.id.menu_Profile -> {
                    bottomNavigationSelect(Fragment_Profile())
                }
            }
            true
        }
        binding.BottomNavigationMain.setOnItemReselectedListener { }
    }

    fun bottomNavigationSelect(Fragment: Fragment) {
        val fragment = supportFragmentManager.beginTransaction()
        fragment.replace(R.id.frameLayoutMain, Fragment)
        fragment.commit()
    }

    fun firstopen() {
        bottomNavigationSelect(Fragment_Explore())
        binding.BottomNavigationMain.selectedItemId = R.id.menu_Explore
    }


    override fun onBackPressed() {
        super.onBackPressed()
        binding.navigationviewMain.menu.getItem(1).isChecked = false
    }








    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main,menu)
        return true

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){

            R.id.menu_Explore ->{

            }
            R.id.menu_Profile->{

            }

        }
        return true
    }
}
