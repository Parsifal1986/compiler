package Tools.error;

import Tools.Position;

public class Error extends RuntimeException {
  private Position errorLine;

  public Error() {
        super();
    }

  public Error(String message) {
        super(message);
    }

  public Error(String message, Throwable cause) {
        super(message, cause);
    }

  public Error(Throwable cause) {
        super(cause);
    }

  public Error(String message, Position errorline) {
        super(message);
        this.errorLine = errorline;
    }

  public Position getErrorLine() {
    return errorLine;
  }
}
