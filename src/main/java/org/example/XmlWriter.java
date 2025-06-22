package org.example;

import model.Student;
import util.JsonUtil;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.logging.Logger;

public class XmlWriter {
    private static final Logger loggerXmlWriter = Logger.getLogger(XmlWriter.class.getName());


    public void writeXmlToFile(Object objects, String fileName){
        try {
            loggerXmlWriter.info("Начата операция записи XML для объектов " + objects.getClass().getSimpleName());
            JAXBContext context = JAXBContext.newInstance(objects.getClass());
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMdd_HHmmss"));
            String fileNameP = fileName + "_" + timestamp + ".xml";
            File file = new File("xmlReqs/" + fileNameP);
            loggerXmlWriter.info("Создан файл для записи XML " + file.getAbsolutePath());
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
                loggerXmlWriter.info("Создана директория: " + file.getParentFile().getAbsolutePath());
            }

            marshaller.marshal(objects, file);
            System.out.println("XML-файл сохранен в " + file.getAbsolutePath());

        } catch (JAXBException e) {
            loggerXmlWriter.severe("Ошибка при сериализации JAXB: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }
}



