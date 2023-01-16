package me.whiteship.inflearnthejavatest.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Executable;
import java.time.Duration;
import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.*;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class StudyTest {
    @Test
    @DisplayName("스터디 만들기 \uD83D")
    void create_new_study() {
        Study study = new Study();
//        assertNotNull(study);
//        assertEquals(
//                StudyStatus.DRAFT,
//                study.getStatus(),
//                () -> "스터디를 처음 만들면 DRAFT 상태다."
//        );
//        assertTrue(1 < 2);
         assertAll(
                 () -> assertNotNull(study),
                 ()->assertEquals(
                    StudyStatus.DRAFT,
                    study.getStatus(),
                    () -> "스터디를 처음 만들면 DRAFT 상태다."
                 ),
                 ()->assertTrue(1 < 2)
         );
    }

    @Test
    void test_create(){
        IllegalArgumentException exception=assertThrows(IllegalArgumentException.class, ()->new Study(-10));
        String message = exception.getMessage();
        assertEquals("limit은 0보다 커야한다.", message);
    }

    @Test
    void test_create_times() {
        assertTimeout(Duration.ofMillis(100), ()-> {
            new Study(10);
            Thread.sleep(300);
        });
    }

    @Test
    void test_create_times_preemptively() {
        // Thread - ex) transaction 과 연관이 없는 코드인 경우에 사용/ 연관있는 경우 문제 발생할 수 있음
        assertTimeoutPreemptively(Duration.ofMillis(100), ()-> {
            new Study(10);
            Thread.sleep(300);
        });
        // TODO ThreadLocal
    }
}