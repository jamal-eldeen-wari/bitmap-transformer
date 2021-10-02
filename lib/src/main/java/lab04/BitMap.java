package lab04;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.Color;

public class BitMap {
    private BufferedImage image;
    private String fileInput, fileOutput, process;
    public static final int FLIP_VERTICAL = 1;
    public static final int FLIP_HORIZONTAL = -1;
// we are going to read a file from the constructor;
    public BitMap(String fileInput, String fileOutput, String process) throws IOException {
        this.fileInput = fileInput;
        this.fileOutput = fileOutput;
        this.process = process;

        File file1 = new File(fileInput);
        this.image = ImageIO.read(file1);
    }

    public void write(String fileNameToWriteTo) throws IOException {
//        we are going to write the new image once it changed;
        File f = new File(fileNameToWriteTo);
        ImageIO.write(this.image, "bmp", f);
    }

    public void convertToGrayScale() {
//        Because we are dealing with rectangle image that has width and height.
        for (int i = 0; i < this.image.getWidth(); i++){
            for( int j = 0; j < this.image.getHeight(); j++){
                //getting RGB color for the image;
                Color c = new Color(this.image.getRGB(i, j));
                int red = c.getRed();
                int green = c.getGreen();
                int blue = c.getBlue();
                int alpha = c.getAlpha();
//                getting the grayscale color we need to find the avg of grayScale
                int gr = (red + green + blue) / 3;

                //create gray color
                Color grayColor = new Color (gr, gr, gr, alpha);
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

    public void negativeImage() {
        for (int i = 0; i < this.image.getWidth(); i++){
            for( int j= 0; j < this.image.getHeight(); j++){
                Color color = new Color(this.image.getRGB(i, j), true);
                color = new Color(255 - color.getRed(), 255 - color.getGreen(), 255 - color.getBlue());
                this.image.setRGB(i, j, color.getRGB());
            }
        }
    }

    public void blackAndWhite(){
        try {

            File input = new File("\\\\wsl$\\Ubuntu\\home\\jamal\\301\\401\\bitmap-transformer\\resources\\cEdDG.png");
            BufferedImage image = ImageIO.read(input);

            BufferedImage result = new BufferedImage(
                    image.getWidth(),
                    image.getHeight(),
                    BufferedImage.TYPE_BYTE_BINARY);

            Graphics2D graphic = result.createGraphics();
            graphic.drawImage(image, 0, 0, Color.WHITE, null);
            graphic.dispose();

            File output = new File("\\\\wsl$\\Ubuntu\\home\\jamal\\301\\401\\bitmap-transformer\\resources\\cEdDGOut.png");
            ImageIO.write(result, "png", output);

        }  catch (IOException e) {
            e.printStackTrace();
        }
    }



}
