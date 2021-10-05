
/**
 * KivaCommand represents all possible commands that a Kiva can receive.
 * 
 * @author (Christopher J. Walker) 
 * @version (10/5/2021)
 */

/**
 *  comments
 */
public enum KivaCommand {
/**
 *  Moves the Kiva forward one location on the FloorMap.
 */
FORWARD ('F'),
/**
 *  Changes the direction that the Kiva is facing by rotating to the left. 
 */
TURN_LEFT ('L'),
/**
 *  Changes the direction that the Kiva is facing by rotating to the right. 
 */
TURN_RIGHT ('R'),
/**
 *  Kiva picks up a pod at the current location on the FloorMap.
 */
TAKE ('T'),
/**
 *  Kiva drops a pod at the current location on the FloorMap. 
 */
DROP ('D');


private char directionKey;

/**
 *  Constructs a KivaCommand with a predefined value 
 *  @param directionKey A char that represents one of the predefined constant KivaCommand values. 
 */
KivaCommand(char directionKey) {
    this.directionKey = directionKey;
}

/**
 * Returns a char that represents one of the predefined constant KivaCommand values. 
 *  @return Returns a char that represents one of the predefined constant KivaCommand values. 
 */
public char getDirectionKey() {

return directionKey;
}

}

