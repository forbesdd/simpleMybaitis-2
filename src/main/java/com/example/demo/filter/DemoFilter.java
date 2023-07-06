package com.example.demo.filter;

import jakarta.servlet.*;

import java.io.IOException;

//@WebFilter(urlPatterns = "/*")
public class DemoFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // フィルタの初期化処理を実装する場合はここに記述します
        System.out.println("init デフォルト");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        // フィルタのメインの処理を実装します
        // リクエストを変更したり、レスポンスを変更したりすることができます
        System.out.println("init　doFilter");
        // フィルタチェーンを呼び出して次のフィルタまたはサーブレットに処理を渡します
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        // フィルタの終了処理を実装する場合はここに記述します
        System.out.println("init　 destroy");
    }
}



