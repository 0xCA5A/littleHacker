import java.awt.Color;

public class RgbColorStrategy implements ColorStrategy {
    @Override
    public Color getColorByChar(char code) {
        switch (code % 3) {
            case 0: return Color.RED;
            case 1: return Color.GREEN;
            case 2: return Color.BLUE;
            default: return Color.BLACK;
        }
    }
}
