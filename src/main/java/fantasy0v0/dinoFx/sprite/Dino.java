package fantasy0v0.dinoFx.sprite;

import fantasy0v0.dinoFx.resources.Resources;
import fantasy0v0.dinoFx.utils.Time;
import javafx.scene.canvas.GraphicsContext;

public class Dino {

  private final GraphicsContext graphicsContext;

  private final Game game;

  private double x = 0;

  private boolean isPause = false;

  public Dino(GraphicsContext graphicsContext, Game game) {
    this.graphicsContext = graphicsContext;
    this.game = game;
  }

  public void update() {
    graphicsContext.drawImage(Resources.offlineResources1X, 40, 4, 44, 45, x, 0, 44, 45);
    if (isPause) {
      return;
    }
    if (x > game.getWidth()) {
      x = -game.getWidth();
    } else {
      x += Time.deltaTime * 120;
    }
  }

  public void pause() {
    isPause = true;
  }

  public void resume() {
    isPause = false;
  }
}
