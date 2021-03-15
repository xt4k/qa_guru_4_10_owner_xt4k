package tests;

import helpers.BaseTest;
import io.qameta.allure.Step;
import po.BasePageObject;
import pojo.Student;

public class StudentRegistrationScenario extends BaseTest {
    BasePageObject po = new BasePageObject( );

    @Step("Success student form register scenario")
    void successStudentRegisterScenario(Student student) {
        po.openForm(basePageUrl)
                .validateFormOpen( )
                .fillRegForm(student)
                .submitForm( );
        po.registeredFormVerification(student);
    }

    @Step("Success student form register scenario")
    void unSuccessStudentRegisterScenario(Student student, String field) {
        po.openForm(basePageUrl)
                .validateFormOpen( )
                .fillRegForm(student)
                .submitForm( );
        po.validateFormOpen( )
                .emptyField(field);
    }

    @Step("Failed scenario")
    public void failedTest( ) {
        po.openForm(basePageUrl)
                .validateFormOpen( )
                .submitForm( );
        po.validateFormOpen( );
        failStep( );
    }
}