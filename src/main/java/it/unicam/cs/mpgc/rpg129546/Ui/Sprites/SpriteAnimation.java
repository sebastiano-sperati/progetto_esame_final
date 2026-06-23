package it.unicam.cs.mpgc.rpg129546.Ui.Sprites;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class SpriteAnimation {

    private final ImageView imageView;
    private final int frameWidth;
    private final int frameHeight;
    private final int frameCount;
    private final int columns;

    private int currentFrame = 0;
    private final Timeline timeline;

    public SpriteAnimation(ImageView imageView, int frameWidth, int frameHeight, int frameCount, int columns, int millis) {
        this.imageView = imageView;
        this.frameWidth = frameWidth;
        this.frameHeight = frameHeight;
        this.frameCount = frameCount;
        this.columns = columns;

        this.timeline = new Timeline(new KeyFrame(Duration.millis(millis), event -> nextFrame()));

        this.timeline.setCycleCount(Timeline.INDEFINITE);
    }

    private void nextFrame() {
        int column = currentFrame % columns;
        int row = currentFrame / columns;

        imageView.setViewport(new Rectangle2D(column * frameWidth, row * frameHeight, frameWidth, frameHeight));

        currentFrame = (currentFrame + 1) % frameCount;
    }

    public void play() {
        timeline.play();
    }

    public void stop() {
        timeline.stop();
    }
}