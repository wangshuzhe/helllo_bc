package w050408;

public class Test {
    public static void main(String[] args) {
        Employee1 employee1 = new Employee1("男");
        employee1.setName("术者");
        System.out.println(employee1.getName1());
        System.out.println(employee1.getCode());
        System.out.println(employee1.getSex());
        System.out.println("---------");
        Employee1 employee2 = new Employee1("女");
        employee2.setName("巫女");
        System.out.println(employee2.getName1());
        System.out.println(employee2.getCode());
        System.out.println(employee2.getSex());
    }
}
