package lk.himash.util;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import lk.himash.dto.QRInfo;

import java.awt.image.BufferedImage;
import java.io.IOException;

public class GenerateQRCode {

    public BufferedImage generateQRCode(QRInfo qrInfo, int width, int height) throws Exception {

        try {
            return generateQRCodeImage(qrInfo.getDoc(), width, height);
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Exception found");
        }
    }

    private BufferedImage generateQRCodeImage(String text, int width, int height) throws WriterException, IOException {
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, width, height);

        BufferedImage qrImage = MatrixToImageWriter.toBufferedImage(bitMatrix);

//        BufferedImage logoImage = ImageIO.read(Objects.requireNonNull(getClass().getResource("/p.PNG")));
//        int deltaHeight = qrImage.getHeight() - logoImage.getHeight();
//        int deltaWidth = qrImage.getWidth() - logoImage.getWidth();
//        BufferedImage combined = new BufferedImage(qrImage.getHeight(), qrImage.getWidth(), BufferedImage.TYPE_INT_ARGB);
//        Graphics2D g = (Graphics2D) combined.getGraphics();
//        g.drawImage(qrImage, 0, 0, null);
//        g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));
//        g.drawImage(logoImage, (int) Math.round(deltaWidth / 2), (int) Math.round(deltaHeight / 2), null);

        return qrImage;
    }


}
