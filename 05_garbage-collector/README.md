# GC

1. Compile `GCTest.java` class 
2. Run compiled binary with following flags
```
java -XX:+PrintGCDetails GCTest
```
3. This command produces gc logs
4. Now stop app and run it once again this time providing additional flag
```
java -XX:+PrintGCDetails -Xloggc:gc.log GCTest
```
5. Open browser and go to http://gceasy.io
6. Upload your gc.log and analyze charts generated from your logs.

# Exercise
1. Play with `UNLUCKY_LEVEL` param, compile program and watch logs once again.
2. What can you notice?
- for higher value?
- for lower value?
3. Look for interesting statistics like:
- Reclaimed Bytes
- GC average time
