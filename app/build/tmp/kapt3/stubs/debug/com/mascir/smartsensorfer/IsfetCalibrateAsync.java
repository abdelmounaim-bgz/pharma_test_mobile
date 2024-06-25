package com.mascir.smartsensorfer;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0011\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000  2\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0001:\u0001 B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J!\u0010\u000f\u001a\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u00122\u0006\u0010\u0013\u001a\u00020\u0010\u00a2\u0006\u0002\u0010\u0014J\u0019\u0010\u0015\u001a\u00020\u00102\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00100\u0012\u00a2\u0006\u0002\u0010\u0017J\u0019\u0010\u0018\u001a\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u0012\u00a2\u0006\u0002\u0010\u0017J\'\u0010\u0019\u001a\u0004\u0018\u00010\u00032\u0016\u0010\u001a\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00020\u0012\"\u0004\u0018\u00010\u0002H\u0014\u00a2\u0006\u0002\u0010\u001bJ\u0012\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0003H\u0014J\b\u0010\u001f\u001a\u00020\u001dH\u0014R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006!"}, d2 = {"Lcom/mascir/smartsensorfer/IsfetCalibrateAsync;", "Landroid/os/AsyncTask;", "Landroid/bluetooth/BluetoothDevice;", "Ljava/lang/Void;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "CalBtn", "Landroid/widget/Button;", "insertion", "Landroid/widget/EditText;", "loadingText", "Landroid/widget/TextView;", "progress", "Landroid/widget/ProgressBar;", "calcuateB", "", "X", "", "a", "([Ljava/lang/Double;D)D", "calculateA", "x", "([Ljava/lang/Double;)D", "correlationCoefficient", "doInBackground", "p0", "([Landroid/bluetooth/BluetoothDevice;)Ljava/lang/Void;", "onPostExecute", "", "result", "onPreExecute", "Companion", "app_debug"})
public final class IsfetCalibrateAsync extends android.os.AsyncTask<android.bluetooth.BluetoothDevice, java.lang.Void, java.lang.Void> {
    private final android.view.View view = null;
    private final android.widget.ProgressBar progress = null;
    private final android.widget.TextView loadingText = null;
    private final android.widget.EditText insertion = null;
    private final android.widget.Button CalBtn = null;
    @org.jetbrains.annotations.NotNull()
    private static java.lang.String resp = "";
    public static final com.mascir.smartsensorfer.IsfetCalibrateAsync.Companion Companion = null;
    
    @java.lang.Override()
    protected void onPreExecute() {
    }
    
    @java.lang.Override()
    protected void onPostExecute(@org.jetbrains.annotations.Nullable()
    java.lang.Void result) {
    }
    
    public final double calculateA(@org.jetbrains.annotations.NotNull()
    java.lang.Double[] x) {
        return 0.0;
    }
    
    public final double calcuateB(@org.jetbrains.annotations.NotNull()
    java.lang.Double[] X, double a) {
        return 0.0;
    }
    
    public final double correlationCoefficient(@org.jetbrains.annotations.NotNull()
    java.lang.Double[] X) {
        return 0.0;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    protected java.lang.Void doInBackground(@org.jetbrains.annotations.NotNull()
    android.bluetooth.BluetoothDevice... p0) {
        return null;
    }
    
    public IsfetCalibrateAsync(@org.jetbrains.annotations.NotNull()
    android.view.View view) {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u0006\t"}, d2 = {"Lcom/mascir/smartsensorfer/IsfetCalibrateAsync$Companion;", "", "()V", "resp", "", "getResp", "()Ljava/lang/String;", "setResp", "(Ljava/lang/String;)V", "app_debug"})
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