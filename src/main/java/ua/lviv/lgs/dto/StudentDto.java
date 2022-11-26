package ua.lviv.lgs.dto;

public class StudentDto {
    private String name;
    private String lastName;
    private Integer age;
    private String uri;

    public StudentDto(String name, String lastName, int age, String uri) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.uri = uri;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getLastName() {
        return lastName;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public String getUri() {
        return uri;
    }
}
