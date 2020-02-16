package bankprojectgui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Yonetici extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldEkleIsim;
	private JTextField textFieldEkleSoyIsim;
	private JTextField textFieldEkleHesapNo;
	private JPasswordField passwordFieldEkleSifre;
	private JLabel lblSilIsim;
	private JTextField textFieldSilIsim;
	private JLabel lblSilSoyIsim;
	private JTextField textFieldSilSoyIsim;
	private JLabel lblSilHesapNo;
	private JTextField textFieldSilHesapNo;
	private JLabel lblSilSifre;
	private JPasswordField passwordFieldSilSifre;
	private JButton btnIslem;
	private JButton btnGeri;

	private DosyaIslemleri dosya = new DosyaIslemleri();
	private List<Hesap> liste = new ArrayList<Hesap>();
	
	
	public Yonetici() throws ClassNotFoundException, IOException {
		liste = dosya.dosyadanOku();
		
		setTitle("Yonetici Ekranı");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 475);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblEkleIsim = new JLabel("\u0130sim");
		lblEkleIsim.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEkleIsim.setBounds(16, 56, 129, 20);
		contentPane.add(lblEkleIsim);

		textFieldEkleIsim = new JTextField();
		textFieldEkleIsim.setBounds(16, 87, 165, 20);
		contentPane.add(textFieldEkleIsim);
		textFieldEkleIsim.setColumns(10);

		JLabel lblEkleSoyisim = new JLabel("Soyisim");
		lblEkleSoyisim.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEkleSoyisim.setBounds(16, 118, 129, 20);
		contentPane.add(lblEkleSoyisim);

		textFieldEkleSoyIsim = new JTextField();
		textFieldEkleSoyIsim.setColumns(10);
		textFieldEkleSoyIsim.setBounds(16, 149, 165, 20);
		contentPane.add(textFieldEkleSoyIsim);

		JLabel lblEkleHesapNo = new JLabel("Hesap No");
		lblEkleHesapNo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEkleHesapNo.setBounds(16, 180, 129, 20);
		contentPane.add(lblEkleHesapNo);

		textFieldEkleHesapNo = new JTextField();
		textFieldEkleHesapNo.setColumns(10);
		textFieldEkleHesapNo.setBounds(16, 211, 165, 20);
		contentPane.add(textFieldEkleHesapNo);

		JLabel lblEkleSifre = new JLabel("\u015Eifre");
		lblEkleSifre.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEkleSifre.setBounds(16, 242, 129, 20);
		contentPane.add(lblEkleSifre);

		passwordFieldEkleSifre = new JPasswordField();
		passwordFieldEkleSifre.setBounds(16, 273, 165, 20);
		contentPane.add(passwordFieldEkleSifre);

		lblSilIsim = new JLabel("\u0130sim");
		lblSilIsim.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSilIsim.setBounds(268, 56, 129, 20);
		contentPane.add(lblSilIsim);

		textFieldSilIsim = new JTextField();
		textFieldSilIsim.setColumns(10);
		textFieldSilIsim.setBounds(268, 87, 165, 20);
		contentPane.add(textFieldSilIsim);

		lblSilSoyIsim = new JLabel("Soyisim");
		lblSilSoyIsim.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSilSoyIsim.setBounds(268, 118, 129, 20);
		contentPane.add(lblSilSoyIsim);

		textFieldSilSoyIsim = new JTextField();
		textFieldSilSoyIsim.setColumns(10);
		textFieldSilSoyIsim.setBounds(268, 149, 165, 20);
		contentPane.add(textFieldSilSoyIsim);

		lblSilHesapNo = new JLabel("Hesap No");
		lblSilHesapNo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSilHesapNo.setBounds(268, 180, 129, 20);
		contentPane.add(lblSilHesapNo);

		textFieldSilHesapNo = new JTextField();
		textFieldSilHesapNo.setColumns(10);
		textFieldSilHesapNo.setBounds(268, 211, 165, 20);
		contentPane.add(textFieldSilHesapNo);

		lblSilSifre = new JLabel("\u015Eifre");
		lblSilSifre.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSilSifre.setBounds(268, 242, 129, 20);
		contentPane.add(lblSilSifre);

		passwordFieldSilSifre = new JPasswordField();
		passwordFieldSilSifre.setBounds(268, 273, 165, 20);
		contentPane.add(passwordFieldSilSifre);
		
		JLabel lblKontrol = new JLabel("Kontrol");
		lblKontrol.setForeground(Color.RED);
		lblKontrol.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblKontrol.setBounds(135, 382, 217, 23);
		contentPane.add(lblKontrol);
		lblKontrol.setVisible(false);

		btnIslem = new JButton("\u0130\u015Flem");
		btnIslem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(textFieldEkleIsim.isEnabled())
				{
					try {
						musteriEkle(textFieldEkleIsim.getText(), textFieldEkleSoyIsim.getText(), Integer.parseInt(textFieldEkleHesapNo.getText()), Integer.parseInt(passwordFieldEkleSifre.getText()));
					} catch (NumberFormatException | IOException e) {
						e.printStackTrace();
					} finally {
						lblKontrol.setText("Kullanıcı başarıyla eklenmiştir");
						lblKontrol.setVisible(true);
					}
				}
				
				if(textFieldSilIsim.isEnabled())
				{
					try {
						musteriSil(textFieldSilIsim.getText(), textFieldSilSoyIsim.getText(), Integer.parseInt(textFieldSilHesapNo.getText()), Integer.parseInt(passwordFieldSilSifre.getText()));
					} catch (NumberFormatException | ClassNotFoundException | IOException e) {
						e.printStackTrace();
					}finally {
						lblKontrol.setText("Kullanıcı başarıyla silinmiştir");
						lblKontrol.setVisible(true);
					}
				}
			}
		});
		btnIslem.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnIslem.setBounds(52, 304, 108, 46);
		contentPane.add(btnIslem);
		
		textFieldSilIsim.disable();
		textFieldSilSoyIsim.disable();
		textFieldSilHesapNo.disable();
		passwordFieldSilSifre.disable();
		
		JButton btnEkle = new JButton("Ekle");
		btnEkle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				textFieldEkleIsim.enable();
				textFieldEkleSoyIsim.enable();
				textFieldEkleHesapNo.enable();
				passwordFieldEkleSifre.enable();
				
				textFieldSilIsim.disable();
				textFieldSilSoyIsim.disable();
				textFieldSilHesapNo.disable();
				passwordFieldSilSifre.disable();
			}
		});
		btnEkle.setBackground(new Color(192, 192, 192));
		btnEkle.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnEkle.setBounds(56, 11, 89, 23);
		contentPane.add(btnEkle);
		
		JButton btnSil = new JButton("Sil");
		btnSil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				textFieldEkleIsim.disable();
				textFieldEkleSoyIsim.disable();
				textFieldEkleHesapNo.disable();
				passwordFieldEkleSifre.disable();
				
				textFieldSilIsim.enable();
				textFieldSilSoyIsim.enable();
				textFieldSilHesapNo.enable();
				passwordFieldSilSifre.enable();
			}
		});
		btnSil.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnSil.setBounds(308, 13, 89, 23);
		contentPane.add(btnSil);

		btnGeri = new JButton("Geri");
		btnGeri.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				GirisEkrani grs;
				try {
					grs = new GirisEkrani();
					grs.ekranGoster();
				} catch (ClassNotFoundException | IOException e) {
					e.printStackTrace();
				}
			}
		});
		btnGeri.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnGeri.setBounds(289, 304, 108, 46);
		contentPane.add(btnGeri);
		
		

	}
	
	public void musteriEkle(String isim, String soyIsim, int hesapNo, int sifre) throws IOException
	{
		Hesap musteri = new Hesap();
		musteri.setIsim(isim);
		musteri.setSoyIsim(soyIsim);
		musteri.setHesapNo(hesapNo);
		musteri.setSifre(sifre);
		
		musteri.setAdres("Erzurum");
		musteri.setBakiye(0);
		musteri.setTcKimlikNo("11111111111");
		
		liste.add(musteri);
		dosya.dosyayaYaz(liste);
		
	}
	
	public void musteriSil(String isim, String soyIsim, int hesapNo, int sifre) throws IOException, ClassNotFoundException
	{
		for(int i = 0; i < liste.size(); i++)
		{
			if(liste.get(i).getIsim().equals(isim))
			{
				liste.remove(i);
			}
		}
		dosya.dosyayaYaz(liste);
	}
}
