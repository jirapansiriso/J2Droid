package thailand.company.riseplus.j2droidlib.connections;

import android.content.Context;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class J2DroidHttpConnect {

    public static final String AUTHENTICATOR_ERROR = "Authenticator error.";
    public static final String CONNECT_FAIL_ERROR = "Connection failed.";
    public static final String NULL_RESULT = "NUll result";

    private static final String TAG = "http_connect";
    private static final int CONNECT_TIMEOUT = 40;
    private static final int WRITE_TIMEOUT = 40;
    private static final int READ_TIMEOUT = 40;
    private static J2DroidHttpConnect instance;
    private OkHttpClient client;
    private Context context;

    public J2DroidHttpConnect(Context context) {
        this.context = context;
        this.client = new OkHttpClient.Builder()
                .connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)
                .writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
                .build();
    }

    public static J2DroidHttpConnect getInstance(Context context) {
        if (instance == null) {
            instance = new J2DroidHttpConnect(context);
        }
        return instance;
    }

    private Request getRequest(J2DroidRequest req){

        if(req.getRequestMethod() == J2DroidRequest.GET){
            if(req.getAccessToken() != null) {
                Request request = new Request.Builder()
                        .url(req.getApiUrl())
                        .get()
                        .addHeader("authorization", req.getAccessToken())
                        .build();
                return request;
            }else{
                Request request = new Request.Builder()
                        .url(req.getApiUrl())
                        .get()
                        .build();
                return request;
            }
        }else if(req.getRequestMethod() == J2DroidRequest.POST){
            MediaType mediaType = MediaType.parse("application/json");
            String json = req.getRequestBodyJson();
            RequestBody body = RequestBody.create(mediaType, json);

            if(req.getAccessToken() != null) {
                Request request = new Request.Builder()
                        .url(req.getApiUrl())
                        .post(body)
                        .addHeader("authorization", req.getAccessToken())
                        .addHeader("content-type", "application/json")
                        .addHeader("cache-control", "no-cache")
                        .build();
                return request;
            }else{
                Request request = new Request.Builder()
                        .url(req.getApiUrl())
                        .post(body)
                        .addHeader("content-type", "application/json")
                        .addHeader("cache-control", "no-cache")
                        .build();
                return request;
            }
        }else if(req.getRequestMethod() == J2DroidRequest.PUT){
            MediaType mediaType = MediaType.parse("application/json");
            String json = req.getRequestBodyJson();
            RequestBody body = RequestBody.create(mediaType, json);

            if(req.getAccessToken() != null) {
                Request request = new Request.Builder()
                        .url(req.getApiUrl())
                        .put(body)
                        .addHeader("authorization", req.getAccessToken())
                        .addHeader("content-type", "application/json")
                        .build();
                return request;
            }else{
                Request request = new Request.Builder()
                        .url(req.getApiUrl())
                        .addHeader("content-type", "application/json")
                        .put(body)
                        .build();
                return request;
            }
        }else if(req.getRequestMethod() == J2DroidRequest.PUT_WITH_FILE){
            String fileName = req.getFile().getName();
            String fileKey = req.getFileKeyRequest();
            File file = req.getFile();
            String extension = file.getAbsolutePath().substring(file.getAbsolutePath().lastIndexOf("."));
            MediaType mediaType;
            if(extension.toLowerCase().equals(".jpg") || extension.toLowerCase().equals(".jpeg") || extension.toLowerCase().equals(".png")) mediaType = MediaType.parse("image/jpeg");
            else if(extension.toLowerCase().equals(".pdf")) mediaType = MediaType.parse("application/pdf");
            else if(extension.toLowerCase().equals(".csv")) mediaType = MediaType.parse("text/csv");
            else mediaType = MediaType.parse("multipart/form-data");

            MultipartBody.Builder  builder = new MultipartBody.Builder();
            builder.setType(MultipartBody.FORM);
            List<J2DroidKeyValue> keyValues = req.getKayValues();
            builder.addFormDataPart(fileKey, fileName, RequestBody.create(mediaType, file));  // file
            if(keyValues != null){
                for (J2DroidKeyValue keyValue:keyValues){
                    builder.addFormDataPart(keyValue.getKey(), keyValue.getValue()); // value
                }
            }

            if(req.getAccessToken() != null) {
                Request request = new Request.Builder()
                        .url(req.getApiUrl())
                        .put(builder.build())
                        .addHeader("authorization", req.getAccessToken())
                        .addHeader("content-type", "multipart/form-data")
                        .addHeader("content-type", "application/json")
                        .build();
                return request;
            }else{
                Request request = new Request.Builder()
                        .url(req.getApiUrl())
                        .addHeader("content-type", "multipart/form-data")
                        .addHeader("content-type", "application/json")
                        .put(builder.build())
                        .build();
                return request;
            }
        }else if(req.getRequestMethod() == J2DroidRequest.POST_WITH_FILE){
            String fileName = req.getFile().getName();
            String fileKey = req.getFileKeyRequest();
            File file = req.getFile();
            String extension = file.getAbsolutePath().substring(file.getAbsolutePath().lastIndexOf("."));
            MediaType mediaType;
            if(extension.toLowerCase().equals(".jpg") || extension.toLowerCase().equals(".jpeg") || extension.toLowerCase().equals(".png")) mediaType = MediaType.parse("image/jpeg");
            else if(extension.toLowerCase().equals(".pdf")) mediaType = MediaType.parse("application/pdf");
            else if(extension.toLowerCase().equals(".csv")) mediaType = MediaType.parse("text/csv");
            else mediaType = MediaType.parse("multipart/form-data");

            MultipartBody.Builder  builder = new MultipartBody.Builder();
            builder.setType(MultipartBody.FORM);
            List<J2DroidKeyValue> keyValues = req.getKayValues();
            builder.addFormDataPart(fileKey, fileName, RequestBody.create(mediaType, file));  // file
            if(keyValues != null){
                for (J2DroidKeyValue keyValue:keyValues){
                    builder.addFormDataPart(keyValue.getKey(), keyValue.getValue()); // value
                }
            }

            if(req.getAccessToken() != null) {
                Request request = new Request.Builder()
                        .url(req.getApiUrl())
                        .post(builder.build())
                        .addHeader("authorization", req.getAccessToken())
                        .addHeader("content-type", "multipart/form-data")
                        .addHeader("content-type", "application/json")
                        .build();
                return request;
            }else{
                Request request = new Request.Builder()
                        .url(req.getApiUrl())
                        .addHeader("content-type", "multipart/form-data")
                        .addHeader("content-type", "application/json")
                        .post(builder.build())
                        .build();
                return request;
            }
        }else if(req.getRequestMethod() == J2DroidRequest.DELETE){
            if(req.getAccessToken() != null) {
                Request request = new Request.Builder()
                        .url(req.getApiUrl())
                        .delete()
                        .addHeader("authorization", req.getAccessToken())
                        .build();
                return request;
            }else{
                Request request = new Request.Builder()
                        .url(req.getApiUrl())
                        .delete()
                        .build();
                return request;
            }
        }else{
            return null;
        }
    }

    private String getResult(Response response){
        String result;

        if (response.isSuccessful()) {
            try {
                if(response.code() == 401){
                    result = AUTHENTICATOR_ERROR;
                }else {
                    result = response.body().string();
                }
            } catch (Exception e) {
                e.printStackTrace();
                result = CONNECT_FAIL_ERROR;
            }
        }else if(response.code() == 401) {
            result = AUTHENTICATOR_ERROR;
        }else{
            result = CONNECT_FAIL_ERROR;
        }

        return result;
    }

    public String connect(J2DroidRequest req) {
        try {
            Request request = getRequest(req);
            Response response = client.newCall(request).execute();
            return getResult(response);
        } catch (IOException e) {
            e.printStackTrace();
            return CONNECT_FAIL_ERROR;
        }
    }
}
