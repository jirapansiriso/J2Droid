<body>

<h2>Install</h2>
<h5>Add the JitPack repository to your build file</h5>
<pre>
allprojects { 
   repositories { 
      maven { url 'https://jitpack.io' } 
   } 
} 
</pre>
	
<h5>Add the dependency</h5>
<pre>
dependencies { 
   implementation 'com.github.jirapansiriso:J2Droid:1.0' 
} 
</pre>

<h2>Tools</h2>
<h5>Loading dialog</h5>
<pre>
J2DroidLoadingDialog loadingDialog = new J2DroidLoadingDialog(this, "Loading..."); 
loadingDialog.show(); // show loading dialog 
loadingDialog.dismiss(); // hide loading dialog 
</pre>

<h5>Information dialog</h5>
<pre>
J2DroidTool.showInformationDialog(this, "Title", "Content");
</pre>

<h5>Http Connect</h5>
<pre>
/** Get request */
J2DroidRequest j2DroidRequest = new J2DroidRequest();
j2DroidRequest.setApiUrl("{API_URL}");
j2DroidRequest.setAccessToken("{ACCESS_TOKEN}");
j2DroidRequest.setRequestMethod(J2DroidRequest.GET);

boolean isLoadingVisible = true;
String loadingTitle = "Loading...";
J2DroidConnection j2DroidConnection = new J2DroidConnection(this, isLoadingVisible, loadingTitle);
j2DroidConnection.setProcessListener(new J2DroidConnection.ConnectionListener() {
    @Override
    public void onPreExecuted() {
    }
    @Override
    public void onPostExecuted(String result) {
    }
});
j2DroidConnection.execute(j2DroidRequest);

/** Post request */
J2DroidRequest j2DroidRequest = new J2DroidRequest();
j2DroidRequest.setApiUrl("{API_URL}");
j2DroidRequest.setAccessToken("{ACCESS_TOKEN}");
j2DroidRequest.setRequestMethod(J2DroidRequest.POST);
j2DroidRequest.setRequestBodyJson("{REQUEST_BODY_JSON}");

boolean isLoadingVisible = true;
String loadingTitle = "Loading...";
J2DroidConnection j2DroidConnection = new J2DroidConnection(this, isLoadingVisible, loadingTitle);
j2DroidConnection.setProcessListener(new J2DroidConnection.ConnectionListener() {
    @Override
    public void onPreExecuted() {
    }
    @Override
    public void onPostExecuted(String result) {
    }
});
j2DroidConnection.execute(j2DroidRequest);

/** Post with file request */
J2DroidRequest j2DroidRequest = new J2DroidRequest();
j2DroidRequest.setApiUrl("{API_URL}");
j2DroidRequest.setAccessToken("{ACCESS_TOKEN}");
j2DroidRequest.setRequestMethod(J2DroidRequest.POST_WITH_FILE);
j2DroidRequest.setFile(new File("FILE"));
j2DroidRequest.setFileKeyRequest("TABLE[COLUMN]");

boolean isLoadingVisible = true;
String loadingTitle = "Loading...";
J2DroidConnection j2DroidConnection = new J2DroidConnection(this, isLoadingVisible, loadingTitle);
j2DroidConnection.setProcessListener(new J2DroidConnection.ConnectionListener() {
    @Override
    public void onPreExecuted() {
    }
    @Override
    public void onPostExecuted(String result) {
    }
});
j2DroidConnection.execute(j2DroidRequest);

/** Delete request */
J2DroidRequest j2DroidRequest = new J2DroidRequest();
j2DroidRequest.setApiUrl("{API_URL}");
j2DroidRequest.setAccessToken("{ACCESS_TOKEN}");
j2DroidRequest.setRequestMethod(J2DroidRequest.DELETE);

boolean isLoadingVisible = true;
String loadingTitle = "Loading...";
J2DroidConnection j2DroidConnection = new J2DroidConnection(this, isLoadingVisible, loadingTitle);
j2DroidConnection.setProcessListener(new J2DroidConnection.ConnectionListener() {
    @Override
    public void onPreExecuted() {
    }
    @Override
    public void onPostExecuted(String result) {
    }
});
j2DroidConnection.execute(j2DroidRequest);
</pre>

<h5>Others</h5>
<pre>
J2DroidTool.hideSoftKeyboard(this);
J2DroidTool.isEmail(new EditText(this));
J2DroidTool.isFindNumber(new EditText(this));
J2DroidTool.isFindSpecialSymbol(new EditText(this));
J2DroidTool.isNumberOnly(new EditText(this));
J2DroidTool.isTextNull(new EditText(this));
</pre>

</body>
