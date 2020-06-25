package fantasy0v0.dinoFx.sprite;

import fantasy0v0.dinoFx.utils.Time;
import javafx.scene.canvas.GraphicsContext;

public class Ground extends Sprite {

  private final Game game;

  private double x = 0;

  private double sx = 600;

  private boolean isPause = false;

  public Ground(GraphicsContext graphicsContext, Game game) {
    super(graphicsContext);
    this.game = game;
  }

  public void update() {
    if (!isPause) {
      double distance = Time.deltaTime * 120;
      x -= distance;
      sx -= distance;
      if (x <= -game.getWidth()) {
        x = game.getWidth();
      }
      if (sx <= -game.getWidth()) {
        sx = game.getWidth();
      }
    }
    double y = game.getHeight() - ResourceDefinition.LDPI.HORIZON.getHeight() - 10;
    drawImage(x, y, ResourceDefinition.LDPI.HORIZON);
    drawImage(sx, y, ResourceDefinition.LDPI.HORIZON);
  }

  public void pause() {
    isPause = true;
  }

  public void resume() {
    isPause = false;
  }

  public void reset() {
    x = 0;
  }

}
