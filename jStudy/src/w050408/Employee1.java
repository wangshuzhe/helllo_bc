package w050408;

public class Employee1 {
    private String name;
    private final String code;
    private final String sex;
     {
        code = "123";
    }

    public Employee1(String sex) {
         this.sex = sex;
    }
    public String getCode(){
        return code;
    }
    public String getSex(){
         return sex;
    }
    //只能在本类中访问，无法使用对对象调用
    private String getName() {
        return name;
    }
    //实例化对象以后可以调用
    public String getName1(){
        return getName();
    }
    public void setName(String name){
        this.name = name;
    }
}
