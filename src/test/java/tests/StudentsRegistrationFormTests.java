package tests;

import helpers.BaseTest;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pojo.Student;

import static io.qameta.allure.SeverityLevel.BLOCKER;

@Epic("Student registration form tests")
public class StudentsRegistrationFormTests extends BaseTest {
    StudentRegistrationScenario test;

    @Feature("Positive tests")
    @Story("Totally filled form")
    @Test
    @Tag("positive")
    @Severity(BLOCKER)
    @DisplayName("Test 01: Check Student form registration for full form fill.")
    public void test01studentRegForm( ) {
        Student student = new Student( );
        test = new StudentRegistrationScenario( );
        test.successStudentRegisterScenario(student);
    }

    @Feature("Positive tests")
    @Story("Form filled partly")
    @Test
    @Tag("positive")
    @Severity(BLOCKER)
    @DisplayName("Test 02: Check Student form registration for full form filled with not only required fields.")
    public void test02studentRegForm( ) {
        Student student = new Student(true);
        student.setHobbies(1);
        test = new StudentRegistrationScenario( );
        test.successStudentRegisterScenario(student);
    }

    @Feature("Positive tests")
    @Story("Form filled in minimal way")
    @Test
    @Tag("positive")
    @Severity(BLOCKER)
    @DisplayName("Test 03: Check Student form registration for full form only required fields fill.")
    public void test03studentRegForm( ) {
        Student student = new Student(true);
        test = new StudentRegistrationScenario( );
        test.successStudentRegisterScenario(student);
    }

    @Feature("Negative tests")
    @Story("Incomplete form")
    @Test
    @Tag("negative")
    @Severity(BLOCKER)
    @DisplayName("Test 04: Check unsuccessful Student form registration for not filled required field `First Name`.")
    public void test04studentRegForm( ) {
        String fieldName = "firstName";
        Student student = new Student(true);
        student.setFirstName(null);
        test = new StudentRegistrationScenario( );
        test.unSuccessStudentRegisterScenario(student, fieldName);
    }

    @Feature("Negative tests")
    @Story("Incomplete form")
    @Test
    @Tag("negative")
    @Severity(BLOCKER)
    @DisplayName("Test 05: Check unsuccessful Student form registration for not filled required field `Last Name`.")
    public void test05studentRegForm( ) {
        String fieldName = "lastName";
        Student student = new Student(true);
        student.setLastName(null);
        test = new StudentRegistrationScenario( );
        test.unSuccessStudentRegisterScenario(student, fieldName);
    }

    @Feature("Negative tests")
    @Story("Incomplete form")
    @Test
    @Tag("negative")
    @Severity(BLOCKER)
    @DisplayName("Test 06: Check unsuccessful Student form registration for not filled required field `Mobile Number`.")
    public void test06studentRegForm( ) {
        String fieldName = "userNumber";
        Student student = new Student(true);
        student.setMobileNum(null);
        test = new StudentRegistrationScenario( );
        test.unSuccessStudentRegisterScenario(student, fieldName);
    }

    @Feature("Failed tests")
    @Story("Test failed in purpose")
    @Test
    @Tag("failed")
    @Severity(BLOCKER)
    @DisplayName("Test 07: Failed test.")
    public void test07studentRegForm( ) {
        test = new StudentRegistrationScenario( );
        test.failedTest( );
    }

    @Feature("Failed tests")
    @Story("Other one Test failed in purpose")
    @Test
    @Tag("failed")
    @Severity(BLOCKER)
    @DisplayName("Test 08:Second failed test.")
    public void test08studentRegForm( ) {
        test = new StudentRegistrationScenario( );
        test.failedTest( );
    }

}