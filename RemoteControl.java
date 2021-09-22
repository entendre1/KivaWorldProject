import edu.duke.FileResource;

/**
 * This is the class that controls Kiva's actions. Implement the <code>run()</code>
 * method to deliver the pod and avoid the obstacles.
 *
 * This is starter code that may or may not work. You will need to update the code to
 * complete the project.
 */
public class RemoteControl {
    KeyboardResource keyboardResource;

    /**
     * Build a new RemoteControl.
     */
    public RemoteControl() {
        keyboardResource = new KeyboardResource();
    }

    /**
     * The controller that directs Kiva's activity. Prompts the user for the floor map
     * to load, displays the map, and asks the user for the commands for Kiva to execute.
     *
     * [Here's the method you'll execute from within BlueJ. It may or may not run successfully
     * as-is, but you'll definitely need to add more to complete the project.]
     */
    public void run() {
        System.out.println("Please select a map file.");
        FileResource fileResource = new FileResource();
        String inputMap = fileResource.asString();
        FloorMap floorMap = new FloorMap(inputMap);
        System.out.println(floorMap);
        Kiva kiva = new Kiva(floorMap);
        System.out.println(String.format("Kiva Starting Location: %s. Kiva Facing Direction: UP", floorMap.getInitialKivaLocation()));
        System.out.println("Please enter the directions for the Kiva Robot to take.");
        String directions = keyboardResource.getLine();
        System.out.println("Directions that you typed in: " + directions);
        KivaCommand[] commands = this.convertToKivaCommands(directions);
        boolean complete = false;
        for (KivaCommand currentCommand : commands) {
            if (complete = true) {
                System.out.println("I'm sorry. The Kiva Robot did not pick up the pod and then drop it off in the right place.");
                break;
            }
            else if (currentCommand == KivaCommand.DROP) {
                complete = true;
            
        }
        kiva.move(currentCommand);

    }
        boolean success = kiva.isSuccessfullyDropped();
        if (success == true) {
            System.out.println("Successfully picked up the pod and dropped it off. Thank you!");
            
        }
        
    }
/**
 *  comments
 */
    
    private KivaCommand[] convertToKivaCommands(String userInput) {
        KivaCommand[] commands = new KivaCommand[userInput.length()];
        char[] inputKeys = userInput.toCharArray();
        int i = 0; 
      for(char key : inputKeys)
      {
          if(key == KivaCommand.FORWARD.getDirectionKey())
          { 
              commands[i] = KivaCommand.FORWARD;
              i++;
            }
          else if (key == KivaCommand.TURN_RIGHT.getDirectionKey())
          {
              commands[i] = KivaCommand.TURN_RIGHT;
              i++;
            }
            else if (key == KivaCommand.TURN_LEFT.getDirectionKey())
          {
              commands[i] = KivaCommand.TURN_LEFT;
              i++;
            }
            else if (key == KivaCommand.TAKE.getDirectionKey())
          {
              commands[i] = KivaCommand.TAKE;
              i++;
            }
            else if (key == KivaCommand.DROP.getDirectionKey())
          {
              commands[i] = KivaCommand.DROP;
              i++;
            }
            
            else {
                
                throw new IllegalArgumentException(String.format("The command %s you entered is not an valid command. Please only enter the following commands: F, R, L, T, D.",key));
            }
        }
        return commands;
    }
}
