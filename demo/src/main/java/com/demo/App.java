package com.demo;

import com.itextpdf.kernel.pdf.*;
import com.itextpdf.kernel.pdf.xobject.PdfFormXObject;
import com.itextpdf.layout.Canvas;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Image;
import com.itextpdf.kernel.geom.Rectangle;
import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;

public class App {
    static void cropImage(String imageName, String pdfName, int positionX, int positionY, int width, int height) {
        try {
            PdfDocument pdf = new PdfDocument(
                    new PdfWriter(System.getProperty("user.dir") + "/src/main/resources/output/" + pdfName + ".pdf"));
            Document document = new Document(pdf);
            Image image = new Image(ImageDataFactory
                    .create(System.getProperty("user.dir") + "/src/main/resources/" + imageName + ".jpg"));
            image.setFixedPosition(100, 100);
            Rectangle rectangle = new Rectangle(300, 300);
            PdfFormXObject template = new PdfFormXObject(rectangle);
            Canvas canvas = new Canvas(template, pdf);
            canvas.add(image);
            Image croppedImage = new Image(template);
            document.add(croppedImage);
            document.close();
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public static void main(String[] args) {
        System.err.println(args.length);
        System.err.println(args[2]);
        // cropImage(args[0], args[1], Integer.from(args[2]), Integer.from(args[3]));
    }
}
