package Junit;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Demo04_LifeCycleHooks_Setup_TearDown {

    private Junit.Demo04_DatabaseService db;

    @BeforeEach
    void init() {
        db = new Junit.Demo04_DatabaseService();
        db.connect();
    }

    @AfterEach
    void cleanup() {
        db.disconnect();
    }

    // Pass Test
    @Test
    void testInsertAndFetchPass() {
        db.insert("user1", "Prasunamba");
        assertEquals("Prasunamba", db.fetch("user1"));
    }

    // Fail Test
    @Test
    void testInsertAndFetchFailValue() {
        db.insert("user1", "Prasunamba");

        assertEquals("WrongName",
                db.fetch("user1"),
                "Expected WrongName but got " + db.fetch("user1"));
    }

    // Fail Test
    @Test
    void testFetchNonExistentKeyFail() {

        assertEquals("SomeValue",
                db.fetch("missingKey"),
                "Expected SomeValue but got null");
    }
}