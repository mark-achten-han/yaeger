package nl.meron.showcase;

import nl.meron.showcase.scenes.dynamicscenewithtimer.DynamicSceneWithTimer;
import nl.meron.showcase.scenes.entitymaps.TileMapScene;
import nl.meron.showcase.scenes.selection.SelectionScene;
import nl.meron.showcase.scenes.shapeentities.ShapeEntitiesScene;
import nl.meron.showcase.scenes.spriteentities.SpriteEntitiesScene;
import nl.meron.showcase.scenes.textentities.TextEntitiesScene;
import nl.meron.yaeger.engine.Size;
import nl.meron.yaeger.engine.YaegerApplication;

/**
 * ShowCase of all Yaeger Features.
 */
public class YaegerShowCase extends YaegerApplication {

    private static final String GAME_TITLE = "Yaeger Show Case";
    private static final int WIDTH = 1280;
    private static final int HEIGHT = 719;
    public static final int SCENE_SELECTION = 0;
    public static final int SCENE_TEXT_ENTITIES = 1;
    public static final int SCENE_SPRITE_ENTITIES = 2;
    public static final int SCENE_SHAPE_ENTITIES = 3;
    public static final int SCENE_WITH_TIMERS = 4;
    public static final int SCENE_WITH_ENTITYMAPS = 5;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    protected void initializeGame() {
        setGameTitle(GAME_TITLE);
        setSize(new Size(WIDTH, HEIGHT));
    }

    @Override
    protected void setupScenes() {
        var selectionScene = new SelectionScene(this);
        addScene(SCENE_SELECTION, selectionScene);
        var textEntitiesScene = new TextEntitiesScene(this);
        addScene(SCENE_TEXT_ENTITIES, textEntitiesScene);
        var spriteEntitiesScene = new SpriteEntitiesScene(this);
        addScene(SCENE_SPRITE_ENTITIES, spriteEntitiesScene);
        var shapeEntitiesScene = new ShapeEntitiesScene(this);
        addScene(SCENE_SHAPE_ENTITIES, shapeEntitiesScene);
        var dynamicSceneWithTimers = new DynamicSceneWithTimer(this);
        addScene(SCENE_WITH_TIMERS, dynamicSceneWithTimers);
        var sceneWithEntityMaps = new TileMapScene(this);
        addScene(SCENE_WITH_ENTITYMAPS, sceneWithEntityMaps);
    }

    public void setActiveScene(int scene) {
        super.setActiveScene(scene);
    }
}
