package texteditor.command;

import java.util.ArrayList;
import java.util.List;

enum Command {
  LIST("list"),
  DELETE("del"),
  INSERT("ins"),
  SAVE("save"),
  QUIT("quit"),
  READ("read");

  private final String name;

  Command(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public static Command fromName(String name){
    for (Command c : Command.values()) {
      if (c.getName().equalsIgnoreCase(name)) {
        return c;
      }
    }
    return null;
  }

  public static List<Command> getLinePointerCommands() {
    List<Command> commands = new ArrayList<>();
    commands.add(INSERT);
    commands.add(DELETE);
    return commands;
  }

  public static List<Command> getCommandsWithoutOperands() {
    List<Command> commands = new ArrayList<>();
    commands.add(LIST);
    commands.add(SAVE);
    commands.add(QUIT);
    return commands;
  }
}
