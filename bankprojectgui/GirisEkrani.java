package bankprojectgui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;


public class GirisEkrani {

	private JFrame frame;
	private DosyaIslemleri dosya = new DosyaIslemleri();
	private JPasswordField passwordFieldSifre;
	public JTextField textFieldHesapNo;
	private List<Hesap> liste = new ArrayList<Hesap>();
	private JPasswordField passwordFieldYoneticiSifre;
	private int index;
			
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GirisEkrani window = new GirisEkrani();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public GirisEkrani() throws IOException, ClassNotFoundException
	{
		initialize();
		dosya.olustur();
		liste = dosya.dosyadanOku();
	}
	
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 600, 480);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblGiriYntemiSeiniz = new JLabel("Giris Yontemi Seciniz");
		lblGiriYntemiSeiniz.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblGiriYntemiSeiniz.setForeground(Color.BLACK);
		lblGiriYntemiSeiniz.setBounds(329, 20, 163, 38);
		frame.getContentPane().add(lblGiriYntemiSeiniz);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 0));
		panel.setBounds(0, 0, 234, 440);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblIcon = new JLabel("");
		lblIcon.setIcon(new ImageIcon(getClass().getResource("/images/logo.png")));
		lblIcon.setBounds(16, -12, 300, 441);
		panel.add(lblIcon);
		
		passwordFieldSifre = new JPasswordField();
		passwordFieldSifre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		passwordFieldSifre.setBounds(260, 279, 301, 38);
		frame.getContentPane().add(passwordFieldSifre);
		
		textFieldHesapNo = new JTextField();
		textFieldHesapNo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textFieldHesapNo.setBounds(260, 187, 301, 38);
		frame.getContentPane().add(textFieldHesapNo);
		textFieldHesapNo.setColumns(10);
		
		JLabel lblYoneticiSifre = new JLabel("Sifre");
		lblYoneticiSifre.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblYoneticiSifre.setBounds(260, 190, 103, 28);
		frame.getContentPane().add(lblYoneticiSifre);
		lblYoneticiSifre.setVisible(false);
		
		passwordFieldYoneticiSifre = new JPasswordField();
		passwordFieldYoneticiSifre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		passwordFieldYoneticiSifre.setBounds(260, 229, 301, 38);
		frame.getContentPane().add(passwordFieldYoneticiSifre);
		passwordFieldYoneticiSifre.setVisible(false);
		
		JLabel lblKontrol = new JLabel("Kontrol");
		lblKontrol.setForeground(Color.RED);
		lblKontrol.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lblKontrol.setBounds(278, 396, 283, 27);
		frame.getContentPane().add(lblKontrol);
		lblKontrol.setVisible(false);
		
		JButton btnYoneticiGiris = new JButton("Giris");
		btnYoneticiGiris.setBackground(Color.LIGHT_GRAY);
		btnYoneticiGiris.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				if(passwordFieldYoneticiSifre.equals(""))
				{
					lblKontrol.setText("Lütfen Şifreyi Giriniz");
					lblKontrol.setVisible(true);
				}
				
				else if(Integer.parseInt(passwordFieldYoneticiSifre.getText()) == 1)
				{
					Yonetici yonetici;
					try {
						yonetici = new Yonetici();
						yonetici.setVisible(true);
					} catch (ClassNotFoundException | IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					frame.dispose();
				}
				
				else
				{
					lblKontrol.setText("Girdiğiniz Bilgileri Kontrol Ediniz");
					lblKontrol.setVisible(true);
				}
			}
		});
		btnYoneticiGiris.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnYoneticiGiris.setBounds(340, 328, 124, 38);
		frame.getContentPane().add(btnYoneticiGiris);
		btnYoneticiGiris.setVisible(false);
		
		JLabel lblHesapNo = new JLabel("Hesap No");
		lblHesapNo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblHesapNo.setBounds(260, 148, 103, 28);
		frame.getContentPane().add(lblHesapNo);
		
		JLabel lblSifre = new JLabel("Sifre");
		lblSifre.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSifre.setBounds(260, 240, 103, 28);
		frame.getContentPane().add(lblSifre);
		
		JButton btnGiris = new JButton("Giris");
		btnGiris.setBackground(Color.LIGHT_GRAY);
		btnGiris.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				for(int i = 0; i < liste.size(); i++)
				{
					if(textFieldHesapNo.getText().equals("") && passwordFieldSifre.getText().equals(""))
					{
						lblKontrol.setText("Lütfen Hesap No ve Şifrenizi Giriniz");
						lblKontrol.setVisible(true);
					}
					
					else if(Integer.parseInt(textFieldHesapNo.getText()) == liste.get(i).getHesapNo() && Integer.parseInt(passwordFieldSifre.getText()) == liste.get(i).getSifre())
					{
						try {
							index = i;
							Musteri asd = new Musteri(index);
							
						} catch (ClassNotFoundException | IOException e) {
							e.printStackTrace();
						}
						frame.setVisible(false);
					}
					
					else
					{
						lblKontrol.setText("Girdiğiniz Bilgileri Kontrol Ediniz!");
						lblKontrol.setVisible(true);
					}
				}
			}
		});
		btnGiris.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnGiris.setBounds(340, 346, 124, 38);
		frame.getContentPane().add(btnGiris);
		
		JButton btnMusteriGirisi = new JButton("Musteri Girisi");
		btnMusteriGirisi.setHorizontalAlignment(SwingConstants.LEFT);
		btnMusteriGirisi.setIcon(new ImageIcon(getClass().getResource("/images/user.png")));
		btnMusteriGirisi.setForeground(new Color(255, 255, 255));
		btnMusteriGirisi.setBackground(new Color(205, 133, 63));
		btnMusteriGirisi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				btnYoneticiGiris.setVisible(false);
				lblYoneticiSifre.setVisible(false);
				passwordFieldYoneticiSifre.setVisible(false);
				
				btnGiris.setVisible(true);
				lblHesapNo.setVisible(true);
				textFieldHesapNo.setVisible(true);
				
				lblSifre.setVisible(true);
				passwordFieldSifre.setVisible(true);
			}
		});
		btnMusteriGirisi.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnMusteriGirisi.setBounds(235, 70, 163, 48);
		frame.getContentPane().add(btnMusteriGirisi);
		
		JButton btnYoneticiGirisi = new JButton("Yonetici Girisi");
		btnYoneticiGirisi.setHorizontalAlignment(SwingConstants.LEFT);
		btnYoneticiGirisi.setIcon(new ImageIcon(getClass().getResource("/images/adin.png")));
		btnYoneticiGirisi.setForeground(new Color(255, 255, 255));
		btnYoneticiGirisi.setBackground(new Color(205, 133, 63));
		btnYoneticiGirisi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				btnYoneticiGiris.setVisible(true);
				lblYoneticiSifre.setVisible(true);
				passwordFieldYoneticiSifre.setVisible(true);
				
				btnGiris.setVisible(false);
				lblHesapNo.setVisible(false);
				textFieldHesapNo.setVisible(false);
				
				lblSifre.setVisible(false);
				passwordFieldSifre.setVisible(false);
				
			}
		});
		btnYoneticiGirisi.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnYoneticiGirisi.setBounds(410, 70, 168, 48);
		frame.getContentPane().add(btnYoneticiGirisi);
	}
	
	public void ekranGoster()
	{
		frame.setVisible(true);
	}
}
