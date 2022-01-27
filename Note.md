### 01/27

### AOP가 필요한 상황
모든 메소드의 호출 시간을 측정하고 싶다면?  
공통 관심 사항(cross-cutting concern) vs 핵심 관심 사항(core concern)  
회원 가입 시간, 회원 조회 시간을 측정하고 싶다면?  

### 문제사항
1. 회원가입, 회원 조회에 시간을 측정하는 기능은 핵심 관심 사항이 아니다.  
2. 시간을 측정하는 로직은 공통 관심 사항이다.
3. 시간을 측정하는 로직과 핵심 비즈니스의 로직이 섞여서 유지보수가 어렵다.
4. 시간을 측정하는 로직을 별도의 공통 로직으로 만들기 매우 어렵다.
5. 시간을 측정하는 로직을 변경할 때 모든 로직을 찾아가면서 변경해야 한다.

### 해결
1. 회원가입, 회원 조회등 핵심 관심사항과 시간을 측정하는 공통 관심 사항을 분리한다.
2. 시간을 측정하는 로직을 별도의 공통 로직으로 만들었다.
3. 핵심 관심 사항을 깔끔하게 유지할 수 있다.
4. 변경이 필요하면 이 로직만 변경하면 된다.
5. 원하는 적용 대상을 선택할 수 있다.

### 동작 방식
실제 객체를 호출하지 않고 proxy 객체를 호출하는 것으로 동작하게 된다.  
프록시 객체 호출 => AOP 실행 => joinPoint 로 실제 객체 호출  
스프링에서는 이를 proxy 방식의 AOP라 함


### 01/26
[SpringDataJpaMemberRepository]
인터페이스를 통한 기본적인 CRUD를 제공하고, @Override 어노테이션 명명 규칙으로 JPQL을 생성해줌
ex) findByParam1(Type Param1)  => JPQL : "select m from Member m where m.Param1 = ?"
    findByParam1AndParam2(Type Param1, Type Param2)  => JPQL : "select m from Member m where m.Param1 = ? and m.Param2 = ?"

별도의 구현체를 생성하지 않아도 스프링 컨테이너에서 구현체를 생성하여 Bean에 등록하여 준다.



### 01/25

[JdbcMemberRepository]  
Jdbc 관련하여 스프링컨테이너에서 작업을 할 때 DataSourceUtils
을 통하여 작업을 하여야 한다.

[MemberServiceIntegrationTest]  
@Transactional 어노테이션을 통해 테스트를 진행할 시,
트랜잭션을 commit 하지 않아 테스트 간의 영향을 받지 않는다.

참고: @commit 등의 어노테이션도 존재하며 이 어노테이션을 사용할 시 해당 테스트 케이스의 트랜잭션은 commit 되도록 한다. 





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


