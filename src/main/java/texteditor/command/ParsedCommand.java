package texteditor.command;

public class ParsedCommand {
  Command command;
  int     linePointer;
  String  operand;

  public Command getCommand() {
    return command;
  }

  public void setCommand(Command command) {
    this.command = command;
  }

  public int getLinePointer() {
    return linePointer;
  }

  public void setLinePointer(int linePointer) {
    this.linePointer = linePointer;
  }

  public String getOperand() {
    return operand;
  }

  public void setOperand(String operand) {
    this.operand = operand;
  }

  public String toString() {
    return String.format("%s%d%s", command, linePointer, operand == null ? "" : (' ' + operand));
  }
}
