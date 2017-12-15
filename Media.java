import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.sun.jna.Native;
import com.sun.jna.NativeLibrary;

import uk.co.caprica.vlcj.binding.LibVlc;
import uk.co.caprica.vlcj.player.MediaPlayerFactory;
import uk.co.caprica.vlcj.player.embedded.EmbeddedMediaPlayer;
import uk.co.caprica.vlcj.player.embedded.windows.Win32FullScreenStrategy;
import uk.co.caprica.vlcj.runtime.RuntimeUtil;

public class Media {
	static JPanel p = new JPanel();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*System.out.println("MAIN");
		
		JFrame f = new JFrame();
		f.setLocation(100, 100);
		f.setSize(1000, 600);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		
		
		Canvas c = new Canvas();
		c.setBackground(Color.black);
		//JPanel p = new JPanel();
		p.setLayout(new BorderLayout());
		
		p.add(c);
		f.add(p);
		String a = "C:\\Program Files\\VideoLAN\\VLC";
		 System.out.println(System.getProperty("VLC_PLUGIN_PATH"));
		NativeLibrary.addSearchPath(RuntimeUtil.getLibVlcLibraryName(), a);
		Native.loadLibrary(RuntimeUtil.getLibVlcLibraryName(), LibVlc.class);
		MediaPlayerFactory mpf = new MediaPlayerFactory();
		EmbeddedMediaPlayer emp = mpf.newEmbeddedMediaPlayer(new Win32FullScreenStrategy(f));
		emp.setVideoSurface(mpf.newVideoSurface(c));
		emp.setEnableKeyInputHandling(false);
		emp.setEnableKeyInputHandling(false);
		String file="vid.mp4";
		emp.prepareMedia(file);	
		emp.play();*/
	
	
	
	}
	public static void md(JFrame f, ImagePanel panel_ls) 
	{
/*	JFrame f = new JFrame();
	//	f.setLocation(100, 100);
		//f.setSize(1000, 600);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//f.setVisible(true);*/
		/*System.out.println("Entrato");
		p.removeAll();
		
		Canvas c = new Canvas();
		c.setBackground(Color.black);
		//JPanel p = new JPanel();
		p.setLayout(new BorderLayout());
		p.add(c);
		f.add(p);
		NativeLibrary.addSearchPath(RuntimeUtil.getLibVlcLibraryName(), "C:\\Program Files\\VideoLAN\\VLC");
		Native.loadLibrary(RuntimeUtil.getLibVlcLibraryName(), LibVlc.class);
		MediaPlayerFactory mpf = new MediaPlayerFactory();
		EmbeddedMediaPlayer emp = mpf.newEmbeddedMediaPlayer(new Win32FullScreenStrategy(f));
		emp.setVideoSurface(mpf.newVideoSurface(c));
		emp.setEnableKeyInputHandling(false);
		emp.setEnableKeyInputHandling(false);
		String file="vid.mp4";
		emp.prepareMedia(file);	
		emp.play();*/
		
		//return (Component) emp;
	}	
}