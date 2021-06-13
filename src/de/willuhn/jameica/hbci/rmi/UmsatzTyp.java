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
import java.util.regex.PatternSyntaxException;

import de.willuhn.datasource.GenericIterator;
import de.willuhn.datasource.rmi.DBObjectNode;

/**
 * Interface zur Einstufung von Umsaetzen in verschiedene Kategorien.
 */
public interface UmsatzTyp extends DBObjectNode
{
  /**
   * Umsatzkategorie vom Typ "Ausgabe".
   */
  final static int TYP_AUSGABE  = 0;
  
  /**
   * Umsatzkategorie vom Typ "Einnahme".
   */
  final static int TYP_EINNAHME = 1;

  /**
   * Umsatzkategorie vom Typ "Egal".
   */
  final static int TYP_EGAL     = 2;
  
  /**
   * Maximale Laenge des Pattern.
   */
  final static int MAXLENGTH_PATTERN = 1000;
  
  /**
   * Flag "kein Flag".
   */
  final static int FLAG_NONE    = 0;

  /**
   * Flag "In Auswertungen ignorieren".
   */
  final static int FLAG_SKIP_REPORTS = 1 << 0;
  
	/**
	 * Liefert den Namen des Umsatz-Typs.
   * @return Name des Umsatz-Typs.
   * @throws RemoteException
   */
  String getName() throws RemoteException;

	/**
	 * Speichert den Namen des Umsatz-Typs.
   * @param name Name des Umsatz-Typs.
   * @throws RemoteException
   */
  void setName(String name) throws RemoteException;
	
  /**
   * Liefert die Nummer des Umsatz-Typs. Die Nummer wird für die Sortierung bei der Auswertung
   * eingesetzt.
   * @return Nummer des Umsatz-Typs.
   * @throws RemoteException
   */
  String getNummer() throws RemoteException;
  
  /**
   * Speichert die Nummer des Umsatz-Typs. 
   * @param nummer Nummer des Umsatz-Typs
   * @throws RemoteException
   */
  void setNummer(String nummer) throws RemoteException;
  
  /**
   * Liefert das Suchmuster fuer den Umsatztyp.
   * @return Suchmuster.
   * @throws RemoteException
   */
  String getPattern() throws RemoteException;

  /**
   * Speichert den Kommentar fuer den Umsatztyp.
   * @param kommentar der Kommentar.
   * @throws RemoteException
   */
  void setKommentar(String kommentar) throws RemoteException;

  /**
   * Liefert den Kommentar fuer den Umsatztyp.
   * @return Kommentar.
   * @throws RemoteException
   */
  String getKommentar() throws RemoteException;

  /**
   * Speichert das Suchmuster fuer den Umsatztyp.
   * @param pattern das Suchmuster.
   * @throws RemoteException
   */
  void setPattern(String pattern) throws RemoteException;

	/**
	 * Liefert eine Liste von Umsaetzen, die diesem Umsatz-Typ entsprechen.
   * @return Umsatz-Liste.
   * @throws RemoteException
   */
  GenericIterator getUmsaetze() throws RemoteException;
  
  /**
   * Liefert eine Liste von Umsaetzen aus dem angegebenen Zeitraum.
   * @param von Start-Datum. Wenn == null, dann bleibt es unberücksichtigt.
   * @param bis Ende-Datum. Wenn == null, dann bleibt es unberücksichtigt.
   * @return Umsatz-Liste.
   * @throws RemoteException
   */
  GenericIterator getUmsaetze(Date von, Date bis) throws RemoteException;
  
  /**
   * Liefert eine Liste von Umsaetzen der letzten Tage, die diesem Umsatz-Typ entsprechen.
   * @param days Anzahl der Tage.
   * @return Umsatz-Liste.
   * @throws RemoteException
   */
  GenericIterator getUmsaetze(int days) throws RemoteException;

  /**
   * Liefert die Hoehe des Umsatzes, der fuer diesen Umsatztyp auf allen Konten vorliegt.
   * @return Hoehe des Umsatzes.
   * @throws RemoteException
   */
  double getUmsatz() throws RemoteException;
  
  /**
   * Liefert die Hoehe des Umsatzes aus dem angegebenen Zeitraum.
   * @param von Start-Datum. Wenn == null, dann bleibt es unberücksichtigt.
   * @param bis Ende-Datum. Wenn == null, dann bleibt es unberücksichtigt.
   * @return Hoehe des Umsatzes.
   * @throws RemoteException
   */
  double getUmsatz(Date von, Date bis) throws RemoteException;
  
  /**
   * Liefert die Hoehe des Umsatzes der letzten Tage, der fuer diesen Umsatztyp auf allen Konten vorliegt.
   * @param days Anzahl der Tage.
   * @return Hoehe des Umsatzes.
   * @throws RemoteException
   */
  double getUmsatz(int days) throws RemoteException;

  /**
   * Prueft, ob es sich bei dem Pattern um einen regulaeren Ausdruck handelt.
   * @return true, wenn es sich um einen regulaeren Ausdruck handelt.
   * @throws RemoteException
   */
  boolean isRegex() throws RemoteException;
  
  /**
   * Liefert den Typ der Kategorie.
   * @return Typ der Kategorie.
   * @see UmsatzTyp#TYP_AUSGABE
   * @see UmsatzTyp#TYP_EINNAHME
   * @see UmsatzTyp#TYP_EGAL
   * @throws RemoteException
   */
  int getTyp() throws RemoteException;
  
  /**
   * Speichert den Typ der Kategorie.
   * @param typ Typ der Kategorie.
   * @see UmsatzTyp#TYP_AUSGABE
   * @see UmsatzTyp#TYP_EINNAHME
   * @see UmsatzTyp#TYP_EGAL
   * @throws RemoteException
   */
  void setTyp(int typ) throws RemoteException;
  
  /**
   * Speichert, ob es sich bei dem Pattern um einen regulaeren Ausdruck handelt.
   * @param regex true, wenn es sich um einen regulaeren Ausdruck handelt.
   * @throws RemoteException
   */
  void setRegex(boolean regex) throws RemoteException;

  /**
   * Prueft, ob der Umsatz diesem Pattern entspricht.
   * Ist fuer den Umsatz-Typ kein Pattern definiert, liefert die Funktion
   * immer false.
   * @param umsatz zu pruefender Umsatz.
   * @return true, wenn er dem Pattern entspricht.
   * @throws RemoteException
   * @throws PatternSyntaxException wird geworden, wenn es ein regulaerer Ausdruck mit Fehlern ist.
   */
  boolean matches(Umsatz umsatz) throws RemoteException, PatternSyntaxException;

  /**
   * Prueft, ob der Umsatz diesem Pattern entspricht.
   * Ist fuer den Umsatz-Typ kein Pattern definiert, liefert die Funktion
   * immer false.
   * @param umsatz zu pruefender Umsatz.
   * @param allowReassign true, wenn der Umsatz auch dann als passend gewertet werden
   * soll, wenn er bereits fest einer anderen Kategorie zugeordnet ist. Per Default (also
   * wenn die "matches(Umsatz)"-Funktion ohne diesen Boolean-Parameter aufgerufen wird)
   * ist dieser Parameter "false". Das heisst, ein Umsatz, der bereits manuell (nicht per Suchbegriff)
   * einer anderen Kategorie zugeordnet ist, liefert hier false, wenn "this" nicht
   * die zugeordnete Kategorie ist.
   * @return true, wenn er dem Pattern entspricht.
   * @throws RemoteException
   * @throws PatternSyntaxException wird geworden, wenn es ein regulaerer Ausdruck mit Fehlern ist.
   */
  boolean matches(Umsatz umsatz, boolean allowReassign) throws RemoteException, PatternSyntaxException;
  
  /**
   * Liefert die fuer diese Kategorie zu verwendende Farbe.
   * @return Farbe oder null, wenn noch keine definiert wurde.
   * @throws RemoteException
   */
  int[] getColor() throws RemoteException;
  
  /**
   * Speichert die Farbe fuer die Umsatz-Kategorie.
   * @param rgb Farbe.
   * @throws RemoteException
   */
  void setColor(int[] rgb) throws RemoteException;
  
  /**
   * Prueft, ob eine benutzerdefinierte Farbe verwendet werden soll.
   * @return true, wenn eine benutzerdefinierte Farbe verwendet werden soll.
   * @throws RemoteException
   */
  boolean isCustomColor() throws RemoteException;
  
  /**
   * Legt fest, ob eine benutzerdefinierte Farbe verwendet werden soll.
   * @param b true, wenn eine benutzerdefinierte Farbe verwendet werden soll.
   * @throws RemoteException
   */
  void setCustomColor(boolean b) throws RemoteException;
  
  /**
   * Liefert das optional zugeordnete Konto.
   * @return Konto.
   * @throws RemoteException
   */
  Konto getKonto() throws RemoteException;
  
  /**
   * Speichert das optional zugeordnete Konto.
   * @param konto Konto.
   * @throws RemoteException
   */
  void setKonto(Konto konto) throws RemoteException;
  
  /**
   * Liefert eine optionale Konto-Kategorie.
   * @return eine optionale Konto-Kategorie.
   * @throws RemoteException
   */
  String getKontoKategorie() throws RemoteException;
  
  /**
   * Speichert eine optionale Konto-Kategorie.
   * @param kategorie die optionale Konto-Kategorie.
   * @throws RemoteException
   */
  void setKontoKategorie(String kategorie) throws RemoteException;
  
  /**
   * Liefert ein Bit-Feld mit Flags.
   * Ein Objekt kann mit verschiedenen Flags markiert
   * werden. Das kann zum Beispiel "deaktiviert" sein.
   * Damit fuer kuenftige weitere Flags nicht immer
   * ein neues Feld zur Datenbank hinzugefuegt werden
   * muss, verwenden wir hier ein Bitfeld. Damit koennen
   * mehrere Flags in einem Wert codiert werden.
   * @return Bit-Feld mit den Flags des Objektes.
   * @throws RemoteException
   */
  int getFlags() throws RemoteException;
  
  /**
   * Speichert die Flags einen Objektes.
   * @param flags die Flags in Form eines Bit-Feldes.
   * @throws RemoteException
   */
  void setFlags(int flags) throws RemoteException;
  
  /**
   * Prueft, ob das angegebene Flag vorhanden ist.
   * @param flag das zu pruefende Flag.
   * @return true, wenn es gesetzt ist.
   * @throws RemoteException
   */
  boolean hasFlag(int flag) throws RemoteException;
}
