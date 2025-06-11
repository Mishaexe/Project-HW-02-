package org.example;

public class Main {
    public static void main(String[] args) {
        Student Ivan = new Student("Цанг Иван Александрович ",
                "U001 ", 3, 4.7f);

        University uni = new University("U001 ",
                "Московский Государственный Университет ", "МГУ ", 1755,  StudyProfile.PROGRAMIST);

        System.out.println(Ivan);
        System.out.println(uni);
    }
}