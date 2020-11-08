package com.peanut.bean;

public class Course {
    private Integer courseId;
    private String courseName;
    private String classRoom;
    private String classTime;

    public Course(Integer courseId, String courseName, String classRoom, String classTime) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.classRoom = classRoom;
        this.classTime = classTime;
    }

    public Course(){}

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getClassRoom() {
        return classRoom;
    }

    public void setClassRoom(String classRoom) {
        this.classRoom = classRoom;
    }

    public String getClassTime() {
        return classTime;
    }

    public void setClassTime(String classTime) {
        this.classTime = classTime;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseId=" + courseId +
                ", courseName='" + courseName + '\'' +
                ", classRoom='" + classRoom + '\'' +
                ", classTime='" + classTime + '\'' +
                '}';
    }
}
