<h3>Add the JitPack repository to your build file</h3>
allprojects { <br/>
	&nbsp;&nbsp;&nbsp;repositories { <br/>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;... <br/>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;maven { url  <br/>'https://jitpack.io' } <br/>
	&nbsp;&nbsp;&nbsp;} <br/>
} <br/>
	
<h3>Add the dependency</h3>
dependencies { <br/>
        &nbsp;&nbsp;&nbsp;implementation  <br/>'com.github.jirapansiriso:J2Droid:1.0' <br/>
} <br/>

<h3>Loading dialog</h3>
J2DroidLoadingDialog loadingDialog = new J2DroidLoadingDialog(this, "Loading..."); <br/>
loadingDialog.show(); // show loading dialog <br/>
loadingDialog.dismiss(); // hide loading dialog <br/>

<h3>Single click</h3>
TextView click = (TextView) findViewById(R.id.click); <br/>
click.setOnClickListener(new J2DroidOnSingleClickListener() { <br/>
    &nbsp;&nbsp;&nbsp;@Override <br/>
    &nbsp;&nbsp;&nbsp;public void onSingleClick(View v) { <br/>
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;// coding <br/>
    &nbsp;&nbsp;&nbsp;} <br/>
}); <br/>

<h3>Information dialog</h3>
J2DroidTool.showInformationDialog(this, "Title", "Content");
