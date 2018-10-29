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

import thailand.company.riseplus.j2droidlib.R;

public class J2DroidLoadingDialog {
    private AlertDialog dialog;
    private LinearLayout layout;
    private TextView titleText;
    private Context context;
    private String title;

    public J2DroidLoadingDialog(Context context) {
        this.context = context;
        init();
    }

    public J2DroidLoadingDialog(Context context, String title) {
        this.title = title;
        this.context = context;
        init();
    }

    private void init(){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);

        View view = ((Activity) context).getLayoutInflater().inflate(R.layout.j2d_dialog_loading, null);
        layout = (LinearLayout) view.findViewById(R.id.dialog_loading_view);
        titleText = (TextView) view.findViewById(R.id.dialog_loading_title);

        if(title != null) {
            titleText.setVisibility(View.VISIBLE);
            titleText.setText(title.trim());
        }
        else titleText.setVisibility(View.GONE);

        builder.setCancelable(false).setView(view);
        dialog = builder.create();
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        if(Build.VERSION.SDK_INT > Build.VERSION_CODES.KITKAT){
            // layout.setBackground(context.getResources().getDrawable(R.drawable.black_background));
        }else{
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                layout.setBackground(context.getResources().getDrawable(R.drawable.j2d_background_loading));
            }
        }
    }

    public void show() {
        if(!dialog.isShowing()) dialog.show();
    }

    public void dismiss() {
        if(dialog.isShowing()) dialog.dismiss();
    }
}
