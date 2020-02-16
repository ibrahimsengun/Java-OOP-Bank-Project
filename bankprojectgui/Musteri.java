package bankprojectgui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Musteri {

	private JFrame frame;
	private JTextArea textAreaEkran;
	private List<Hesap> liste = new ArrayList<Hesap>();
	private List<String> ozet = new ArrayList<String>();
	private DosyaIslemleri dosya = new DosyaIslemleri();
	private JTextField textFieldParaYatir;
	private JTextField textFieldParaCek;
	private JTextField textFieldHavale;
	private JTextField textFieldHavale2;
	private int index;
	

	public Musteri(int index) throws ClassNotFoundException, IOException, NullPointerException {
		this.index = index;
		initialize();
		frame.setVisible(true);
		liste = dosya.dosyadanOku();
		ekranaYazdir();
	}
	
	private void initialize() {

		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 570, 480);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		panel.setBounds(0, 0, 126, 441);
		frame.getContentPane().add(panel);
		
		JButton btnGuncelle = new JButton("Guncelle");
		btnGuncelle.setBackground(Color.WHITE);
		btnGuncelle.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnGuncelle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				try {
					Guncelle guncelleEkrani = new Guncelle(index);
					guncelleEkrani.setVisible(true);
				} catch (ClassNotFoundException | IOException e) {
					e.printStackTrace();
				}
				frame.setVisible(false);
			}
		});
		panel.setLayout(null);
		btnGuncelle.setBounds(10, 322, 94, 41);
		panel.add(btnGuncelle);
		
		textFieldParaYatir = new JTextField();
		textFieldParaYatir.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textFieldParaYatir.setBounds(136, 271, 408, 31);
		frame.getContentPane().add(textFieldParaYatir);
		textFieldParaYatir.setColumns(10);
		textFieldParaYatir.setVisible(false);
		
		textFieldParaCek = new JTextField();
		textFieldParaCek.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textFieldParaCek.setColumns(10);
		textFieldParaCek.setBounds(136, 271, 408, 31);
		frame.getContentPane().add(textFieldParaCek);
		textFieldParaCek.setVisible(false);
		
		textFieldHavale = new JTextField();
		textFieldHavale.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textFieldHavale.setColumns(10);
		textFieldHavale.setBounds(136, 271, 408, 31);
		frame.getContentPane().add(textFieldHavale);
		textFieldHavale.setVisible(false);
		
		textFieldHavale2 = new JTextField();
		textFieldHavale2.setBounds(136, 353, 408, 31);
		frame.getContentPane().add(textFieldHavale2);
		textFieldHavale2.setColumns(10);
		textFieldHavale2.setVisible(false);
		
		JLabel lblHvl = new JLabel("Label");
		lblHvl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblHvl.setBounds(136, 312, 408, 31);
		frame.getContentPane().add(lblHvl);
		lblHvl.setVisible(false);
		
		JLabel lblBilgiYazisi = new JLabel("Label");
		lblBilgiYazisi.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblBilgiYazisi.setBounds(136, 230, 408, 31);
		frame.getContentPane().add(lblBilgiYazisi);
		lblBilgiYazisi.setVisible(false);
		
		JButton btnParaCek = new JButton("Para Cek");
		btnParaCek.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblBilgiYazisi.setVisible(true);
				lblBilgiYazisi.setText("Çekilecek tutarı giriniz.");
				textFieldParaCek.setVisible(true);
				textFieldHavale.setVisible(false);
				textFieldHavale2.setVisible(false);
				textFieldParaYatir.setVisible(false);
				lblHvl.setVisible(false);
			}
		});
		btnParaCek.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnParaCek.setBounds(10, 82, 94, 41);
		panel.add(btnParaCek);
		btnParaCek.setBackground(Color.WHITE);
		
		JButton btnParaYatir = new JButton("Para Yatir");
		btnParaYatir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				lblBilgiYazisi.setVisible(true);
				lblBilgiYazisi.setText("Yatırılacak tutarı giriniz.");
				textFieldParaYatir.setVisible(true);
				textFieldParaCek.setVisible(false);
				textFieldHavale.setVisible(false);
				textFieldHavale2.setVisible(false);
				lblHvl.setVisible(false);
			}
		});
		btnParaYatir.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnParaYatir.setBounds(10, 10, 94, 41);
		panel.add(btnParaYatir);
		btnParaYatir.setBackground(Color.WHITE);
		
		JButton btnHavale = new JButton("Havale");
		btnHavale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				
				
				lblBilgiYazisi.setVisible(true);
				lblBilgiYazisi.setText("Havale edilecek tutarı giriniz.");
				textFieldParaCek.setVisible(false);
				textFieldHavale.setVisible(true);
				textFieldHavale2.setVisible(true);
				textFieldParaYatir.setVisible(false);
				lblHvl.setText("Havale edilecek hesabı giriniz.");
				lblHvl.setVisible(true);
			}
		});
		btnHavale.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnHavale.setBounds(10, 163, 94, 41);
		panel.add(btnHavale);
		btnHavale.setBackground(Color.WHITE);
		
		JButton btnOzet = new JButton("Ozet");
		btnOzet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String metin = "";
				ozet = liste.get(index).getOzet();
				for(int i = 0; i < ozet.size(); i++)
				{
					metin += ozet.get(i) + "\n";
					textAreaEkran.setText(metin);
				}
			}
		});
		btnOzet.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnOzet.setBounds(10, 241, 94, 41);
		panel.add(btnOzet);
		btnOzet.setBackground(Color.WHITE);
		
		textAreaEkran = new JTextArea();
		textAreaEkran.setForeground(Color.BLACK);
		textAreaEkran.setLineWrap(true);
		textAreaEkran.setBackground(Color.WHITE);
		textAreaEkran.setFont(new Font("Monospaced", Font.PLAIN, 15));
		textAreaEkran.setBounds(136, 10, 408, 210);
		frame.getContentPane().add(textAreaEkran);
		
		JButton btnGeri = new JButton("Geri");
		btnGeri.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
				try {
					GirisEkrani grs = new GirisEkrani();
					grs.ekranGoster();
				} catch (ClassNotFoundException | IOException e) {
					e.printStackTrace();
				}
			}
		});
		btnGeri.setBounds(479, 400, 65, 29);
		frame.getContentPane().add(btnGeri);
		btnGeri.setBackground(Color.WHITE);
		
		JButton btnIslem = new JButton("\u0130\u015Flem");
		btnIslem.setBackground(Color.WHITE);
		btnIslem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(textFieldParaYatir.isVisible())
				{
					if(textFieldParaYatir.getText().equals(""))
					{
						lblBilgiYazisi.setText("Lütfen miktarı giriniz.");
					}
					
					else if(Integer.parseInt(textFieldParaYatir.getText()) <= 0)
					{
						lblBilgiYazisi.setText("Lütfen 0'dan büyük bir sayı giriniz.");
						textFieldParaYatir.setText("");
					}
					
					else
					{
						liste.get(index).paraYatir(Integer.parseInt(textFieldParaYatir.getText()));
						lblBilgiYazisi.setText("İşlem Başarılı!");
						textFieldParaYatir.setText("");
					}
				}
				
				if(textFieldParaCek.isVisible())
				{
					if(textFieldParaCek.getText().equals(""))
					{
						lblBilgiYazisi.setText("Lütfen miktarı giriniz.");
					}
					
					else if(Integer.parseInt(textFieldParaCek.getText()) <= 0)
					{
						lblBilgiYazisi.setText("Lütfen 0'dan büyük bir sayı giriniz.");
						textFieldParaCek.setText("");
					}
					else
					{
						if(liste.get(index).paraCek(Integer.parseInt(textFieldParaCek.getText())) == true)
						{
							lblBilgiYazisi.setText("İşlem Başarılı!");
							textFieldParaCek.setText("");
						}
						else {
							lblBilgiYazisi.setText("Yeterli paranız bulunmamaktadır.");
							textFieldParaCek.setText("");
						}
					}	
				}
				
				if(textFieldHavale.isVisible() && textFieldHavale2.isVisible())
				{
					if(textFieldHavale.getText().equals(""))
					{
						lblBilgiYazisi.setText("Lütfen miktarı giriniz.");
					}
					
					else if(Integer.parseInt(textFieldHavale.getText()) <= 0)
					{
						lblBilgiYazisi.setText("Lütfen 0'dan büyük bir sayı giriniz.");
						textFieldHavale.setText("");
						textFieldHavale2.setText("");
					}
					else
					{
						
						for(int i = 0; i < liste.size(); i++)
						{
							if(Integer.parseInt(textFieldHavale2.getText()) == liste.get(i).getHesapNo())
							{
								Hesap hesap = new Hesap();
								hesap = liste.get(i);
								
								if(liste.get(index).Havale(hesap, Integer.parseInt(textFieldHavale.getText())))
								{
									lblBilgiYazisi.setText("İşlem Başarılı.");
									textFieldHavale.setText("");
									textFieldHavale2.setText("");
								}
								else
								{
									lblBilgiYazisi.setText("Yeterli paranız bulunmamaktadır.");
									textFieldHavale.setText("");
									textFieldHavale2.setText("");
								}
							}
							else
							{
								lblBilgiYazisi.setText("Böyle bir hesap bulunamadı.");

							}
						}	
					}
				}
				
				try {
					dosya.dosyayaYaz(liste);
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				try {
					ekranaYazdir();
				} catch (ClassNotFoundException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnIslem.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnIslem.setBounds(136, 394, 114, 32);
		frame.getContentPane().add(btnIslem);
		
		JButton btnYenile = new JButton("Yenile");
		btnYenile.setBackground(Color.WHITE);
		btnYenile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					ekranaYazdir();
				} catch (ClassNotFoundException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnYenile.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnYenile.setBounds(260, 394, 114, 32);
		frame.getContentPane().add(btnYenile);
	}
	
	public void ekranaYazdir() throws ClassNotFoundException, IOException
	{
		String metin = new String();

		metin += "Hoşgeldiniz Sayın " + liste.get(index).getIsim() + " " + liste.get(index).getSoyIsim() + "\n" + "Hesap No: " + liste.get(index).getHesapNo() + "\n" + "TC Kimlik No: " + liste.get(index).getTcKimlikNo() + "\n" + "Adres: " + liste.get(index).getAdres() + "\n" + "Bakiye: " + liste.get(index).getBakiye() + " TL" + "\n\n";
		textAreaEkran.setText(metin);
	}
}
