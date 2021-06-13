/**********************************************************************
 *
 * Copyright (c) 2004 Olaf Willuhn
 * All rights reserved.
 * 
 * This software is copyrighted work licensed under the terms of the
 * Jameica License.  Please consult the file "LICENSE" for details. 
 *
 **********************************************************************/
package de.willuhn.jameica.hbci.rmi;

import java.rmi.RemoteException;
import java.util.Date;

import de.willuhn.datasource.rmi.DBIterator;

/**
 * Bildet eine Bankverbindung in HBCI ab.
 */
public interface Konto extends HibiscusDBObject, Checksum, Flaggable
{
  /**
   * Flag "kein Flag".
   */
  int FLAG_NONE    = 0;

  /**
   * Flag "Deaktiviert".
   */
  int FLAG_DISABLED = 1 << 0;

  /**
   * Flag "Offline".
   */
  int FLAG_OFFLINE = 1 << 1;

  /**
	 * Liefert die Kontonummer fuer diese Bankverbindung.
	 * 
	 * @return Kontonummer.
	 * @throws RemoteException
	 */
	String getKontonummer() throws RemoteException;
  
  /**
   * Liefert die Unterkonto-Nummer.
   * BUGZILLA 355
   * @return Unterkonto-Nummer.
   * @throws RemoteException
   */
  String getUnterkonto() throws RemoteException;

	/**
	 * Liefert die Bankleitzahl fuer diese Bankverbindung.
	 * 
	 * @return Bankleitzahl.
	 * @throws RemoteException
	 */
	String getBLZ() throws RemoteException;

	/**
	 * Liefert den Namen des Konto-Inhabers.
	 * 
	 * @return Name des Konto-Inhabers.
	 * @throws RemoteException
	 */
	String getName() throws RemoteException;

	/**
	 * Liefert eine ausfuehrliche Bezeichnung des Kontos bestehend aus
	 * Bezeichnung, Kto und BLZ.
	 * 
	 * @return ausfuehrliche Bezeichnung.
	 * @throws RemoteException
	 */
	String getLongName() throws RemoteException;

	/**
	 * Liefert die Bezeichnung des Kontos.
	 * 
	 * @return Bezeichnung des Kontos.
	 * @throws RemoteException
	 */
	String getBezeichnung() throws RemoteException;

	/**
	 * Liefert die Kundennummer bei der Bank.
	 * 
	 * @return Kundennummer.
	 * @throws RemoteException
	 */
	String getKundennummer() throws RemoteException;

	/**
	 * Liefert die Java-Klasse des zu verwendenden Passports. Dieser kann
	 * anschliessend mittels <code>PassportRegistry#findByClass(String)</code>
	 * geladen werden.
	 * 
	 * @return Java-Klasse des Passports.
	 * @throws RemoteException
	 */
	String getPassportClass() throws RemoteException;

  /**
   * Liefert die Java-Klasse des zu verwendenden Backends.
   * @return Java-Klasse des Backends.
   * @throws RemoteException
   */
  String getBackendClass() throws RemoteException;
  
  /**
   * Liefert die Kontoart. Kann NULL sein.
   * @return die Kontoart.
   * @throws RemoteException
   */
  Integer getAccountType() throws RemoteException;

	/**
	 * Liefert die Waehrungs-Bezeichnung der Bankverbindung.
	 * 
	 * @return Waehrungsbezeichnung.
	 * @throws RemoteException
	 */
	String getWaehrung() throws RemoteException;

	/**
	 * Speichert die Kontonummer der Bankverbindung.
	 * 
	 * @param kontonummer
	 *          Kontonummer.
	 * @throws RemoteException
	 */
	void setKontonummer(String kontonummer) throws RemoteException;

  /**
   * Speichert das Unterkonto.
   * @param unterkonto
   * @throws RemoteException
   */
  void setUnterkonto(String unterkonto) throws RemoteException;
  
	/**
	 * Speichert die Bankleitzahl der Bankverbindung.
	 * @param blz Bankleitzahl.
	 * @throws RemoteException
	 */
	void setBLZ(String blz) throws RemoteException;

	/**
	 * Speichert den Namen des Konto-Inhabers.
	 * @param name Name des Konto-Inhaber.s
	 * @throws RemoteException
	 */
	void setName(String name) throws RemoteException;

	/**
	 * Speichert die Bezeichnung des Kontos.
	 * @param bezeichnung Bezeichnung.
	 * @throws RemoteException
	 */
	void setBezeichnung(String bezeichnung) throws RemoteException;

	/**
	 * Speichert die Waehrungsbezeichnung.
	 * @param waehrung Bezeichnung.
	 * @throws RemoteException
	 */
	void setWaehrung(String waehrung) throws RemoteException;

	/**
	 * Speichert den Namen der Java-Klasse des zu verwendenden Passports.
	 * @param passport Passport.
	 * @throws RemoteException
	 */
	void setPassportClass(String passport) throws RemoteException;

  /**
   * Speichert die Java-Klasse des zu verwendenden Backends.
   * @param backend Java-Klasse des Backends.
   * @throws RemoteException
   */
  void setBackendClass(String backend) throws RemoteException;
  
  /**
   * Speichert die Kontoart. Kann NULL sein.
   * @param i die Kontoart.
   * @throws RemoteException
   */
  void setAccountType(Integer i) throws RemoteException;

	/**
	 * Speichert die Kundennummer.
	 * @param kundennummer Kundennummer.
	 * @throws RemoteException
	 */
	void setKundennummer(String kundennummer) throws RemoteException;

	/**
	 * Liefert den Saldo des Kontos oder <code>0.0</code> wenn er noch nie
	 * abgefragt wurde.
	 * @return Saldo des Kontos.
	 * @throws RemoteException
	 */
	double getSaldo() throws RemoteException;
  
	/**
	 * Speichert den neuen Saldo.
	 * @param saldo Neuer Saldo.
	 * @throws RemoteException
	 */
	void setSaldo(double saldo) throws RemoteException;
	
	/**
	 * Liefert den verfuegbaren Betrag auf dem Konto.
	 * BUGZILLA 530
	 * @return der verfuegbare Betrag auf dem Konto.
	 * @throws RemoteException
	 */
	double getSaldoAvailable() throws RemoteException;
	
	/**
	 * Speichert den verfuegbaren Betrag auf dem Konto.
	 * @param saldo der verfuegbare Betrag auf dem Konto.
	 * @throws RemoteException
	 */
	void setSaldoAvailable(double saldo) throws RemoteException;

	/**
	 * Liefert das Datum des aktuellen Saldos oder <code>null</code> wenn er
	 * noch nie abgefragt wurde.
	 * @return Datum des Saldos.
	 * @throws RemoteException
	 */
	Date getSaldoDatum() throws RemoteException;
  
  /**
   * Setzt das Saldo und Datum zurück
   * @throws RemoteException
   */
  void reset() throws RemoteException;

	/**
	 * Liefert eine Liste aller Umsaetze fuer das Konto in umgekehrter
	 * chronologischer Reihenfolge. Also die neuesten zuerst, die aeltesten zuletzt.
	 * @return Umsatzliste.
	 * @throws RemoteException
	 */
	DBIterator getUmsaetze() throws RemoteException;

	 /**
   * Liefert die Liste der fest zugeordneten Umsatzkategorien.
   * @return Liste der fest zugeordneten Umsatzkategorien.
   * @throws RemoteException
   */
  DBIterator getUmsatzTypen() throws RemoteException;

	/**
	 * Liefert die Anzahl der Umsaetze auf dem Konto.
	 * @return Anzahl der Umsaetze auf dem Konto.
	 * @throws RemoteException
	 */
	int getNumUmsaetze() throws RemoteException;

	/**
	 * Liefert eine Liste aller Umsaetze fuer die letzten x Tage.
   * Die neuesten zuerst, die aeltesten zuletzt.
	 * @param days Anzahl der Tage.
	 * @return Umsatzliste.
	 * @throws RemoteException
	 */
	DBIterator getUmsaetze(int days) throws RemoteException;

	/**
	 * Liefert eine Liste aller Umsaetze fuer den vorgegebenen Zeitraum.
   * Die neuesten zuerst, die aeltesten zuletzt.
	 * @param start Startdatum
	 * @param end EndeDatum
	 * @return Umsatzliste.
	 * @throws RemoteException
	 */
	DBIterator getUmsaetze(Date start, Date end) throws RemoteException;

	/**
	 * Liefert eine Liste aller Ueberweisungen, die ueber dieses Konto getaetigt wurden.
	 * @return Ueberweisungsliste.
	 * @throws RemoteException
	 */
	DBIterator getUeberweisungen() throws RemoteException;

  /**
   * Liefert eine Liste aller Auslandsueberweisungen, die ueber dieses Konto getaetigt wurden.
   * @return Liste der Auslandsueberweisungen.
   * @throws RemoteException
   */
  DBIterator getAuslandsUeberweisungen() throws RemoteException;
  
  /**
   * Liefert eine Liste aller SEPA-Lastschriften, die ueber dieses Konto getaetigt wurden.
   * @return Liste der SEPA-Lastschriften.
   * @throws RemoteException
   */
  DBIterator getSepaLastschriften() throws RemoteException;

  /**
   * Liefert eine Liste aller SEPA-Sammellastschriften, die ueber dieses Konto getaetigt wurden.
   * @return Liste der SEPA-Sammellastschriften.
   * @throws RemoteException
   */
  DBIterator getSepaSammelLastschriften() throws RemoteException;

  /**
   * Liefert eine Liste aller SEPA-Sammelueberweisungen, die ueber dieses Konto getaetigt wurden.
   * @return Liste der SEPA-Sammelueberweisungen.
   * @throws RemoteException
   */
  DBIterator getSepaSammelUeberweisungen() throws RemoteException;

  /**
	 * Liefert alle Dauerauftraege, die fuer das Konto vorliegen. Dabei werden
	 * auch jene geliefert, die lokal erstellt, jedoch noch nicht zur Bank
	 * hochgeladen wurden.
	 * @return Liste der Dauerauftraege.
	 * @throws RemoteException
	 */
	DBIterator getDauerauftraege() throws RemoteException;

  /**
   * Liefert alle SEPA-Dauerauftraege, die fuer das Konto vorliegen. Dabei werden
   * auch jene geliefert, die lokal erstellt, jedoch noch nicht zur Bank
   * hochgeladen wurden.
   * @return Liste der SEPA-Dauerauftraege.
   * @throws RemoteException
   */
  DBIterator getSepaDauerauftraege() throws RemoteException;

	/**
	 * Liefert alle Lastschriften, die fuer das Konto vorliegen.
	 * @return Liste der Lastschriften.
	 * @throws RemoteException
	 */
	DBIterator getLastschriften() throws RemoteException;

	/**
	 * Liefert alle Sammel-Lastschriften, die fuer das Konto vorliegen.
	 * @return Liste der Lastschriften.
	 * @throws RemoteException
	 */
	DBIterator getSammelLastschriften() throws RemoteException;

	/**
	 * Liefert alle Sammel-Ueberweisungen, die fuer das Konto vorliegen.
	 * @return Liste der Sammelueberweisungen.
	 * @throws RemoteException
	 */
	DBIterator getSammelUeberweisungen() throws RemoteException;

	/**
	 * Liefert die HBCI-Protokollierung des Kontos in Form einer Liste von Protokoll-Objekten.
	 * @return Liste von Protokoll-Objekten.
	 * @throws RemoteException
	 */
	DBIterator getProtokolle() throws RemoteException;
	
	/**
	 * Liefert die Liste der Kontoauszuege.
	 * @return die Liste der Kontoauszuege.
	 * @throws RemoteException
	 */
	DBIterator getKontoauszuege() throws RemoteException;

	/**
	 * Fuegt den uebergebenen Text zum Konto-Protokoll hinzu.
	 * @param kommentar der hinzuzufuegende Text.
	 * @param protokollTyp Typ des Protokoll-Eintrags. Siehe <code>de.willuhn.jameica.hbci.rmi.Protokoll</code>.
	 * @throws RemoteException
	 */
	void addToProtokoll(String kommentar, int protokollTyp) throws RemoteException;

  /**
   * Speichert einen zusaetzlichen Kommentar fuer das Konto.
   * @param kommentar
   * @throws RemoteException
   */
  void setKommentar(String kommentar) throws RemoteException;

  /**
   * Liefert einen zusaetzlichen Kommentar fuer das Konto.
   * @return Kommentar.
   * @throws RemoteException
   */
  String getKommentar() throws RemoteException;
  
  /**
   * Liefert die BIC.
   * @return die BIC.
   * @throws RemoteException
   */
  String getBic() throws RemoteException;
  
  /**
   * Speichert die BIC.
   * @param bic die BIC.
   * @throws RemoteException
   */
  void setBic(String bic) throws RemoteException;
  
  /**
   * Liefert die IBAN.
   * @return die IBAN.
   * @throws RemoteException
   */
  String getIban() throws RemoteException;
  
  /**
   * Speichert die IBAN.
   * @param iban die IBAN.
   * @throws RemoteException
   */
  void setIban(String iban) throws RemoteException;
  
  /**
   * Liefert einen Freitext mit der Kategorie.
   * @return Freitext mit der Kategorie.
   * @throws RemoteException
   */
  String getKategorie() throws RemoteException;
  
  /**
   * Speichert die Kategorie.
   * @param kategorie die Kategorie.
   * @throws RemoteException
   */
  void setKategorie(String kategorie) throws RemoteException;
  
}
