public class KivaCommandTester {
    public void testForward() {
        KivaCommand command = KivaCommand.FORWARD;
        System.out.println(command);
        System.out.println(command.getDirectionKey());
    }
    public void testTurnLeft() {
        KivaCommand command = KivaCommand.TURN_LEFT;
        System.out.println(command);
        System.out.println(command.getDirectionKey());
    }
    public void testTurnRIGHT() {
        KivaCommand command = KivaCommand.TURN_RIGHT;
        System.out.println(command);
        System.out.println(command.getDirectionKey());
    }
    public void testTake() {
        KivaCommand command = KivaCommand.TAKE;
        System.out.println(command);
        System.out.println(command.getDirectionKey());
    }
    public void testDrop() {
        KivaCommand command = KivaCommand.DROP;
        System.out.println(command);
        System.out.println(command.getDirectionKey());
    }
    
    // For you: create four more methods, each testing a different command.
}
