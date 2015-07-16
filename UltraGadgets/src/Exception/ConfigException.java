package Exception;

import java.io.IOException;

public class ConfigException
  extends IOException
{
  private static final long serialVersionUID = -6129312661428298460L;
  
  public ConfigException() {}
  
  public ConfigException(String message)
  {
    super(message);
  }
}
