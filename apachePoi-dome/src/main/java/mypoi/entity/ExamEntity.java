package mypoi.entity;

import java.util.Date;

/*
 * @Author WQL-KXJ
 * @ProjectName apachePoi-Test
 * @PackageName mypoi.entity
 * @Date 2023/5/28 10:34
 * @Version 1.0
 */
public class ExamEntity {

    //考试时间
    Date examTime;

    //教室名称
    String classRoomName;

    //课程名称
    String courseName;

    public Date getExamTime() {
        return examTime;
    }

    public void setExamTime(Date examTime) {
        this.examTime = examTime;
    }

    public String getClassRoomName() {
        return classRoomName;
    }

    public void setClassRoomName(String classRoomName) {
        this.classRoomName = classRoomName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    @Override
    public String toString() {
        return "ExamEntity{" +
                "examTime=" + examTime +
                ", classRoomName='" + classRoomName + '\'' +
                ", courseName='" + courseName + '\'' +
                '}';
    }
}
