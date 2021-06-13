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

/**
 * Interface fuer eine einzelne Buchung eines Sammel-Transfers.
 */
public interface SammelTransferBuchung extends Transfer, HibiscusDBObject
{
	/**
	 * Liefert den zugeordneten Sammel-Transfer.
   * @return Sammel-Transfer.
   * @throws RemoteException
   */
  SammelTransfer getSammelTransfer() throws RemoteException;

	/**
	 * Legt den zugehoerigen Sammel-Transfer fest.
   * @param s Sammel-Transfer.
   * @throws RemoteException
   */
  void setSammelTransfer(SammelTransfer s) throws RemoteException;

	/**
	 * Speichert die Kontonummer des Gegenkontos.
   * @param kontonummer
   * @throws RemoteException
   */
  void setGegenkontoNummer(String kontonummer) throws RemoteException;

	/**
	 * Speichert die BLZ des Gegenkontos.
   * @param blz
   * @throws RemoteException
   */
  void setGegenkontoBLZ(String blz) throws RemoteException;

	/**
	 * Speichert den Namen des Kontoinhabers des Gegenkontos.
   * @param name
   * @throws RemoteException
   */
  void setGegenkontoName(String name) throws RemoteException;

	/**
	 * Speichert den zu ueberweisenden Betrag.
	 * @param betrag Betrag.
	 * @throws RemoteException
	 */
  void setBetrag(double betrag) throws RemoteException;

	/**
	 * Speichert den Zweck der Ueberweisung.
	 * @param zweck Zweck der Ueberweisung.
	 * @throws RemoteException
	 */
  void setZweck(String zweck) throws RemoteException;

	/**
	 * Speichert Zeile 2 des Verwendungszwecks.
	 * @param zweck2 Zeile 2 des Verwendungszwecks.
	 * @throws RemoteException
	 */
  void setZweck2(String zweck2) throws RemoteException;

  /**
   * Liefert den Textschluessel der Buchung.
   * @return Textschluessel.
   * @throws RemoteException
   */
  String getTextSchluessel() throws RemoteException;

  /**
   * Speichert den Textschluessel der Buchung.
   * @param schluessel Textschluessel.
   * @throws RemoteException
   */
  void setTextSchluessel(String schluessel) throws RemoteException;

  /**
   * Speichert eine Liste erweiterter Verwendungszwecke.
   * @param list Liste erweiterter Verwendungszwecke.
   * @throws RemoteException
   */
  void setWeitereVerwendungszwecke(String[] list) throws RemoteException;

  /**
   * Liefert eine ggf aufgetretene Warnung bei der Ausfuehrung.
   * @return eine ggf aufgetretene Warnung bei der Ausfuehrung.
   * @throws RemoteException
   */
  String getWarnung() throws RemoteException;

  /**
   * Speichert eine ggf aufgetretene Warnung bei der Ausfuehrung.
   * @param warnung eine ggf aufgetretene Warnung bei der Ausfuehrung.
   * @throws RemoteException
   */
  void setWarnung(String warnung) throws RemoteException;
}
