package lk.himash;

import lk.himash.dto.QRInfo;
import lk.himash.util.Config;
import lk.himash.util.GenerateQRCode;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

@SpringBootTest
class ProjectApplicationTests {

	@Test
	void contextLoads() throws Exception {
		GenerateQRCode generateQRCode = new GenerateQRCode();
		BufferedImage bi = generateQRCode.generateQRCode(QRInfo.builder()
				.doc(Config.DOC_01)
				.build(), 200, 200);

		try {
			String fileName = "qr".concat(LocalDateTime.now().toString().replaceAll(":","")).concat(".png");
			ImageIO.write(bi, "png", new File(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
