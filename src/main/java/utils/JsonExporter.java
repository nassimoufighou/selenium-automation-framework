package utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public final class JsonExporter {

    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    private JsonExporter() {
    }

    public static void writeObject(Object object, Path file) {
        write(object, file);
    }

    public static <T> void writeList(List<T> list, Path file) {
        write(list, file);
    }

    private static void write(Object data, Path file) {
        try {
            Path parent = file.getParent();
            if (parent != null) {
                Files.createDirectories(parent);
            }
            try (Writer writer = Files.newBufferedWriter(file, StandardCharsets.UTF_8)) {
                GSON.toJson(data, writer);
            }
        } catch (IOException e) {
            throw new RuntimeException("Could not write JSON to " + file, e);
        }
    }

    public static <T> T readObject(Path file, Class<T> type) {
        try (Reader reader = Files.newBufferedReader(file, StandardCharsets.UTF_8)) {
            return GSON.fromJson(reader, type);
        } catch (IOException e) {
            throw new RuntimeException("Could not read JSON from " + file, e);
        }
    }

    public static <T> List<T> readList(Path file, Class<T> elementType) {
        Type listType = TypeToken.getParameterized(List.class, elementType).getType();
        try (Reader reader = Files.newBufferedReader(file, StandardCharsets.UTF_8)) {
            return GSON.fromJson(reader, listType);
        } catch (IOException e) {
            throw new RuntimeException("Could not read JSON from " + file, e);
        }
    }
}
