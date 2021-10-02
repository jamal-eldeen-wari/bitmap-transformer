package lab04;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class ImageFlipping {
    public static final int FLIP_VERTICAL = 1;
    public static final int FLIP_HORIZONTAL = -1;

    public static void flipVerOrHori(File input, File output, int directions){
        try{

            BufferedImage image = ImageIO.read(input);
            int width = image.getWidth();
            int height = image.getHeight();

            BufferedImage flipped = new BufferedImage(width,height, BufferedImage.TYPE_INT_RGB);
            for (int y = 0; y<height; y++){
                for (int x = 0; x<width; x++){
                    switch (directions){
                        case FLIP_HORIZONTAL:
                            flipped.setRGB((width-1)-x,y,image.getRGB(x,y));
                            break;

                        case FLIP_VERTICAL:
                            flipped.setRGB(x,(height-1)-y,image.getRGB(x,y));
                            break;
                    }

                }
            }
            ImageIO.write(flipped, "bmp",output);

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
