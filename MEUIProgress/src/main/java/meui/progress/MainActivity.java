package meui.progress;

import android.app.*;
import android.content.*;
import android.net.*;
import android.os.*;
import android.view.*;
import android.view.View.*;
import android.widget.*;

public class MainActivity extends Activity 
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		final Button gitHubLink=(Button)findViewById(R.id.goToGitHub);
		gitHubLink.getPaint().setFakeBoldText(true);
		gitHubLink.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View view){
				final Uri uri=Uri.parse("https://github.com/pnikosis/materialish-progress");
				final Intent goToGitHub=new Intent(Intent.ACTION_VIEW,uri);
				startActivity(goToGitHub);
			}
		});
		final TextView author=(TextView)findViewById(R.id.author);
		
		author.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View p1){
				Toast toast = Toast.makeText(MainActivity.this,"干什么点我？",Toast.LENGTH_LONG);
				toast.show();
			}
		});
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
			final Window window = getWindow();
			window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS|WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
			window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
			window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
			window.setStatusBarColor(0xff009688);
			window.setNavigationBarColor(0xff009688);
			}
    }
	public void cannotButtonClicked(View view){
		final String kernel="\n内核:"+System.getProperty("os.version");
		
		final String mCopyText="型号:"+Build.MODEL+kernel+"\nSDK:"+Build.VERSION.SDK_INT+"\n无法正常显示，具体故障描述：";
		if(Build.VERSION.SDK_INT>10){
			final android.content.ClipboardManager cmb = (ClipboardManager)this.getSystemService(Context.CLIPBOARD_SERVICE);
			cmb.setText(mCopyText);
		}else{
			final android.text.ClipboardManager cmb=(android.text.ClipboardManager)this.getSystemService(Context.CLIPBOARD_SERVICE);
			cmb.setText(mCopyText);
		}
		final Toast goToReport=Toast.makeText(this,"详细信息已被复制，请粘贴到主帖反馈！",Toast.LENGTH_LONG);
		goToReport.show();
		final Uri uri=Uri.parse("http://tieba.baidu.com/f?kw=%E5%8D%8E%E4%B8%BAy220t10&frs=yqtb");
		final Intent report=new Intent(Intent.ACTION_VIEW,uri);
		startActivity(report);
	}
	public void canButtonClicked(View view){
		
		final Toast goToGuide=Toast.makeText(this,"即将打开教程主帖。",Toast.LENGTH_LONG);
		goToGuide.show();
		final Uri uri=Uri.parse("http://tieba.baidu.com/f?kw=%E5%8D%8E%E4%B8%BAy220t10&frs=yqtb");
		final Intent report=new Intent(Intent.ACTION_VIEW,uri);
		startActivity(report);
	}
	
}
