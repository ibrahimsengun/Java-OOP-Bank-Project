package bankprojectgui;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class DosyaIslemleri {
	
	private List<Hesap> liste = new ArrayList<Hesap>();
	File f = new File("Kullanıcılar.ser");

	public void olustur() throws IOException
	{
		if(f.exists())
			;

		else
		{
			FileOutputStream fos;

			fos = new FileOutputStream(f);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.reset();

			Hesap nesne1 = new Hesap();
			nesne1.setIsim("İbrahim");
			nesne1.setSoyIsim("Şengün");
			nesne1.setTcKimlikNo("12345678901");
			nesne1.setHesapNo(1);
			nesne1.setAdres("Malatya");
			nesne1.setBakiye(100);
			nesne1.setSifre(1);

			oos.writeObject(nesne1);
			
			Hesap nesne2 = new Hesap();
			nesne2.setIsim("Muhammed");
			nesne2.setSoyIsim("Bayat");
			nesne2.setTcKimlikNo("12345678910");
			nesne2.setHesapNo(2);
			nesne2.setAdres("Malatya");
			nesne2.setBakiye(1000);
			nesne2.setSifre(2);

			oos.writeObject(nesne2);	

			fos.close();
			oos.close();
		}
	}

	public List<Hesap> dosyadanOku() throws IOException, ClassNotFoundException
	{
		FileInputStream fis;
		fis = new FileInputStream(f);
		ObjectInputStream ois = new ObjectInputStream(fis);
		
		while(fis.available()>0)
		{
			liste.add((Hesap) ois.readObject());
		}
		ois.close();
		return liste;
	}

	public void dosyayaYaz(List<Hesap> gelenListe) throws IOException
	{
		FileOutputStream fos;
		fos = new FileOutputStream(f);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		for(int i = 0; i < gelenListe.size(); i++)
		{
			oos.writeObject(gelenListe.get(i));
		}
		
		fos.close();
		oos.close();
	}
	
}
