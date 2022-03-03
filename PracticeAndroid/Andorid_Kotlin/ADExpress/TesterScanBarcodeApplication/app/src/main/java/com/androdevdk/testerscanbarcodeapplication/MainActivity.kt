package com.androdevdk.testerscanbarcodeapplication

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.google.zxing.integration.android.IntentIntegrator

class MainActivity : AppCompatActivity() {
    lateinit var scanBtn: Button
    var messageText: TextView? = null
    var messageFormat: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // referencing and initializing
        // the button and textviews
        scanBtn = findViewById(R.id.scanBtn);
        messageText = findViewById(R.id.textContent);
        messageFormat = findViewById(R.id.textFormat);

        val zxingActivityResultLauncher =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
                val intentResult = IntentIntegrator.parseActivityResult(it.resultCode, it.data)
                if (intentResult.contents != null) {
//                Toast.makeText(this, intentResult.contents, Toast.LENGTH_LONG).show()
                    if (intentResult.getContents() == null) {
                        Toast.makeText(baseContext, "Cancelled", Toast.LENGTH_SHORT).show()
                    } else {
                        // if the intentResult is not null we'll set
                        // the content and format of scan message
                        messageText?.setText(intentResult.getContents())
                        messageFormat?.setText(intentResult.getFormatName())
                    }
                }
            }
        // adding listener to the button
        scanBtn.setOnClickListener {
            val intentIntegrator = IntentIntegrator(this)
            intentIntegrator.setPrompt("Scan a barcode or QR Code") //message
            intentIntegrator.setCameraId(0) //use specific camera of device
            intentIntegrator.setOrientationLocked(false);
            intentIntegrator.setBarcodeImageEnabled(true)
//            intentIntegrator.initiateScan()
            zxingActivityResultLauncher.launch(intentIntegrator.createScanIntent())
        }
    }

    /*  override fun onActivityResult(requestCode: Int, resultCode: Int, @Nullable data: Intent?) {
          super.onActivityResult(requestCode, resultCode, data)
          val intentResult: IntentResult = IntentIntegrator.parseActivityResult(resultCode, data)
          // if the intentResult is null then
          // toast a message as "cancelled"
          if (intentResult != null) {
              if (intentResult.getContents() == null) {
                  Toast.makeText(baseContext, "Cancelled", Toast.LENGTH_SHORT).show()
              } else {
                  // if the intentResult is not null we'll set
                  // the content and format of scan message
                  messageText?.setText(intentResult.getContents())
                  messageFormat?.setText(intentResult.getFormatName())
              }
          } else {
              super.onActivityResult(requestCode, resultCode, data)
          }
      }*/
}