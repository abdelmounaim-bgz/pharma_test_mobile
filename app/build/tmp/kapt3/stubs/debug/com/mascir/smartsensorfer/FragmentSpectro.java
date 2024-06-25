package com.mascir.smartsensorfer;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 (2\u00020\u0001:\u0001(B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0010\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\"\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J&\u0010\u001f\u001a\u0004\u0018\u00010\u001c2\u0006\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#2\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J\u001a\u0010&\u001a\u00020\u00122\u0006\u0010\'\u001a\u00020\u001c2\b\u0010$\u001a\u0004\u0018\u00010%H\u0016R.\u0010\u0003\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010\u00a8\u0006)"}, d2 = {"Lcom/mascir/smartsensorfer/FragmentSpectro;", "Landroidx/fragment/app/Fragment;", "()V", "data", "", "", "", "getData", "()Ljava/util/List;", "setData", "(Ljava/util/List;)V", "exists", "", "getExists", "()Z", "setExists", "(Z)V", "deleteScan", "", "listPosition", "", "onContextItemSelected", "item", "Landroid/view/MenuItem;", "onCreateContextMenu", "menu", "Landroid/view/ContextMenu;", "v", "Landroid/view/View;", "menuInfo", "Landroid/view/ContextMenu$ContextMenuInfo;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "Companion", "app_debug"})
public final class FragmentSpectro extends androidx.fragment.app.Fragment {
    private boolean exists = false;
    @org.jetbrains.annotations.Nullable()
    private java.util.List<java.util.Map<java.lang.String, java.lang.String>> data;
    @org.jetbrains.annotations.NotNull()
    public static android.content.SharedPreferences sharedPreference;
    public static final com.mascir.smartsensorfer.FragmentSpectro.Companion Companion = null;
    private java.util.HashMap _$_findViewCache;
    
    public final boolean getExists() {
        return false;
    }
    
    public final void setExists(boolean p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<java.util.Map<java.lang.String, java.lang.String>> getData() {
        return null;
    }
    
    public final void setData(@org.jetbrains.annotations.Nullable()
    java.util.List<java.util.Map<java.lang.String, java.lang.String>> p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    @java.lang.Override()
    public void onViewCreated(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    public void onCreateContextMenu(@org.jetbrains.annotations.NotNull()
    android.view.ContextMenu menu, @org.jetbrains.annotations.NotNull()
    android.view.View v, @org.jetbrains.annotations.Nullable()
    android.view.ContextMenu.ContextMenuInfo menuInfo) {
    }
    
    @java.lang.Override()
    public boolean onContextItemSelected(@org.jetbrains.annotations.NotNull()
    android.view.MenuItem item) {
        return false;
    }
    
    private final void deleteScan(int listPosition) {
    }
    
    public FragmentSpectro() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u0006\t"}, d2 = {"Lcom/mascir/smartsensorfer/FragmentSpectro$Companion;", "", "()V", "sharedPreference", "Landroid/content/SharedPreferences;", "getSharedPreference", "()Landroid/content/SharedPreferences;", "setSharedPreference", "(Landroid/content/SharedPreferences;)V", "app_debug"})
    public static final class Companion {
        
        @org.jetbrains.annotations.NotNull()
        public final android.content.SharedPreferences getSharedPreference() {
            return null;
        }
        
        public final void setSharedPreference(@org.jetbrains.annotations.NotNull()
        android.content.SharedPreferences p0) {
        }
        
        private Companion() {
            super();
        }
    }
}