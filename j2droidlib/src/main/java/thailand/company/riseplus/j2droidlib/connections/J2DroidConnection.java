package thailand.company.riseplus.j2droidlib.connections;

import android.app.Activity;
import android.os.AsyncTask;
import android.util.Log;

import thailand.company.riseplus.j2droidlib.views.J2DroidLoadingDialog;

public class J2DroidConnection extends AsyncTask<J2DroidRequest, Void, String> {

    private static final String TAG = "log_connection";
    private ConnectionListener listener;
    private Activity activity;
    private J2DroidLoadingDialog loadingDialog;
    private boolean loadingVisible = false;
    private String loadingTitle;

    public interface ConnectionListener {
        void onPreExecuted();
        void onPostExecuted(String result);
    }

    public J2DroidConnection(Activity activity, boolean loadingVisible, String loadingTitle) {
        this.activity = activity;
        this.loadingVisible = loadingVisible;
        this.loadingTitle = loadingTitle;
    }

    public J2DroidConnection(Activity activity, boolean loadingVisible) {
        this.activity = activity;
        this.loadingVisible = loadingVisible;
    }

    final public void setProcessListener(ConnectionListener listener) {
        this.listener = listener;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public void setLoadingVisible(boolean loadingVisible) {
        this.loadingVisible = loadingVisible;
    }

    public String getLoadingTitle() {
        return loadingTitle;
    }

    public void setLoadingTitle(String title_loading) {
        this.loadingTitle = loadingTitle;
    }

    @Override
    final protected void onPreExecute() {
        if (listener != null) listener.onPreExecuted();
        if(loadingVisible){
            if(loadingTitle != null) loadingDialog = new J2DroidLoadingDialog(activity, loadingTitle);
            else loadingDialog = new J2DroidLoadingDialog(activity);
            loadingDialog.show();
        }
    }

    @Override
    final protected String doInBackground(J2DroidRequest... values) {
        J2DroidRequest request = values[0];
        try {
            return J2DroidHttpConnect.getInstance(activity).connect(request);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    final protected void onPostExecute(String result) {
        if(loadingVisible) loadingDialog.dismiss();

        if(result != null){
            if(result.equals(J2DroidHttpConnect.AUTHENTICATOR_ERROR)){
                Log.e(TAG, result);
                if (listener != null) listener.onPostExecuted(result);
            }else if(result.equals(J2DroidHttpConnect.CONNECT_FAIL_ERROR)){
                Log.e(TAG, result);
                if (listener != null) listener.onPostExecuted(result);
            }else{
                if (listener != null) listener.onPostExecuted(result);
            }
        }else{
            result = J2DroidHttpConnect.NULL_RESULT;
            Log.e(TAG, result);
            if (listener != null) listener.onPostExecuted(result);
        }
    }
}
