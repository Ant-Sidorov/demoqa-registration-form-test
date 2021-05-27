package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Selenide.*;

public class Student_Registration_Form {

    static void setup() {
        Configuration.startMaximized = true;
    }


    @Test
    void successfulSubmitForm() {
        open("https://demoqa.com/automation-practice-form");

        $("[id=firstName]").setValue("Anton");
        $("[id=lastName]").setValue("Sidorov");
        $("[id=userEmail]").setValue("ant@mail.com");
        $("[for='gender-radio-1']").click();
        $("[id=userNumber]").setValue("1234567890");
        $("[id=dateOfBirthInput]").click();
        $("[class=react-datepicker__month-select]").selectOption(3);
        $("[class=react-datepicker__year-select]").selectOption("1991");
        $("[aria-label=\"Choose Monday, April 8th, 1991\"]").click();


        $("[id=subjectsInput]").setValue("Commerce").pressEnter();

        $("[for=hobbies-checkbox-1]").click();
        File file = $("[id=uploadPicture]").uploadFile(new File("src/test/resources/test_upload.jpg"));

        $("[id=currentAddress]").setValue("Sport street");

        $("[id=react-select-3-input]").setValue("NCR").pressEnter();
        $("[id=react-select-4-input]").setValue("Gurgaon").pressEnter();

        $("[id=submit]").click();


        sleep(5000);
    }
}
