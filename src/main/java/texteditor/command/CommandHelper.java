package texteditor.command;

import texteditor.buffer.Buffer;
import java.io.File;

public class CommandHelper {
  public static CommandExecutor commands = null;
  static        Buffer          buffer   = null;

  public CommandHelper(Buffer buffer) {
    CommandHelper.buffer = buffer;
  }

  private void readFile(String fileName) {
    if (fileName == null) {
      System.out.println("?no filename");
    } else {
      File f = new File(fileName);
      if (f.canRead()) {
        buffer.readBuffer(fileName);
      } else {
        System.out.println("File not readable");
      }
    }
  }

  public CommandExecutor executeCommand(Command command) {
    switch (command) {
      case LIST:
        return commands = pl -> buffer.getLines().forEach(System.out::println);
      case QUIT:
        return commands = pl -> System.exit(0);
      case DELETE:
        return commands = pl -> buffer.deleteLine(pl.getLinePointer());
      case INSERT:
        return commands = pl -> buffer.addLine(pl.getLinePointer(), pl.getOperand());
      case SAVE:
        return commands = pl -> buffer.save();
      case READ:
        return commands = pl -> {
          buffer.clearBuffer();
          readFile(pl.getOperand());
        };
      default:
        return null;
    }
  }
}
