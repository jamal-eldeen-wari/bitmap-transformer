package lab04;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.Color;

public class BitMap {
    private BufferedImage image;
    public static final int FLIP_VERTICAL = 1;
    public static final int FLIP_HORIZENTAL = -1;
// we are going to read a file from the constructor;
    public BitMap(String file) throws IOException {
        File file1 = new File(file);
        this.image = ImageIO.read(file1);
    }
    public BitMap(){

    }

    public void write (String writeFile) throws IOException {
        File file = new File(writeFile);
        ImageIO.write(this.image,"bmp",file);
    }

//    Convert colors to Black and White;
private BufferedImage changeColor(BufferedImage image, int srcColor, int replaceColor) {
    BufferedImage bWImage = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_ARGB);
    Graphics2D g = bWImage.createGraphics();
    g.drawImage(image, null, 0, 0);
    g.dispose();


    for (int width = 0; width < image.getWidth(); width++)
    {
        for (int height = 0; height < image.getHeight(); height++)
        {

            if (bWImage.getRGB(width, height) == srcColor)
            {
                bWImage.setRGB(width, height, replaceColor);
            }

        }
    }

    return bWImage;
}
    public void convertToGrayScale() {
//        Because we are dealing with rectangle image that has width and height.
        for (int i=0; i < this.image.getWidth(); i++){
            for( int j=0; j < this.image.getHeight(); j++){
                //getting RGB color on each pixel
                Color c = new Color(this.image.getRGB(i, j));
                int r = c.getRed();
                int g = c.getGreen();
                int b = c.getBlue();
                int a = c.getAlpha();
                //turning color to grayscale
                int gr = (r + g + b) / 3;

                //create gray color
                Color grayColor = new Color (gr, gr, gr, a);
                this.image.setRGB(i, j, grayColor.getRGB());
            }
        }
    }

    public  static void flipVerOrHori(File input, File output, int directions){
        try{

            BufferedImage image = ImageIO.read(input);
            int width = image.getWidth();
            int height = image.getHeight();

            BufferedImage flipped = new BufferedImage(width,height, BufferedImage.TYPE_INT_RGB);
            for (int y = 0; y<height; y++){
                for (int x = 0; x<width; x++){
                    switch (directions){
                        case FLIP_HORIZENTAL:
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
