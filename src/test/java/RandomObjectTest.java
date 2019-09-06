import org.hibernate.validator.constraints.Length;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author yanming
 * @date 2019-09-06 23:20
 */
public class RandomObjectTest {

    @Before
    public void setUp() throws Exception {}

    @After
    public void tearDown() throws Exception {}

    @Test
    public void shouldGenerateTestLimitLength() throws Exception {
        TestDTO testDTO = RandomObject.random(TestDTO.class);
        Assert.assertTrue(testDTO.getTest().length() <= 10);
    }

    @NoArgsConstructor
    @AllArgsConstructor
    @Data
    @Builder
    public static class TestDTO {
        @Length(max = 10, message = "字段长度不能超过10")
        String test;
    }
}