package com.securemessage;

import android.Manifest;
import android.content.pm.PackageManager;
import android.graphics.ImageFormat;
import android.os.Bundle;
import android.util.Log;
import android.view.TextureView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.camera.camera2.Camera2Config;
import androidx.camera.core.Camera;
import androidx.camera.core.CameraProvider;
import androidx.camera.core.Preview;
import androidx.camera.core.SurfaceProvider;
import androidx.camera.lifecycle.ProcessCameraProvider;
import androidx.camera.view.CameraView;
import androidx.core.app.ActivityCompat;

import com.google.mlkit.vision.face.Face;
import com.google.mlkit.vision.face.FaceDetection;
import com.google.mlkit.vision.face.FaceDetector;
import com.google.mlkit.vision.face.FaceDetectorOptions;
import com.google.mlkit.vision.common.InputImage;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

public class FaceVerificationActivity extends AppCompatActivity {
    private static final String TAG = "FaceVerification";
    private CameraView cameraView;
    private FaceDetector faceDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_face_verification);

        cameraView = findViewById(R.id.camera_view);
        setupCamera();
        setupFaceDetector();
    }

    private void setupCamera() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, 101);
            return;
        }

        ProcessCameraProvider cameraProvider = ProcessCameraProvider.getInstance(this);
        cameraProvider.addListener(() -> {
            try {
                bindPreview(cameraProvider.get());
            } catch (ExecutionException | InterruptedException e) {
                Log.e(TAG, "Camera binding failed", e);
            }
        }, ContextCompat.getMainExecutor(this));
    }

    private void bindPreview(@NonNull ProcessCameraProvider cameraProvider) {
        Preview preview = new Preview.Builder().build();
        preview.setSurfaceProvider(cameraView.getSurfaceProvider());

        Camera camera = cameraProvider.bindToLifecycle(this, CameraSelector.DEFAULT_FRONT_CAMERA, preview);
    }

    private void setupFaceDetector() {
        FaceDetectorOptions options = new FaceDetectorOptions.Builder()
                .setPerformanceMode(FaceDetectorOptions.PERFORMANCE_MODE_FAST)
                .setTrackingEnabled(true)
                .build();

        faceDetector = FaceDetection.getClient(options);
        startFaceDetection();
    }

    private void startFaceDetection() {
        cameraView.setBitmapProcessor(bitmap -> {
            InputImage image = InputImage.fromBitmap(bitmap, 0);
            faceDetector.process(image)
                .addOnSuccessListener(faces -> {
                    for (Face face : faces) {
                        // Handle face detection success
                        Log.d(TAG, "Face detected: " + face.getBoundingBox());
                    }
                })
                .addOnFailureListener(e -> {
                    // Handle face detection failure
                    Log.e(TAG, "Face detection failed", e);
                });
        });
    }

    @Override
    protected void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 101) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                setupCamera();
            } else {
                Toast.makeText(this, "Camera permission required", Toast.LENGTH_SHORT).show();
                finish();
            }
        }
    }
}