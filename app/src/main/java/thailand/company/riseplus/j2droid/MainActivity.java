package thailand.company.riseplus.j2droid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.File;

import thailand.company.riseplus.j2droidlib.connections.J2DroidConnection;
import thailand.company.riseplus.j2droidlib.connections.J2DroidRequest;
import thailand.company.riseplus.j2droidlib.others.J2DroidOnSingleClickListener;
import thailand.company.riseplus.j2droidlib.others.J2DroidTool;
import thailand.company.riseplus.j2droidlib.views.J2DroidLoadingDialog;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /** Loading dialog */
//         J2DroidLoadingDialog loadingDialog = new J2DroidLoadingDialog(this, "Loading...");
//         loadingDialog.show(); // show loading dialog
//         loadingDialog.dismiss(); // hide loading dialog

        /** Single click */
//        TextView click = (TextView) findViewById(R.id.click);
//        click.setOnClickListener(new J2DroidOnSingleClickListener() {
//            @Override
//            public void onSingleClick(View v) {
//
//            }
//        });

        /** Information dialog */
//         J2DroidTool.showInformationDialog(this, "Title", "Content");

        /** Get request */
//        J2DroidRequest j2DroidRequest = new J2DroidRequest();
//        j2DroidRequest.setApiUrl("{API_URL}");
//        j2DroidRequest.setAccessToken("{ACCESS_TOKEN}");
//        j2DroidRequest.setRequestMethod(J2DroidRequest.GET);
//
//        boolean isLoadingVisible = true;
//        String loadingTitle = "Loading...";
//        J2DroidConnection j2DroidConnection = new J2DroidConnection(this, isLoadingVisible, loadingTitle);
//        j2DroidConnection.setProcessListener(new J2DroidConnection.ConnectionListener() {
//            @Override
//            public void onPreExecuted() {
//
//            }
//
//            @Override
//            public void onPostExecuted(String result) {
//
//            }
//        });
//        j2DroidConnection.execute(j2DroidRequest);

        /** Post request */
//        J2DroidRequest j2DroidRequest = new J2DroidRequest();
//        j2DroidRequest.setApiUrl("{API_URL}");
//        j2DroidRequest.setAccessToken("{ACCESS_TOKEN}");
//        j2DroidRequest.setRequestMethod(J2DroidRequest.POST);
//        j2DroidRequest.setRequestBodyJson("{REQUEST_BODY_JSON}");
//
//        boolean isLoadingVisible = true;
//        String loadingTitle = "Loading...";
//        J2DroidConnection j2DroidConnection = new J2DroidConnection(this, isLoadingVisible, loadingTitle);
//        j2DroidConnection.setProcessListener(new J2DroidConnection.ConnectionListener() {
//            @Override
//            public void onPreExecuted() {
//
//            }
//
//            @Override
//            public void onPostExecuted(String result) {
//
//            }
//        });
//        j2DroidConnection.execute(j2DroidRequest);

        /** Post with file request */
//        J2DroidRequest j2DroidRequest = new J2DroidRequest();
//        j2DroidRequest.setApiUrl("{API_URL}");
//        j2DroidRequest.setAccessToken("{ACCESS_TOKEN}");
//        j2DroidRequest.setRequestMethod(J2DroidRequest.POST_WITH_FILE);
//        j2DroidRequest.setFile(new File("FILE"));
//        j2DroidRequest.setFileKeyRequest("TABLE[COLUMN]");
//
//        boolean isLoadingVisible = true;
//        String loadingTitle = "Loading...";
//        J2DroidConnection j2DroidConnection = new J2DroidConnection(this, isLoadingVisible, loadingTitle);
//        j2DroidConnection.setProcessListener(new J2DroidConnection.ConnectionListener() {
//            @Override
//            public void onPreExecuted() {
//
//            }
//
//            @Override
//            public void onPostExecuted(String result) {
//
//            }
//        });
//        j2DroidConnection.execute(j2DroidRequest);

        /** Delete request */
//        J2DroidRequest j2DroidRequest = new J2DroidRequest();
//        j2DroidRequest.setApiUrl("{API_URL}");
//        j2DroidRequest.setAccessToken("{ACCESS_TOKEN}");
//        j2DroidRequest.setRequestMethod(J2DroidRequest.DELETE);
//
//        boolean isLoadingVisible = true;
//        String loadingTitle = "Loading...";
//        J2DroidConnection j2DroidConnection = new J2DroidConnection(this, isLoadingVisible, loadingTitle);
//        j2DroidConnection.setProcessListener(new J2DroidConnection.ConnectionListener() {
//            @Override
//            public void onPreExecuted() {
//
//            }
//
//            @Override
//            public void onPostExecuted(String result) {
//
//            }
//        });
//        j2DroidConnection.execute(j2DroidRequest);

        /** Others */
//        J2DroidTool.hideSoftKeyboard(this);
//        J2DroidTool.isEmail(new EditText(this));
//        J2DroidTool.isFindNumber(new EditText(this));
//        J2DroidTool.isFindSpecialSymbol(new EditText(this));
//        J2DroidTool.isNumberOnly(new EditText(this));
//        J2DroidTool.isTextNull(new EditText(this));
    }
}
