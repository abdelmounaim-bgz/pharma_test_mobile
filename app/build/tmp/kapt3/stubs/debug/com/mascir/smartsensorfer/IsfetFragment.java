package com.mascir.smartsensorfer;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0005\u00a2\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u001a\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016\u00a8\u0006\u000f"}, d2 = {"Lcom/mascir/smartsensorfer/IsfetFragment;", "Landroidx/fragment/app/Fragment;", "()V", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "Companion", "app_debug"})
public final class IsfetFragment extends androidx.fragment.app.Fragment {
    @org.jetbrains.annotations.Nullable()
    private static java.lang.String a;
    @org.jetbrains.annotations.Nullable()
    private static java.lang.String b;
    @org.jetbrains.annotations.Nullable()
    private static java.lang.String Rcar;
    @org.jetbrains.annotations.NotNull()
    private static java.lang.Double[] calValues;
    @org.jetbrains.annotations.NotNull()
    public static android.widget.TextView vsg1;
    @org.jetbrains.annotations.NotNull()
    public static android.widget.TextView vsg2;
    @org.jetbrains.annotations.NotNull()
    public static android.widget.TextView vsg3;
    private static int num = 0;
    public static final com.mascir.smartsensorfer.IsfetFragment.Companion Companion = null;
    private java.util.HashMap _$_findViewCache;
    
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
    
    public IsfetFragment() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u0011\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\"\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\u0016\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0017\u001a\u00020\u0018X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u00020\u001eX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001a\u0010#\u001a\u00020\u001eX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b$\u0010 \"\u0004\b%\u0010\"R\u001a\u0010&\u001a\u00020\u001eX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\'\u0010 \"\u0004\b(\u0010\"\u00a8\u0006)"}, d2 = {"Lcom/mascir/smartsensorfer/IsfetFragment$Companion;", "", "()V", "Rcar", "", "getRcar", "()Ljava/lang/String;", "setRcar", "(Ljava/lang/String;)V", "a", "getA", "setA", "b", "getB", "setB", "calValues", "", "", "getCalValues", "()[Ljava/lang/Double;", "setCalValues", "([Ljava/lang/Double;)V", "[Ljava/lang/Double;", "num", "", "getNum", "()I", "setNum", "(I)V", "vsg1", "Landroid/widget/TextView;", "getVsg1", "()Landroid/widget/TextView;", "setVsg1", "(Landroid/widget/TextView;)V", "vsg2", "getVsg2", "setVsg2", "vsg3", "getVsg3", "setVsg3", "app_debug"})
    public static final class Companion {
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String getA() {
            return null;
        }
        
        public final void setA(@org.jetbrains.annotations.Nullable()
        java.lang.String p0) {
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String getB() {
            return null;
        }
        
        public final void setB(@org.jetbrains.annotations.Nullable()
        java.lang.String p0) {
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String getRcar() {
            return null;
        }
        
        public final void setRcar(@org.jetbrains.annotations.Nullable()
        java.lang.String p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.Double[] getCalValues() {
            return null;
        }
        
        public final void setCalValues(@org.jetbrains.annotations.NotNull()
        java.lang.Double[] p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.TextView getVsg1() {
            return null;
        }
        
        public final void setVsg1(@org.jetbrains.annotations.NotNull()
        android.widget.TextView p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.TextView getVsg2() {
            return null;
        }
        
        public final void setVsg2(@org.jetbrains.annotations.NotNull()
        android.widget.TextView p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.TextView getVsg3() {
            return null;
        }
        
        public final void setVsg3(@org.jetbrains.annotations.NotNull()
        android.widget.TextView p0) {
        }
        
        public final int getNum() {
            return 0;
        }
        
        public final void setNum(int p0) {
        }
        
        private Companion() {
            super();
        }
    }
}