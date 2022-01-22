### 01/22


### DI 관련
DI에는 필드 주입, setter 주입, 생성자 주입 이렇게 3가지 방법이 존재

1. 필드 주입 : @Autowired private MemberService 처럼 작성하는 방식
            바꿀 수 있는 방법이 존재하지 않아 좋지 않음
2. setter 주입 : 생성은 한 뒤 setter를 호출하여 의존성을 주입하는 방식
            setter가 public으로 열려있기 때문에 다른 개발자가 호출 가능(예전에 주로 사용)
3. 생성자 주입 : 현재 사용한 방식으로 애플리케이션이 스프링 컨테이너에 올라가는 시점에
            의존성이 주입되고, 의존 관계가 동적으로 변하는 경우는 거의 없으므로(사실상 아예 없음) 가장 권장되는 방식.

자세한 내용에 대해서는 추후 강의에서 다룰 예정(스프링 컨테이너, DI 내용)

### HomeController 관련

기존에 만든 index.html 이 있지만, spring이 
![image](https://user-images.githubusercontent.com/34308156/150632182-62fa1f39-fedc-4b39-a756-f2b0993df4ef.png)
위 순서로 응답을 찾아보기 때문에 새로 만들어진 HomeController가 존재하여 기존 index.html이 아닌
home.html을 렌더링하여 응답


