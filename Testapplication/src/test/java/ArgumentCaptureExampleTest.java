
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.MockitoAnnotations;

public class ArgumentCaptureExampleTest {

    @Test
    public void test(){
        // Create a mock of the OtherClass
        OtherClass other = mock(OtherClass.class);

        // Run the foo method with the mock
        new ArgumentCaptureExample().foo(other);

        // Capture the argument of the doSomething function
        ArgumentCaptor<SomeData> captor = ArgumentCaptor.forClass(SomeData.class);
        verify(other, times(1)).doSomething(captor.capture());

        // Assert the argument
        SomeData actual = captor.getValue();
        assertEquals("Some inner data", actual.innerData);
    }
}
