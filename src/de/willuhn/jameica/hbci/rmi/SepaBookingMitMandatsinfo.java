package de.willuhn.jameica.hbci.rmi;

import java.rmi.RemoteException;
import java.util.Date;

public interface SepaBookingMitMandatsinfo extends SepaBooking
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
}
