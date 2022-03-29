package tn.esprit;

import java.awt.image.BufferedImage;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

public class QRCodeGenerator {
	public static BufferedImage generateQRcode(String UrlText)throws Exception {
		QRCodeWriter qrCodeWriter=new QRCodeWriter();
		BitMatrix bitMatrix=qrCodeWriter.encode(UrlText, BarcodeFormat.QR_CODE, 200, 200);
		return MatrixToImageWriter.toBufferedImage(bitMatrix);
	}
}
