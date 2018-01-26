package com.example.android.emojify;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import android.util.SparseArray;
import android.widget.Toast;

import com.google.android.gms.vision.Frame;
import com.google.android.gms.vision.face.Face;
import com.google.android.gms.vision.face.FaceDetector;

/**
 * Created by ANGA on 1/26/2018.
 */

public class Emojifier {

    private static final String LOG_TAG = Emojifier.class.getSimpleName();

    /**
     * Method for detecting face in bitmap
     * @param context
     * @param picture
     */
    static void detectFaces(Context context, Bitmap picture){

        //create the fade detector disable tracking and set classification type
        FaceDetector detector = new FaceDetector.Builder(context)
                .setTrackingEnabled(false)
                .setClassificationType(FaceDetector.ALL_CLASSIFICATIONS)
                .build();

        //Build the frame
        Frame frame = new Frame.Builder().setBitmap(picture).build();

        //Detect the faces
        SparseArray<Face> faces = detector.detect(frame);

        //log the number of faces
        Log.d(LOG_TAG, "detectFaces: number of faces = " + faces.size());

        //Show toast if there are no faces detected
        if(faces.size() == 0){
            Toast.makeText(context, R.string.no_faces_message, Toast.LENGTH_SHORT).show();
        }

        //release the detector
        detector.release();
    }
}
