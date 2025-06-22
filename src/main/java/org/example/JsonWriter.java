package org.example;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Objects;
import java.util.logging.Logger;

import static util.JsonUtil.gson;

public class JsonWriter {
    private static final Logger loggerJsonWriter = Logger.getLogger(JsonWriter.class.getName());
    public void writeJsonToFile(Object objects, String fileName){
        try {
            loggerJsonWriter.info("Начата операция записи JSON для объектов " + objects.getClass().getSimpleName());
            String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
            String fileNamep = fileName + "_" + timestamp + ".json";
            File file = new File("jsonReqs/" + fileNamep);
            loggerJsonWriter.info("Файл будет сохранен в " + file.getAbsolutePath());
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
                loggerJsonWriter.info("Создана директория: " + file.getParentFile().getAbsolutePath());
            }
           try (FileWriter writer = new FileWriter(file)) {
               gson.toJson(objects, writer);
           }

            System.out.println("JSON-файл сохранён: " + file.getAbsolutePath());

        } catch (IOException e) {
            loggerJsonWriter.severe("Ошибка при сериализации " + e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
