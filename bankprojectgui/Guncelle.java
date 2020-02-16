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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Guncelle extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldAdres;
	private JTextField textFieldTcKimlikNo;
	private JPasswordField passwordFieldSifre;
	private DosyaIslemleri dosya = new DosyaIslemleri();
	private List<Hesap> liste = new ArrayList<Hesap>();
	private Hesap hesap = new Hesap();
	private GirisEkrani girisEkrani = new GirisEkrani();
	private int index;


	public Guncelle(int index) throws ClassNotFoundException, IOException {
		this.index = index;
		liste = dosya.dosyadanOku();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 350, 350);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAdres = new JLabel("Adres: ");
		lblAdres.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAdres.setBounds(25, 11, 80, 40);
		contentPane.add(lblAdres);
		
		JLabel lblTcKimlikNo = new JLabel("TC Kimlik No:");
		lblTcKimlikNo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTcKimlikNo.setBounds(25, 71, 121, 40);
		contentPane.add(lblTcKimlikNo);
		
		JLabel lblSifre = new JLabel("\u015Eifre:");
		lblSifre.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSifre.setBounds(25, 131, 80, 40);
		contentPane.add(lblSifre);
		
		JLabel lblBilgi = new JLabel("Bilgi");
		lblBilgi.setForeground(Color.RED);
		lblBilgi.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblBilgi.setBounds(25, 211, 283, 27);
		contentPane.add(lblBilgi);
		lblBilgi.setVisible(false);
		
		textFieldAdres = new JTextField();
		textFieldAdres.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textFieldAdres.setBounds(156, 15, 150, 32);
		contentPane.add(textFieldAdres);
		textFieldAdres.setColumns(10);
		
		textFieldTcKimlikNo = new JTextField();
		textFieldTcKimlikNo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textFieldTcKimlikNo.setColumns(10);
		textFieldTcKimlikNo.setBounds(156, 75, 150, 32);
		contentPane.add(textFieldTcKimlikNo);
		
		passwordFieldSifre = new JPasswordField();
		passwordFieldSifre.setFont(new Font("Tahoma", Font.PLAIN, 15));
		passwordFieldSifre.setBounds(156, 135, 150, 32);
		contentPane.add(passwordFieldSifre);
		
		JButton btnGuncelle = new JButton("G\u00FCncelle");
		btnGuncelle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(textFieldAdres.getText().equals("") && textFieldTcKimlikNo.getText().equals("") && passwordFieldSifre.getText().equals(""))
				{
					lblBilgi.setText("Lütfen bilgilerinizi giriniz.");
					lblBilgi.setVisible(true);
				}
				else
				{
					liste.get(index).Guncelle(textFieldAdres.getText(), textFieldTcKimlikNo.getText(), Integer.parseInt(passwordFieldSifre.getText()));
					lblBilgi.setText("Bilgilerinizi başarıyla güncellendi.");
					lblBilgi.setVisible(true);
					try {
						dosya.dosyayaYaz(liste);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
		btnGuncelle.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnGuncelle.setBackground(Color.LIGHT_GRAY);
		btnGuncelle.setBounds(25, 268, 121, 32);
		contentPane.add(btnGuncelle);
		
		JButton btnGeri = new JButton("Geri");
		btnGeri.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				try {
					Musteri musteriEkrani = new Musteri(index);
				} catch (ClassNotFoundException | NullPointerException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnGeri.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnGeri.setBackground(Color.LIGHT_GRAY);
		btnGeri.setBounds(185, 268, 121, 32);
		contentPane.add(btnGeri);
		
		
	}
}
