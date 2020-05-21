package fantasy0v0.dinoFx.obj;

import fantasy0v0.dinoFx.resources.Resources;
import fantasy0v0.dinoFx.sprite.SpriteDefinition;
import fantasy0v0.dinoFx.utils.Time;
import javafx.scene.canvas.GraphicsContext;

public class Ground {

  private final GraphicsContext graphicsContext;

  private double x = 0;

  private double sx = 600;

  private boolean isPause = false;

  public Ground(GraphicsContext graphicsContext) {
    this.graphicsContext = graphicsContext;
  }

  public void update() {
    if (!isPause) {
      double distance = Time.deltaTime * 120;
      x -= distance;
      sx -= distance;
      if (x <= -600) {
        x = 600;
      }
      if (sx <= -600) {
        sx = 600;
      }
    }
    graphicsContext.drawImage(
      Resources.offlineResources1X, SpriteDefinition.LDPI.HORIZON.getX(), SpriteDefinition.LDPI.HORIZON.getY(),
      600, 13,
      x, 100, 600, 13);
    graphicsContext.drawImage(
      Resources.offlineResources1X, SpriteDefinition.LDPI.HORIZON.getX() + 600, SpriteDefinition.LDPI.HORIZON.getY(),
      600, 13,
      sx, 100, 600, 13);
  }

  public void pause() {
    isPause = true;
  }

  public void reset() {
    x = 0;
  }

}
