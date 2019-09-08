import javax.validation.constraints.Digits;
import javax.validation.constraints.Pattern;

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
        LengthDTO lengthDTO = RandomObject.random(LengthDTO.class);
        Assert.assertTrue(lengthDTO.getTest().length() <= 10);
    }

    @Test
    public void shouldGeneratePattern() throws Exception {
        PatternDTO patternDTO = RandomObject.random(PatternDTO.class);
        Assert.assertTrue(java.util.regex.Pattern.matches("\\d{10}", patternDTO.getTest()));

    }

    @Test
    public void shouldGenerateDigits() throws Exception {
        DigitsDTO digitsDTO = RandomObject.random(DigitsDTO.class);
        Assert.assertTrue(java.util.regex.Pattern.matches("\\d{1,10}\\.\\d{1,10}", digitsDTO.getTest()));

    }

    @NoArgsConstructor
    @AllArgsConstructor
    @Data
    @Builder
    public static class LengthDTO {
        @Length(max = 10, message = "字段长度不能超过10")
        private String test;
    }

    @NoArgsConstructor
    @AllArgsConstructor
    @Data
    @Builder
    public static class PatternDTO {
        @Pattern(regexp = "\\d{10}")
        private String test;
    }

    @NoArgsConstructor
    @AllArgsConstructor
    @Data
    @Builder
    public static class DigitsDTO {
        @Digits(integer = 10, fraction = 10)
        private String test;
    }
}