package it.unicam.cs.mpgc.rpg129546.Ui.Sprites;
/**
 * contiene tutte le informazioni necessarie per riprodurre
 * una specifica animazione di uno spritesheet.
 * ogni istanza descrive la posizione dello spritesheet,
 * la dimensione dei frame, il numero di fotogrammi,
 * la velocità dell'animazione e i parametri grafici
 * necessari per il corretto posizionamento dello sprite.
 */

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

    public double getScale() { return scale; }

}