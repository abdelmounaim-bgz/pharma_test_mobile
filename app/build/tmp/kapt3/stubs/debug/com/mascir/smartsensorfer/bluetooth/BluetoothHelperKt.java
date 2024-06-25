package com.mascir.smartsensorfer.bluetooth;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 2, d1 = {"\u0000B\n\u0000\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010 \n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\"\n\u0002\b\u0004\u001a\u0006\u0010\u0014\u001a\u00020\u0015\u001a\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00020\u0017\u001a\u000e\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u0007\"\u0017\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004\"?\u0010\u0005\u001a0\u0012\u0004\u0012\u00020\u0007\u0012&\u0012$\u0012\u0004\u0012\u00020\t\u0012\u001a\u0012\u0018\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\b0\nj\u0002`\f0\b0\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u000e\u0010\u000f\u001a\u00020\u0007X\u0082D\u00a2\u0006\u0002\n\u0000\"?\u0010\u0010\u001a0\u0012\u0004\u0012\u00020\u0007\u0012&\u0012$\u0012\u0004\u0012\u00020\t\u0012\u001a\u0012\u0018\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\b0\nj\u0002`\f0\b0\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000e\"\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004\u00a2\u0006\u0002\n\u0000*.\u0010\u001a\"\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\b0\n2\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\b0\n\u00a8\u0006\u001b"}, d2 = {"candidateNonPairedDevices", "", "Landroid/bluetooth/BluetoothDevice;", "getCandidateNonPairedDevices", "()Ljava/util/Set;", "defaultTransformer", "Lkotlin/Function1;", "", "Lkotlin/Pair;", "", "", "", "Lcom/mascir/smartsensorfer/bluetooth/Reading;", "getDefaultTransformer", "()Lkotlin/jvm/functions/Function1;", "sensor_name_regex", "transform", "getTransform", "uuid", "Ljava/util/UUID;", "checkBluetooth", "", "fetchInPairedDevices", "", "isValidDevice", "deviceName", "Reading", "app_debug"})
public final class BluetoothHelperKt {
    private static final java.lang.String sensor_name_regex = "AgriSensor";
    private static final java.util.UUID uuid = null;
    @org.jetbrains.annotations.NotNull()
    private static final java.util.Set<android.bluetooth.BluetoothDevice> candidateNonPairedDevices = null;
    @org.jetbrains.annotations.NotNull()
    private static final kotlin.jvm.functions.Function1<java.lang.String, kotlin.Pair<java.lang.Integer, java.util.List<kotlin.Pair<java.lang.Float, java.lang.Float>>>> defaultTransformer = null;
    @org.jetbrains.annotations.NotNull()
    private static final kotlin.jvm.functions.Function1<java.lang.String, kotlin.Pair<java.lang.Integer, java.util.List<kotlin.Pair<java.lang.Float, java.lang.Float>>>> transform = null;
    
    @org.jetbrains.annotations.NotNull()
    public static final java.util.Set<android.bluetooth.BluetoothDevice> fetchInPairedDevices() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final java.util.Set<android.bluetooth.BluetoothDevice> getCandidateNonPairedDevices() {
        return null;
    }
    
    public static final boolean isValidDevice(@org.jetbrains.annotations.NotNull()
    java.lang.String deviceName) {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final kotlin.jvm.functions.Function1<java.lang.String, kotlin.Pair<java.lang.Integer, java.util.List<kotlin.Pair<java.lang.Float, java.lang.Float>>>> getDefaultTransformer() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final kotlin.jvm.functions.Function1<java.lang.String, kotlin.Pair<java.lang.Integer, java.util.List<kotlin.Pair<java.lang.Float, java.lang.Float>>>> getTransform() {
        return null;
    }
    
    public static final boolean checkBluetooth() {
        return false;
    }
}