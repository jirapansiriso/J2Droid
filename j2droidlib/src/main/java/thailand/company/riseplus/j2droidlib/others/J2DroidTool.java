package thailand.company.riseplus.j2droidlib.others;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.balysv.materialripple.MaterialRippleLayout;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Iterator;
import java.util.regex.Pattern;

import thailand.company.riseplus.j2droidlib.R;

import static android.content.Context.INPUT_METHOD_SERVICE;

public class J2DroidTool {

    public static boolean isPackageInstalled(String packageName, PackageManager packageManager) {
        try {
            packageManager.getPackageInfo(packageName, 0);
            return true;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean isFindNumber(String text){
        if(text != null){
            for (int i=0; i<text.length(); i++){
                try {
                    Integer.parseInt(text.substring(i));
                    return true;
                }catch (Exception e){ e.printStackTrace(); }
            }
            return false;
        }else{
            return false;
        }
    }

    public static boolean isFindNumber(EditText editText){
        if(!isTextNull(editText)){
            String text = editText.getText().toString().trim();
            if(text != null){
                for (int i=0; i<text.length(); i++){
                    try {
                        Integer.parseInt(text.substring(i));
                        return true;
                    }catch (Exception e){ e.printStackTrace(); }
                }
                return false;
            }else{
                return false;
            }
        }else {
            return false;
        }


    }

    public static boolean isFindSpecialSymbol(String text){
        if(text != null){
            Pattern regex = Pattern.compile("[$&+,:;=\\\\?@#|/'<>.^*()%!-]");
            if (regex.matcher(text.trim()).find()) return true;
            else return false;
        }else{
            return false;
        }
    }

    public static boolean isFindSpecialSymbol(EditText editText){
        if(!isTextNull(editText)){
            String text = editText.getText().toString().trim();
            Pattern regex = Pattern.compile("[$&+,:;=\\\\?@#|/'<>.^*()%!-]");
            if (regex.matcher(text.trim()).find()) return true;
            else return false;
        }else{
            return false;
        }
    }

    public static boolean isTextNull(EditText editText){
        if(editText != null){
            if(editText.getText().toString().trim().length() > 0){
                return false;
            }else{
                return true;
            }
        }else{
            return false;
        }
    }

    public static boolean isTextNull(String text){
        if(text != null){
            if(text.trim().length() > 0){
                return false;
            }else{
                return true;
            }
        }else{
            return false;
        }
    }

    public static boolean isEmail(EditText editText) {
        if(!isTextNull(editText)){
            return android.util.Patterns.EMAIL_ADDRESS.matcher(editText.getText().toString().trim()).matches();
        }else{
            return false;
        }
    }

    public static boolean isEmail(String text) {
        if(text != null){
            return android.util.Patterns.EMAIL_ADDRESS.matcher(text.trim()).matches();
        }else {
            return false;
        }
    }

    public static boolean isTextOnly(EditText editText){
        boolean status;
        if(!isTextNull(editText)){
            if(!isFindNumber(editText.getText().toString())){
                if(!isFindSpecialSymbol(editText.getText().toString())){
                    status = true;
                }else{
                    status = false;
                }
            }else{
                status = false;
            }
        }else{
            status = false;
        }
        return status;
    }

    public static boolean isTextOnly(String text){
        if(text != null) {
            boolean status;
            if(!isFindNumber(text)){
                if(!isFindSpecialSymbol(text)){
                    status = true;
                }else{
                    status = false;
                }
            }else{
                status = false;
            }
            return status;
        }else {
            return false;
        }
    }

    public static boolean isNumberOnly(EditText editText){
        boolean status;
        if(!isTextNull(editText)){
            String regex = "[0-9]+";
            if(editText.getText().toString().trim().matches(regex)){
                return true;
            }else{
                return false;
            }
        }else{
            status = false;
        }
        return status;
    }

    public static boolean isNumberOnly(String text){
        boolean status;
        if(text != null){
            String regex = "[0-9]+";
            if(text.trim().matches(regex)){
                return true;
            }else{
                return false;
            }
        }else{
            status = false;
        }
        return status;
    }

    public static void hideSoftKeyboard(Activity activity) {
        if(activity.getCurrentFocus()!= null) {
            InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService(INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(), 0);
        }
    }

    public static void startActivity(Activity activity, Intent intent) {
        activity.startActivity(intent);
        hideSoftKeyboard(activity);
    }

    public static void startActivityForResult(Activity activity, Intent intent, int requestCode) {
        activity.startActivityForResult(intent, requestCode);
        hideSoftKeyboard(activity);
    }

    public static void showInformationDialog(Activity activity, String titleText, String contentText){
        final Dialog dialog = new Dialog(activity);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(true);
        dialog.setContentView(R.layout.custom_information_dialog);

        LinearLayout layout = (LinearLayout) dialog.findViewById(R.id.custom_dialog_information);
        TextView title = (TextView) dialog.findViewById(R.id.custom_information_dialog_title);
        TextView content = (TextView) dialog.findViewById(R.id.custom_information_dialog_content);
        MaterialRippleLayout close = (MaterialRippleLayout) dialog.findViewById(R.id.custom_information_dialog_close_button);

        title.setText(titleText);
        content.setText(contentText);
        close.setOnClickListener(new J2DroidOnSingleClickListener() {
            @Override
            public void onSingleClick(View v) {
                dialog.dismiss();
            }
        });

        dialog.show();
    }

    public static float convertDpToPixel(Context context, float dp){
        Resources resources = context.getResources();
        DisplayMetrics metrics = resources.getDisplayMetrics();
        float px = dp * ((float)metrics.densityDpi / DisplayMetrics.DENSITY_DEFAULT);
        return px;
    }

    public static float convertPixelsToDp(Context context, float px){
        Resources resources = context.getResources();
        DisplayMetrics metrics = resources.getDisplayMetrics();
        float dp = px / ((float)metrics.densityDpi / DisplayMetrics.DENSITY_DEFAULT);
        return dp;
    }

    public static String getErrorMessage(Activity context, JSONObject json){
        try {
            json = json.getJSONObject("errors");
            Iterator<String> iterator = json.keys();
            String messages = "";
            int count = 1;

            while (iterator.hasNext()) {
                String key = iterator.next();
                try {
                    Object values = json.get(key);
                    try {
                        JSONArray jsonArray = new JSONArray(values.toString());

                        for (int i=0; i<jsonArray.length(); i++){
                            messages += count + ". " + key + " " + jsonArray.getString(i) + "\n";
                            count ++;
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            return messages;
        } catch (JSONException e) {
            try {
                String messages = "";
                int count = 1;

                JSONArray jsonArray = json.getJSONArray("errors");
                for (int i=0; i<jsonArray.length(); i++){
                    messages += count + ". " + jsonArray.getString(i) + "\n";
                    count ++;
                }

                return messages;
            } catch (JSONException e1) {
                e1.printStackTrace();
                return null;
            }
        }
    }
}
