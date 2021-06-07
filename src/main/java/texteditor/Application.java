package texteditor;

import texteditor.buffer.Buffer;
import texteditor.buffer.DefaultBuffer;
import texteditor.command.CommandHelper;
import texteditor.command.CommandExecutor;
import texteditor.command.LineParser;
import texteditor.command.ParsedCommand;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Application {

  protected static Buffer buff = new DefaultBuffer();

  protected static BufferedReader in = null;

  static CommandHelper commandHelper;


  public static void main(String[] args) throws IOException {
    commandHelper = new CommandHelper(buff);
    String line;
    in = new BufferedReader(new InputStreamReader(System.in));

    while ((line = in.readLine())  != null) {
      try {
        ParsedCommand pl = LineParser.parse(line);
        if (pl == null) {
          System.out.println("?");
          continue;
        }
        CommandExecutor c = commandHelper.executeCommand(pl.getCommand());
        if (c == null) {
          System.out.println("? Unknown command in " + line);
        } else {
          c.execute(pl);
        }
      } catch (Exception e) {
        System.err.println("? Caught exception " + e);
        e.printStackTrace();
      }
    }
  }
}
