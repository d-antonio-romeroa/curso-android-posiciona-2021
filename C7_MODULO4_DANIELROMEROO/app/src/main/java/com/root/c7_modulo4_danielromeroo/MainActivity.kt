package com.root.c7_modulo4_danielromeroo

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import androidx.appcompat.app.AlertDialog
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.net.URL
import com.root.c7_modulo4_danielromeroo.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

val CORROUTINE_TAG = "Corroutine"

class MainActivity : AppCompatActivity() {
    private lateinit var enlace: ActivityMainBinding
    private lateinit var listaURLs: List<String>
    private lateinit var listaBarraProgreso: List<ProgressBar>
    private lateinit var listaVistas: List<ImageView>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enlace = ActivityMainBinding.inflate(layoutInflater)
//        setContentView(R.layout.activity_main)
        setContentView(enlace.root)

        cargarImagenes()
        iniciarBarraProgreso()
        iniciarVistaImagenes()

        enlace.btnMSG.setOnClickListener {
            AlertDialog
                .Builder(this)
                .setMessage("Si ve este mensaje es pq están funcionando las corrutinas en segundo plano.")
                .setCancelable(true)
                .show()
        }

        CoroutineScope(Dispatchers.Main).launch{
            for (i in listaURLs.indices){
                val imagen = doInBackground(listaURLs[i], listaBarraProgreso[i])
                Log.d(CORROUTINE_TAG, imagen.toString())

                if(imagen != null){
                    actualizarVista(imagen, listaBarraProgreso[i],  listaVistas[i])
                }

            }
        }
    }

    private fun cargarImagenes() {
        listaURLs = listOf<String>(
            "https://www.thoughtco.com/thmb/ckvm3YnmBofyuG_WdEpPuT3dIwM=/2131x1199/smart/filters:no_upscale()/betelgeuse-star-987396640-afd328ff2f774d769c56ed59ca336eb4.jpg",
            "https://estaticos.muyinteresante.es/media/cache/1140x_thumb/uploads/images/article/60a8cff75cafe8bfa22f8041/vialactea-fusion_0.jpg",
            "https://services.meteored.com/img/article/300-millones-de-planetas-potencialmente-habitables-en-la-via-lactea-289541-2_1024.jpg",
            "https://www.timeforkids.com/wp-content/uploads/2021/01/K1_CMS_0129_1.jpg"
        )

    }

    private fun iniciarBarraProgreso(){
        listaBarraProgreso = listOf(enlace.p1, enlace.p2, enlace.p3, enlace.p4)
    }

    private fun iniciarVistaImagenes(){
        listaVistas = listOf(enlace.i1, enlace.i2, enlace.i3, enlace.i4)
    }

    private suspend fun doInBackground(url: String, progressBar: ProgressBar): Bitmap {
        lateinit var bmp : Bitmap
        withContext(Dispatchers.Default) {
            try {
                progressBar.visibility = View.VISIBLE
                val nuevaURL = URL(url)
                val inputStream = nuevaURL.openConnection().getInputStream()

                Log.d(CORROUTINE_TAG, inputStream.toString())

                bmp = BitmapFactory.decodeStream(inputStream)
            } catch (e: Exception) {
                Log.d(CORROUTINE_TAG, e.message.toString())
                e.printStackTrace()
            }
        }
        return bmp
    }

    private fun actualizarVista(imagen: Bitmap, barraProgreso: ProgressBar, vistaImagen: ImageView){
        Log.d(CORROUTINE_TAG, "Se ha actualizado la vista")
        barraProgreso.visibility = View.GONE
        vistaImagen.setImageBitmap(imagen)
    }
}