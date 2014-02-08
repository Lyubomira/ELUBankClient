
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JComponent;

/**
 *
 * @author Elena Koevska
 */
public class BackgroundImage extends JComponent {

    private final Image img;

    public BackgroundImage(Image img) {
        this.img = img;
    }

    @Override
    public void paintComponent(Graphics g) {

        g.drawImage(img, 0, 0, null);

    }
}
