package hello.core.singleton;

public class SingletonService {

    private static final SingletonService instance = new SingletonService();
    //객체를 생성하고 자기자신을 인스턴스에 넣어놓음

    public static SingletonService getInstance() {
        return instance;  //오직 여기서만 싱글톤이 실행된다.
    }

    private SingletonService() {
    }  //생성자를 private으로 막아 다른 어떤 곳에서도 싱글톤서비스를 생성할 수 없다.

    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }
}
