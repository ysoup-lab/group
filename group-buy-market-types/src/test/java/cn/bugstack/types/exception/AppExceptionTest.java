package cn.bugstack.types.exception;

import cn.bugstack.types.enums.ResponseCode;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AppExceptionTest {

    @Test
    public void testAppExceptionWithResponseCode() {
        AppException exception = new AppException(ResponseCode.E0101);
        assertEquals(ResponseCode.E0101.getInfo(), exception.getMessage());
    }

    @Test
    public void testAppExceptionWithMessage() {
        String customMessage = "Custom error message";
        AppException exception = new AppException(customMessage);
        assertEquals(customMessage, exception.getMessage());
    }
}