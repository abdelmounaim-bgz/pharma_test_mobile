package com.mascir.smartsensorfer;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u00132\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0013B\u001d\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\'\u0010\u000b\u001a\u0004\u0018\u00010\u00032\u0016\u0010\f\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00020\r\"\u0004\u0018\u00010\u0002H\u0014\u00a2\u0006\u0002\u0010\u000eJ\u0012\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0003H\u0014J\b\u0010\u0012\u001a\u00020\u0010H\u0014R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2 = {"Lcom/mascir/smartsensorfer/Calibrate;", "Landroid/os/AsyncTask;", "Landroid/bluetooth/BluetoothDevice;", "Ljava/lang/Void;", "progress", "Landroid/widget/ProgressBar;", "loadingText", "Landroid/widget/TextView;", "insertion", "Landroidx/constraintlayout/widget/ConstraintLayout;", "(Landroid/widget/ProgressBar;Landroid/widget/TextView;Landroidx/constraintlayout/widget/ConstraintLayout;)V", "doInBackground", "p0", "", "([Landroid/bluetooth/BluetoothDevice;)Ljava/lang/Void;", "onPostExecute", "", "result", "onPreExecute", "Companion", "app_debug"})
public final class Calibrate extends android.os.AsyncTask<android.bluetooth.BluetoothDevice, java.lang.Void, java.lang.Void> {
    private final android.widget.ProgressBar progress = null;
    private final android.widget.TextView loadingText = null;
    private final androidx.constraintlayout.widget.ConstraintLayout insertion = null;
    @org.jetbrains.annotations.NotNull()
    private static java.lang.String resp = "";
    public static final com.mascir.smartsensorfer.Calibrate.Companion Companion = null;
    
    @java.lang.Override()
    protected void onPreExecute() {
    }
    
    @java.lang.Override()
    protected void onPostExecute(@org.jetbrains.annotations.Nullable()
    java.lang.Void result) {
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    protected java.lang.Void doInBackground(@org.jetbrains.annotations.NotNull()
    android.bluetooth.BluetoothDevice... p0) {
        return null;
    }
    
    public Calibrate(@org.jetbrains.annotations.NotNull()
    android.widget.ProgressBar progress, @org.jetbrains.annotations.NotNull()
    android.widget.TextView loadingText, @org.jetbrains.annotations.NotNull()
    androidx.constraintlayout.widget.ConstraintLayout insertion) {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u0006\t"}, d2 = {"Lcom/mascir/smartsensorfer/Calibrate$Companion;", "", "()V", "resp", "", "getResp", "()Ljava/lang/String;", "setResp", "(Ljava/lang/String;)V", "app_debug"})
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