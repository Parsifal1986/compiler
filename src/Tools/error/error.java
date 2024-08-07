package Tools.error;

import Tools.Position;

public class error extends RuntimeException {
  private Position errorLine;

  public error() {
        super();
    }

  public error(String message) {
        super(message);
    }

  public error(String message, Throwable cause) {
        super(message, cause);
    }

  public error(Throwable cause) {
        super(cause);
    }

  public error(String message, Position errorline) {
        super(message);
        this.errorLine = errorline;
    }

  public Position getErrorLine() {
    return errorLine;
  }
}
