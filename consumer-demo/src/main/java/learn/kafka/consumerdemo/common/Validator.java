package learn.kafka.consumerdemo.common;

import org.springframework.util.Assert;

public final class Validator {

    private Validator() {
    }

    //TODO: Add Validation Aspect
    public static void validate(ValidationAware validationAware, Object... objects) {
        validationAware.validate();
        for (Object o : objects) {
            Assert.notNull(o, () -> "Params cannot be null");
        }
    }
}
