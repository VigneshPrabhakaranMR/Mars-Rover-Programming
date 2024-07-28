public class Rover {
    private Position position;
    private Direction direction;
    private final Grid grid;

    public Rover(Position position, Direction direction, Grid grid) {
        this.position = position;
        this.direction = direction;
        this.grid = grid;
    }

    public void move() {
        Position newPosition = calculateNewPosition();
        if (grid.isWithinBounds(newPosition) && !grid.isObstacle(newPosition)) {
            this.position = newPosition;
        }
    }

    public void turnLeft() {
        this.direction = switch (this.direction) {
            case N -> Direction.W;
            case W -> Direction.S;
            case S -> Direction.E;
            case E -> Direction.N;
        };
    }

    public void turnRight() {
        this.direction = switch (this.direction) {
            case N -> Direction.E;
            case E -> Direction.S;
            case S -> Direction.W;
            case W -> Direction.N;
        };
    }

    private Position calculateNewPosition() {
        int newX = position.getX();
        int newY = position.getY();

        switch (direction) {
            case N -> newY++;
            case E -> newX++;
            case S -> newY--;
            case W -> newX--;
        }

        return new Position(newX, newY);
    }

    public Position getPosition() {
        return position;
    }

    public Direction getDirection() {
        return direction;
    }
}
