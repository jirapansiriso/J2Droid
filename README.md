<body>

<h2>Install</h2>
<h5>Add the JitPack repository to your build file</h5>
allprojects { <br/>
	&nbsp;&nbsp;&nbsp;repositories { <br/>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;maven { url 'https://jitpack.io' } <br/>
	&nbsp;&nbsp;&nbsp;} <br/>
} <br/>
	
<h5>Add the dependency</h5>
dependencies { <br/>
        &nbsp;&nbsp;&nbsp;implementation 'com.github.jirapansiriso:J2Droid:1.0' <br/>
} <br/>

<h2>Tools</h2>
<h5>Loading dialog</h5>
J2DroidLoadingDialog loadingDialog = new J2DroidLoadingDialog(this, "Loading..."); <br/>
loadingDialog.show(); // show loading dialog <br/>
loadingDialog.dismiss(); // hide loading dialog <br/>

<h5>Single click</h5>
TextView click = (TextView) findViewById(R.id.click); <br/>
click.setOnClickListener(new J2DroidOnSingleClickListener() { <br/>
    &nbsp;&nbsp;&nbsp;@Override <br/>
    &nbsp;&nbsp;&nbsp;public void onSingleClick(View v) { <br/>
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;// coding <br/>
    &nbsp;&nbsp;&nbsp;} <br/>
}); <br/>

<h5>Information dialog</h5>
J2DroidTool.showInformationDialog(this, "Title", "Content");

<h5>Http Connect</h5>
/** Get request */ <br/>
J2DroidRequest j2DroidRequest = new J2DroidRequest(); <br/>
j2DroidRequest.setApiUrl("{API_URL}"); <br/>
j2DroidRequest.setAccessToken("{ACCESS_TOKEN}"); <br/>
j2DroidRequest.setRequestMethod(J2DroidRequest.GET); <br/> <br/>

boolean isLoadingVisible = true; <br/>
String loadingTitle = "Loading..."; <br/>
J2DroidConnection j2DroidConnection = new J2DroidConnection(this, isLoadingVisible, loadingTitle); <br/>
j2DroidConnection.setProcessListener(new J2DroidConnection.ConnectionListener() { <br/>
    &nbsp;&nbsp;&nbsp;@Override <br/>
    &nbsp;&nbsp;&nbsp;public void onPreExecuted() { <br/>

    &nbsp;&nbsp;&nbsp;} <br/>

    &nbsp;&nbsp;&nbsp;@Override <br/>
    &nbsp;&nbsp;&nbsp;public void onPostExecuted(String result) { <br/>

    &nbsp;&nbsp;&nbsp;} <br/>
}); <br/>
j2DroidConnection.execute(j2DroidRequest); <br/> <br>

/** Post request */ <br/>
J2DroidRequest j2DroidRequest = new J2DroidRequest(); <br/>
j2DroidRequest.setApiUrl("{API_URL}"); <br/>
j2DroidRequest.setAccessToken("{ACCESS_TOKEN}"); <br/>
j2DroidRequest.setRequestBodyJson("{REQUEST_BODY_JSON}"); <br>
j2DroidRequest.setRequestMethod(J2DroidRequest.POST); <br/> <br/>

boolean isLoadingVisible = true; <br/>
String loadingTitle = "Loading..."; <br/>
J2DroidConnection j2DroidConnection = new J2DroidConnection(this, isLoadingVisible, loadingTitle); <br/>
j2DroidConnection.setProcessListener(new J2DroidConnection.ConnectionListener() { <br/>
    &nbsp;&nbsp;&nbsp;@Override <br/>
    &nbsp;&nbsp;&nbsp;public void onPreExecuted() { <br/>

    &nbsp;&nbsp;&nbsp;} <br/>

    &nbsp;&nbsp;&nbsp;@Override <br/>
    &nbsp;&nbsp;&nbsp;public void onPostExecuted(String result) { <br/>

    &nbsp;&nbsp;&nbsp;} <br/>
}); <br/>
j2DroidConnection.execute(j2DroidRequest); <br/> <br>

/** Post with file request */ <br/>
J2DroidRequest j2DroidRequest = new J2DroidRequest(); <br/>
j2DroidRequest.setApiUrl("{API_URL}"); <br/>
j2DroidRequest.setAccessToken("{ACCESS_TOKEN}"); <br/>
j2DroidRequest.setFile(new File("FILE")); <br>
j2DroidRequest.setFileKeyRequest("TABLE[COLUMN]"); <br>
j2DroidRequest.setRequestMethod(J2DroidRequest.POST_WITH_FILE); <br/> <br/>

boolean isLoadingVisible = true; <br/>
String loadingTitle = "Loading..."; <br/>
J2DroidConnection j2DroidConnection = new J2DroidConnection(this, isLoadingVisible, loadingTitle); <br/>
j2DroidConnection.setProcessListener(new J2DroidConnection.ConnectionListener() { <br/>
    &nbsp;&nbsp;&nbsp;@Override <br/>
    &nbsp;&nbsp;&nbsp;public void onPreExecuted() { <br/>

    &nbsp;&nbsp;&nbsp;} <br/>

    &nbsp;&nbsp;&nbsp;@Override <br/>
    &nbsp;&nbsp;&nbsp;public void onPostExecuted(String result) { <br/>

    &nbsp;&nbsp;&nbsp;} <br/>
}); <br/>
j2DroidConnection.execute(j2DroidRequest); <br/> <br>

/** Delete request */ <br/>
J2DroidRequest j2DroidRequest = new J2DroidRequest(); <br/>
j2DroidRequest.setApiUrl("{API_URL}"); <br/>
j2DroidRequest.setAccessToken("{ACCESS_TOKEN}"); <br/>
j2DroidRequest.setRequestMethod(J2DroidRequest.DELETE); <br/> <br/>

boolean isLoadingVisible = true; <br/>
String loadingTitle = "Loading..."; <br/>
J2DroidConnection j2DroidConnection = new J2DroidConnection(this, isLoadingVisible, loadingTitle); <br/>
j2DroidConnection.setProcessListener(new J2DroidConnection.ConnectionListener() { <br/>
    &nbsp;&nbsp;&nbsp;@Override <br/>
    &nbsp;&nbsp;&nbsp;public void onPreExecuted() { <br/>

    &nbsp;&nbsp;&nbsp;} <br/>

    &nbsp;&nbsp;&nbsp;@Override <br/>
    &nbsp;&nbsp;&nbsp;public void onPostExecuted(String result) { <br/>

    &nbsp;&nbsp;&nbsp;} <br/>
}); <br/>
j2DroidConnection.execute(j2DroidRequest); <br/>

<h5>Others</h5>
J2DroidTool.hideSoftKeyboard(this); <br/>
J2DroidTool.isEmail(new EditText(this)); <br/>
J2DroidTool.isFindNumber(new EditText(this)); <br/>
J2DroidTool.isFindSpecialSymbol(new EditText(this)); <br/>
J2DroidTool.isNumberOnly(new EditText(this)); <br/>
J2DroidTool.isTextNull(new EditText(this)); <br/>
</body>
