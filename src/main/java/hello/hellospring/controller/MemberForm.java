package hello.hellospring.controller;

public class MemberForm {
    private String name;

    public String getName() {
        return name;
    }

    //Spring이 setName을 통해 변수에 할당해줌
    public void setName(String name) {
        this.name = name;
    }
}
