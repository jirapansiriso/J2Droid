package thailand.company.riseplus.j2droidlib.views;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.balysv.materialripple.MaterialRippleLayout;

import thailand.company.riseplus.j2droidlib.R;
import thailand.company.riseplus.j2droidlib.others.J2DroidOnSingleClickListener;

public class J2DroidConfirmDialog {

    private AlertDialog dialog;
    private Context context;
    private LinearLayout layout;
    private String title, content, denied, accept;
    private J2DroidConfirmDialogListener listener;

    public interface J2DroidConfirmDialogListener {
        void onAccept();
        void onDenied();
    }

    public void setListener(J2DroidConfirmDialogListener listener) {
        this.listener = listener;
    }

    public J2DroidConfirmDialog(Context context, String title, String content, String accept, String denied) {
        this.context = context;
        this.title = title;
        this.content = content;
        this.accept = accept;
        this.denied = denied;
        init();
    }

    private void init(){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);

        View view = ((Activity) context).getLayoutInflater().inflate(R.layout.custom_confirm_dialog, null);
        layout = (LinearLayout) view.findViewById(R.id.custom_confirm_dialog_layout);
        TextView titleText = (TextView) view.findViewById(R.id.custom_dialog_title);
        TextView contentText = (TextView) view.findViewById(R.id.custom_dialog_confirm_body);
        MaterialRippleLayout deniedButton = (MaterialRippleLayout) view.findViewById(R.id.custom_dialog_confirm_no);
        MaterialRippleLayout acceptButton = (MaterialRippleLayout) view.findViewById(R.id.custom_dialog_confirm_yes);
        TextView deniedText = (TextView) view.findViewById(R.id.custom_dialog_confirm_no_text);
        TextView acceptText = (TextView) view.findViewById(R.id.custom_dialog_confirm_yes_text);

        if(title != null) titleText.setText(title.trim());
        if(content != null) contentText.setText(content.trim());
        if(accept != null) acceptText.setText(accept.trim());
        if(denied != null) deniedText.setText(denied.trim());

        deniedButton.setOnClickListener(new J2DroidOnSingleClickListener() {
            @Override
            public void onSingleClick(View v) {
                if (listener != null) listener.onDenied();
                dismiss();
            }
        });

        acceptButton.setOnClickListener(new J2DroidOnSingleClickListener() {
            @Override
            public void onSingleClick(View v) {
                if (listener != null) listener.onAccept();
                dismiss();
            }
        });

        builder.setCancelable(false).setView(view);
        dialog = builder.create();
    }

    public void show() {
        if(!dialog.isShowing()) dialog.show();
    }

    public void dismiss() {
        if(dialog.isShowing()) dialog.dismiss();
    }
}
