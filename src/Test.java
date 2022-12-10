import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

class MainFrame extends JFrame implements ActionListener {
    JPanel panel;
    JButton convertBtn;
    JButton saveBtn;
    BufferedImage myImage;
    File ofile;
    int width;
    int height;

    public MainFrame() {
        panel = new JPanel();

        saveBtn = new JButton("저장");
        convertBtn = new JButton("변환");

        panel.setLayout(new GridLayout(2, 1, 10, 10));

        add(panel);
        panel.add(convertBtn);
        panel.add(saveBtn);

        convertBtn.addActionListener(this);
        saveBtn.addActionListener(this);

        setSize(500, 300);
        setVisible(true);
        setTitle("gray scale convert");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == convertBtn) {
            File ifile = new File("test.jpg");
            try {
                myImage = ImageIO.read(ifile);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            width = myImage.getWidth();
            height = myImage.getHeight();
            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    Color c = new Color(myImage.getRGB(x, y));
                    int red = (int) (c.getRed() * 0.299);
                    int green = (int) (c.getGreen() * 0.587);
                    int blue = (int) (c.getBlue() * 0.114);
                    Color gray = new Color(red + green + blue, red + green
                            + blue, red + green + blue);
                    myImage.setRGB(x, y, gray.getRGB());
                }
            }
            ofile = new File("gray.jpg");
        } else {
            try {
                ImageIO.write(myImage, "jpg", ofile);
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }
    }
}

public class Test {
    public static void main(String[] args) {
        new MainFrame();
    }
}