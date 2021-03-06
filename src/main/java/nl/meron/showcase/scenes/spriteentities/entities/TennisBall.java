package nl.meron.showcase.scenes.spriteentities.entities;

import nl.meron.yaeger.engine.Size;
import nl.meron.yaeger.engine.entities.entity.Location;
import nl.meron.yaeger.engine.entities.entity.SceneBorderTouchingWatcher;
import nl.meron.yaeger.engine.entities.entity.motion.Direction;
import nl.meron.yaeger.engine.entities.entity.sprite.DynamicSpriteEntity;
import nl.meron.yaeger.engine.scenes.SceneBorder;

public class TennisBall extends DynamicSpriteEntity implements SceneBorderTouchingWatcher {

    public TennisBall(Location location) {
        super("showcase/entities/tennisball.png", location, new Size(30, 30), 0);
        setMotionTo(4, Direction.RIGHT.getValue());
    }

    @Override
    public void notifyBoundaryTouching(SceneBorder border) {
        changeDirectionBy(180);
    }
}
