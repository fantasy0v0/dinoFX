package fantasy0v0.dinoFx.sprite;

import javafx.geometry.Point2D;

/**
 * 精灵定义类
 *
 * Fan 1/16/2020
 */
public interface SpriteDefinition {

  interface LDPI {

    /**
     * 大仙人掌
     */
    Point2D CACTUS_LARGE = new Point2D(332, 2);

    /**
     * 小仙人掌
     */
    Point2D CACTUS_SMALL = new Point2D(228, 2);

    /**
     * 云
     */
    Point2D CLOUD = new Point2D(86, 2);

    /**
     * 地平线
     */
    Point2D HORIZON = new Point2D(2, 54);

    /**
     * 月亮
     */
    Point2D MOON = new Point2D(484, 2);

    /**
     * 翼手龙
     */
    Point2D PTERODACTYL = new Point2D(134, 2);

    /**
     * 重新开始
     */
    Point2D RESTART = new Point2D(2, 2);

    /**
     * 文字
     */
    Point2D TEXT_SPRITE = new Point2D(655, 2);

    /**
     * 霸王龙
     */
    Point2D TREX = new Point2D(848, 2);

    /**
     * 开始
     */
    Point2D STAR = new Point2D(645, 2);
  }

  interface HDPI {

  }
}