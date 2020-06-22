package fantasy0v0.dinoFx.sprite;

import javafx.scene.canvas.GraphicsContext;

public class Game {

  private final GraphicsContext graphicsContext;

  private Ground ground;

  private Dino dino;

  private boolean paused;

  public Game(GraphicsContext graphicsContext) {
    this.graphicsContext = graphicsContext;
    init();
  }

  private void init() {
    ground = new Ground(graphicsContext);
    dino = new Dino(graphicsContext);
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


}
