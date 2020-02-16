package bankprojectgui;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextArea;

public class Hesap  implements Serializable{

	private static final long serialVersionUID = 4769652639441999422L;
	private String isim;
	private String soyIsim;
	private String tcKimlikNo;
	private int hesapNo;
	private String adres;
	private double bakiye;
	private int sifre;
	private List<String> ozet = new ArrayList<String>();
	
	public boolean Havale(Hesap hesap, double miktar)
	{
		hesap.bakiye += miktar;
		if(bakiye > miktar)
		{
			bakiye -= miktar;
			OzetEkle(hesap.hesapNo + " numaralı hesaba " + miktar + " TL havale edildi.");
			hesap.OzetEkle(hesapNo + " numaralı hesaptan " + miktar + " TL havale geldi.");
			return true;
		}
		return false;
	}
	
	public void paraYatir(double miktar)
	{
		bakiye += miktar;
		OzetEkle(miktar + " TL Para yatırıldı.");
	}
	
	public boolean paraCek(double miktar)
	{
		if(bakiye < miktar)
		{
			return false;
		}
		else
		{
			bakiye -= miktar;
			OzetEkle(miktar + " TL Para çekildi.");
		}
		return true;
	}
	
	public void Guncelle(String adres, String tcKimlikNo, int sifre)
	{
		this.adres = adres;
		this.tcKimlikNo = tcKimlikNo;
		this.sifre = sifre;
	}
	
	public List<String> getOzet() {
		return ozet;
	}

	public void OzetEkle(String s) {
		ozet.add(s);
		if(ozet.size() > 8)
		{
			ozet.remove(0);
		}
	}

	
	public String getIsim() {
		return isim;
	}
	
	public void setIsim(String isim) {
		this.isim = isim;
	}
	
	public String getSoyIsim() {
		return soyIsim;
	}
	
	public void setSoyIsim(String soyIsim) {
		this.soyIsim = soyIsim;
	}
	
	public String getTcKimlikNo() {
		return tcKimlikNo;
	}
	
	public void setTcKimlikNo(String tcKimlikNo) {
		this.tcKimlikNo = tcKimlikNo;
	}
	
	public int getHesapNo() {
		return hesapNo;
	}
	
	public void setHesapNo(int hesapNo) {
		this.hesapNo = hesapNo;
	}
	
	public String getAdres() {
		return adres;
	}
	
	public void setAdres(String adres) {
		this.adres = adres;
	}
	
	public double getBakiye() {
		return bakiye;
	}
	
	public void setBakiye(double bakiye) {
		this.bakiye = bakiye;
	}
	
	public int getSifre() {
		return sifre;
	}
	
	public void setSifre(int sifre) {
		this.sifre = sifre;
	}
}
	

	