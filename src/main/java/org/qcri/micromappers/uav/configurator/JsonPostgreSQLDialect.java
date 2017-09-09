package org.qcri.micromappers.uav.configurator;

import org.hibernate.dialect.PostgreSQL9Dialect;

public class JsonPostgreSQLDialect extends PostgreSQL9Dialect
{
  public JsonPostgreSQLDialect()
  {
    registerColumnType(2000, "jsonb");
  }
}
