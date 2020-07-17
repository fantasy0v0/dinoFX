package fantasy0v0.dinoFx.sprite;

import fantasy0v0.dinoFx.utils.Time;
import javafx.scene.canvas.GraphicsContext;

public class Cloud extends Sprite {

  private final Game game;

  private final double[] xPos = new double[3];

  private final double[] yPos = new double[3];

  public Cloud(GraphicsContext graphicsContext, Game game) {
    super(graphicsContext);
    this.game = game;
    for (int i = 0; i < xPos.length; i++) {
      xPos[i] = game.getWidth() + ResourceDefinition.LDPI.CLOUD.getWidth() * i * 3;
      yPos[i] = getRandomY();
    }

  }

  @Override
  public void update() {
    for (int i = 0; i < xPos.length; i++) {
      drawImage(xPos[i], yPos[i], ResourceDefinition.LDPI.CLOUD);
      xPos[i] -= 100 * Time.deltaTime;
      if (xPos[i] < -ResourceDefinition.LDPI.CLOUD.getWidth()) {
        xPos[i] = game.getWidth();
        yPos[i] = getRandomY();
      }
    }
  }

  private double getRandomY() {
    return Math.random() * 45 + 5;
  }
}
