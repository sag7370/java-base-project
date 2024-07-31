package bigzhou.interfaces;

/**
 * Employee类
 * date: 2024/7/31 16:31<br/>
 *
 * @author SAg <br/>
 */
public class Employee implements Comparable<Employee> {
    private String name;
    private double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void raiseSalary(double byPercent) {
        double raise = salary * byPercent / 100;
        salary += raise;
    }

    @Override
    public int compareTo(Employee other) {
        // 如果第一个参数小于第二个参数，返回负值；相等返回0，大于返回正值
        return Double.compare(salary, other.salary);
    }
}
