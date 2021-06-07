JAVA command line-oriented text editor that reads a text file and allows basic editing commands.

There was developed scalable architecture around _Buffer_ and _Commands_ on it.

There are several types of commands implemented:
- Without operands. It doesn't need any operand just command: SAVE, LIST, QUIT.
- With line pointer. It needs an operand after command which point to line number: INSERT, DELETE.

**Usage**
1) Compile and package: mvn package
2) Copy the JAR file from target/ to someplace like $HOME/lib/

Then start with a 'read' (read file) command.

**An example of working with the program:**

_read D:\projects\texteditor\src\main\java\texteditor\texrfile_

2 - lines, 52 - characters

_list_

1:ukfyuko ulygfulyfg ulygfuofy

2:iulgipl iu;hiu; iuhgio;u

_ins 1 fgbn dfbh dfgb_

_list_

1:fgbn dfbh dfgb 

2:ukfyuko ulygfulyfg ulygfuofy

3:iulgipl iu;hiu; iuhgio;u

_ins 2 dfbd bgdgtb rdbhdrb rdbdb 

list_

1:fgbn dfbh dfgb 

2:dfbd bgdgtb rdbhdrb rdbdb 

3:ukfyuko ulygfulyfg ulygfuofy

4:iulgipl iu;hiu; iuhgio;u

_save_
