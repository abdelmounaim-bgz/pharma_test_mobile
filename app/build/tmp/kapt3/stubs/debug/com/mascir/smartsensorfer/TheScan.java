package com.mascir.smartsensorfer;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\t\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \"2\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\"B5\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u00a2\u0006\u0002\u0010\u0010J\'\u0010\u001a\u001a\u0004\u0018\u00010\u00032\u0016\u0010\u001b\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00020\u001c\"\u0004\u0018\u00010\u0002H\u0015\u00a2\u0006\u0002\u0010\u001dJ\u0012\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0003H\u0014J\b\u0010!\u001a\u00020\u001fH\u0014R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u00020\u0012X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0012X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006#"}, d2 = {"Lcom/mascir/smartsensorfer/TheScan;", "Landroid/os/AsyncTask;", "Landroid/bluetooth/BluetoothDevice;", "Ljava/lang/Void;", "context", "Landroid/content/Context;", "progress", "Landroid/widget/ProgressBar;", "loadingText", "Landroid/widget/TextView;", "insertion", "Landroidx/constraintlayout/widget/ConstraintLayout;", "resView", "Landroid/widget/LinearLayout;", "numEchant", "", "(Landroid/content/Context;Landroid/widget/ProgressBar;Landroid/widget/TextView;Landroidx/constraintlayout/widget/ConstraintLayout;Landroid/widget/LinearLayout;Ljava/lang/String;)V", "resFe", "", "getResFe", "()D", "setResFe", "(D)V", "resMg", "getResMg", "setResMg", "doInBackground", "p0", "", "([Landroid/bluetooth/BluetoothDevice;)Ljava/lang/Void;", "onPostExecute", "", "result", "onPreExecute", "Companion", "app_debug"})
public final class TheScan extends android.os.AsyncTask<android.bluetooth.BluetoothDevice, java.lang.Void, java.lang.Void> {
    private double resFe = 0.0;
    private double resMg = 0.0;
    private final android.content.Context context = null;
    private final android.widget.ProgressBar progress = null;
    private final android.widget.TextView loadingText = null;
    private final androidx.constraintlayout.widget.ConstraintLayout insertion = null;
    private final android.widget.LinearLayout resView = null;
    private final java.lang.String numEchant = null;
    @org.jetbrains.annotations.NotNull()
    private static java.lang.String resp = "";
    public static final com.mascir.smartsensorfer.TheScan.Companion Companion = null;
    
    public final double getResFe() {
        return 0.0;
    }
    
    public final void setResFe(double p0) {
    }
    
    public final double getResMg() {
        return 0.0;
    }
    
    public final void setResMg(double p0) {
    }
    
    @java.lang.Override()
    protected void onPreExecute() {
    }
    
    @java.lang.Override()
    protected void onPostExecute(@org.jetbrains.annotations.Nullable()
    java.lang.Void result) {
    }
    
    @org.jetbrains.annotations.Nullable()
    @androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.N)
    @android.annotation.SuppressLint(value = {"MissingPermission"})
    @java.lang.Override()
    protected java.lang.Void doInBackground(@org.jetbrains.annotations.NotNull()
    android.bluetooth.BluetoothDevice... p0) {
        return null;
    }
    
    public TheScan(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    android.widget.ProgressBar progress, @org.jetbrains.annotations.NotNull()
    android.widget.TextView loadingText, @org.jetbrains.annotations.NotNull()
    androidx.constraintlayout.widget.ConstraintLayout insertion, @org.jetbrains.annotations.NotNull()
    android.widget.LinearLayout resView, @org.jetbrains.annotations.NotNull()
    java.lang.String numEchant) {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u0006\t"}, d2 = {"Lcom/mascir/smartsensorfer/TheScan$Companion;", "", "()V", "resp", "", "getResp", "()Ljava/lang/String;", "setResp", "(Ljava/lang/String;)V", "app_debug"})
    public static final class Companion {
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getResp() {
            return null;
        }
        
        public final void setResp(@org.jetbrains.annotations.NotNull()
        java.lang.String p0) {
        }
        
        private Companion() {
            super();
        }
    }
}