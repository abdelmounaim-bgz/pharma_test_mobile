package com.mascir.smartsensorfer.storage;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010 \n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0006\n\u0002\b\u0003\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J@\u0010\u0005\u001a\u00020\u00062(\u0010\u0007\u001a$\u0012\u0004\u0012\u00020\t\u0012\u001a\u0012\u0018\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\b0\nj\u0002`\f0\b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0007J2\u0010\u0010\u001a\u00020\u00062(\u0010\u0007\u001a$\u0012\u0004\u0012\u00020\t\u0012\u001a\u0012\u0018\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\b0\nj\u0002`\f0\bH\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2 = {"Lcom/mascir/smartsensorfer/storage/CsvStorage;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "saveReading", "", "result", "Lkotlin/Pair;", "", "", "", "Lcom/mascir/smartsensorfer/bluetooth/Reading;", "avg", "", "", "saveReadingFiles", "Companion", "app_debug"})
public final class CsvStorage {
    private final android.content.Context context = null;
    @org.jetbrains.annotations.NotNull()
    private static java.lang.String nameOfFile = "";
    @org.jetbrains.annotations.NotNull()
    private static java.lang.String nameOfFileAvg = "";
    @org.jetbrains.annotations.NotNull()
    private static java.lang.String spectroId = "";
    public static final com.mascir.smartsensorfer.storage.CsvStorage.Companion Companion = null;
    
    @androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.N)
    @android.annotation.SuppressLint(value = {"NewApi"})
    public final void saveReading(@org.jetbrains.annotations.NotNull()
    kotlin.Pair<java.lang.Integer, ? extends java.util.List<kotlin.Pair<java.lang.Float, java.lang.Float>>> result, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.Double> avg) {
    }
    
    @androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.N)
    @android.annotation.SuppressLint(value = {"NewApi"})
    public final void saveReadingFiles(@org.jetbrains.annotations.NotNull()
    kotlin.Pair<java.lang.Integer, ? extends java.util.List<kotlin.Pair<java.lang.Float, java.lang.Float>>> result) {
    }
    
    public CsvStorage(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\b\u00a8\u0006\u000f"}, d2 = {"Lcom/mascir/smartsensorfer/storage/CsvStorage$Companion;", "", "()V", "nameOfFile", "", "getNameOfFile", "()Ljava/lang/String;", "setNameOfFile", "(Ljava/lang/String;)V", "nameOfFileAvg", "getNameOfFileAvg", "setNameOfFileAvg", "spectroId", "getSpectroId", "setSpectroId", "app_debug"})
    public static final class Companion {
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getNameOfFile() {
            return null;
        }
        
        public final void setNameOfFile(@org.jetbrains.annotations.NotNull()
        java.lang.String p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getNameOfFileAvg() {
            return null;
        }
        
        public final void setNameOfFileAvg(@org.jetbrains.annotations.NotNull()
        java.lang.String p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getSpectroId() {
            return null;
        }
        
        public final void setSpectroId(@org.jetbrains.annotations.NotNull()
        java.lang.String p0) {
        }
        
        private Companion() {
            super();
        }
    }
}