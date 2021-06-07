package texteditor.buffer;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static texteditor.buffer.BufferUtils.lineNumToIndex;

public abstract class AbstractBuffer implements Buffer {
  protected        List<String> buffer = new ArrayList<>();
  protected static String       currentFileName;

  @Override
  public void addLine(int index, String newLine) {
    if (index < 1 || index > buffer.size()) {
      System.out.println("Index out of bounds [1-" + (buffer.size()) + "]");
      return;
    }
    buffer.add(lineNumToIndex(index), newLine);
  }

  @Override
  public void deleteLine(int linePointer) {
    int startIx = lineNumToIndex(linePointer);
    if (buffer.isEmpty()) {
      System.out.println("?Deleted all lines!");
      return;
    }
    buffer.remove(startIx);
  }

  @Override
  public List<String> getLines() {
    List<String> result = new ArrayList<>();
    int          i      = 1;
    for (String line : buffer) {
      result.add(i + ":" + line);
      i++;
    }
    return result;
  }

  @Override
  public void save() {
    try {
      FileWriter writer = new FileWriter(currentFileName);
      for (String str : buffer) {
        writer.write(str + System.lineSeparator());
      }
      writer.close();
      System.out.println("Successfully wrote to the file.");
    }
    catch (IOException e) {
      System.out.println("Error when trying to save!");
      e.printStackTrace();
    }
  }
}
