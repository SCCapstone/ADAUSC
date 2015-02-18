import java.io.FileOutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;


public class Main {

	public static void main(String[] args) {

		for(int i = 1; i <= 134; i++){
			String daWeb = String.format("http://www.ada.gov/regs2010/2010ADAStandards/images/ADA-AB%d.gif", i);	
			try {
				URL daGif = new URL(daWeb);
				ReadableByteChannel rbc = Channels.newChannel(daGif.openStream());
				FileOutputStream fos = new FileOutputStream(String.format("C:\\Users\\dohertsm\\Desktop\\ADAGIFs\\diagram%d.gif", i));
				fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
			} catch (Exception e) {
				e.printStackTrace();
				//seems the following gif #s dont exist 47,48,49,50,92
			}
			
		}

	}

}
