package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class SignInPage extends BasePage<SignInPage> {

    private By signUpBtn = By.xpath("//form[@class='auth-container__form-side-container']//span[contains(text(), 'Sign Up')]");


    public SignInPage open() {
        Selenide.open("/login");

        return this;
    }

    public SignUpPage clickSignUpBtn() {
        $(signUpBtn).shouldBe(Condition.visible).click();
        return page(SignUpPage.class).waitPage();
    }


    @Override
    public SignInPage waitPage() {
        return this;
    }
}
