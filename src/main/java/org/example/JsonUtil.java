package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.lang.reflect.Type;
import java.util.List;

public final class JsonUtil {
    JsonUtil() {
    }

    private static Gson gson = new GsonBuilder().setPrettyPrinting().create();
    public static String studentToJson(Student student){
        return gson.toJson(student);
    }
    public static String universityToJson(University university){
        return gson.toJson(university);
    }

    public static String studentListToJson(List<Student> studentList){
        return gson.toJson(studentList);
    }
    public static String universityListToJson(List<University> universityList){
        return gson.toJson(universityList);
    }

    public static Student jsonToStudent(String jsonStudent){
        return gson.fromJson(jsonStudent, Student.class);
    }

    public static University jsonToUniversity(String jsonUniversity){
        return gson.fromJson(jsonUniversity, University.class);
    }

    public static List<Student> jsonToStudentList(String json, Type listType){
        return gson.fromJson(json, listType);
    }

    public static List<University> jsonToUniversityList(String json, Type listType){
        return gson.fromJson(json, listType);
    }
}
