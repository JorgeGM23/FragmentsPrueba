package com.example.jorge.fragmentsprueba;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class FragmentWeb extends Fragment {

    WebView webView;
    String url;


    public static FragmentWeb newInstance(String url) {
        Bundle bundle = new Bundle();
        bundle.putString("url", url);

        FragmentWeb fragment = new FragmentWeb();
        fragment.setArguments(bundle);

        return fragment;
    }

    private void readBundle(Bundle bundle) {
        if (bundle != null) {
            url = bundle.getString("url");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_fragment_web, container, false);

        webView = (WebView) v.findViewById(R.id.webView);

        readBundle(getArguments());

        webView.setWebViewClient(new WebViewClient());  // PARA QUE SE MANTENGA EN EL FRAGMENT
        webView.getSettings().setJavaScriptEnabled(true);   // HABILITO SCRIPTS DE JAVASCRIPT
        webView.loadUrl("http://"+url);
        Toast.makeText(v.getContext(), "URL: " + url, Toast.LENGTH_SHORT).show();

        return v;
    }
}
