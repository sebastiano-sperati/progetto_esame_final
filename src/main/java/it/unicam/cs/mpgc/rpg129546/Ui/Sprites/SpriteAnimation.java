package it.unicam.cs.mpgc.rpg129546.Ui.Sprites;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
/**
 * gestisce la riproduzione di un'animazione basata su uno spritesheet.
 * l'animazione viene ottenuta aggiornando periodicamente il viewport
 * dell'ImageView, mostrando un frame differente dello spritesheet.
 * supporta sia animazioni cicliche (idle) sia animazioni eseguite
 * una sola volta (attacchi, danno, morte).
 */
public class SpriteAnimation {

    private final ImageView imageView;
    private final int frameWidth;
    private final int frameHeight;
    private final int frameCount;
    private final int columns;

    private int currentFrame = 0;
    private final Timeline timeline;
    /**
     * crea una nuova animazione associata ad uno spritesheet.
     * @param imageView ImageView su cui riprodurre l'animazione
     * @param frameWidth larghezza di un singolo frame
     * @param frameHeight altezza di un singolo frame
     * @param frameCount numero totale di frame
     * @param columns numero di colonne dello spritesheet
     * @param millis intervallo di tempo tra due frame consecutivi
     * @param loop true se l'animazione deve essere ripetuta all'infinito
     * @param onFinished operazione da eseguire al termine dell'animazione
     */
    public SpriteAnimation(ImageView imageView, int frameWidth, int frameHeight, int frameCount, int columns, int millis, boolean loop, Runnable onFinished) {
        this.imageView = imageView;
        this.frameWidth = frameWidth;
        this.frameHeight = frameHeight;
        this.frameCount = frameCount;
        this.columns = columns;

        this.timeline = new Timeline(new KeyFrame(Duration.millis(millis), event -> nextFrame()));

        timeline.setCycleCount(loop ? Timeline.INDEFINITE : frameCount);

        timeline.setOnFinished(event -> {
            if (onFinished != null) {
                onFinished.run();
            }
        });
    }

    public void play() {
        currentFrame = 0;
        applyFrame();
        timeline.playFromStart();
    }

    private void nextFrame() {
        currentFrame = (currentFrame + 1) % frameCount;
        applyFrame();
    }
    /**
     * aggiorna il viewport dell'ImageView per visualizzare
     * il frame corrente dello spritesheet.
     */
    private void applyFrame() {
        int column = currentFrame % columns;
        int row = currentFrame / columns;

        imageView.setViewport(new Rectangle2D(column * frameWidth, row * frameHeight, frameWidth, frameHeight));
    }

    public void stop() {
        timeline.stop();
    }
}