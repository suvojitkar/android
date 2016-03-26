package com.androidbelieve.drawerwithswipetabs;

        import android.net.ConnectivityManager;
        import android.net.NetworkInfo;
        import android.os.Bundle;
        import android.support.annotation.Nullable;
        import android.support.v4.app.Fragment;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.webkit.WebSettings;
        import android.webkit.WebView;
        import android.webkit.WebViewClient;


public class Pricinga extends Fragment {
    String url="http://mehuljain160.esy.es/graph.php";
    private WebView wv1;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_pricinga, container, false);

        wv1=(WebView)v.findViewById(R.id.webView);
        wv1.setWebViewClient(new MyBrowser());
        WebSettings webSettings = wv1.getSettings();
        wv1.getSettings().setJavaScriptEnabled(true);
        webSettings.setJavaScriptEnabled(true);
        wv1.getSettings().setPluginState(WebSettings.PluginState.ON);
        webSettings.setDomStorageEnabled(true);
        wv1.getSettings().setJavaScriptEnabled(true);
        wv1.getSettings().setDomStorageEnabled(true);

        //caching
        wv1.getSettings().setAppCacheMaxSize( 5 * 1024 * 1024 ); // 5MB
        wv1.getSettings().setAppCachePath( getActivity().getApplicationContext().getCacheDir().getAbsolutePath() );
        wv1.getSettings().setAllowFileAccess( true );
        wv1.getSettings().setAppCacheEnabled( true );
        wv1.getSettings().setJavaScriptEnabled( true );
        wv1.getSettings().setCacheMode( WebSettings.LOAD_DEFAULT ); // load online by default

        if ( !isNetworkAvailable() ) { // loading offline
            wv1.getSettings().setCacheMode( WebSettings.LOAD_CACHE_ELSE_NETWORK );
        }

        wv1.loadUrl(url);
        return v;
    }

    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getActivity().getSystemService( getActivity().CONNECTIVITY_SERVICE );
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    private class MyBrowser extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }
}
