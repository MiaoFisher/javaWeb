package com.spring01.bean;

import java.util.List;

public class Stu {
    private List<String> courses;

    public List<String> getCourses() {
        return courses;
    }

    public void setCourses(List<String> courses) {
        this.courses = courses;
    }

    @Override
    public String toString() {
        return "Stu{" +
                "courses=" + courses +
                '}';
    }
}
