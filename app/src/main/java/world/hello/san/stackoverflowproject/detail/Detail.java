package world.hello.san.stackoverflowproject.detail;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

import world.hello.san.stackoverflowproject.R;
import world.hello.san.stackoverflowproject.model.Item;

public class Detail extends AppCompatActivity {

    WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Bundle bundle = getIntent().getExtras();
        Item item = (Item) bundle.getSerializable("item");

        webView = (WebView) findViewById(R.id.web_detail);
        webView.loadUrl(item.getLink());
    }
}
