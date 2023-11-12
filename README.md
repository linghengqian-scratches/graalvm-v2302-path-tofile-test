## graalvm-v2302-path-tofile-test

- For https://github.com/apache/shardingsphere/pull/29000 and https://github.com/oracle/graal/issues/7804 .

- Execute the following command on the new Ubuntu 22.04.3 LTS instance.

```shell
sudo apt install unzip zip curl sed -y
curl -s "https://get.sdkman.io" | bash
source "$HOME/.sdkman/bin/sdkman-init.sh"
sdk install java 17.0.9-graalce
sdk use java 17.0.9-graalce

git clone git@github.com:linghengqian/graalvm-v2302-path-tofile-test.git
cd ./graalvm-v2302-path-tofile-test/
./gradlew -Pagent clean test
./gradlew metadataCopy --task test
./gradlew clean nativeTest
```

- The Error Log is as follows.

```shell
$ ./gradlew clean nativeTest

> Task :generateTestResourcesConfigFile
[native-image-plugin] Resources configuration written into /home/linghengqian/TwinklingLiftWorks/git/public/graalvm-v2302-path-tofile-test/build/native/generated/generateTestResourcesConfigFile/resource-config.json

> Task :nativeTestCompile
[native-image-plugin] GraalVM Toolchain detection is disabled
[native-image-plugin] GraalVM location read from environment variable: JAVA_HOME
[native-image-plugin] Native Image executable path: /home/linghengqian/.sdkman/candidates/java/17.0.9-graalce/lib/svm/bin/native-image
========================================================================================================================
GraalVM Native Image: Generating 'graalvm-v2302-path-tofile-test-tests' (executable)...
========================================================================================================================
For detailed information and explanations on the build output, visit:
https://github.com/oracle/graal/blob/master/docs/reference-manual/native-image/BuildOutput.md
------------------------------------------------------------------------------------------------------------------------
[1/8] Initializing...                                                                                    (8.5s @ 0.09GB)
 Java version: 17.0.9+9, vendor version: GraalVM CE 17.0.9+9.1
 Graal compiler: optimization level: 2, target machine: x86-64-v3
 C compiler: gcc (linux, x86_64, 11.4.0)
 Garbage collector: Serial GC (max heap size: 80% of RAM)
 1 user-specific feature(s)
 - org.graalvm.junit.platform.JUnitPlatformFeature
[junit-platform-native] Running in 'test listener' mode using files matching pattern [junit-platform-unique-ids*] found in folder [/home/linghengqian/TwinklingLiftWorks/git/public/graalvm-v2302-path-tofile-test/build/test-results/test/testlist] and its subfolders.
[2/8] Performing analysis...  [****]                                                                    (27.3s @ 0.70GB)
   6,007 (81.68%) of  7,354 types reachable
   9,265 (62.18%) of 14,900 fields reachable
  28,230 (53.55%) of 52,714 methods reachable
   1,802 types,     0 fields, and   710 methods registered for reflection
      59 types,    59 fields, and    52 methods registered for JNI access
       4 native libraries: dl, pthread, rt, z
[3/8] Building universe...                                                                               (3.5s @ 0.60GB)
[4/8] Parsing methods...      [**]                                                                       (2.2s @ 0.93GB)
[5/8] Inlining methods...     [***]                                                                      (1.4s @ 0.79GB)
[6/8] Compiling methods...    [*****]                                                                   (21.7s @ 0.84GB)
[7/8] Layouting methods...    [**]                                                                       (2.2s @ 1.21GB)
[8/8] Creating image...       [**]                                                                       (2.9s @ 0.58GB)
  12.02MB (44.07%) for code area:    17,383 compilation units
  14.12MB (51.80%) for image heap:  162,612 objects and 68 resources
   1.13MB ( 4.13%) for other data
  27.26MB in total
------------------------------------------------------------------------------------------------------------------------
Top 10 origins of code area:                                Top 10 object types in image heap:
   5.89MB java.base                                            2.66MB byte[] for code metadata
   3.78MB java.xml                                             1.57MB java.lang.String
 988.32kB svm.jar (Native Image)                               1.42MB java.lang.Class
 207.75kB junit-jupiter-engine-5.10.1.jar                      1.42MB byte[] for general heap data
 203.74kB jdk.zipfs                                            1.25MB byte[] for java.lang.String
 138.26kB junit-platform-launcher-1.10.1.jar                 752.07kB byte[] for embedded resources
 114.42kB java.logging                                       516.23kB com.oracle.svm.core.hub.DynamicHubCompanion
 111.19kB junit-platform-reporting-1.10.1.jar                513.00kB int[][]
 103.36kB junit-platform-engine-1.10.1.jar                   448.03kB java.util.HashMap$Node
  92.97kB junit-platform-commons-1.10.1.jar                  334.08kB java.lang.String[]
 326.92kB for 14 more packages                                 2.80MB for 1428 more object types
------------------------------------------------------------------------------------------------------------------------
Recommendations:
 HEAP: Set max heap for improved and more predictable memory usage.
 CPU:  Enable more CPU features with '-march=native' for improved performance.
------------------------------------------------------------------------------------------------------------------------
                        4.7s (6.5% of total time) in 102 GCs | Peak RSS: 2.29GB | CPU load: 4.84
------------------------------------------------------------------------------------------------------------------------
Produced artifacts:
 /home/linghengqian/TwinklingLiftWorks/git/public/graalvm-v2302-path-tofile-test/build/native/nativeTestCompile/graalvm-v2302-path-tofile-test-tests (executable)
========================================================================================================================
Finished generating 'graalvm-v2302-path-tofile-test-tests' in 1m 10s.
[native-image-plugin] Native Image written to: /home/linghengqian/TwinklingLiftWorks/git/public/graalvm-v2302-path-tofile-test/build/native/nativeTestCompile

> Task :nativeTest FAILED
JUnit Platform on Native Image - report
----------------------------------------

com.lingh.PathTest > test() FAILED


Failures (1):
  JUnit Jupiter:PathTest:test()
    MethodSource [className = 'com.lingh.PathTest', methodName = 'test', methodParameterTypes = '']
    => org.opentest4j.AssertionFailedError: Unexpected exception thrown: java.lang.UnsupportedOperationException
       org.junit.jupiter.api.AssertionFailureBuilder.build(AssertionFailureBuilder.java:152)
       org.junit.jupiter.api.AssertDoesNotThrow.createAssertionFailedError(AssertDoesNotThrow.java:84)
       org.junit.jupiter.api.AssertDoesNotThrow.assertDoesNotThrow(AssertDoesNotThrow.java:53)
       org.junit.jupiter.api.AssertDoesNotThrow.assertDoesNotThrow(AssertDoesNotThrow.java:36)
       org.junit.jupiter.api.Assertions.assertDoesNotThrow(Assertions.java:3168)
       [...]
     Caused by: java.lang.UnsupportedOperationException
       org.graalvm.nativeimage.builder/com.oracle.svm.core.jdk.resources.NativeImageResourcePath.toFile(NativeImageResourcePath.java:421)
       com.lingh.PathTest.lambda$test$2(PathTest.java:41)
       org.junit.jupiter.api.AssertDoesNotThrow.assertDoesNotThrow(AssertDoesNotThrow.java:49)
       [...]

Test run finished after 2 ms
[         2 containers found      ]
[         0 containers skipped    ]
[         2 containers started    ]
[         0 containers aborted    ]
[         2 containers successful ]
[         0 containers failed     ]
[         1 tests found           ]
[         0 tests skipped         ]
[         1 tests started         ]
[         0 tests aborted         ]
[         0 tests successful      ]
[         1 tests failed          ]


FAILURE: Build failed with an exception.

* What went wrong:
Execution failed for task ':nativeTest'.
> Process 'command '/home/linghengqian/TwinklingLiftWorks/git/public/graalvm-v2302-path-tofile-test/build/native/nativeTestCompile/graalvm-v2302-path-tofile-test-tests'' finished with non-zero exit value 1

* Try:
> Run with --stacktrace option to get the stack trace.
> Run with --info or --debug option to get more log output.
> Run with --scan to get full insights.
> Get more help at https://help.gradle.org.

BUILD FAILED in 1m 14s
8 actionable tasks: 8 executed

```