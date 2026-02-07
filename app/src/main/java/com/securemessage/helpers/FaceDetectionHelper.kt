package com.securemessage.helpers;

import android.graphics.Bitmap;
import com.google.firebase.ml.vision.FirebaseVision;
import com.google.firebase.ml.vision.face.FirebaseVisionFace;
import com.google.firebase.ml.vision.face.FirebaseVisionFaceDetector;
import com.google.firebase.ml.vision.face.FirebaseVisionFaceDetectorOptions;

import java.util.List;

public class FaceDetectionHelper {
    private FirebaseVisionFaceDetector detector;

    public FaceDetectionHelper() {
        FirebaseVisionFaceDetectorOptions options = new FirebaseVisionFaceDetectorOptions.Builder()
                .setPerformanceMode(FirebaseVisionFaceDetectorOptions.STREAM_MODE)
                .setLandmarkMode(FirebaseVisionFaceDetectorOptions.ALL_LANDMARKS)
                .setClassificationMode(FirebaseVisionFaceDetectorOptions.ALL_CLASSIFICATIONS)
                .build();
        detector = FirebaseVision.getInstance().getVisionFaceDetector(options);
    }

    public void detectFaces(Bitmap bitmap, OnFacesDetectedListener listener) {
        FirebaseVisionImage image = FirebaseVisionImage.fromBitmap(bitmap);
        detector.detectInImage(image)
                .addOnSuccessListener(faces -> {
                    listener.onFacesDetected(faces);
                })
                .addOnFailureListener(e -> {
                    listener.onDetectionError(e);
                });
    }

    public interface OnFacesDetectedListener {
        void onFacesDetected(List<FirebaseVisionFace> faces);
        void onDetectionError(Exception e);
    }
}