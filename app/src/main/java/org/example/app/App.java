package org.example.app;

import org.apache.commons.fileupload.disk.DiskFileItem;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class App {
    public static void main(String[] args) {
        // Simulating the use of a vulnerable function in DiskFileItem
        try {
            File repository = new File(System.getProperty("java.io.tmpdir"));
            DiskFileItem fileItem = new DiskFileItem("file", "text/plain", false, "test.txt", 1000000, repository);

            // Vulnerable method: write
            String fileName = "../../vulnerable.txt"; // Directory traversal vulnerability
            File file = new File(repository, fileName);
            try (OutputStream os = new FileOutputStream(file)) {
                os.write("This is a test".getBytes());
            }

            System.out.println("File created: " + file.getCanonicalPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}