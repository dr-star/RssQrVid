import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.qrcode.QRCodeWriter;
import com.sun.jna.Native;
import com.sun.jna.NativeLibrary;

import uk.co.caprica.vlcj.binding.LibVlc;
import uk.co.caprica.vlcj.component.EmbeddedMediaPlayerComponent;
import uk.co.caprica.vlcj.player.MediaPlayer;
import uk.co.caprica.vlcj.player.MediaPlayerFactory;
import uk.co.caprica.vlcj.player.embedded.EmbeddedMediaPlayer;
import uk.co.caprica.vlcj.player.embedded.videosurface.CanvasVideoSurface;
import uk.co.caprica.vlcj.player.embedded.windows.Win32FullScreenStrategy;
import uk.co.caprica.vlcj.runtime.RuntimeUtil;

import java.awt.Frame;
import java.awt.Image;
import java.awt.Rectangle;




public class gui_main {

	int timeRun = 0;
	private JFrame frame;
	Font fnt = new Font("TimesRoman",Font.PLAIN, 19);
	Font fnt_title = new Font("TimesRoman",Font.BOLD, 25);
	static JTextArea TA_bio = new JTextArea("");
	static JLabel lbl_t = new JLabel("");
	static JLabel lbl_img = new JLabel("");
	static JLabel lbl_img2 = new JLabel("");
	private EmbeddedMediaPlayerComponent vidComp;
	static ImagePanel panel_ld;
	static JPanel panel_ls = new JPanel();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		System.out.println("entrato");
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gui_main window = new gui_main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public void restart() 
	{
		
	}	
	
	
	
	
	public void p_bot(ImagePanel p) //Pannello inferiore
	{
		JLabel lblNuovaCircolare = new JLabel("Circolari:");
		lblNuovaCircolare.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNuovaCircolare.setBounds(27, 20, 357, 60);
		lblNuovaCircolare.setIcon(new ImageIcon("albolbl.png"));
		p.add(lblNuovaCircolare);
		
		l_qr(p);
		l_ti(p);
	}
	public void l_qr(ImagePanel p) //Label img qr
	{
		JLabel[] im = new JLabel[4];
		String[] n_img = reg.idlist();
		int d = 75;	
		for (int a=0;a<4;a++) 
		{
			ImageIcon qrcode = new ImageIcon(n_img[a]+".jpg");
			im[a] = new JLabel("");
			im[a].setBounds(d, 125, 250, 250);
			im[a].setIcon(qrcode);
			im[a].setOpaque(true);
			p.add(im[a]);
			d=d+300;
		}
	}
	public void l_ti(ImagePanel p) //Label titoli circolari
	{
		JLabel[] lb = new JLabel[4];
		Font ft =  (new Font("Tahoma", Font.BOLD, 18));
		int d = 75;	
		for (int s=0;s<4;s++) 
		{
			lb[s] = new JLabel(scrappyrss.titolo(s));
			lb[s].setFont(ft);
			lb[s].setBounds(d, 90, 250, 41);
			p.add(lb[s]);
			d=d+300;
		}
	}
	public void top_pan() //to define
	{
	
		
		
		
	}
	public void dd(ImagePanel pnl_top) //Label data
	{

		Calendar data = new GregorianCalendar();
		Font ft = (new Font("Tahoma", Font.PLAIN, 20));
		int giorno = data.get(Calendar.DAY_OF_MONTH);
		int mese = data.get(Calendar.MONTH) + 1;
		int anno = data.get(Calendar.YEAR);
		
		JLabel Date = new JLabel(giorno+"/"+mese+"/"+anno);
		Date.setBackground(new Color(255, 255, 255));
		Date.setForeground(new Color(0, 0, 0));
		Date.setFont(ft);
		Date.setBounds(10, 2, 110, 29);
		pnl_top.add(Date);
		
		JLabel Clocks = new JLabel("00:00");
		Clocks.setForeground(new Color(0, 0, 0));
		Clocks.setBounds(138, 2, 86, 29);
		Clocks.setFont(ft);
		pnl_top.add(Clocks);
		
		
		
		new Thread(){
			
			public void run()
			{
				
				while (timeRun==0)
				{
					Calendar cal = new GregorianCalendar();
					
					int hour =  cal.get(Calendar.HOUR_OF_DAY);
					int min =  cal.get(Calendar.MINUTE);
				//	int sec =  cal.get(Calendar.SECOND);
				
					String time = (hour+":"+min);
					Clocks.setText(time);
				}
			}
			
		}.start();
	}
	public void right_pan(ImagePanel panel_ld2)  //Pannello di destra(creazione)
	{
		TA_bio.setBackground(new Color(0, 0, 0, 0));
		TA_bio.setBounds(10, 109, 318, 250);//		TA_bio.setBounds(312, 132, 558, 408);
		TA_bio.setEditable(false);
		TA_bio.setFocusable(false);
		TA_bio.setHighlighter(null);
		TA_bio.setFont(fnt);
		//TA_bio.setBackground(new Color(0,0,0,0));
		panel_ld2.add(TA_bio);
		lbl_t.setBackground(Color.WHITE);
		
		lbl_t.setBounds(400, 25, 200, 50);//(312, 13, 558, 106);
		lbl_t.setFont(fnt_title);

		panel_ld2.add(lbl_t);
		
		lbl_img.setBounds(338, 360, 292, 200);//(49, 115, 210, 200);
		//allineare centro
		panel_ld2.add(lbl_img);	
	}
	public static void right_pan(String p) //Pannello di destra aggiornamento componenti
	{
		TA_bio.setVisible(false);
		lbl_t.setVisible(false);
		//lbl_img.setVisible(false);

		lbl_img.setBounds(0,0,900,600);
		lbl_img.setIcon(img_rsz(p,lbl_img));
		//lbl_img2.setBounds(900,600,200,200);//panel_ld.getX(),panel_ld.getY()
		//lbl_img2.setIcon(img_rsz(p));
		//panel_ld.add(lbl_img2);

	}
	public static void right_pan(String t,String bio,String p) //Pannello di destra aggiornamento componenti
	{
		//TA_bio.removeAll();
		//TA_bio.validate();
		//TA_bio.setVisible(true);
		//lbl_t.setVisible(true);
		//lbl_img.setVisible(true);

		lbl_t.setText(t);
		TA_bio.setText(bio);//
		
		/*try 
		{
		    img = ImageIO.read(new File(p));
		} 
		catch (IOException e) 
		{
			System.out.println("Errore, immagine non selezionata");
			e.printStackTrace();
		}
		//https://stackoverflow.com/questions/16343098/resize-a-picture-to-fit-a-jlabel
		java.awt.Image dimg = img.getScaledInstance(lbl_img.getWidth(), lbl_img.getHeight(),java.awt.Image.SCALE_SMOOTH);
		ImageIcon imageIcon = new ImageIcon(dimg);*/
		//System.out.println(img_rsz(p));
		lbl_img.setIcon(img_rsz(p,lbl_img));
		SwingUtilities.updateComponentTreeUI(panel_ld);

	}	
	
	public static Icon img_rsz(String p,JLabel l)//img_rsz(String p)
	{		
		BufferedImage img = null;

		try 
		{
		    img = ImageIO.read(new File(p));
		} 
		catch (IOException e) 
		{
			System.out.println("Errore, immagine non selezionata");
			e.printStackTrace();
		}
//		java.awt.Image dimg = img.getScaledInstance(lbl_img.getWidth(), lbl_img.getHeight(),java.awt.Image.SCALE_SMOOTH);
		java.awt.Image dimg = img.getScaledInstance(l.getWidth(), l.getHeight(),java.awt.Image.SCALE_SMOOTH);

		ImageIcon imageIcon = new ImageIcon(dimg);
		return imageIcon;
	}
	
	
	/**
	 * Create the application.
	 */
	public gui_main() 
	{
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		

		File a = new File("back.png");
		BufferedImage myImage = null;
		try {
			myImage = ImageIO.read(a);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JFrame myJFrame = new JFrame("Image pane");
		myJFrame.setContentPane(new ImagePanel(myImage));
		frame = new JFrame();
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		frame.setUndecorated(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setBackground(new Color(224, 255, 255));
		frame.setContentPane(new ImagePanel(myImage));
		
		
		
		JButton btnOpt = new JButton();		
		btnOpt.setBounds(10, 7, 43, 31);
		btnOpt.setIcon(new ImageIcon("stn.png"));
		btnOpt.setBackground(new Color(0, 0, 0,0));
		btnOpt.setContentAreaFilled(false);
		btnOpt.setFocusPainted(false);
		btnOpt.setBorderPainted(false);
		btnOpt.addActionListener(new ActionListener() 
		{public void actionPerformed(ActionEvent arg0) {Sett.main(null);}});

		frame.add(btnOpt);
		//////////////////
		
		
		
		frame.getContentPane().setLayout(null);
		//###############################
		//PANNELLO SOTTO
		//###############################
		
		File f = new File("rt_c.png");
		File fz = new File("qrzoom.png");
		BufferedImage bkg_pnl_st = null;
		BufferedImage zoom = null;
		JLabel bigqr = new JLabel();
		bigqr.setBounds(71, 6, 350, 350);
		bigqr.setIcon(img_rsz("qritis.png", bigqr));
		try {
			bkg_pnl_st = ImageIO.read(f);
			zoom = ImageIO.read(fz);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ImagePanel pnl_st = new ImagePanel(bkg_pnl_st);
		ImagePanel pnl_zoom = new ImagePanel(zoom);
		pnl_st.setBounds(44, 668, 1832, 392);
		pnl_zoom.setBounds(1300,15, 493, 362);
		frame.add(pnl_st);	
		p_bot(pnl_st);		   //Creaiamo tutto cio' che andra' nel pannello (pnl_st) [descritta sopra la funzione]
		pnl_st.add(pnl_zoom); //Aggiungiamo il pannello che conterra' il qr piu' grande
		pnl_zoom.add(bigqr);	//Aggiungiamo il qr della scuola

		//###############################
		//PANNELLO SUPERIORE--------------------------------------------------------------
		//###############################
		File ft = new File("tempo.png");
		BufferedImage bkg_pnl_top = null;
		try {
			bkg_pnl_top = ImageIO.read(ft);
		} catch (IOException e) {
			e.printStackTrace();
		}
		ImagePanel pnl_top = new ImagePanel(bkg_pnl_top);
		pnl_top.setBounds(1662, 0, 208, 39);
		pnl_top.setLayout(null);
		
		frame.getContentPane().add(pnl_top);
		dd(pnl_top);
		//###############################
		//PANNELLO LDESTRO--------------------------------------------------------------
		//###############################

				
		File fn = new File("news_bkg.png");
		BufferedImage bkg_pnl_ld = null;
		try {
			bkg_pnl_ld = ImageIO.read(fn);
		} catch (IOException e) {
			e.printStackTrace();
		}
		panel_ld = new ImagePanel(bkg_pnl_ld);
		panel_ld.setBackground(new Color(0,0,0,0));
		panel_ld.setBounds(960, 50, 912,612);
		panel_ld.setLayout(null);
		JLabel news = new JLabel();
		news.setBounds(30,25,162,35);
		news.setIcon(img_rsz("news.png", news));
		panel_ld.add(news);
		right_pan(panel_ld);
		frame.getContentPane().add(panel_ld);
		
		//PANNELLO LSINISTRO-------------------------------------------------------------
		File fv = new File("news_bkg.png");
		BufferedImage bkg_pnl_ls = null;
		try {
			bkg_pnl_ls = ImageIO.read(fn);
		} catch (IOException e) {
			e.printStackTrace();
		}
		ImagePanel panel_ls = new ImagePanel(bkg_pnl_ls);
		panel_ls.setBounds(44, 50, 912, 612);
		frame.getContentPane().add(panel_ls);
		
		//Media.md(frame, panel_ls);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				Media.md(frame, panel_ls);
				SwingUtilities.updateComponentTreeUI(frame);

			}
		});
		panel_ls.add(btnNewButton);
		
		
		/*
		JTextArea ta = new JTextArea();
		ta.setBounds(1233, 219, 1000,1000);
		ta.setText("TASDASDASDASDASDASDASDASDASDSADASDASDDASD");
		ta.setVisible(true);
		ta.setBackground(new Color(0,0,0));
		//frame.getContentPane().add(ta);
		panel_ld.add(ta);*//*
		File ia = new File("358033.jpg");
		Image asd = null;
		try {
			Image i = ImageIO.read(ia);
			Color col = Color.WHITE;
			asd = Transparency.makeColorTransparent(i,new Color(0).WHITE);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		ImageIcon imi = new ImageIcon(asd);

		lbl_t.setIcon(imi);*/

		
		//right_pan(panel_ld);
		
		}
}




/*
https://stackoverflow.com/questions/6791767/make-a-bunch-of-jlabel-s-invisible
http://www.math.uni-hamburg.de/doc/java/tutorial/post1.0/converting/deprecatedAWT.html
https://stackoverflow.com/questions/2479058/how-to-make-a-boolean-variable-switch-between-true-and-false-every-time-a-method
https://stackoverflow.com/questions/11050074/how-to-check-if-radiobutton-is-checked
https://stackoverflow.com/questions/16343098/resize-a-picture-to-fit-a-jlabel/16345968#16345968

*/