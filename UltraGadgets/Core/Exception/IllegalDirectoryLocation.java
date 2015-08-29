package Exception;

import java.io.IOException;

public class IllegalDirectoryLocation extends IOException {
	
	private static final long serialVersionUID = -569168349534472060L;

	public IllegalDirectoryLocation() {}
	
	public IllegalDirectoryLocation(String m) {
		super(m);
	}
}
