package thailand.company.riseplus.j2droid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SimpleActivity extends AppCompatActivity {

    private static final String TAG = "log_main";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple);

//        /** Loading dialog */
//        J2DroidLoadingDialog loadingDialog = new J2DroidLoadingDialog(this, "Loading...");
//        loadingDialog.show(); // show loading dialog
//        loadingDialog.dismiss(); // hide loading dialog
//
//        /** Single click */
//        TextView click = (TextView) findViewById(R.id.click);
//        click.setOnClickListener(new J2DroidOnSingleClickListener() {
//            @Override
//            public void onSingleClick(View v) {
//
//            }
//        });
//
//        /** Information dialog */
//         J2DroidTool.showInformationDialog(this, "Title", "Content");
//
//        /** Post with file request */
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
//
//        /** Others */
//        J2DroidTool.hideSoftKeyboard(this);
//        J2DroidTool.isEmail(new EditText(this));
//        J2DroidTool.isFindNumber(new EditText(this));
//        J2DroidTool.isFindSpecialSymbol(new EditText(this));
//        J2DroidTool.isNumberOnly(new EditText(this));
//        J2DroidTool.isTextNull(new EditText(this));
//
//        /** Confirm dialog */
//        J2DroidConfirmDialog j2DroidConfirmDialog = new J2DroidConfirmDialog(this, "Title", "Content", "Yes", "Cancel");
//        j2DroidConfirmDialog.setListener(new J2DroidConfirmDialog.J2DroidConfirmDialogListener() {
//            @Override
//            public void onAccept() {
//                Log.i(TAG, "Accept");
//            }
//
//            @Override
//            public void onDenied() {
//                Log.i(TAG, "Denied");
//            }
//        });
//        j2DroidConfirmDialog.show();
//
//
//        /** Permission */
//        J2DroidPermissionRequest
//                .getInstance(this)
//                .permissionRequest(J2DroidPermissionRequest.CALL_PHONE_PERMISSION)
//                .setListener(new J2DroidPermissionRequest.J2DroidPermissionListener() {
//                    @Override
//                    public void onGranted() {
//                        Log.i(TAG, "Camera Granted");
//                    }
//                });
    }
}
