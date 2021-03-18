package tests;

import config.WebConfig;
import helpers.BaseTest;
import io.qameta.allure.Step;
import org.aeonbits.owner.ConfigFactory;
import po.BasePageObject;
import pojo.Student;

public class StudentRegistrationScenario extends BaseTest {
    BasePageObject po = new BasePageObject( );
    final WebConfig config = ConfigFactory.create(WebConfig.class, System.getProperties());

    @Step("Success student form register scenario")
    void successStudentRegisterScenario(Student student) {
        po.openForm(config.getBaseUrl())
                .validateFormOpen( )
                .fillRegForm(student)
                .submitForm( );
        po.registeredFormVerification(student);
    }

    @Step("Success student form register scenario")
    void unSuccessStudentRegisterScenario(Student student, String field) {
        po.openForm(config.getBaseUrl())
                .validateFormOpen( )
                .fillRegForm(student)
                .submitForm( );
        po.validateFormOpen( )
                .emptyField(field);
    }

    @Step("Failed scenario")
    public void failedTest( ) {
        po.openForm(config.getBaseUrl())
                .validateFormOpen( )
                .submitForm( );
        po.validateFormOpen( );
        failStep( );
    }
}