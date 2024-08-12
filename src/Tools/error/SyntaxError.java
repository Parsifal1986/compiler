package Tools.error;

import Tools.Position;

public class SyntaxError extends Error {
    public SyntaxError(String msg, Position pos) {
        // super("SyntaxError: " + msg, pos);
        super(msg, pos);
    }
}
