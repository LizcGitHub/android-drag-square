package com.swifty.dragsquareimage;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.widget.Toast;

import com.soundcloud.android.crop.Crop;

import java.io.File;

/**
 * Created by swifty on 29/11/2016.
 */

public class DraggablePresentImpl implements DraggablePresent {
    private final DraggableSquareView dragSquare;
    private int imageStatus;
    private boolean isModify;

    public DraggablePresentImpl(@NonNull DraggableSquareView dragSquare) {
        this.dragSquare = dragSquare;
        dragSquare.setPresent(this);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent result) {
        if (requestCode == Crop.REQUEST_PICK && resultCode == Activity.RESULT_OK) {
            if (dragSquare.getContext() instanceof Activity) {
                beginCrop(result.getData());
            }
        } else if (requestCode == Crop.REQUEST_CROP) {
            handleCrop(resultCode, result);
        }
    }

    @Override
    public void beginCrop(Uri source) {
        Uri destination = Uri.fromFile(new File(dragSquare.getContext().getCacheDir(), "cropped_" + System.currentTimeMillis() + ".jpg"));
        Crop.of(source, destination).asSquare().start((Activity) dragSquare.getContext());
    }

    @Override
    public void handleCrop(int resultCode, Intent result) {
        if (resultCode == Activity.RESULT_OK) {
            Uri uri = Crop.getOutput(result);
            String imagePath = uri.toString();
            dragSquare.fillItemImage(imageStatus, imagePath, isModify);

        } else if (resultCode == Crop.RESULT_ERROR) {
            Toast.makeText(dragSquare.getContext(), Crop.getError(result).getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void pickImage(int imageStatus, boolean isModify) {
        this.imageStatus = imageStatus;
        this.isModify = isModify;
        Crop.pickImage((Activity) dragSquare.getContext());
    }
}
