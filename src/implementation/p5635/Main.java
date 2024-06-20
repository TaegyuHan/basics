package implementation.p5635;

import implementation.Implementation;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream(Implementation.PATH + "/p5635/data/1.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Class c = Class.of(br.readLine());
        for (int i = 0; i < c.getStudentCount(); ++i) {
            c.setStudent(br.readLine());
        }
        c.answer();
    }
}

class Class {
    private final int studentCount;
    private Student oldest;
    private Student youngest;

    public Class(int count) {
        this.studentCount = count;
    }

    public static Class of(String line) {
        return new Class(Integer.parseInt(line));
    }

    public int getStudentCount() {
        return studentCount;
    }

    public void setStudent(String line) {
        Student student = Student.of(line);
        // 초기값
        if (oldest == null || youngest == null) {
            oldest = student;
            youngest = student;
            return;
        }
        // 가장 많은 나이를 갖는 학생
        if (!oldest.isOlder(student)) {
            oldest = student;
        }

        // 가장 많은 나이를 갖는 학생
        if (!youngest.isYoung(student)) {
            youngest = student;
        }
    }

    public void answer() {
        System.out.print(youngest.getName() + "\n" + oldest.getName());
    }
}

class Student {
    private final String name;
    private final int year;
    private final int month;
    private final int day;

    public Student(String name, int day, int month, int year) {
        this.name = name;
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public static Student of(String line) {
        String[] data = line.split(" ");
        return new Student(
                data[0],
                Integer.parseInt(data[1]),
                Integer.parseInt(data[2]),
                Integer.parseInt(data[3])
        );
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    // 더 빨리 태어난 것
    public boolean isOlder(Student o) {

        if (year < o.getYear()) {
            return true;
        } else if (year > o.getYear()) {
            return false;
        }

        if (month < o.getMonth()) {
            return true;
        } else if (month > o.getMonth()) {
            return false;
        }

        return day <= o.getDay();
    }

    // 더 늦게 태어난 것
    public boolean isYoung(Student o) {
        if (year > o.getYear()) {
            return true;
        } else if (year < o.getYear()) {
            return false;
        }

        if (month > o.month) {
            return true;
        } else if (month < o.month) {
            return false;
        }

        return day >= o.day;
    }
}