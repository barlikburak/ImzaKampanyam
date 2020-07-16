package email;

import entity.User;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author burak
 */
public class EmailSendJUnitTest {

    private User user;
    
    @Before
    public void setUp() {
        user = new User();
        user.setEmail("example@gmail.com");
        user.setMailOnayUrl("Onay URL");
    }

    @Test
    public void test() {
        Assert.assertEquals(EmailSend.sendMail(user), true);
    }

    @After
    public void tearDown() {
        user = null;
    }
}
