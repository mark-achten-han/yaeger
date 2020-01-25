package nl.meron.showcase.scenes.selection;

import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import nl.meron.showcase.YaegerShowCase;
import nl.meron.yaeger.engine.entities.entity.Point;
import nl.meron.yaeger.engine.entities.entity.text.TextEntity;
import nl.meron.yaeger.engine.scenes.impl.StaticScene;

import java.util.Set;

public class SelectionScene extends StaticScene {

    private Color TEXT_COLOR = Color.YELLOW;
    private Font TEXT_FONT = Font.font("American Typewriter", FontWeight.BOLD, 30);
    private YaegerShowCase showCase;

    public SelectionScene(final YaegerShowCase showCase) {
        this.showCase = showCase;
    }

    @Override
    public void setupScene() {
        setBackgroundImage("showcase/backgrounds/nature.jpg");
    }

    @Override
    public void setupEntities() {
        var select = new TextEntity(new Point(20, 30), "Please select a scene...");
        styleText(select);
        addEntity(select);

        var textEntities = new TextEntity(new Point(20, 70), "1) Text Entities");
        styleText(textEntities);
        addEntity(textEntities);

        var spriteEntities = new TextEntity(new Point(20, 100), "2) Sprite Entities");
        styleText(spriteEntities);
        addEntity(spriteEntities);
    }

    @Override
    public void onInputChanged(Set<KeyCode> input) {
        if (input.contains(KeyCode.DIGIT1)) {
            showCase.setActiveScene(YaegerShowCase.SCENE_TEXT_ENTITIES);
        } else if (input.contains(KeyCode.DIGIT2)) {
            showCase.setActiveScene(YaegerShowCase.SCENE_SPRITE_ENTITIES);
        }
    }

    void styleText(TextEntity entity) {
        entity.setFill(TEXT_COLOR);
        entity.setFont(TEXT_FONT);
    }
}
