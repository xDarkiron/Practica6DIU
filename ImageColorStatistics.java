package pck_practica6;

/**
 *
 * @author Airam
 * @author Gioele
 * 
 */
import java.awt.Dimension;
import java.awt.Point;
import java.util.ArrayList;
import org.opencv.core.Core;
import static org.opencv.core.Core.mean;
import static org.opencv.core.Core.minMaxLoc;
import static org.opencv.core.Core.split;
import org.opencv.core.Mat;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;

public class ImageColorStatistics {
    public final int RED = 2;
    public final int GREEN = 1;
    public final int BLUE = 0;

    private final int[] components = {RED, GREEN, BLUE};

    private int[] maximum = new int[3];
    private int[] minimum = new int[3];
    private int[] average = new int[3];

    public int[] getMaximum() {
        return maximum;
    }

    public int[] getMinimum() {
        return minimum;
    }

    public int[] getAverage() {
        return average;
    }

    public void getColorStatistics(Mat imagenColor, Point esqSupIzda,
            Dimension dimVista) {

        // crea la subimagen correspondiente al viewport
        Mat subimagen = new Mat(imagenColor, new Rect(esqSupIzda.x, esqSupIzda.y,
                dimVista.width, dimVista.height));

        // separa los tres canales de la subimagen BGR
        ArrayList<Mat> bgr = new ArrayList<>();
        split(subimagen, bgr);

        // estadisticas 
        ImageColorStatistics res = new ImageColorStatistics();

        for (int c : res.components) {
            // obtiene el máximo y mínimo del canal c de la subimagen
            Core.MinMaxLocResult minmax = minMaxLoc(bgr.get(c));
            // calcula el premodio del canal c de la subimagen
            Scalar prom_scalar = mean(bgr.get(c));

            this.maximum[c] = (int) minmax.maxVal;
            this.minimum[c] = (int) minmax.minVal;
            this.average[c] = (int) prom_scalar.val[0];
        }
    }
}
