package ee.spring.aop;

import javax.annotation.PostConstruct;

@org.springframework.stereotype.Service
public class Service {

    @PostConstruct
    void init() {
        System.out.println(Service.class.getCanonicalName() + "... initializing");
    }

    private void mock() {

    }

    public void doService() {

        mock();
        System.out.println("-----");

    }
}
