import java.util.Set;

public class MarsRoverSimulation {
    public static void main(String[] args) {
        // Define a grid with obstacles
        Set<Position> obstacles = Set.of(new Position(2, 2), new Position(3, 5));
        Grid grid = new Grid(10, 10, obstacles);

        // Initialize the rover at position (0, 0) facing North
        Rover rover = new Rover(new Position(0, 0), Direction.N, grid);

        // Define a series of commands
        Command[] commands = {
            new MoveCommand(), new MoveCommand(),
            new TurnRightCommand(), new MoveCommand(),
            new TurnLeftCommand(), new MoveCommand()
        };

        // Execute the commands
        for (Command command : commands) {
            command.execute(rover);
        }

        // Print the final position and direction
        Position finalPosition = rover.getPosition();
        System.out.println("Final Position: (" + finalPosition.getX() + ", " + finalPosition.getY() + ", " + rover.getDirection() + ")");
    }
}
