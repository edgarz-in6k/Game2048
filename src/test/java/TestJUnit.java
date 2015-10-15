import com.game.GameField;
import org.junit.Assert;
import org.junit.Test;

public class TestJUnit {
    @Test
    public void testing(){
        GameField gameField = new GameField(4);
        int[] arr = gameField.getArrayField();
        int n = 0;
        for (int i : arr){
            if (i == 2 || i == 4)
                n++;
        }
        Assert.assertEquals(2, n);

        for (int i = 0; i < 14; i++) {
            gameField.fillEntryCell();
        }
        arr = gameField.getArrayField();
        n = 0;
        for (int i : arr){
            if (i == 2 || i == 4)
                n++;
        }
        Assert.assertEquals(16, n);
    }
}