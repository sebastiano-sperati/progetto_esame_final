package it.unicam.cs.mpgc.rpg129546.Ui.Sprites;

public class SpriteData {

    private final String path;
    private final int frameWidth;
    private final int frameHeight;
    private final int frameCount;
    private final int columns;
    private final int millis;
    private final double offsetX;
    private final double offsetY;
    private final double scale;

    public SpriteData(String path, int frameWidth, int frameHeight, int frameCount, int columns, int millis, double offsetX, double offsetY, double scale){
        this.path = path;
        this.frameWidth = frameWidth;
        this.frameHeight = frameHeight;
        this.frameCount = frameCount;
        this.columns = columns;
        this.millis = millis;
        this.offsetX=offsetX;
        this.offsetY=offsetY;
        this.scale=scale;
    }

    public String getPath() {
        return path;
    }

    public int getFrameWidth() {
        return frameWidth;
    }

    public int getFrameHeight() {
        return frameHeight;
    }

    public int getFrameCount() {
        return frameCount;
    }

    public int getColumns() {
        return columns;
    }

    public int getMillis() {
        return millis;
    }

    public double getOffsetX() { return offsetX; }

    public double getOffsetY() { return offsetY; }

    public double getScale() { return scale; }

}