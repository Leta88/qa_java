import com.example.Feline;
import com.example.Lion;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import java.util.List;
import static org.junit.Assert.assertEquals;

public class LionTest {
    @Mock
    Feline felineMock;

    @Before
    public void setUp() {
        // Инициализация моков
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void checKittensNumberLionTest() throws Exception {
        String sex = "Самец";
        int actualNumberKittens = 1;
        Mockito.when(felineMock.getKittens()).thenReturn(actualNumberKittens);
        Lion lion = new Lion(felineMock, sex);
        assertEquals(lion.getKittens(), actualNumberKittens);
    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void checkTextLionCreationException() throws Exception {

        thrown.expect(Exception.class);
        thrown.expectMessage("Используйте допустимые значения пола животного - самец или самка");
        String wrongSex = "Инопланетянин";

        Lion lion = new Lion(felineMock, wrongSex);
    }

    @Test
    public void checkCorrectFoodListLionTest() throws Exception {
        String sex = "Самец";
        List<String> expectedFoodList = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(felineMock.getFood("Хищник")).thenReturn(expectedFoodList);
        Lion lion = new Lion(felineMock, sex);
        assertEquals(lion.getFood(), expectedFoodList);
    }
}
