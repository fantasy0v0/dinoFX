package fantasy0v0.dinoFx.sprite;

import javafx.scene.canvas.GraphicsContext;

public class Game {

  private final GraphicsContext graphicsContext;

  private double width;

  private double height;

  private Ground ground;

  private Dino dino;

  private boolean paused;

  public Game(GraphicsContext graphicsContext, double width, double height) {
    this.width = width;
    this.height = height;
    this.graphicsContext = graphicsContext;
    init();
  }

  private void init() {
    ground = new Ground(graphicsContext, this);
    dino = new Dino(graphicsContext, this);
  }

  public void update() {
    ground.update();
    dino.update();
  }

  public boolean isPaused() {
    return paused;
  }

  public void pause() {
    ground.pause();
    dino.pause();
    paused = true;
  }

  public void resume() {
    ground.resume();
    dino.resume();
    paused = false;
  }

  public double getWidth() {
    return width;
  }

  public double getHeight() {
    return height;
  }
}
