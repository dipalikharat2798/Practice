package com.androdevdk.camerax_mvvm.fragment

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.hardware.display.DisplayManager
import android.media.MediaScannerConnection
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.MimeTypeMap
import android.widget.Toast
import androidx.camera.core.*
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.net.toFile
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.window.WindowManager
import com.androdevdk.camerax_mvvm.ApplicationClass
import com.androdevdk.camerax_mvvm.CameraXActivity
import com.androdevdk.camerax_mvvm.MainActivity
import com.androdevdk.camerax_mvvm.R
import com.androdevdk.camerax_mvvm.databinding.FragmentCameraXBinding
import java.io.File
import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class CameraXFragment : Fragment() {
    private var _fragmentCameraXBinding: FragmentCameraXBinding? = null
    private val fragmentCameraXBinding get() = _fragmentCameraXBinding!!
    lateinit var applicationClass: ApplicationClass
    private lateinit var outputDirectory: File
    private var lensFacing: Int = CameraSelector.LENS_FACING_BACK
    private var preview: Preview? = null
    private var imageCapture: ImageCapture? = null
    private var imageAnalyzer: ImageAnalysis? = null
    private var camera: Camera? = null
    private var cameraProvider: ProcessCameraProvider? = null
    private lateinit var windowManager: WindowManager
    val ANIMATION_FAST_MILLIS = 50L
    val ANIMATION_SLOW_MILLIS = 100L

    /** Blocking camera operations are performed using this executor */
    private lateinit var cameraExecutor: ExecutorService
    var zoomVal: Int = 0
    var flashVal: Int = 0
    var indexcamera: Int = -1

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _fragmentCameraXBinding = FragmentCameraXBinding.inflate(inflater, container, false)
        return fragmentCameraXBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        cameraExecutor = Executors.newSingleThreadExecutor()


        //Initialize WindowManager to retrieve display metrics
        windowManager = WindowManager(view.context)

        // Determine the output directory
        outputDirectory = MainActivity.getOutputDirectory(requireContext())

        // Wait for the views to be properly laid out
        fragmentCameraXBinding.viewFinder.post {

            // Build UI controls
            //   updateCameraUi()

            // Set up the camera and its use cases
            setUpCamera()
        }

        zoomVal = 0
        flashVal = 0

        fragmentCameraXBinding.zoomBtn.setOnClickListener() {
            zoom()
        }
        fragmentCameraXBinding.flashBtn.setOnClickListener() {
            flash_onoff()
        }
        fragmentCameraXBinding.tapToCaptureTv.setOnClickListener {
            fragmentCameraXBinding.retakeBtn.setVisibility(View.VISIBLE)
            fragmentCameraXBinding.tapToCaptureTv.setVisibility(View.GONE)
            fragmentCameraXBinding.saveAndNextBtn.setVisibility(View.VISIBLE)
            fragmentCameraXBinding.viewFinder.setVisibility(View.GONE)
            fragmentCameraXBinding.viewFinder.setVisibility(View.VISIBLE)
            if (!indexcamera.equals(-1)) {
                (activity as CameraXActivity?)?.senddatatoPhotolist(indexcamera)
            }
        }
        fragmentCameraXBinding.retakeBtn.setOnClickListener {
            fragmentCameraXBinding.retakeBtn.setVisibility(View.GONE)
            fragmentCameraXBinding.saveAndNextBtn.setVisibility(View.GONE)
            fragmentCameraXBinding.tapToCaptureTv.setVisibility(View.VISIBLE)
            fragmentCameraXBinding.tapToCaptureTv.setVisibility(View.VISIBLE)
        }
        fragmentCameraXBinding.saveAndNextBtn.setOnClickListener {
            fragmentCameraXBinding.retakeBtn.setVisibility(View.GONE)
            fragmentCameraXBinding.saveAndNextBtn.setVisibility(View.GONE)
            fragmentCameraXBinding.tapToCaptureTv.setVisibility(View.GONE)
            fragmentCameraXBinding.viewFinder.setVisibility(View.GONE)
        }
    }

    private fun takePhoto() {
        fragmentCameraXBinding.viewFinder.setOnClickListener {

            // Get a stable reference of the modifiable image capture use case
            imageCapture?.let { imageCapture ->

                // Create output file to hold the image
                val photoFile = CameraXFragment.createFile(
                    outputDirectory,
                    CameraXFragment.FILENAME,
                    CameraXFragment.PHOTO_EXTENSION
                )

                // Setup image capture metadata
                val metadata = ImageCapture.Metadata().apply {

                    // Mirror image when using the front camera
                    isReversedHorizontal = lensFacing == CameraSelector.LENS_FACING_FRONT
                }

                // Create output options object which contains file + metadata
                val outputOptions = ImageCapture.OutputFileOptions.Builder(photoFile)
                    .setMetadata(metadata)
                    .build()

                // Setup image capture listener which is triggered after photo has been taken
                imageCapture.takePicture(
                    outputOptions, cameraExecutor, object : ImageCapture.OnImageSavedCallback {
                        override fun onError(exc: ImageCaptureException) {
                            Log.e(CameraXFragment.TAG, "Photo capture failed: ${exc.message}", exc)
                        }

                        override fun onImageSaved(output: ImageCapture.OutputFileResults) {
                            val savedUri = output.savedUri ?: Uri.fromFile(photoFile)
                            Log.d(CameraXFragment.TAG, "Photo capture succeeded: $savedUri")


                            // If the folder selected is an external media directory, this is
                            // unnecessary but otherwise other apps will not be able to access our
                            // images unless we scan them using [MediaScannerConnection]
                            val mimeType = MimeTypeMap.getSingleton()
                                .getMimeTypeFromExtension(savedUri.toFile().extension)
                            MediaScannerConnection.scanFile(
                                context,
                                arrayOf(savedUri.toFile().absolutePath),
                                arrayOf(mimeType)
                            ) { _, uri ->
                                Log.d(
                                    CameraXFragment.TAG,
                                    "Image capture scanned into media store: $uri"
                                )
                            }
                        }
                    })

                // We can only change the foreground Drawable using API level 23+ API
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {

                    // Display flash animation to indicate that photo was captured
                    fragmentCameraXBinding.root.postDelayed({
                        fragmentCameraXBinding.root.foreground = ColorDrawable(Color.WHITE)
                        fragmentCameraXBinding.root.postDelayed(
                            { fragmentCameraXBinding.root.foreground = null }, ANIMATION_FAST_MILLIS
                        )
                    }, ANIMATION_SLOW_MILLIS)
                }
            }
        }
    }

    private fun setUpCamera() {
        val cameraProviderFuture = ProcessCameraProvider.getInstance(requireContext())
        cameraProviderFuture.addListener(Runnable {

            // CameraProvider
            cameraProvider = cameraProviderFuture.get()

            // Select lensFacing depending on the available cameras
            lensFacing = when {
                hasBackCamera() -> CameraSelector.LENS_FACING_BACK
                hasFrontCamera() -> CameraSelector.LENS_FACING_FRONT
                else -> throw IllegalStateException("Back and front camera are unavailable")
            }

            // Enable or disable switching between cameras
            //updateCameraSwitchButton()

            // Build and bind the camera use cases
            bindCameraUseCases()
        }, ContextCompat.getMainExecutor(requireContext().applicationContext))
    }

    private fun bindCameraUseCases() {


        // CameraProvider
        val cameraProvider = cameraProvider
            ?: throw IllegalStateException("Camera initialization failed.")

        // CameraSelector
        val cameraSelector = CameraSelector.Builder().requireLensFacing(lensFacing).build()

        // Preview
        preview = Preview.Builder()
            // We request aspect ratio but no resolution

            .build()

        // ImageCapture
        imageCapture = ImageCapture.Builder()
            .setCaptureMode(ImageCapture.CAPTURE_MODE_MINIMIZE_LATENCY)
            // We request aspect ratio but no resolution to match preview config, but letting
            // CameraX optimize for whatever specific resolution best fits our use cases
            .build()

        // ImageAnalysis
        imageAnalyzer = ImageAnalysis.Builder()
            // We request aspect ratio but no resolution
            .build()
        // The analyzer can then be assigned to the instance
//            .also {
//                it.setAnalyzer(cameraExecutor, MainActivity3.LuminosityAnalyzer { luma ->
//                    // Values returned from our analyzer are passed to the attached listener
//                    // We log image analysis results here - you should do something useful
//                    // instead!
//                    //  Log.d(TAG, "Average luminosity: $luma")
//                })
//            }

        // Must unbind the use-cases before rebinding them
        cameraProvider.unbindAll()

        try {
            // A variable number of use-cases can be passed here -
            // camera provides access to CameraControl & CameraInfo
            camera = cameraProvider.bindToLifecycle(
                this, cameraSelector, preview, imageCapture, imageAnalyzer
            )

            // Attach the viewfinder's surface provider to preview use case
            preview?.setSurfaceProvider(fragmentCameraXBinding.viewFinder.surfaceProvider)
        } catch (exc: Exception) {
            Log.e("TAG", "Use case binding failed", exc)
        }
    }

    /** Returns true if the device has an available back camera. False otherwise */
    private fun hasBackCamera(): Boolean {
        return cameraProvider?.hasCamera(CameraSelector.DEFAULT_BACK_CAMERA) ?: false
    }

    /** Returns true if the device has an available front camera. False otherwise */
    private fun hasFrontCamera(): Boolean {
        return cameraProvider?.hasCamera(CameraSelector.DEFAULT_FRONT_CAMERA) ?: false
    }

    private fun zoom() {
        if (zoomVal.equals(0)) {
            fragmentCameraXBinding.seekBar.setVisibility(View.VISIBLE)
            Toast.makeText(requireContext(), "Zoom enable", Toast.LENGTH_SHORT).show()
            zoomVal = 1
        } else {
            fragmentCameraXBinding.seekBar.setVisibility(View.GONE)
            Toast.makeText(requireContext(), "Zoom disable", Toast.LENGTH_SHORT).show()
            zoomVal = 0
        }
    }

    override fun onResume() {
        super.onResume()
        if (allPermissionsGranted()) {
            setUpCamera()
        } else {
            ActivityCompat.requestPermissions(
                requireActivity(), REQUIRED_PERMISSIONS, REQUEST_CODE_PERMISSIONS
            )
        }

    }
    private fun allPermissionsGranted() = REQUIRED_PERMISSIONS.all {
        ContextCompat.checkSelfPermission(
            requireContext(), it
        ) == PackageManager.PERMISSION_GRANTED
    }
    private fun flash_onoff() {
        if (flashVal.equals(0)) {
            fragmentCameraXBinding.flashBtn.setImageResource(R.drawable.ic_flash_on)
            Toast.makeText(requireContext(), "flash enable", Toast.LENGTH_SHORT).show()
            flashVal = 1
        } else {
            fragmentCameraXBinding.flashBtn.setImageResource(R.drawable.ic_flash_off)
            Toast.makeText(requireContext(), "Zoom disable", Toast.LENGTH_SHORT).show()
            flashVal = 0
        }
    }

    public fun setImage(index: Int) {
        applicationClass = ApplicationClass.instance
        indexcamera = index
        Toast.makeText(requireContext(), "Received in LeftFrag " + index, Toast.LENGTH_SHORT)
            .show()
        fragmentCameraXBinding.mainimageView.setImageResource(applicationClass.imageData[index].image)
        fragmentCameraXBinding.tapToCaptureTv.setVisibility(View.VISIBLE)
        fragmentCameraXBinding.viewFinder.setVisibility(View.VISIBLE)
    }


    companion object {

        private const val TAG = "CameraXBasic"
        private const val FILENAME = "yyyy-MM-dd-HH-mm-ss-SSS"
        private const val PHOTO_EXTENSION = ".jpg"
        private const val RATIO_4_3_VALUE = 4.0 / 3.0
        private const val RATIO_16_9_VALUE = 16.0 / 9.0
        private const val REQUEST_CODE_PERMISSIONS = 10
        private val REQUIRED_PERMISSIONS = arrayOf(Manifest.permission.CAMERA)
        /** Helper function used to create a timestamped file */
        private fun createFile(baseFolder: File, format: String, extension: String) =
            File(
                baseFolder, SimpleDateFormat(format, Locale.US)
                    .format(System.currentTimeMillis()) + extension
            )
    }
    override fun onRequestPermissionsResult(
        requestCode: Int, permissions: Array<String>, grantResults:
        IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == REQUEST_CODE_PERMISSIONS) {
            if (allPermissionsGranted()) {
                //  startCamera()
                setUpCamera()
            } else {
                Toast.makeText(
                    requireContext(),
                    "Permissions not granted by the user.",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
    override fun onDestroy() {
        _fragmentCameraXBinding = null
        super.onDestroy()
        cameraExecutor.shutdown()
    }
}