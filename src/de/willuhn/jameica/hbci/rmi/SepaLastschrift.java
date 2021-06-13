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
 * Bildet eine SEPA-Lastschrift ab.
 */
public interface SepaLastschrift extends BaseUeberweisung, Duplicatable, SepaPayment, SepaBooking
{
  /**
   * Liefert die Mandats-ID.
   * @return die Mandats-ID.
   * @throws RemoteException
   */
  String getMandateId() throws RemoteException;
  
  /**
   * Speichert die Mandats-ID.
   * @param id die Mandats-ID.
   * @throws RemoteException
   */
  void setMandateId(String id) throws RemoteException;
  
  /**
   * Liefert die Glaeubiger-ID.
   * @return die Glaeubiger-ID.
   * @throws RemoteException
   */
  String getCreditorId() throws RemoteException;
  
  /**
   * Speichert die Glaeubiger-ID.
   * @param id die Glaeubiger-ID.
   * @throws RemoteException
   */
  void setCreditorId(String id) throws RemoteException;

  /**
   * Liefert das Datum der Unterschrift des Mandats.
   * @return das Datum der Unterschrift des Mandats.
   * @throws RemoteException
   */
  Date getSignatureDate() throws RemoteException;
  
  /**
   * Speichert das Datum der Unterschrift des Mandats.
   * @param date das Datum der Unterschrift des Mandats.
   * @throws RemoteException
   */
  void setSignatureDate(Date date) throws RemoteException;
  
  /**
   * Liefert den Sequenz-Typ der Lastschrft.
   * @return der Sequenz-Typ der Lastschrift.
   * @throws RemoteException
   */
  SepaLastSequenceType getSequenceType() throws RemoteException;
  
  /**
   * Speichert den Sequenz-Typ der Lastschrift.
   * @param type der Sequenz-Typ der Lastschrift.
   * @throws RemoteException
   */
  void setSequenceType(SepaLastSequenceType type) throws RemoteException;
  
  /**
   * Liefert das Ziel-Ausfuehrungsdatum bei der Bank.
   * @return das Ziel-Ausfuehrungsdatum bei der Bank.
   * @throws RemoteException
   */
  Date getTargetDate() throws RemoteException;
  
  /**
   * Speichert das Ziel-Ausfuehrungsdatum bei der Bank.
   * @param date das Ziel-Ausfuehrungsdatum bei der Bank.
   * @throws RemoteException
   */
  void setTargetDate(Date date) throws RemoteException;
  
  /**
   * Liefert den Typ der Lastschrft.
   * @return der Typ der Lastschrift.
   * @throws RemoteException
   */
  SepaLastType getType() throws RemoteException;
  
  /**
   * Speichert den Typ der Lastschrift.
   * @param type der Typ der Lastschrift.
   * @throws RemoteException
   */
  void setType(SepaLastType type) throws RemoteException;
  
  /**
   * Liefert die von der Bank nach der Uebertragung zurueckgemeldete Order-ID.
   * @return die Order-ID. NULL, wenn der Auftrag noch nicht an die Bank gesendet wurde.
   * @throws RemoteException
   */
  String getOrderId() throws RemoteException;
  
  /**
   * Speichert die von der Bank zurueckgemeldete Order-ID.
   * @param orderId die von der Bank zurueckgemeldete Order-ID.
   * @throws RemoteException
   */
  void setOrderId(String orderId) throws RemoteException;
  
}
