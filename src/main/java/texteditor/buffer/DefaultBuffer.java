package texteditor.buffer;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import static texteditor.buffer.BufferUtils.lineNumToIndex;

public class DefaultBuffer extends AbstractBuffer {

  private int lineCount = 0, charCount = 0;

  @Override
  public void clearBuffer() {
    buffer.clear();
    lineCount = 0;
    charCount = 0;
  }

  @Override
  public void readBuffer(String fileName) {
    try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
      bufferedReader.lines().forEach((s) -> {
        lineCount++;
        charCount += s.length();
        buffer.add(s);
      });
    } catch (FileNotFoundException e) {
      throw new BufferException("File " + fileName + " not found", e);
    } catch (IOException e) {
      throw new BufferException("File " + fileName + " failed during read", e);
    }
    currentFileName = fileName;
    println(String.format("%d - lines, %d - characters", lineCount, charCount));
  }

  public void println(String s) {
    System.out.println(s);
  }
}
