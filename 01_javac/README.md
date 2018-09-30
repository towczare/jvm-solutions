# 01. Compilation & reading bytecode

1. Compile files using command:
```
javac HelloWorld.java
```
`HellowWorld.class` compiled file should appear.
2. Read compiled file using following command:
```
javap -c HelloWorld.class
```
this command should result in:
```                                                                   /cygdrive/c/sda/jvm-examples/01_javac
Compiled from "HelloWorld.java"
public class HelloWorld {
  public HelloWorld();
    Code:
       0: aload_0
       1: invokespecial #1                  // Method java/lang/Object."<init>":()V
       4: return

  public static void main(java.lang.String[]);
    Code:
       0: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;
       3: ldc           #3                  // String Hello, World
       5: invokevirtual #4                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V
       8: return
}
```
`-c` stands for `Disassemble the code`
3. To read additional information, use `-v` flag
```
javap -v HelloWorld.class
```
this command should result in:
```                                                                   /cygdrive/c/sda/jvm-examples/01_javac
Classfile /C:/sda/jvm-examples/01_javac/HelloWorld.class
  Last modified 2018-09-24; size 426 bytes
  MD5 checksum c4b1a974539eed094905e994711848dc
  Compiled from "HelloWorld.java"
public class HelloWorld
  minor version: 0
  major version: 52
  flags: ACC_PUBLIC, ACC_SUPER
Constant pool:
   #1 = Methodref          #6.#15         // java/lang/Object."<init>":()V
   #2 = Fieldref           #16.#17        // java/lang/System.out:Ljava/io/PrintStream;
   #3 = String             #18            // Hello, World
   #4 = Methodref          #19.#20        // java/io/PrintStream.println:(Ljava/lang/String;)V
   #5 = Class              #21            // HelloWorld
   #6 = Class              #22            // java/lang/Object
   #7 = Utf8               <init>
   #8 = Utf8               ()V
   #9 = Utf8               Code
  #10 = Utf8               LineNumberTable
  #11 = Utf8               main
  #12 = Utf8               ([Ljava/lang/String;)V
  #13 = Utf8               SourceFile
  #14 = Utf8               HelloWorld.java
  #15 = NameAndType        #7:#8          // "<init>":()V
  #16 = Class              #23            // java/lang/System
  #17 = NameAndType        #24:#25        // out:Ljava/io/PrintStream;
  #18 = Utf8               Hello, World
  #19 = Class              #26            // java/io/PrintStream
  #20 = NameAndType        #27:#28        // println:(Ljava/lang/String;)V
  #21 = Utf8               HelloWorld
  #22 = Utf8               java/lang/Object
  #23 = Utf8               java/lang/System
  #24 = Utf8               out
  #25 = Utf8               Ljava/io/PrintStream;
  #26 = Utf8               java/io/PrintStream
  #27 = Utf8               println
  #28 = Utf8               (Ljava/lang/String;)V
{
  public HelloWorld();
    descriptor: ()V
    flags: ACC_PUBLIC
    Code:
      stack=1, locals=1, args_size=1
         0: aload_0
         1: invokespecial #1                  // Method java/lang/Object."<init>":()V
         4: return
      LineNumberTable:
        line 1: 0

  public static void main(java.lang.String[]);
    descriptor: ([Ljava/lang/String;)V
    flags: ACC_PUBLIC, ACC_STATIC
    Code:
      stack=2, locals=1, args_size=1
         0: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;
         3: ldc           #3                  // String Hello, World
         5: invokevirtual #4                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V
         8: return
      LineNumberTable:
        line 3: 0
        line 4: 8
}
SourceFile: "HelloWorld.java"
```

`-v`  `-verbose` stands for `Print additional information`
4. Now let's read it using `xxd` command. 
Just simply use:
```
xxd HelloWorld.class                                                                         
```

You should see something like:

`| Offset| Bytecode_______________________________|the ASCII viewer|`
```
00000000: cafe babe 0000 0034 001d 0a00 0600 0f09  .......4........
00000010: 0010 0011 0800 120a 0013 0014 0700 1507  ................
00000020: 0016 0100 063c 696e 6974 3e01 0003 2829  .....<init>...()
00000030: 5601 0004 436f 6465 0100 0f4c 696e 654e  V...Code...LineN
00000040: 756d 6265 7254 6162 6c65 0100 046d 6169  umberTable...mai
00000050: 6e01 0016 285b 4c6a 6176 612f 6c61 6e67  n...([Ljava/lang
00000060: 2f53 7472 696e 673b 2956 0100 0a53 6f75  /String;)V...Sou
00000070: 7263 6546 696c 6501 000f 4865 6c6c 6f57  rceFile...HelloW
00000080: 6f72 6c64 2e6a 6176 610c 0007 0008 0700  orld.java.......
00000090: 170c 0018 0019 0100 0c48 656c 6c6f 2c20  .........Hello,
000000a0: 576f 726c 6407 001a 0c00 1b00 1c01 000a  World...........
000000b0: 4865 6c6c 6f57 6f72 6c64 0100 106a 6176  HelloWorld...jav
000000c0: 612f 6c61 6e67 2f4f 626a 6563 7401 0010  a/lang/Object...
000000d0: 6a61 7661 2f6c 616e 672f 5379 7374 656d  java/lang/System
000000e0: 0100 036f 7574 0100 154c 6a61 7661 2f69  ...out...Ljava/i
000000f0: 6f2f 5072 696e 7453 7472 6561 6d3b 0100  o/PrintStream;..
00000100: 136a 6176 612f 696f 2f50 7269 6e74 5374  .java/io/PrintSt
00000110: 7265 616d 0100 0770 7269 6e74 6c6e 0100  ream...println..
00000120: 1528 4c6a 6176 612f 6c61 6e67 2f53 7472  .(Ljava/lang/Str
00000130: 696e 673b 2956 0021 0005 0006 0000 0000  ing;)V.!........
00000140: 0002 0001 0007 0008 0001 0009 0000 001d  ................
00000150: 0001 0001 0000 0005 2ab7 0001 b100 0000  ........*.......
00000160: 0100 0a00 0000 0600 0100 0000 0100 0900  ................
00000170: 0b00 0c00 0100 0900 0000 2500 0200 0100  ..........%.....
00000180: 0000 09b2 0002 1203 b600 04b1 0000 0001  ................
00000190: 000a 0000 000a 0002 0000 0003 0008 0004  ................
000001a0: 0001 000d 0000 0002 000e                 ..........
```
You can also use some online hex editor tool like this one:
- https://hex-works.com/eng

## Exercise

### Hacking magic number
1. Use mentioned earlier online editor (or any other) and change magic number to following value:
```
ccff
```
2. Now save new version of file and try to run it. What just happened?

### Compiling inner classes

1. Add inner class called `HelloPoland` inside HelloWorld class and compile code once again. 
2. How many files did compiler just created?

### Compile with package

1. Crate new class `HelloPiotrkowska` in following package `world.pl.lodz.srodmiescie` 
2. Implement main method printing something on screen like following:
```java
System.out.println("I am so looong");
```
3. Compile and run code

