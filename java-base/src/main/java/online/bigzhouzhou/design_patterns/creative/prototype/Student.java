package online.bigzhouzhou.design_patterns.creative.prototype;

/**
 * Student类
 * date: 2024/8/12 15:16<br/>
 * 用原型实例指定创建对象的种类，并且通过拷贝这些原型创建新的对象
 *
 * @author SAg <br/>
 */
public class Student {
    private int id;
    private String name;
    private int score;

    public Student clone()
    {
        Student student = new Student();
        student.setId(this.id);
        student.setName(this.name);
        student.setScore(this.score);
        return student;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", score=" + score +
                '}';
    }
}
