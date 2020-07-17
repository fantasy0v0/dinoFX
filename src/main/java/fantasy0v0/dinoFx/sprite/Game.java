package fantasy0v0.dinoFx.sprite;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;

public class Game {

  private final GraphicsContext graphicsContext;

  private double width;

  private double height;

  private Ground ground;

  private Dino dino;

  private Cloud cloud;

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
    cloud = new Cloud(graphicsContext, this);
  }

  public void update() {
    cloud.update();
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

  public void onKeyPressed(KeyCode keyCode) {
    if (keyCode.equals(KeyCode.P)) {
      if (isPaused()) {
        resume();
      } else {
        pause();
      }
      return;
    }

    if (keyCode.equals(KeyCode.SPACE)) {
      dino.jump();
    } else if (keyCode.equals(KeyCode.DOWN)) {
      dino.startDuck();
    }
  }

  public void onKeyReleased(KeyCode keyCode) {
    if (keyCode.equals(KeyCode.DOWN)) {
      dino.endDuck();
    }
  }
}
