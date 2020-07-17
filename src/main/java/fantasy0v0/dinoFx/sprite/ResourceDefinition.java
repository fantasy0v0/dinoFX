package fantasy0v0.dinoFx.sprite;

import javafx.geometry.Point2D;
import javafx.scene.shape.Rectangle;

/**
 * 精灵定义类
 * <p>
 * Fan 1/16/2020
 */
public interface ResourceDefinition {

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
    Rectangle CLOUD = new Rectangle(86, 2, 46, 13);

    /**
     * 地平线
     */
    Rectangle HORIZON = new Rectangle(2, 54, 600, 13);

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
     * 霸王龙 初始
     */
    Rectangle TREX_INITIAL = new Rectangle(40, 4, 44, 46);

    /**
     * 霸王龙
     */
    Point2D TREX = new Point2D(848, 2);

    /**
     * 霸王龙 奔跑 0
     */
    Rectangle TREX_RUN_0 = new Rectangle(936, 2, 44, 47);

    /**
     * 霸王龙 奔跑 1
     */
    Rectangle TREX_RUN_1 = new Rectangle(980, 2, 44, 47);

    /**
     * 霸王龙 躲避 0
     */
    Rectangle TREX_DUCK_0 = new Rectangle(1112, 19, 59, 30);

    /**
     * 霸王龙 躲避 1
     */
    Rectangle TREX_DUCK_1 = new Rectangle(1171, 19, 59, 30);

    /**
     * 开始
     */
    Point2D STAR = new Point2D(645, 2);
  }

  interface HDPI {

  }
}