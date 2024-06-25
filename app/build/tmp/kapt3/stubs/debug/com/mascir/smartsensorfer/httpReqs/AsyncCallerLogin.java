package com.mascir.smartsensorfer.httpReqs;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u00192\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0019B\u001d\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\'\u0010\u0011\u001a\u0004\u0018\u00010\u00022\u0016\u0010\u0012\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00020\u0013\"\u0004\u0018\u00010\u0002H\u0014\u00a2\u0006\u0002\u0010\u0014J\u0012\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0002H\u0014J\b\u0010\u0018\u001a\u00020\u0016H\u0014R\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006\u001a"}, d2 = {"Lcom/mascir/smartsensorfer/httpReqs/AsyncCallerLogin;", "Landroid/os/AsyncTask;", "", "Ljava/lang/Void;", "progress", "Landroid/widget/ProgressBar;", "btn", "Landroid/widget/Button;", "act", "Landroid/app/Activity;", "(Landroid/widget/ProgressBar;Landroid/widget/Button;Landroid/app/Activity;)V", "getAct", "()Landroid/app/Activity;", "getBtn", "()Landroid/widget/Button;", "getProgress", "()Landroid/widget/ProgressBar;", "doInBackground", "p0", "", "([Ljava/lang/String;)Ljava/lang/String;", "onPostExecute", "", "result", "onPreExecute", "Companion", "app_debug"})
public final class AsyncCallerLogin extends android.os.AsyncTask<java.lang.String, java.lang.Void, java.lang.String> {
    @org.jetbrains.annotations.NotNull()
    private final android.widget.ProgressBar progress = null;
    @org.jetbrains.annotations.NotNull()
    private final android.widget.Button btn = null;
    @org.jetbrains.annotations.NotNull()
    private final android.app.Activity act = null;
    @org.jetbrains.annotations.NotNull()
    private static java.lang.String res = "";
    @org.jetbrains.annotations.NotNull()
    private static org.json.JSONObject user;
    public static final com.mascir.smartsensorfer.httpReqs.AsyncCallerLogin.Companion Companion = null;
    
    @org.jetbrains.annotations.NotNull()
    public final android.widget.ProgressBar getProgress() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.widget.Button getBtn() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.app.Activity getAct() {
        return null;
    }
    
    @java.lang.Override()
    protected void onPreExecute() {
    }
    
    @java.lang.Override()
    protected void onPostExecute(@org.jetbrains.annotations.Nullable()
    java.lang.String result) {
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    protected java.lang.String doInBackground(@org.jetbrains.annotations.NotNull()
    java.lang.String... p0) {
        return null;
    }
    
    public AsyncCallerLogin(@org.jetbrains.annotations.NotNull()
    android.widget.ProgressBar progress, @org.jetbrains.annotations.NotNull()
    android.widget.Button btn, @org.jetbrains.annotations.NotNull()
    android.app.Activity act) {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e\u00a8\u0006\u000f"}, d2 = {"Lcom/mascir/smartsensorfer/httpReqs/AsyncCallerLogin$Companion;", "", "()V", "res", "", "getRes", "()Ljava/lang/String;", "setRes", "(Ljava/lang/String;)V", "user", "Lorg/json/JSONObject;", "getUser", "()Lorg/json/JSONObject;", "setUser", "(Lorg/json/JSONObject;)V", "app_debug"})
    public static final class Companion {
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getRes() {
            return null;
        }
        
        public final void setRes(@org.jetbrains.annotations.NotNull()
        java.lang.String p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final org.json.JSONObject getUser() {
            return null;
        }
        
        public final void setUser(@org.jetbrains.annotations.NotNull()
        org.json.JSONObject p0) {
        }
        
        private Companion() {
            super();
        }
    }
}