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
			File f = new File(System.getProperty("user.dir")+"/img/qr_large/"+img_n[run]+".jpg");
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
			BufferedImage crop = ImageIO.read(f);//
			//crop = crop.getSubimage(31, 31, crop.getWidth() -2*50,crop.getHeight() -2*50);//
			crop = crop.getSubimage(32, 32, 186,186);//

			File outp = new File(System.getProperty("user.dir")+"/img/qr/"+img_n[run]+".jpg");
			ImageIO.write(crop, "jpg", outp);
			File del = new File(f.getAbsolutePath());
			del.delete();
			System.out.println(del.exists());
		}
		
	}
}
/*
https://stackoverflow.com/questions/12674064/how-to-save-a-bufferedimage-as-a-file

*/
