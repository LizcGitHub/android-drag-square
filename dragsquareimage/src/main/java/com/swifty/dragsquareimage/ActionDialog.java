package com.swifty.dragsquareimage;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StyleRes;
import android.support.v7.app.AlertDialog;

/**
 * Created by swifty on 9/12/2016.
 */

public abstract class ActionDialog extends AlertDialog {
    protected boolean showDeleteButton;
    protected ActionDialogClick actionDialogClick;

    protected ActionDialog(@NonNull Context context) {
        super(context);
    }

    protected ActionDialog(@NonNull Context context, @StyleRes int themeResId) {
        super(context, themeResId);
    }

    protected ActionDialog(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }

    public abstract ActionDialog setActionDialogClick(ActionDialogClick actionDialogClick);

    public abstract boolean showDeleteButton();

    public abstract ActionDialog setShowDeleteButton(boolean showDeleteButton);
}
