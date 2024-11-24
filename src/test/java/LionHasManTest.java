import com.example.Feline;
import com.example.Lion;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class LionHasManTest {

    @Mock
    Feline felineMock;

    private final String sex;
    private final Boolean hasManExpected;

    public LionHasManTest(String sex, Boolean hasManExpected){
        this.sex = sex;
        this.hasManExpected = hasManExpected;
    }

    @Parameterized.Parameters
    public static Object[][] getSumData() {
        return new Object[][] {
                // параметры:
                { "Самец", true },
                { "Самка", false },
        };
    }

    @Before
    public void setUp() {
        // Инициализация моков
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void ifManeCorrectLionTest() throws Exception {
        Lion lion = new Lion(felineMock, sex);
        assertEquals(lion.doesHaveMane(), hasManExpected);
    }
}
