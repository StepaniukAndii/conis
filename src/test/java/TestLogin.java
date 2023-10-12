import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SignInPage;

public class TestLogin extends BaseTest {

    @Test
    public void checkLogin() {
        new SignInPage()
                .open()
                .clickSignUpBtn();

        Assert.assertEquals(getActualUrl(), getExpectedUrl("/register"));
    }
}
