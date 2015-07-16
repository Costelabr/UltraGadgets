package Exception;

public class BlockReRollException
  extends RuntimeException
{
  private static final long serialVersionUID = 8261339069682568500L;
  
  public BlockReRollException() {}
  
  public BlockReRollException(String message)
  {
    super(message);
  }
}
