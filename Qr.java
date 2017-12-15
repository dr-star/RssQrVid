import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import net.glxn.qrgen.QRCode;
import net.glxn.qrgen.image.ImageType;
public class Qr  {

	public static void GenerateQR() 
	{
		String details[] = reg.lastlink();
		String[] img_n = reg.idlist();
		System.out.println("Inizia ciclo per creazione QR");
		
		for (int run = 0; run <= 3; run++) 
		{
			System.out.println("QR:"+details[run]);
			ByteArrayOutputStream out = QRCode.from(details[run]).withSize(250, 250).to(ImageType.JPG).stream();
			
			File f = new File(System.getProperty("user.dir")+"\\"+img_n[run]+".jpg");
			FileOutputStream fos;
			try 
			{
				fos = new FileOutputStream(f);
				fos.write(out.toByteArray());
				fos.flush();
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
		}
		
	}
}