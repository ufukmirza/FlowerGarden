package com.example.flowergarden


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_flowerdetail.*

class flowerdetail : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flowerdetail)

        var bundle: Bundle? = intent.extras
        var ad=bundle?.getString("flowername")
        var photo=bundle?.getInt("flowerphoto")
        var detay=bundle?.getString("flowerdescription")

        isim.text=ad
        if (photo != null) {
            foto.setImageResource(photo)
        }

        aciklama.text=detay






    }
}