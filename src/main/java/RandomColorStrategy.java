import java.awt.Color;
import java.util.Random;

public class RandomColorStrategy implements ColorStrategy {
    @Override
    public Color getColorByChar(char code) {
        final Random random = new Random();
        final int red = random.nextInt(255);
        final int green = random.nextInt(255);
        final int blue = random.nextInt(255);
        return new Color(red, green, blue);
    }
}
