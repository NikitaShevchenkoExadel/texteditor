package texteditor.command;

public class LineParser {

  public static ParsedCommand parse(String line) {

    if (line == null || (line = line.trim()).length() == 0) {
      return null;
    }

    String[]      parts     = line.split(" ");
    ParsedCommand cmd       = new ParsedCommand();
    int           i         = 0;
    final String  cmdString = parts[i++];

    // set command
    Command command = Command.fromName(cmdString.toLowerCase());
    if (command != null) {
      cmd.setCommand(command);
      if (Command.getCommandsWithoutOperands().contains(command)) {
        return cmd;
      }
    }
    else {
      System.err.printf("LineParser.parse(): failed to parse input %s (i=%d)\n", line, i);
      return null;
    }

    //set linePointer
    boolean isLinePointerCommand = Command.getLinePointerCommands().contains(command);
    if (isLinePointerCommand) {
      try {
        int linePointer = Integer.parseInt(parts[i++]);
        cmd.setLinePointer(linePointer);
      }
      catch (NumberFormatException ex) {
        System.err.printf("LineParser.parse(): failed to parse input %s (i=%d)\n", line, i);
        return null;
      }
    }

    // set the rest of line
    StringBuilder operandLine = new StringBuilder();
    if (i < parts.length) {
      for (int j = i; j < parts.length; j++) {
        operandLine.append(parts[j]).append(" ");
      }
      cmd.operand = operandLine.toString();
    }
    return cmd;
  }
}
