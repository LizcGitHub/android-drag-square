package com.swifty.dragsquareimage;

import android.content.Intent;
import android.net.Uri;

/**
 * Created by swifty on 29/11/2016.
 */

public interface DraggablePresent {

    void onActivityResult(int requestCode, int resultCode, Intent result);

    void beginCrop(Uri source);

    void handleCrop(int resultCode, Intent result);

    void pickImage(int imageStatus, boolean isModify);
}
