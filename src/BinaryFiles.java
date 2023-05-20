import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class BinaryFiles {

    public void writeBinaryFile(String filename) throws IOException {
        FileOutputStream fos = new FileOutputStream(filename);
        String str = "Hello Test";
        fos.write(str.getBytes());
        fos.close();
    }

    public void readBinaryFile(String filename) throws IOException {
        FileInputStream fis = new FileInputStream(filename);
        int data;
        while((data = fis.read()) != -1) {
            System.out.print((char)data);
        }
        fis.close();
    }
}
