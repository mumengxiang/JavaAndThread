package Java8Model;


import java.util.Objects;

public class emplyee {
    private String name;
    private Integer age;
    private Double slary;
    private Status status;
    public emplyee() {
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public emplyee(String name, Integer age, Double slary) {
        this.name = name;
        this.age = age;
        this.slary = slary;
    }
    public emplyee(String name, Integer age, Double slary, Status status) {
        this.name = name;
        this.age = age;
        this.slary = slary;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        emplyee emplyee = (emplyee) o;
        return name.equals(emplyee.name) &&
                age.equals(emplyee.age) &&
                slary.equals(emplyee.slary);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, slary);
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "emplyee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", slary=" + slary +
                ", status=" + status +
                '}';
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Double getSlary() {
        return slary;
    }

    public void setSlary(Double slary) {
        this.slary = slary;
    }




    public enum Status{
        free,
        busy,
        vacation
    }
}
