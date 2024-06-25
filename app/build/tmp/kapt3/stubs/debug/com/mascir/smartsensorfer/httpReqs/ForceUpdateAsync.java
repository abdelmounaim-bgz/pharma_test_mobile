package com.mascir.smartsensorfer.httpReqs;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001B%\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u00a2\u0006\u0002\u0010\fJ%\u0010\u000e\u001a\u00020\u00042\u0016\u0010\u000f\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00020\u0010\"\u0004\u0018\u00010\u0002H\u0014\u00a2\u0006\u0002\u0010\u0011J\u0012\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0004H\u0014J\u0006\u0010\u0015\u001a\u00020\u0013R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0002X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u0002X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0016"}, d2 = {"Lcom/mascir/smartsensorfer/httpReqs/ForceUpdateAsync;", "Landroid/os/AsyncTask;", "", "Ljava/lang/Void;", "Lorg/json/JSONObject;", "currentVersion", "context", "Landroid/content/Context;", "progress", "Landroid/widget/ProgressBar;", "updateBtn", "Landroid/widget/Button;", "(Ljava/lang/String;Landroid/content/Context;Landroid/widget/ProgressBar;Landroid/widget/Button;)V", "latestVersion", "doInBackground", "p0", "", "([Ljava/lang/String;)Lorg/json/JSONObject;", "onPostExecute", "", "jsonObject", "showForceUpdateDialog", "app_debug"})
public final class ForceUpdateAsync extends android.os.AsyncTask<java.lang.String, java.lang.Void, org.json.JSONObject> {
    private final android.widget.ProgressBar progress = null;
    private final android.widget.Button updateBtn = null;
    private java.lang.String latestVersion;
    private final java.lang.String currentVersion = null;
    private final android.content.Context context = null;
    
    @java.lang.Override()
    protected void onPostExecute(@org.jetbrains.annotations.Nullable()
    org.json.JSONObject jsonObject) {
    }
    
    public final void showForceUpdateDialog() {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    protected org.json.JSONObject doInBackground(@org.jetbrains.annotations.NotNull()
    java.lang.String... p0) {
        return null;
    }
    
    public ForceUpdateAsync(@org.jetbrains.annotations.NotNull()
    java.lang.String currentVersion, @org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    android.widget.ProgressBar progress, @org.jetbrains.annotations.NotNull()
    android.widget.Button updateBtn) {
        super();
    }
}