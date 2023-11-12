package com.lingh;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class PathTest {

    @SuppressWarnings("unused")
    @Test
    void test() throws IOException {
        if (null == System.getProperty("org.graalvm.nativeimage.imagecode") || !"runtime".equals(System.getProperty("org.graalvm.nativeimage.imagecode"))) {
            Path result = Paths.get(Objects.requireNonNull(getClass().getClassLoader().getResource("h2.txt")).getPath());
            assertDoesNotThrow(() -> {
                InputStream inputStreamFirst = Files.newInputStream(result.toAbsolutePath());
                inputStreamFirst.close();
                File file = result.toFile();
                InputStream inputStreamSecond = Files.newInputStream(result.toFile().toPath());
                inputStreamSecond.close();
            });
        } else {
            try (FileSystem fileSystem = FileSystems.newFileSystem(URI.create("resource:/"), Collections.emptyMap())) {
                Path result = fileSystem.getPath("h2.txt");
                assertDoesNotThrow(() -> {
                    InputStream inputStreamFirst = Files.newInputStream(result.toAbsolutePath());
                    inputStreamFirst.close();
                });
                assertDoesNotThrow(() -> {
                    File file = result.toFile();
                });
                assertDoesNotThrow(() -> {
                    InputStream inputStreamSecond = Files.newInputStream(result.toFile().toPath());
                    inputStreamSecond.close();
                });
            }
        }
    }
}
