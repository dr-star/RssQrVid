import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JRadioButton;

public class Sett extends JFrame {

	private JPanel contentPane;
	private JTextField titleField;
	private JTextArea textArea;
	private JLabel lblTitolo;
	private JLabel lblDescrizione;
	private JLabel lblImmagine;
	static String rtn_value;
	static JFileChooser fc = new JFileChooser();
	private JButton img_ch2;
	static JRadioButton rd_btn = new JRadioButton("");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sett frame = new Sett();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Sett() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 985, 526);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		titleField= new JTextField();
		titleField.setBounds(130, 41, 402, 32);
		contentPane.add(titleField);
		titleField.setColumns(10);
		
		textArea = new JTextArea();
		textArea.setBounds(130, 86, 805, 250);
		contentPane.add(textArea);
		JButton btnNewButton = new JButton("Salva");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				if(rd_btn.isSelected()==true)
				{
					System.out.println("SOLO IMG");
					gui_main.right_pan(rtn_value);

				}
				else
				{								
					System.out.println(" IMG  e TESTO");

					gui_main.right_pan(titleField.getText().toString(), textArea.getText().toString(),rtn_value);
				}
				dispose();
			}
		});
		btnNewButton.setBounds(838, 440, 97, 25);
		contentPane.add(btnNewButton);
		
		lblTitolo = new JLabel("Titolo ");
		lblTitolo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTitolo.setBounds(12, 44, 66, 25);
		contentPane.add(lblTitolo);
		
		lblDescrizione = new JLabel("Descrizione");
		lblDescrizione.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDescrizione.setBounds(12, 187, 81, 25);
		contentPane.add(lblDescrizione);
		
		lblImmagine = new JLabel("Immagine");
		lblImmagine.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblImmagine.setBounds(12, 350, 66, 19);
		contentPane.add(lblImmagine);
		
		JButton img_ch1 = new JButton("Seleziona immagine");
		img_ch1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				//
				//JFileChooser fc = new JFileChooser();
				fc.showDialog(Sett.this, "Attach");
				rtn_value = fc.getSelectedFile().toString();
			}
		});
		img_ch1.setBounds(130, 348, 147, 25);
		contentPane.add(img_ch1);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(12, 382, 943, 9);
		contentPane.add(separator);
		
		JLabel lblTestoEImmagini = new JLabel("Testo e immagine");
		lblTestoEImmagini.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblTestoEImmagini.setBounds(12, 13, 182, 16);
		contentPane.add(lblTestoEImmagini);
		
		JLabel lblSoloImmagine = new JLabel("Solo immagine");
		lblSoloImmagine.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblSoloImmagine.setBounds(12, 404, 109, 16);
		contentPane.add(lblSoloImmagine);
		
		img_ch2 = new JButton("Seleziona immagine");
		img_ch2.setEnabled(false);
		img_ch2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				fc.showDialog(Sett.this, "Attach");
				rtn_value = fc.getSelectedFile().toString();
			}
		});
		img_ch2.setBounds(130, 440, 147, 25);
		contentPane.add(img_ch2);
		
		rd_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				img_ch2.setEnabled((rd_btn.isSelected()==true));
			}
		});
		rd_btn.setBounds(129, 396, 38, 25);
		contentPane.add(rd_btn);
		
		

	}
}
