package app.webview.imooc.com.webviewapplication;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class MainActivity extends Activity {
private WebView appView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        appView = (WebView)findViewById(R.id.webview);
        WebSettings webSettings = appView.getSettings();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            webSettings.setAllowUniversalAccessFromFileURLs(true);
        }
        webSettings.setJavaScriptEnabled(true);
        // setWebClient：主要处理解析，渲染网页等浏览器做的事情
        //setWebChromeClient：辅助WebView处理Javascript的对话框，网站图标，网站title，加载进度等
        appView.setWebChromeClient(new MyWebChromeClient());
        //WebViewClient就是帮助WebView处理各种通知、请求事件的。
        appView.setWebViewClient(new HelpClient());
        appView.loadUrl("http://d.eqxiu.com/s/HdWj7kAY");
    }
    final class MyWebChromeClient extends WebChromeClient {
        @Override
        public boolean onJsAlert(WebView view, String url, String message,
                                 JsResult result) {
            result.confirm();
            return true;
        }
    }
    private final class HelpClient extends WebViewClient {
        @Override
        public void onPageFinished(WebView view, String url) {
            Toast.makeText(MainActivity.this, "onPageFinished",
                    Toast.LENGTH_SHORT).show();
        }
    }
    }
