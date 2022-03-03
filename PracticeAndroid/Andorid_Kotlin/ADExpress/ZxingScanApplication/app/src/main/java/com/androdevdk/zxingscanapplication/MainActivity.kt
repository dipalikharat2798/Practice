package com.androdevdk.zxingscanapplication

import android.content.Intent
import android.hardware.Camera
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.zxing.client.android.Intents
import com.journeyapps.barcodescanner.ScanContract
import com.journeyapps.barcodescanner.ScanIntentResult
import com.journeyapps.barcodescanner.ScanOptions

class MainActivity : AppCompatActivity() {
    lateinit var scanBtn: Button
    var messageText: TextView? = null
    var messageFormat: TextView? = null
    private val barcodeLauncher = registerForActivityResult(ScanContract()) {
        if (it.getContents() == null) {
            val originalIntent: Intent = it.getOriginalIntent()
            if (originalIntent == null) {
                Log.d("MainActivity", "Cancelled scan")
                Toast.makeText(this@MainActivity, "Cancelled", Toast.LENGTH_LONG).show()
            } else if (originalIntent.hasExtra(Intents.Scan.MISSING_CAMERA_PERMISSION)) {
                Log.d("MainActivity", "Cancelled scan due to missing camera permission")
                Toast.makeText(
                    this@MainActivity,
                    "Cancelled due to missing camera permission",
                    Toast.LENGTH_LONG
                ).show()
            }
        } else {
            Log.d("MainActivity", "Scanned")
            Toast.makeText(
                this@MainActivity,
                "Scanned: " + it.getContents(),
                Toast.LENGTH_LONG
            ).show()
        }
    }
    /* override fun onCreate(savedInstanceState: Bundle?) {
         super.onCreate(savedInstanceState)
         setContentView(R.layout.activity_main)
         // referencing and initializing
         // the button and textviews
         scanBtn = findViewById(R.id.scanBtn);
         messageText = findViewById(R.id.textContent);
         messageFormat = findViewById(R.id.textFormat);

         // adding listener to the button
         scanBtn.setOnClickListener {
 //            val options = options(this)
 //            options.setPrompt("Scan a barcode or QR Code") //message
 //            options.setCameraId(0) //use specific camera of device
 //            options.setOrientationLocked(false);
 //            options.setBarcodeImageEnabled(true)
 //            options.initiateScan()
 //            zxingActivityResultLauncher.launch(options.createScanIntent())
 //            val options = ScanOptions()
 //            options.setPrompt("Scan a barcode or QR Code") //message
 //            options.setCameraId(0) //use specific camera of device
 //            options.setOrientationLocked(false);
 //            options.setBarcodeImageEnabled(true)
 //            bs.launch(options)
             val options = ScanOptions().setOrientationLocked(false).setCaptureActivity(
                 CustomScannerActivity::class.java
             )
             bs.launch(options)
         }
     }*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun scanBarcode(view: View?) {
        barcodeLauncher.launch(ScanOptions())
    }

    fun scanBarcodeInverted(view: View?) {
        val options = ScanOptions()
        options.addExtra(Intents.Scan.SCAN_TYPE, Intents.Scan.INVERTED_SCAN)
        barcodeLauncher.launch(options)
    }

    fun scanMixedBarcodes(view: View?) {
        val options = ScanOptions()
        options.addExtra(Intents.Scan.SCAN_TYPE, Intents.Scan.MIXED_SCAN)
        barcodeLauncher.launch(options)
    }

    fun scanBarcodeCustomLayout(view: View?) {
        val options = ScanOptions()
        options.captureActivity = AnyOrientationCaptureActivity::class.java
        options.setDesiredBarcodeFormats(ScanOptions.ONE_D_CODE_TYPES)
        options.setPrompt("Scan something")
        options.setOrientationLocked(false)
        options.setBeepEnabled(false)
        barcodeLauncher.launch(options)
    }

    fun scanPDF417(view: View?) {
        val options = ScanOptions()
        options.setDesiredBarcodeFormats(ScanOptions.PDF_417)
        options.setPrompt("Scan something")
        options.setOrientationLocked(false)
        options.setBeepEnabled(false)
        barcodeLauncher.launch(options)
    }


    fun scanBarcodeFrontCamera(view: View?) {
        val options = ScanOptions()
        options.setCameraId(Camera.CameraInfo.CAMERA_FACING_FRONT)
        barcodeLauncher.launch(options)
    }

    fun scanContinuous(view: View?) {
        val intent = Intent(this, ContinuousCaptureActivity::class.java)
        startActivity(intent)
    }

    fun scanToolbar(view: View?) {
        val options = ScanOptions().setCaptureActivity(ToolbarCaptureActivity::class.java)
        barcodeLauncher.launch(options)
    }

    fun scanCustomScanner(view: View?) {
        val options = ScanOptions().setOrientationLocked(false).setCaptureActivity(
            CustomScannerActivity::class.java
        )
        barcodeLauncher.launch(options)
    }

    fun scanMarginScanner(view: View?) {
        val options = ScanOptions()
        options.setOrientationLocked(false)
        options.captureActivity = SmallCaptureActivity::class.java
        barcodeLauncher.launch(options)
    }

    fun scanWithTimeout(view: View?) {
        val options = ScanOptions()
        options.setTimeout(8000)
        barcodeLauncher.launch(options)
    }

    fun tabs(view: View?) {
        val intent = Intent(this, TabbedScanning::class.java)
        startActivity(intent)
    }

    fun about(view: View?) {
        // LibsBuilder().start(this)
    }

    class ScanFragment : Fragment() {
        private val fragmentLauncher = registerForActivityResult(
            ScanContract()
        ) { result: ScanIntentResult ->
            if (result.contents == null) {
                Toast.makeText(context, "Cancelled from fragment", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(
                    context,
                    "Scanned from fragment: " + result.contents,
                    Toast.LENGTH_LONG
                ).show()
            }
        }

        override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {
            val view = inflater.inflate(R.layout.fragment_scan, container, false)
            val scan = view.findViewById<Button>(R.id.scan_from_fragment)
            scan.setOnClickListener { v: View? -> scanFromFragment() }
            return view
        }

        fun scanFromFragment() {
            fragmentLauncher.launch(ScanOptions())
        }
    }
}