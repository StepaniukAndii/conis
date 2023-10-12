package pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class SignUpPage extends BasePage<SignUpPage> {

    private By confirm_password = By.xpath("//input[@autocomplete=\"new-password\"]");

    @Override
    public SignUpPage waitPage() {
        $(confirm_password).shouldBe(Condition.visible);
        return page(SignUpPage.class);
    }
}
