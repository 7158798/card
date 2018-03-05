package com.rw.finance.common.utils;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Hashtable;

/**
 * 二维码工具类
 *
 * @author huanghongfei
 * @file QrCodeUtils.java
 * @date 2018年1月18日 下午4:10:56
 * @declaration
 */
public class QrCodeUtils {

    //    private static final int BLACK = 0xFF000000;
//    private static final int WHITE = 0xFFFFFFFF;
    private static final int margin = 1;               // 白边大小，取值范围0~4
    private static final ErrorCorrectionLevel level = ErrorCorrectionLevel.H;  // 二维码容错率

    private QrCodeUtils() {
    }

    private static void writeToFile(BufferedImage image, String format, File file) throws IOException {
        if (!ImageIO.write(image, format, file)) {
            throw new IOException("Could not write an image of format " + format + " to " + file);
        }
    }

    /**
     * 创建二维码
     *
     * @param text 文本
     */
    public static BufferedImage createQrCode(String text, String mobile) throws Exception {
        BufferedImage image = createQrCode(text, 530, 520);
        if (image != null) {
            File bgFile=new File(File.listRoots()[0]+"/data/file/static/img/bg.jpg");
            File iconFile=new File(File.listRoots()[0]+"/data/file/static/img/icon-50@2x.png");
            insertImage(image,iconFile);
            return mergeShareImage(image, bgFile, mobile);
        } else {
            throw new IOException("create QR Code Error");
        }
    }

    /**
     * 分享图片与二维码合成
     *
     * @param qrImage 二维码
     * @param bgFile  背景图
     * @param text    文本内容
     * @throws IOException Exception
     */
    private static BufferedImage mergeShareImage(BufferedImage qrImage, File bgFile, String text) throws IOException {
        BufferedImage bgBufferImage = ImageIO.read(bgFile);
        BufferedImage combined = new BufferedImage(bgBufferImage.getWidth(), bgBufferImage.getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics graphics = combined.getGraphics();
        graphics.drawImage(bgBufferImage, 0, 0, null);
        graphics.drawImage(qrImage, 650, 1215, null);

        graphics.setColor(new Color(228, 117, 120));
        graphics.setFont(new Font(null, Font.BOLD, 35)); //字体、字型、字号
        graphics.drawString(text, 660, 2050); //画文字
        graphics.dispose();
        return combined;
    }

    private static BufferedImage createQrCode(String text, int width, int height) {
        Hashtable<EncodeHintType, Object> hints = new Hashtable<>();
        hints.put(EncodeHintType.ERROR_CORRECTION, level);
        hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
        hints.put(EncodeHintType.MARGIN, margin);
        BitMatrix bitMatrix;
        try {
            bitMatrix = new MultiFormatWriter().encode(text, BarcodeFormat.QR_CODE, width, height, hints);
            BufferedImage image = new BufferedImage(bitMatrix.getWidth(), bitMatrix.getHeight(), BufferedImage.TYPE_INT_RGB);
            for (int x = 0; x < width; x++) {
                for (int y = 0; y < height; y++) {
                    image.setRGB(x, y, bitMatrix.get(x, y) ? 0x000000 : 0xFFFFFF);
                }
            }
            return image;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @param source  二维码
     * @param imgPath logo的路径
     */
    private static void insertImage(BufferedImage source, File imgPath) throws Exception {
        Image src = ImageIO.read(imgPath);
        int width = src.getWidth(null);
        int height = src.getHeight(null);
        int x = source.getWidth() / 2 - width / 2;
        int y = source.getHeight() / 2 - height / 2;
        Graphics2D graph = source.createGraphics();
        graph.drawImage(src, x, y, width, height, null);
        Shape shape = new RoundRectangle2D.Float(x, y, width, height, 5, 5);
        graph.setStroke(new BasicStroke(2f));
        graph.draw(shape);
        graph.dispose();
    }

    /**
     * 给jpg添加文字
     *
     * @param image            图片
     * @param markContent      文字内容
     * @param markContentColor 文字颜色
     */
    /*public static void createStringMark(BufferedImage image, String markContent, Color markContentColor) {
        ImageIcon imgIcon = new ImageIcon(image);
        Image theImg = imgIcon.getImage();
        int width = theImg.getWidth(null) == -1 ? 200 : theImg.getWidth(null);
        int height = theImg.getHeight(null) == -1 ? 200 : theImg.getHeight(null);
        BufferedImage bufferImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = bufferImage.createGraphics();
        g.setColor(markContentColor);
        g.setBackground(Color.red);
        g.drawImage(theImg, 0, 0, null);
        g.setFont(new Font(null, Font.BOLD, 15)); //字体、字型、字号
        g.drawString(markContent, 11, height / 2); //画文字
        g.dispose();
    }*/
}
