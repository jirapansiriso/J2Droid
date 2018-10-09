package thailand.company.riseplus.j2droid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import thailand.company.riseplus.j2droidlib.others.J2DroidOnSingleClickListener;
import thailand.company.riseplus.j2droidlib.others.J2DroidTool;
import thailand.company.riseplus.j2droidlib.views.J2DroidLoadingDialog;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /** Loading dialog */
        J2DroidLoadingDialog loadingDialog = new J2DroidLoadingDialog(this, "Loading...");
        // loadingDialog.show(); // show loading dialog
        // loadingDialog.dismiss(); // hide loading dialog

        /** Single click */
        TextView click = (TextView) findViewById(R.id.click);
        click.setOnClickListener(new J2DroidOnSingleClickListener() {
            @Override
            public void onSingleClick(View v) {

            }
        });

        /** Information dialog */
        J2DroidTool.showInformationDialog(this, "Title", "Content");


    }
}
