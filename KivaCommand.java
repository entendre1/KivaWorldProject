
/**
 * Write a description of KivaCommand here.
 * 
 * @author (Christopher J. Walker) 
 * @version (Version 1.0)
 */

/**
 *  comments
 */
public enum KivaCommand {
FORWARD ('F'),
TURN_LEFT ('L'),
TURN_RIGHT ('R'),
TAKE ('T'),
DROP ('D');

/**
 *  comments
 */
private char directionKey;

/**
 *  comments
 */
KivaCommand(char directionKey) {
    this.directionKey = directionKey;
}

/**
 *  comments
 */
public char getDirectionKey() {

return directionKey;
}

}
