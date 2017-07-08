package meui.progress;

import android.app.*;
import android.content.*;
import android.net.*;
import android.os.*;
import android.view.*;
import android.widget.*;

public class MainActivity extends Activity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        final Button gitHubLink=(Button)findViewById(R.id.goToGitHub);
        gitHubLink.getPaint().setFakeBoldText(true);
        gitHubLink.setOnClickListener(this);
        findViewById(R.id.author).setOnClickListener(this);
        findViewById(R.id.can_work).setOnClickListener(this);
        findViewById(R.id.cant_work).setOnClickListener(this);
        findViewById(R.id.meui_github).setOnClickListener(this);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            final Window window = getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS | WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(0xff009688);
            window.setNavigationBarColor(0xff009688);
        }
    }

    @Override
    public void onClick(View p1) {
        final Uri uri;
        final Intent intent;
        switch (p1.getId()) {
            case R.id.author:
                Toast.makeText(MainActivity.this, "干什么点我？", Toast.LENGTH_LONG).show();
                break;
            case R.id.goToGitHub:
                uri=Uri.parse("https://github.com/pnikosis/materialish-progress");
                intent=new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
                break;
            case R.id.can_work:
                Toast.makeText(this, "即将打开教程主帖。", Toast.LENGTH_LONG).show();
                uri=Uri.parse("http://tieba.baidu.com/f?kw=%E5%8D%8E%E4%B8%BAy220t10&frs=yqtb");
                intent=new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
                break;
            case R.id.cant_work:
                final String kernel="\n内核:" + System.getProperty("os.version");
                final String mCopyText="型号:" + Build.MODEL + kernel + "\nSDK:" + Build.VERSION.SDK_INT + "\n无法正常显示，具体故障描述：";

                if (Build.VERSION.SDK_INT > 10) {
                    final android.content.ClipboardManager cmb = (ClipboardManager)this.getSystemService(Context.CLIPBOARD_SERVICE);
                    cmb.setText(mCopyText);
                } else {
                    final android.text.ClipboardManager cmb=(android.text.ClipboardManager)this.getSystemService(Context.CLIPBOARD_SERVICE);
                    cmb.setText(mCopyText);
                }
                Toast.makeText(this, "详细信息已被复制，请粘贴到主帖反馈！", Toast.LENGTH_LONG).show();
                uri=Uri.parse("http://tieba.baidu.com/f?kw=%E5%8D%8E%E4%B8%BAy220t10&frs=yqtb");
                intent=new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
                break;
            case R.id.meui_github:
                uri=Uri.parse("https://github.com/zhaozihanzzh/materialish-progress");
                intent=new Intent(Intent.ACTION_VIEW,uri);
                startActivity(intent);
                break;
            default:
                break;
        }
    }
}
