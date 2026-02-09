package com.BrainyByte.road_ai_system.model;

public class AiResult {

    private boolean potholeDetected;
    private double potholeSize;
    private double confidence;

    public boolean isPotholeDetected() {
        return potholeDetected;
    }

    public void setPotholeDetected(boolean potholeDetected) {
        this.potholeDetected = potholeDetected;
    }

    public double getPotholeSize() {
        return potholeSize;
    }

    public void setPotholeSize(double potholeSize) {
        this.potholeSize = potholeSize;
    }

    public double getConfidence() {
        return confidence;
    }

    public void setConfidence(double confidence) {
        this.confidence = confidence;
    }
}
