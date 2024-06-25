package com.mascir.smartsensorfer;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0015\u00a8\u0006\b"}, d2 = {"Lcom/mascir/smartsensorfer/Login;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "app_debug"})
public final class Login extends androidx.appcompat.app.AppCompatActivity {
    @org.jetbrains.annotations.NotNull()
    private static java.lang.String username = "";
    @org.jetbrains.annotations.NotNull()
    public static android.content.SharedPreferences sharedPreference;
    private static boolean logged = false;
    public static final com.mascir.smartsensorfer.Login.Companion Companion = null;
    private java.util.HashMap _$_findViewCache;
    
    @androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.LOLLIPOP)
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    public Login() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0015"}, d2 = {"Lcom/mascir/smartsensorfer/Login$Companion;", "", "()V", "logged", "", "getLogged", "()Z", "setLogged", "(Z)V", "sharedPreference", "Landroid/content/SharedPreferences;", "getSharedPreference", "()Landroid/content/SharedPreferences;", "setSharedPreference", "(Landroid/content/SharedPreferences;)V", "username", "", "getUsername", "()Ljava/lang/String;", "setUsername", "(Ljava/lang/String;)V", "app_debug"})
    public static final class Companion {
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getUsername() {
            return null;
        }
        
        public final void setUsername(@org.jetbrains.annotations.NotNull()
        java.lang.String p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.content.SharedPreferences getSharedPreference() {
            return null;
        }
        
        public final void setSharedPreference(@org.jetbrains.annotations.NotNull()
        android.content.SharedPreferences p0) {
        }
        
        public final boolean getLogged() {
            return false;
        }
        
        public final void setLogged(boolean p0) {
        }
        
        private Companion() {
            super();
        }
    }
}