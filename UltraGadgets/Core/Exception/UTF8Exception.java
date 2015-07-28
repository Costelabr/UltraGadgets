package Exception;

public class UTF8Exception
  extends IllegalArgumentException
{
  private static final long serialVersionUID = -7077319005387562897L;
  
  public UTF8Exception() {}
  
  public UTF8Exception(String message)
  {
    super(message);
  }
}
