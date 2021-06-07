package texteditor.buffer;

import java.util.List;

public interface Buffer {

  void addLine(int lineNumber, String newLine);

  void deleteLine(int lineNumber);

  void clearBuffer();

  void readBuffer(String fileName);

  void save();

  List<String> getLines();
}
