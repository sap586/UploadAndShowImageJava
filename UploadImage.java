import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class UploadImage {
    
    public static void main(String[] args) {
        final JFileChooser fc = new JFileChooser();
        int returnVal = fc.showOpenDialog(fc);
        String filePath = null;
        if(returnVal == JFileChooser.APPROVE_OPTION) {
            filePath = fc.getSelectedFile().getAbsolutePath();
        } else {
            System.out.println("Cancel");
            System.exit(1);
        }
        new FileChooser(filePath);
    }

}

class FileChooser {
    
    FileChooser(String filepath) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame(filepath);
                frame.setDefaultCloseOperation(3);
                BufferedImage img = null;
                try {
                    img = ImageIO.read(new File(filepath));
                } catch(Exception e) {
                    System.out.println("Exception");
                }
                JLabel lbl = new JLabel();
                lbl.setIcon(new ImageIcon(img));
                frame.getContentPane().add(lbl, BorderLayout.CENTER);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }
    
}
