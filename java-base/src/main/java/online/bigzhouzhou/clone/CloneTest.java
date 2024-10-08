package online.bigzhouzhou.clone;

/**
 * CloneTest类
 * date: 2024/7/31 21:39<br/>
 *
 * @author SAg <br/>
 */
public class CloneTest {
    public static void main(String[] args) throws CloneNotSupportedException {
        Employee original = new Employee("John Q. Public", 50000);
        original.setHireDay(2000, 1, 1);
        Employee copy = original.clone();
        copy.raiseSalary(10);
        copy.setHireDay(2002, 12, 31);
        System.out.println("original = " + original);
        System.out.println("copy = " + copy);
    }
}
