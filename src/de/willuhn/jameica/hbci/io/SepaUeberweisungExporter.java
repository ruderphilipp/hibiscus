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

import java.text.SimpleDateFormat;
import java.util.Properties;

import org.apache.commons.lang.StringUtils;
import org.kapott.hbci.GV.SepaUtil;
import org.kapott.hbci.sepa.SepaVersion.Type;

import de.willuhn.jameica.hbci.rmi.AuslandsUeberweisung;
import de.willuhn.jameica.hbci.rmi.Konto;

/**
 * Exporter fuer SEPA-Ueberweisungen.
 */
public class SepaUeberweisungExporter extends AbstractSepaExporter
{
  @Override
  protected void exportObject(Object o, int idx, JobContext ctx) throws Exception
  {
    Properties props = ctx.props;

    AuslandsUeberweisung u = (AuslandsUeberweisung) o;
    Konto k = u.getKonto();

    ergaenzeUeberweisung(props, idx, u, k);
    props.setProperty("pmtinfid",StringUtils.trimToEmpty(u.getPmtInfId()));

    if (u.isTerminUeberweisung())
    {
      SimpleDateFormat df = new SimpleDateFormat(SepaUtil.DATE_FORMAT);
      String date = StringUtils.trimToNull(df.format(u.getTermin()));
      if (date != null)
        props.setProperty("date",date);
    }
  }

  @Override
  protected Type getPainType()
  {
    return Type.PAIN_001;
  }

  @Override
  protected String getJobName()
  {
    return "UebSEPA";
  }

  @Override
  Class[] getSupportedObjectTypes()
  {
    return new Class[]{AuslandsUeberweisung.class};
  }
}
