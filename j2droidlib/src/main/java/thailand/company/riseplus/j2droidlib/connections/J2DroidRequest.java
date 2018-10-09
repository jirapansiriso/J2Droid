package thailand.company.riseplus.j2droidlib.connections;

import java.io.File;
import java.util.List;

public class J2DroidRequest {

    public static final int GET = 1;
    public static final int POST = 2;
    public static final int POST_WITH_FILE = 3;
    public static final int PUT = 4;
    public static final int PUT_WITH_FILE= 5;
    public static final int DELETE = 6;

    private String apiUrl;
    private int requestMethod;
    private String RequestBodyJson;
    private String accessToken;

    /** for file */

    private File file;
    private String fileKeyRequest;
    private List<J2DroidKeyValue> kayValues;


    public J2DroidRequest() {

    }

    public J2DroidRequest(String apiUrl, int requestMethod) {
        this.apiUrl = apiUrl;
        this.requestMethod = requestMethod;
    }

    public J2DroidRequest(String apiUrl, int requestMethod, String RequestBodyJson) {
        this.apiUrl = apiUrl;
        this.requestMethod = requestMethod;
        this.RequestBodyJson = RequestBodyJson;
    }

    public String getApiUrl() {
        return apiUrl;
    }

    public void setApiUrl(String apiUrl) {
        this.apiUrl = apiUrl;
    }

    public int getRequestMethod() {
        return requestMethod;
    }

    public void setRequestMethod(int requestMethod) {
        this.requestMethod = requestMethod;
    }

    public String getRequestBodyJson() {
        return RequestBodyJson;
    }

    public void setRequestBodyJson(String requestBodyJson) {
        RequestBodyJson = requestBodyJson;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    /** for file */

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public String getFileKeyRequest() {
        return fileKeyRequest;
    }

    public void setFileKeyRequest(String fileKeyRequest) {
        this.fileKeyRequest = fileKeyRequest;
    }

    public List<J2DroidKeyValue> getKayValues() {
        return kayValues;
    }

    public void setKayValues(List<J2DroidKeyValue> kayValues) {
        this.kayValues = kayValues;
    }
}
