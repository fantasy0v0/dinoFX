package fantasy0v0.dinoFx.sprite;

import fantasy0v0.dinoFx.utils.Time;
import javafx.scene.canvas.GraphicsContext;

public class Dino extends Sprite {

  private final Game game;

  private double x = 0;

  private boolean isPause = false;

  public Dino(GraphicsContext graphicsContext, Game game) {
    super(graphicsContext);
    this.game = game;
  }

  public void update() {
    double y = game.getHeight() - ResourceDefinition.LDPI.TREX_INITIAL.getHeight() - 10;
    drawImage(x, y, ResourceDefinition.LDPI.TREX_INITIAL);
    if (isPause) {
      return;
    }
    if (x > game.getWidth()) {
      x = -44;
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
