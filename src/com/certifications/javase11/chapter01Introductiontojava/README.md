Summary

1.  It's an OOP language, advent in 1995 
2.  It's platform independent.
3.  Java SE is the base edition and all the other editions are built on top of them.
4.  Other editions ( Java MP, Java ME(Micro edition: TV's), Java Cards(Sim cards))
5.  In the subsequent lessons, we'll cover the basic concepts in SE.
6.  JVM executes your application by translating the byte code or .class into platform specific code.
7.  Java API are specific classes designed into achieve specific function. (InputStream, Collections etc.)
8.  Java Keywords are reserved words, that you cannot use for naming your identifier.
9.  Java literals include 'true', 'false' and 'null'.
10. Java is case-sensitive. (ex)
11. Java naming convention (ex):
        a. Class name should be a noun.
        b. Name should not start with numeric characters(0-9), underscore(_) or dollar ($).
        c. Method name should be a verb.
        d. Constant name should be all caps.
        e. Package name is usually reverse of your company domain name.
12. If package definition is missing, class would belong to the "default" package, and would not be placed 
    into any package folder.
13. The import of all classes from the "java.lang.*" package is implicitly assumed.
        a. Import statements are not present in the compiled code.
14. Compile java program
        a. java -cp <path of dependent classes> -d <destination path> <path to source code>
        b. cp and -d are optional.
15. Execute java program
        java -cp <folders where classes are located> <fully qualified class name> <space separated paramter>
        Since java 11, it's possible to run single-source code file as compiled code. 
16. Documenting your code.
        java -d <documentation path> -sourcepath <source-path> -subpackages <subpackages>