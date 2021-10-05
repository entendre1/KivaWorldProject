
/**
 * Write a description of Kiva here.
 * 
 * @author (Christopher J. Walker) 
 * @version (10/5/2021)
 */

import edu.duke.Point;
public class Kiva {
private Point currentLocation;
private FacingDirection directionFacing;
private FloorMap map;
private boolean carryingPod;
private boolean successfullyDropped;
private long motorLifeTime; 
 
  /** Constucts a Kiva and represents the location and environment of the Kiva.
  *   @param map A FloorMap object that represents the location and environment of the Kiva.
  * 
  */ 
public Kiva(FloorMap map){

 this.map = map;
 this.currentLocation = map.getInitialKivaLocation();
 this.directionFacing = directionFacing.UP;
 this.carryingPod = false;
 this.successfullyDropped = false;
 this.motorLifeTime = 0;
 
}

/**
 * Constructs a Kiva and represents its environment via a FloorMap object argument and initial location via Point object argument. 
 * @param map A FloorMap object that represents the environment of the Kiva.
 * @param currentLocation A Point object that sets the initial location of the Kiva.
 */ 
 
public Kiva(FloorMap map, Point currentLocation) {
    this.map = map;
    this.currentLocation = currentLocation;
    this.directionFacing = directionFacing.UP;
    this.carryingPod = false;
    this.successfullyDropped = false;
    this.motorLifeTime = 0;
}
/**
 * Moves Kiva based on which KivaCommand that is received.
 * @param command A KivaCommand constant that represents a valid action that the Kiva robot can make. 
 */
public void move(KivaCommand command) {
    
if (command == KivaCommand.FORWARD)
{
    moveForward();
}
else if(command == KivaCommand.TURN_LEFT) {
    turnLeft();
}
else if(command == KivaCommand.TURN_RIGHT) {
    turnRight();
}
else if(command == KivaCommand.TAKE) {
    takePod();
}
else {
    dropPod();
}
    
}
//moves Kiva forward
private void moveForward() {
   Point delta;
   int deltaX;
   int deltaY;
   int currentX;
   int currentY;
   Point newLocation;
   
   delta = directionFacing.getDelta();
   deltaX = delta.getX();
   deltaY = delta.getY();
   currentX = currentLocation.getX();
   currentY = currentLocation.getY();
   newLocation = new Point((deltaX + currentX),(deltaY + currentY));
   
   if ((this.carryingPod == true) && (map.getObjectAtLocation(newLocation) == FloorMapObject.POD)) 
   {
       throw new IllegalMoveException(String.format("Illegal Move:Pod Collision. Can't move FORWARD from %s to %s because %s is at %s",
       currentLocation,newLocation,map.getObjectAtLocation(newLocation),newLocation));
    }
   
   if ((newLocation.getX() < 0) || (newLocation.getY() < 0))
   {
       throw new IllegalMoveException(String.format("Illegal Move: Out of Bounds. Can't move FORWARD from %s to %s because %s is off the floor",
       currentLocation, newLocation, newLocation));
       
    }
   else if ((newLocation.getX() > map.getMaxColNum()) || (newLocation.getY() > map.getMaxRowNum()))
   {
       throw new IllegalMoveException(String.format("Illegal Move: Out of Bounds. Can't move FORWARD from %s to %s because %s is off the floor",
       currentLocation, newLocation, newLocation));
    }
    
   else if (map.getObjectAtLocation(newLocation) == FloorMapObject.OBSTACLE)
   {
       throw new IllegalMoveException(String.format("Illegal Move: Obstacle Collision. Can't move FORWARD from %s to %s because %s is at %s",
       currentLocation, newLocation, map.getObjectAtLocation(newLocation), newLocation));
    }
    else {
        currentLocation = newLocation;
        this.incrementMotorLifetime();
    }
   
   
    
}
// Turns Kiva Left
private void turnLeft() {
    
  if(this.directionFacing == directionFacing.UP) {
      this.directionFacing = directionFacing.LEFT;
    }
    else if(this.directionFacing == directionFacing.RIGHT) {
        this.directionFacing = directionFacing.UP;
    }
    else if(this.directionFacing == directionFacing.DOWN) {
        this.directionFacing = directionFacing.RIGHT;
    }
    else {
        this.directionFacing = directionFacing.DOWN;
    }
    this.incrementMotorLifetime();
    
}
// Turns Kiva Right
private void turnRight() {
    //change to switch statement
  if(this.directionFacing == directionFacing.UP) {
      this.directionFacing = directionFacing.RIGHT;
    }
    else if(this.directionFacing == directionFacing.RIGHT) {
        this.directionFacing = directionFacing.DOWN;
    }
    else if(this.directionFacing == directionFacing.DOWN) {
        this.directionFacing = directionFacing.LEFT;
    }
    else {
        this.directionFacing = directionFacing.UP;
    }  
    this.incrementMotorLifetime();
}
// Kiva takes pod
private void takePod() {
    if (carryingPod == true) {
        throw new IllegalMoveException(String.format("Illegal Move: Attempting To Take Pod While Carrying Pod. Can't TAKE %s from %s while carrying pod",
        map.getObjectAtLocation(currentLocation), currentLocation));
    }
    else if(map.getObjectAtLocation(currentLocation) != FloorMapObject.POD)
    {
        throw new NoPodException(String.format("No Pod At Location. Can't TAKE POD from %s because %s is %s",currentLocation, currentLocation,
        map.getObjectAtLocation(currentLocation)));
    }
    else {
    this.carryingPod = true;
    }

}
// Kiva drops pod
private void dropPod() {
     if(map.getObjectAtLocation(currentLocation) != FloorMapObject.DROP_ZONE)
    {
        throw new IllegalDropZoneException(String.format("Not A Drop Zone. Can't DROP POD at %s because %s is a %s",
        currentLocation, currentLocation, map.getObjectAtLocation(currentLocation)));
    }
    else if(carryingPod == false) 
    {
        throw new IllegalMoveException(String.format("Illegal Move: No Pod To Drop. Can't DROP at %s because Kiva is not carrying a POD",
        currentLocation));
    }
    else
    {
    this.successfullyDropped = true;
    this.carryingPod = false;
    }

}

/**
 *  Returns the current location of the Kiva
 *  @return Returns Point representing the current location of the Kiva.
 */
public Point getCurrentLocation(){
    return currentLocation;
}

/**
 *  Returns the direction that the Kiva is currently facing.
 *  @return Returns FacingDirection that represents the direction that the Kiva is currently facing.
 */
public FacingDirection getDirectionFacing() {
    return directionFacing;
}
/**
 *  Returns a boolean representing whether or not the Kiva is carrying a pod.
 *  @return Returns a boolean representing whether or not the Kiva is carrying a pod.
 */

public boolean isCarryingPod() {
    
    return carryingPod;
}
/**
 *  Returns a boolean representing whether or not the Kiva has successfully dropped a pod in the drop zone.
 *  @return Returns a boolean representing whether or not the Kiva has successfully dropped a pod in the drop zone.
 */
public boolean isSuccessfullyDropped() {
    
    return successfullyDropped;
}
/**
 *  Returns the current motor lifetime of the Kiva robot. 
 *  @return Returns a long that represents the motor lifetime of the Kiva Robot in milliseconds. 
 */
public long getMotorLifetime() {
    return this.motorLifeTime;
}
// Increments Motor Lifetime by 1000 milliseconds.
private void incrementMotorLifetime() {
    this.motorLifeTime += 1000;
}
}
