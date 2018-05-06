import java.util.*;
import java.io.*;

@SuppressWarnings("unchecked")


public interface Frontier{

  public Location next();

  public void add(Location n);

  public boolean hasNext();

}
