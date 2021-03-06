package nl.meron.yaeger.engine;

import com.google.inject.Inject;
import com.google.inject.Injector;
import javafx.stage.Stage;
import nl.meron.yaeger.engine.scenes.SceneCollection;
import nl.meron.yaeger.engine.scenes.YaegerScene;
import nl.meron.yaeger.guice.factories.SceneCollectionFactory;

public class YaegerStage implements Initializable {

    private Size size = YaegerApplication.DEFAULT_GAME_DIMENSIONS;

    private YaegerApplication yaegerApplication;
    private Stage stage;
    private SceneCollectionFactory sceneCollectionFactory;
    private SceneCollection sceneCollection;

    YaegerStage(final YaegerApplication yaegerApplication, final Stage stage) {
        this.yaegerApplication = yaegerApplication;
        this.stage = stage;
    }

    /**
     * Set the {@link Size}, being the {@code width} and {@code height} of the game.
     *
     * @param size A {@link Size} object that encapsulates the {@code width} and {@code height} of the game
     */
    protected void setSize(final Size size) {
        this.size = size;
    }

    @Override
    public void init(Injector injector) {
        stage.setResizable(false);

        sceneCollection = sceneCollectionFactory.create(stage);
        injector.injectMembers(sceneCollection);
        sceneCollection.init(injector);

        yaegerApplication.initializeGame();

        stage.setWidth(size.getWidth());
        stage.setHeight(size.getHeight());

        yaegerApplication.setupScenes();

        stage.show();
    }

    /**
     * Stop and close the Game.
     */
    protected void quit() {
        stage.close();
    }

    /**
     * Set the title of the Game.
     *
     * @param title A {@link String} containing the title of the Game
     */
    protected void setTitle(final String title) {
        stage.setTitle(title);
    }

    /**
     * Add a {@link YaegerScene} to the {@link YaegerStage}.
     *
     * @param number The number as an {@code int} that identifies the {@link YaegerScene}. By calling the method
     *               {@link #setActiveScene(int)} the added {@link YaegerScene} can be set as the active one.
     * @param scene  The {@link YaegerScene} that should be added.
     */
    protected void addScene(final int number, final YaegerScene scene) {
        sceneCollection.addScene(number, scene);
    }

    /**
     * Set the current active {@link YaegerScene}.
     *
     * @param number The {@link Integer} identifying the {@link YaegerScene}
     */
    protected void setActiveScene(final int number) {
        sceneCollection.setActive(number);
    }

    @Inject
    public void setSceneCollectionFactory(SceneCollectionFactory sceneCollectionFactory) {
        this.sceneCollectionFactory = sceneCollectionFactory;
    }
}
