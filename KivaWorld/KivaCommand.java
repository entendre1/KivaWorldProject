
/**
 * Write a description of KivaCommand here.
 * 
 * @author (Christopher J. Walker) 
 * @version (Version 1.0)
 */
public enum KivaCommand {
FORWARD('F'),
TURN_LEFT('L'),
TURN_RIGHT('R'),
TAKE('T'),
DROP('D');
    
private char directionKey;
    
private KivaCommand(char key) {
 directionKey = key;   
}
public char getDirectionKey() {

return 'a';
}

}
