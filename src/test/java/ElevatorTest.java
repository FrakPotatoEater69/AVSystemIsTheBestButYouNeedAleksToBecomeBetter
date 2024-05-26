import com.shakhner.commands.commandImpl.*;
import com.shakhner.models.Elevator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ElevatorTest {
    Elevator elevator;

    @BeforeEach
    void setUp() {
        elevator = new Elevator(5, 2);
    }

    @Test
    void shouldElevatorMoveUpIfTargetFloorIsAboveCurrent() {
        int startingFloor = elevator.getCurrentFloor();
        elevator.receiveNewCommand(new AddCommandAsFirst(new MoveToTargetCommand(5)));
        elevator.doStep();

        assertEquals(true, startingFloor < elevator.getCurrentFloor());
    }

    @Test
    void shouldElevatorMoveDownIfTargetFloorIsBelowCurrent() {
        int startingFloor = elevator.getCurrentFloor();
        elevator.receiveNewCommand(new AddCommandAsLast(new MoveToTargetCommand(0)));
        elevator.doStep();

        assertEquals(true, startingFloor > elevator.getCurrentFloor());
    }

    @Test
    void shouldElevatorNotMoveIfTargetFloorIsSameAsCurrent() {
        Integer startingFloor = elevator.getCurrentFloor();
        elevator.receiveNewCommand(new AddCommandAsFirst(new MoveToTargetCommand(2)));
        elevator.doStep();

        assertEquals(true, startingFloor.equals(elevator.getCurrentFloor()));
    }

    @Test
    void shouldElevatorNotMoveIfTargetFloorIsNull() {
        Integer startingFloor = elevator.getCurrentFloor();
        elevator.doStep();
        elevator.doStep();

        assertEquals(true, startingFloor.equals(elevator.getCurrentFloor()));
    }

    @Test
    void shouldNextDirectionBeUpIfCommandIsMoveToOrderWithUpDirection() {
        elevator.receiveNewCommand(new AddCommandAsLast(new MoveToCommand(3, 1,
                                   new AddCommandAsFirst(new ReceiveCommand(1, new AddTargetAsFirstCommand())))));

        assertEquals(1, elevator.getNextDirection());
    }

    @Test
    void shouldDirectionBeDownIfCommandIsMoveToOrderWithDownDirection() {
        elevator.receiveNewCommand(new AddCommandAsFirst(new MoveToCommand(1, -1,
                new AddCommandAsLast(new ReceiveCommand(1, new AddTargetAsFirstCommand())))));

        assertEquals(-1, elevator.getNextDirection());
    }

    @Test
    void shouldDirectionBeNullIfCommandIsMoveToTarget() {
        elevator.receiveNewCommand(new AddCommandAsFirst(new MoveToTargetCommand(4)));

        assertEquals(null, elevator.getNextDirection());
    }

    @Test
    void shouldDirectionBeNullIfCommandIsReceiveOrder() {
        elevator.receiveNewCommand(new AddCommandAsFirst(new ReceiveCommand(2, new AddTargetAsFirstCommand())));

        assertEquals(null, elevator.getNextDirection());
    }
}