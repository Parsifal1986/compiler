package Tools.error;

import Tools.Position;

public class syntaxError extends error {
    public syntaxError(String msg, Position pos) {
        super("SyntaxError: " + msg, pos);
    }
}
