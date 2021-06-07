package texteditor.buffer;

public class BufferException extends RuntimeException {
  BufferException(String message, Throwable t) {
    super(message, t);
  }
}
