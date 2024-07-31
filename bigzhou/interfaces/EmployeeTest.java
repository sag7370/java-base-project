package bigzhou.interfaces;

import java.util.Arrays;

/**
 * EmployeeTest类
 * date: 2024/7/31 20:10<br/>
 *
 * @author SAg <br/>
 */
public class EmployeeTest {
    public static void main(String[] args) {
        var staff = new Employee[3];
        staff[0] = new Employee("Harry Hacker", 35000);
        staff[1] = new Employee("Carl Cracker", 75000);
        staff[2] = new Employee("Tony Tester", 38000);
        // 对数组a中的元素进行排序。要求数组中的元素必须属于实现了Comparable接口的类，并且元素之间必须是可比较的。
        Arrays.sort(staff);

        for (Employee e : staff) {
            System.out.println("name = " + e.getName() + ", salary = " + e.getSalary());
        }
    }
}
