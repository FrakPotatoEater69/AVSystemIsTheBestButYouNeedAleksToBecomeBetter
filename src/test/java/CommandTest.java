import com.shakhner.commands.ElevatorCommand;
import com.shakhner.commands.commandImpl.*;
import com.shakhner.models.Elevator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class CommandTest {
    @Test
    void AddMovingDownCommandAsFirstShouldMoveDownTest() {
        Elevator elevator = new Elevator(1, 10);
        ElevatorCommand command = new AddCommandAsFirst(new MoveToTargetCommand(9));
        elevator.doStep();
        command.execute(elevator);
        assertEquals(9, elevator.getCurrentCommand().getFloorNumber());
    }

    @Test
    public void AddMovingUpCommandAsFirstTest() {
        Elevator elevator = new Elevator(1, 10);
        ElevatorCommand command = new AddCommandAsFirst(new MoveToTargetCommand(11));
        command.execute(elevator);
        assertEquals(new MoveToTargetCommand(11), elevator.getCurrentCommand());
    }

    @Test
    public void AddCommandAsLastTest() {
        Elevator elevator = new Elevator(1, 10);
        ElevatorCommand command = new AddCommandAsFirst(new MoveToCommand(11, 11, new MoveToTargetCommand(2)));
        ElevatorCommand command2 = new AddCommandAsLast(new MoveToTargetCommand(11));
        command.execute(elevator);
        assertNotEquals(new MoveToTargetCommand(11), elevator.getCurrentCommand());
    }
}
