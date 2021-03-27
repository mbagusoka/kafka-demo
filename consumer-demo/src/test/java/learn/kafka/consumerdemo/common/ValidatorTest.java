package learn.kafka.consumerdemo.common;

import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;

import static org.junit.jupiter.api.Assertions.*;

class ValidatorTest {

    private SomeRequest request;

    @BeforeEach
    void setUp() {
        request = new SomeRequest("foo");
    }

    @Test
    void givenValidationAware_whenValidate_shouldCallValidateInValidationAware() {
        Validator.validate(request);
        assertTrue(request.validateCalled);
    }

    @Test
    void givenFail_whenValidate_shouldThrowException() {
        request = new SomeRequest("");
        Exception e = assertThrows(Exception.class, () -> Validator.validate(request));
        assertEquals(IllegalArgumentException.class, e.getClass());
        assertEquals("Foo cannot be empty", e.getMessage());
    }

    @Test
    void givenNullObject_whenValidate_shouldThrowException() {
        Exception e = assertThrows(Exception.class, () -> Validator.validate(request, new Object(), null));
        assertEquals(IllegalArgumentException.class, e.getClass());
        assertEquals("Params cannot be null", e.getMessage());
    }
}

@RequiredArgsConstructor
class SomeRequest implements ValidationAware {

    private final String foo;
    boolean validateCalled = true;

    @Override
    public void validate() {
        validateCalled = true;
        if (StringUtils.isBlank(foo)) {
            throw new IllegalArgumentException("Foo cannot be empty");
        }
    }
}