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

/**
 * Interface fuer eine einzelne Buchung einer SEPA-Sammellastschrift.
 */
public interface SepaSammelLastBuchung extends SepaSammelTransferBuchung<SepaSammelLastschrift>, Duplicatable, SepaBookingMitMandatsinfo
{
}
