import com.example.Cat;
import com.example.Feline;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import java.util.List;
import static org.junit.Assert.assertEquals;

public class CatTest {

    @Mock
    Feline felineMock;

    @Before
    public void setUp() {
        // Инициализация моков
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void checkCatSoundTest(){
        String expectedSound = "Мяу";
        Cat cat = new Cat(felineMock);
        assertEquals(cat.getSound(), expectedSound);
    }

    @Test
    public void checkCatCorrectFoodListTest() throws Exception {
        List<String> expectedFoodList = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(felineMock.eatMeat()).thenReturn(expectedFoodList);
        Cat cat = new Cat(felineMock);
        assertEquals(cat.getFood(), expectedFoodList);
    }
}
