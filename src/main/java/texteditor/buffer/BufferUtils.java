package texteditor.buffer;

public class BufferUtils {
  public static int lineNumToIndex(int ln) {
    if (ln == 0) {
      ln = 1;
    }
    return ln - 1;
  }
  public static int indexToLineNum(int ix) {
    return ix + 1;
  }
}
