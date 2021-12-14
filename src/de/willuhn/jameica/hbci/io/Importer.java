/**********************************************************************
 *
 * Copyright (c) 2004 Olaf Willuhn
 * All rights reserved.
 * 
 * This software is copyrighted work licensed under the terms of the
 * Jameica License.  Please consult the file "LICENSE" for details. 
 *
 **********************************************************************/

package de.willuhn.jameica.hbci.io;

import java.io.InputStream;
import java.rmi.RemoteException;

import de.willuhn.jameica.system.BackgroundTask;
import de.willuhn.util.ApplicationException;
import de.willuhn.util.ProgressMonitor;

/**
 * Basis-Interface aller Importer.
 * <p>
 * Alle Klassen, die dieses Interface implementieren, werden automatisch
 * von Hibiscus erkannt und dem Benutzer als Import-M�glichkeit angeboten,
 * wenn sie einen parameterlosen Konstruktor mit dem Modifier "public"
 * besitzen (Java-Bean-Konvention).
 *
 * @see de.willuhn.jameica.hbci.io.IORegistry
 */
public interface Importer extends IO
{

  /**
   * Importiert Daten aus dem InputStream.
   *
   * @param context Context, der dem Importer hilft, den Zusammenhang zu erkennen,
   * in dem er aufgerufen wurde. Das kann zum Beispiel ein Konto sein.
   * @param format das vom User ausgewaehlte Import-Format.
   * @param is der Stream, aus dem die Daten gelesen werden.
   * @param monitor ein Monitor, an den der Importer Ausgaben ueber seinen
   * Bearbeitungszustand ausgeben kann.
   * Der Importer muss den Import-Stream selbst schliessen!
   * @param t der {@link BackgroundTask}
   *
   * @throws RemoteException
   * @throws ApplicationException 
   */
  public void doImport(Object context, IOFormat format, InputStream is, ProgressMonitor monitor, BackgroundTask t) throws RemoteException, ApplicationException;
}
