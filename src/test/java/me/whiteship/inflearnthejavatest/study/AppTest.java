package me.whiteship.inflearnthejavatest.study;

import me.whiteship.inflearnthejavatest.App;

import org.junit.jupiter.api.*;

import static org.junit.Assert.assertNotNull;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class AppTest {
    @Test
    @DisplayName("create_app")
    void create() {
        App app=new App();
        assertNotNull(app);
        System.out.println("create");
    }

    @Test
    @Disabled
    void create1(){
        System.out.println("create1");
    }

    @BeforeAll
    static void beforeAll() {
        System.out.println("before All");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("after All");
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("before Each");
    }

    @AfterEach
    void afterEach() {
        System.out.println("after Each");
    }


}
