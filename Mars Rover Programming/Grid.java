import java.util.HashSet;
import java.util.Set;

public class Grid {
    private final int width;
    private final int height;
    private final Set<Position> obstacles;

    public Grid(int width, int height, Set<Position> obstacles) {
        this.width = width;
        this.height = height;
        this.obstacles = new HashSet<>(obstacles);
    }

    public boolean isWithinBounds(Position position) {
        return position.getX() >= 0 && position.getX() < width &&
               position.getY() >= 0 && position.getY() < height;
    }

    public boolean isObstacle(Position position) {
        return obstacles.contains(position);
    }
}
