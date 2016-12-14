package com.swifty.dragsquareimage;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

/**
 * Created by Administrator on 2016/5/27.
 */
public class DefaultActionDialog extends ActionDialog {

    public ActionDialogClick actionDialogClick;

    protected DefaultActionDialog(Context context) {
        super(context);
    }

    public DefaultActionDialog(Context context, int theme) {
        super(context, theme);
    }

    public DefaultActionDialog(Context context, boolean cancelable, OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.default_action_dialog);
        findViewById(R.id.take_photo).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (actionDialogClick != null) actionDialogClick.onTakePhotoClick(v);
                dismiss();
            }
        });
        findViewById(R.id.pick_image).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (actionDialogClick != null) actionDialogClick.onPickImageClick(v);
                dismiss();
            }
        });
        findViewById(R.id.delete).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (actionDialogClick != null) actionDialogClick.onDeleteClick(v);
                dismiss();
            }
        });
    }

    public void setActionDialogClick(ActionDialogClick actionDialogClick) {
        this.actionDialogClick = actionDialogClick;
    }

}
