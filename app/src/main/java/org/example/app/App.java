package org.example.app;

import org.apache.commons.fileupload.disk.DiskFileItem;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

public class App {
    public static void main(String[] args) {
        // Simulating the use of a vulnerable function in DiskFileItem
        try {
            File repository = new File(System.getProperty("java.io.tmpdir"));
            DiskFileItem fileItem = new DiskFileItem("file", "text/plain", false, "test.txt", 1000000, repository);

            // Vulnerable method: write
            File file = new File("vulnerable.txt");
            OutputStream os = fileItem.getOutputStream();
            os.write("This i a test".getBytes());
            os.close();
            
            System.out.println("File created: " + file.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}