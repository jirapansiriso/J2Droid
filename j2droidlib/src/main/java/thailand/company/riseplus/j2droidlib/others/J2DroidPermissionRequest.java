package thailand.company.riseplus.j2droidlib.others;

import android.Manifest;
import android.content.Context;

import com.gun0912.tedpermission.PermissionListener;
import com.gun0912.tedpermission.TedPermission;

import java.util.ArrayList;
import java.util.List;

public class J2DroidPermissionRequest {

    public static final int LOCATION_PERMISSION = 1;
    public static final int READ_EXTERNAL_PERMISSION = 2;
    public static final int WRITE_EXTERNAL_PERMISSION = 3;
    public static final int CAMERA_PERMISSION = 4;
    public static final int CALL_PHONE_PERMISSION = 5;
    public static final int READ_AND_WRITE_EXTERNAL_PERMISSION = 6;

    private static J2DroidPermissionRequest instance;
    private J2DroidPermissionListener listener;
    private Context context;

    public J2DroidPermissionRequest(Context context) {
        this.context = context;
    }

    public static J2DroidPermissionRequest getInstance(Context context){
        if(instance == null) instance = new J2DroidPermissionRequest(context);
        return instance;
    }

    public interface J2DroidPermissionListener {
        void onGranted();
    }

    public J2DroidPermissionRequest setListener(J2DroidPermissionListener listener) {
        this.listener = listener;
        return this;
    }

    private ArrayList<String> getPermissions(int type){
        if(type == LOCATION_PERMISSION){
            ArrayList<String> permissions = new ArrayList<>();
            permissions.add(Manifest.permission.ACCESS_FINE_LOCATION);
            permissions.add(Manifest.permission.ACCESS_COARSE_LOCATION);
            return permissions;
        }else if(type == READ_EXTERNAL_PERMISSION){
            ArrayList<String> permissions = new ArrayList<>();
            permissions.add(Manifest.permission.READ_EXTERNAL_STORAGE);
            return permissions;
        }else if(type == WRITE_EXTERNAL_PERMISSION){
            ArrayList<String> permissions = new ArrayList<>();
            permissions.add(Manifest.permission.WRITE_EXTERNAL_STORAGE);
            return permissions;
        }else if(type == CAMERA_PERMISSION){
            ArrayList<String> permissions = new ArrayList<>();
            permissions.add(Manifest.permission.CAMERA);
            return permissions;
        }else if(type == CALL_PHONE_PERMISSION){
            ArrayList<String> permissions = new ArrayList<>();
            permissions.add(Manifest.permission.CALL_PHONE);
            return permissions;
        }else if(type == READ_AND_WRITE_EXTERNAL_PERMISSION){
            ArrayList<String> permissions = new ArrayList<>();
            permissions.add(Manifest.permission.READ_EXTERNAL_STORAGE);
            permissions.add(Manifest.permission.WRITE_EXTERNAL_STORAGE);
            return permissions;
        }else {
            return null;
        }
    }

    public J2DroidPermissionRequest permissionRequest(final int type){
        ArrayList<String> permissions = getPermissions(type);

        if(permissions != null){
            TedPermission.with(context)
                    .setPermissionListener(new PermissionListener() {
                        @Override
                        public void onPermissionGranted() {
                            if (listener != null) listener.onGranted();
                        }

                        @Override
                        public void onPermissionDenied(List<String> deniedPermissions) {
                            permissionRequest(type);
                        }
                    })
                    .setPermissions(permissions.toArray(new String[permissions.size()]))
                    .check();
        }

        return this;
    }
}
