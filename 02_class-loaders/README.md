# 02 Class loaders

1. Open file `ClassLoaders.java` and see source
2. Compile following class `CLassLoaders.java` from commandline 
3. Run compiled .class binary.
4. You should see following:
```
Class loader of this class:sun.misc.Launcher$AppClassLoader@18b4aac2
Class loader of Logging:sun.misc.Launcher$ExtClassLoader@3caeaf62
Class loader of ArrayList:null
```

## Exercise
1. Add new class called `NonExistingForClassLoader` in separate file.
2. Now add similar code executing classLoader of newly created class.
3. Compile sources and remove `NonExistingForClassLoader.class` 
4. Now run your `ClassLoaders` compiled class
5. What happened?