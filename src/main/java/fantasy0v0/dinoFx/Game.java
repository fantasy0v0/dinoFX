package fantasy0v0.dinoFx;

import javafx.scene.canvas.GraphicsContext;

public class Game {

  private final GraphicsContext graphicsContext;

  private Ground ground;

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
}
