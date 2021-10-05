
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
FORWARD ('F'),
TURN_LEFT ('L'),
TURN_RIGHT ('R'),
TAKE ('T'),
DROP ('D');


private char directionKey;


KivaCommand(char directionKey) {
    this.directionKey = directionKey;
}

/**
 *  Returns @return directionKey
 */
public char getDirectionKey() {

return directionKey;
}

}
