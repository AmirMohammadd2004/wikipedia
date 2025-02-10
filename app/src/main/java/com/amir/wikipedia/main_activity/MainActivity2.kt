package com.amir.wikipedia.main_activity

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.amir.wikipedia.R
import com.amir.wikipedia.databinding.ActivityMain2Binding
import com.amir.wikipedia.dataclass.DataClassExplore
import com.amir.wikipedia.dataclass.DataClassTrend
import com.amir.wikipedia.fragment.key_intent_Trend
import com.amir.wikipedia.fragment.key_intent_explor
import com.bumptech.glide.Glide


class MainActivity2 : AppCompatActivity() {
    lateinit var binding: ActivityMain2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        setSupportActionBar(binding.toolbarMain)



        binding.collapsingMain.setExpandedTitleColor(ContextCompat.
        getColor(this , android.R.color.transparent))


        supportActionBar!!.setHomeButtonEnabled(true)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)





        val data_intent_explor = intent.getParcelableExtra<DataClassExplore>(key_intent_explor)

        val data_intent_trend = intent.getParcelableExtra<DataClassTrend>(key_intent_Trend)


        if( data_intent_trend != null){

            show_data_trend(data_intent_trend)

        }

        if ( data_intent_explor != null ){

            show_data_explor(data_intent_explor)
        }


        binding.fabMain2.setOnClickListener {

            val url = "https://fa.wikipedia.org/wiki/%D8%B5%D9%81%D8%AD%D9%87%D9%94_%D8%A7%D8%B5%D9%84%DB%8C"


            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(intent)
        }

    }


    fun show_data_explor(dataClassExplore: DataClassExplore){


        Glide.with(this)
            .load(dataClassExplore.url_img)
            .into(binding.imagMain2)

        binding.textTitleMain2.text = dataClassExplore.text_title
        binding.textSubtitleMain2.text = dataClassExplore.text_subtitle
        binding.textDetailMain2.text = dataClassExplore.text_detail
    }


    fun show_data_trend (dataClassTrend: DataClassTrend){

        Glide.with(this)
            .load(dataClassTrend.imgurl)
            .into(binding.imagMain2)

        binding.textTitleMain2.text = dataClassTrend.textsubject
        binding.textSubtitleMain2.text = dataClassTrend.text_textsubject
        binding.textDetailMain2.text = dataClassTrend.text_main
    }







    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home)
        {
            onBackPressed()
        }

        return true
    }

}