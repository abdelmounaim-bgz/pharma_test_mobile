package com.mascir.smartsensorfer;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0014J\b\u0010\t\u001a\u00020\nH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2 = {"Lcom/mascir/smartsensorfer/Home;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "drawerLayout", "Landroidx/drawerlayout/widget/DrawerLayout;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onSupportNavigateUp", "", "Companion", "app_debug"})
public final class Home extends androidx.appcompat.app.AppCompatActivity {
    private androidx.drawerlayout.widget.DrawerLayout drawerLayout;
    @org.jetbrains.annotations.Nullable()
    private static android.bluetooth.BluetoothDevice theDevice;
    @org.jetbrains.annotations.Nullable()
    private static android.bluetooth.BluetoothSocket theSocket;
    @org.jetbrains.annotations.NotNull()
    private static final java.util.UUID uuid = null;
    private static boolean connected = false;
    public static final com.mascir.smartsensorfer.Home.Companion Companion = null;
    private java.util.HashMap _$_findViewCache;
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    public boolean onSupportNavigateUp() {
        return false;
    }
    
    public Home() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0015\u001a\u00020\u0016\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018\u00a8\u0006\u0019"}, d2 = {"Lcom/mascir/smartsensorfer/Home$Companion;", "", "()V", "connected", "", "getConnected", "()Z", "setConnected", "(Z)V", "theDevice", "Landroid/bluetooth/BluetoothDevice;", "getTheDevice", "()Landroid/bluetooth/BluetoothDevice;", "setTheDevice", "(Landroid/bluetooth/BluetoothDevice;)V", "theSocket", "Landroid/bluetooth/BluetoothSocket;", "getTheSocket", "()Landroid/bluetooth/BluetoothSocket;", "setTheSocket", "(Landroid/bluetooth/BluetoothSocket;)V", "uuid", "Ljava/util/UUID;", "getUuid", "()Ljava/util/UUID;", "app_debug"})
    public static final class Companion {
        
        @org.jetbrains.annotations.Nullable()
        public final android.bluetooth.BluetoothDevice getTheDevice() {
            return null;
        }
        
        public final void setTheDevice(@org.jetbrains.annotations.Nullable()
        android.bluetooth.BluetoothDevice p0) {
        }
        
        @org.jetbrains.annotations.Nullable()
        public final android.bluetooth.BluetoothSocket getTheSocket() {
            return null;
        }
        
        public final void setTheSocket(@org.jetbrains.annotations.Nullable()
        android.bluetooth.BluetoothSocket p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.UUID getUuid() {
            return null;
        }
        
        public final boolean getConnected() {
            return false;
        }
        
        public final void setConnected(boolean p0) {
        }
        
        private Companion() {
            super();
        }
    }
}