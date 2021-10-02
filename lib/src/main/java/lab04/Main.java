package lab04;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        File input = new File("\\\\wsl$\\Ubuntu\\home\\jamal\\301\\401\\bitmap-transformer\\resources\\bitmap.bmp");
        File output = new File("\\\\wsl$\\Ubuntu\\home\\jamal\\301\\401\\bitmap-transformer\\resources\\bitmapOut.bmp");

        String inputFile ="\\\\wsl$\\Ubuntu\\home\\jamal\\301\\401\\bitmap-transformer\\resources\\bitmap.bmp";
        String outputFile = "\\\\wsl$\\Ubuntu\\home\\jamal\\301\\401\\bitmap-transformer\\resources\\bitmap.bmp";

        String processGray = "Gray Scale";
        String processNeg = "Negative Image";
        String processBAW = "Black and White";



        BitMap bitMapG = new BitMap(inputFile,outputFile,processGray);
        BitMap bitMapNeg = new BitMap(inputFile,outputFile,processNeg);
        BitMap bitMapBAW = new BitMap(inputFile,outputFile,processBAW);

        bitMapG.convertToGrayScale();
        bitMapNeg.negativeImage();
        bitMapBAW.blackAndWhite();
        BitMap.flipVerOrHori(input,output,BitMap.FLIP_VERTICAL);
    }

}



