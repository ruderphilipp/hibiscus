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

/**
 * Bildet einen einzelnen elektronischen Kontoauszug ab.
 */
public interface Kontoauszug extends HibiscusDBObject
{
  /**
   * Liefert das Konto.
   * @return Konto.
   * @throws RemoteException
   */
  Konto getKonto() throws RemoteException;
  
  /**
   * Speichert das Konto.
   * @param konto Konto.
   * @throws RemoteException
   */
  void setKonto(Konto konto) throws RemoteException;

  /**
   * Liefert das Datum, zu dem der Kontoauszug abgerufen wurde.
   * @return das Datum zu dem der Kontoauszug abgerufen wurde.
   * @throws RemoteException
   */
  Date getAusfuehrungsdatum() throws RemoteException;

  /**
   * Liefert einen optionalen Kommentar.
   * @return optionaler Kommentar.
   * @throws RemoteException
   */
  String getKommentar() throws RemoteException;
  
  /**
   * Speichert einen optionalen Kommentar.
   * @param kommentar Kommentar.
   * @throws RemoteException
   */
  void setKommentar(String kommentar) throws RemoteException;

  /**
   * Liefert den Ordner, in dem sich die zugehorige Datei befindet.
   * @return der Ordner - ohne Dateiname.
   * @throws RemoteException
   */
  String getPfad() throws RemoteException;
  
  /**
   * Speichert den Ordner, in dem sich die zugehoerige Datei befindet.
   * @param pfad der Ordner - ohne Dateiname.
   * @throws RemoteException
   */
  void setPfad(String pfad) throws RemoteException;
  
  /**
   * Liefert den Dateinamen des Kontoauszuges.
   * @return der Dateiname des Kontoauszuges.
   * @throws RemoteException
   */
  String getDateiname() throws RemoteException;
  
  /**
   * Speichert den Dateinamen des Kontoauszuges.
   * @param dateiname der Dateiname des Kontoauszuges.
   * @throws RemoteException
   */
  void setDateiname(String dateiname) throws RemoteException;
  
  /**
   * Liefert eine optionale UUID des Kontoauszuges, falls die Datei per Messaging gespeichert wurde.
   * @return optionale UUID des Kontoauszuges, falls die Datei per Messaging gespeichert wurde.
   * @throws RemoteException
   */
  String getUUID() throws RemoteException;
  
  /**
   * Speichert optionale UUID des Kontoauszuges, falls die Datei per Messaging gespeichert wurde.
   * @param uuid optionale UUID des Kontoauszuges, falls die Datei per Messaging gespeichert wurde.
   * @throws RemoteException
   */
  void setUUID(String uuid) throws RemoteException;
  
  /**
   * Liefert das Format-Kuerzel der Datei.
   *  1 = Swift MT940
   *  2 = ISO 8583
   *  3 = PDF
   * @return das Format-Kuerzel der Datei.
   * @throws RemoteException
   */
  String getFormat() throws RemoteException;
  
  /**
   * Speichert das Format-Kuerzel der Datei.
   * @param format das Format-Kuerzel der Datei.
   * @throws RemoteException
   */
  void setFormat(String format) throws RemoteException;
  
  /**
   * Liefert das Datum der bankseitigen Erstellung des Kontoauszuges.
   * @return das Datum der bankseitigen Erstellung des Kontoauszuges.
   * @throws RemoteException
   */
  Date getErstellungsdatum() throws RemoteException;
  
  /**
   * Speichert das Datum der bankseitigen Erstellung des Kontoauszuges.
   * @param d das Datum der bankseitigen Erstellung des Kontoauszuges.
   * @throws RemoteException
   */
  void setErstellungsdatum(Date d) throws RemoteException;
  
  /**
   * Liefert das Start-Datum des Berichtszeitraumes.
   * @return das Start-Datum des Berichtszeitraumes.
   * @throws RemoteException
   */
  Date getVon() throws RemoteException;
  
  /**
   * Speichert das Start-Datum des Berichtszeitraumes.
   * @param von das Start-Datum des Berichtszeitraumes.
   * @throws RemoteException
   */
  void setVon(Date von) throws RemoteException;
  
  /**
   * Liefert das Ende-Datum des Berichtszeitraumes.
   * @return das Ende-Datum des Berichtszeitraumes.
   * @throws RemoteException
   */
  Date getBis() throws RemoteException;
  
  /**
   * Speichert das Ende-Datum des Berichtszeitraumes.
   * @param bis das Ende-Datum des Berichtszeitraumes.
   * @throws RemoteException
   */
  void setBis(Date bis) throws RemoteException;
  
  /**
   * Liefert das Jahr des Kontoauszuges.
   * @return das Jahr des Kontoauszuges.
   * @throws RemoteException
   */
  Integer getJahr() throws RemoteException;
  
  /**
   * Speichert das Jahr des Kontoauszuges.
   * @param jahr das jahr des Kontoauszuges.
   * @throws RemoteException
   */
  void setJahr(Integer jahr) throws RemoteException;
  
  /**
   * Liefert die Nummer des Kontoauszuges.
   * @return die Nummer des Kontoauszuges.
   * @throws RemoteException
   */
  Integer getNummer() throws RemoteException;
  
  /**
   * Speichert die Nummer des Kontoauszuges.
   * @param nummer die Nummer des Kontoauszuges.
   * @throws RemoteException
   */
  void setNummer(Integer nummer) throws RemoteException;

  /**
   * Liefert den ersten Namen des Kontoauszuges.
   * @return der erste Name des Kontoauszuges.
   * @throws RemoteException
   */
  String getName1() throws RemoteException;
  
  /**
   * Speichert den ersten Namen des Kontoauszuges.
   * @param name1 der erste Name des Kontoauszuges.
   * @throws RemoteException
   */
  void setName1(String name1) throws RemoteException;

  /**
   * Liefert den zweiten Namen des Kontoauszuges.
   * @return der zweite Name des Kontoauszuges.
   * @throws RemoteException
   */
  String getName2() throws RemoteException;
  
  /**
   * Speichert den zweiten Namen des Kontoauszuges.
   * @param name2 der zweite Name des Kontoauszuges.
   * @throws RemoteException
   */
  void setName2(String name2) throws RemoteException;

  /**
   * Liefert den dritten Namen des Kontoauszuges.
   * @return der dritte Name des Kontoauszuges.
   * @throws RemoteException
   */
  String getName3() throws RemoteException;
  
  /**
   * Speichert den dritten Namen des Kontoauszuges.
   * @param name3 der dritte Name des Kontoauszuges.
   * @throws RemoteException
   */
  void setName3(String name3) throws RemoteException;
  
  /**
   * Liefert den Quittungscode des Kontoauszuges.
   * @return der Quittungscode des Kontoauszuges.
   * @throws RemoteException
   */
  byte[] getQuittungscode() throws RemoteException;
  
  /**
   * Speichert den Quittungscode des Kontoauszuges.
   * @param code der Quittungscode des Kontoauszuges.
   * @throws RemoteException
   */
  void setQuittungscode(byte[] code) throws RemoteException;
  
  /**
   * Liefert das Datum, an dem die Quittung an die Bank gesendet wurde.
   * @return das Datum, an dem die Quittung an die Bank gesendet wurde.
   * @throws RemoteException
   */
  Date getQuittiertAm() throws RemoteException;
  
  /**
   * Speichert das Datum, an dem die Quittung an die Bank gesendet wurde.
   * @param d das Datum, an dem die Quittung an die Bank gesendet wurde.
   * @throws RemoteException
   */
  void setQuittiertAm(Date d) throws RemoteException;
  
  /**
   * Liefert das Datum, an dem der Kontoauszug als gelesen markiert wurde.
   * @return das Datum, an dem der Kontoauszug als gelesen markiert wurde.
   * @throws RemoteException
   */
  Date getGelesenAm() throws RemoteException;
  
  /**
   * Speichert das Datum, an dem der Kontoauszug als gelesen markiert wurde.
   * @param d das Datum, an dem der Kontoauszug als gelesen markiert wurde.
   * @throws RemoteException
   */
  void setGelesenAm(Date d) throws RemoteException;

}
