import com.example.Feline;
import org.junit.Test;
import java.util.List;
import static org.junit.Assert.assertEquals;

public class FelineTest {

    @Test
    public void checkFelineKittensNumberTest(){
        Feline feline = new Feline();
        int expectedNumberKittens = 1;
        assertEquals(feline.getKittens(), expectedNumberKittens);
    }

    @Test
    public void checkFelineFamilyTest(){
        Feline feline = new Feline();
        String expectedFamily = "Кошачьи";
        assertEquals(feline.getFamily(), expectedFamily);
    }

    @Test
    public void checkFelineCorrectFoodListTest() throws Exception {
        Feline feline = new Feline();
        List<String> expectedFoodList = List.of("Животные", "Птицы", "Рыба");
        assertEquals(feline.eatMeat(), expectedFoodList);
    }
}
