package fantasy0v0.dinoFx.obj;

import javafx.scene.canvas.GraphicsContext;

public class Game {

  private final GraphicsContext graphicsContext;

  private Ground ground;

  private boolean paused;

  public Game(GraphicsContext graphicsContext) {
    this.graphicsContext = graphicsContext;
    init();
  }

  private void init() {
    ground = new Ground(graphicsContext);
  }

  public void update() {
    ground.update();
  }

  public boolean isPaused() {
    return paused;
  }

  public void pause() {
    ground.pause();
  }


}
