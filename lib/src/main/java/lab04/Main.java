package lab04;

import javax.swing.*;
import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("hi");
        BitMap bitMap = new BitMap();

        File input = new File("C:\\Users\\jamal\\Desktop\\willi.bmp");
        File output = new File("C:\\Users\\jamal\\Desktop\\willi1.bmp");

        Library.flipVerOrHori(input,output,Library.FLIP_VERTICAL);
        bitMap.convertToGrayScale();


    }


}
