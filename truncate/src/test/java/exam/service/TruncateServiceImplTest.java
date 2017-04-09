package exam.service;

import org.junit.Assert;
import org.junit.Test;


public class TruncateServiceImplTest {

    private TruncateService service = new TruncateServiceImpl();

    @Test
    public void truncateTest() throws Exception {

        Assert.assertEquals("12 ... (truncated) ... 90", service.truncate("123456789012345678901234567890", 25));
        Assert.assertEquals("1234567890", service.truncate("1234567890", 25));
        Assert.assertEquals("123456789012345678901234567890", service.truncate("123456789012345678901234567890", 31));

    }

}
