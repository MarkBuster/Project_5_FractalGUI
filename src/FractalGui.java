import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Fractal GUI class which extends JFrame
 */
public class FractalGui extends JFrame {
    /**
     * FractalSubject global variable
     */
    private FractalSubject subject;
    /**
     * Global variable for recursion
     */
    private JSlider recursionDepthSlider;
    /**
     * global variable for Opacity
     */
    private JSlider circleOpacitySlider;
    /**
     * global variable for color fractal color themes
     */
    private JButton fracColorButton;
    /**
     * global variable for color chooser panel
     */
    private Color chosenColor = null;

    /**
     * FractalGui method
     * all widegets and GUI controls are created, displayed and put into action from here.
     * @param subject Subject which is used
     */
    public FractalGui(FractalSubject subject){
        this.subject = subject;
        setTitle("Fractal Settings");
        setSize(400,450);
        setDefaultCloseOperation(EXIT_ON_CLOSE);


        subject.getData();
        // Jpanel is an intermediate container that will allow widgets to go on the jframe,aka a button or slider or whatever.
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(null);// denies help from the layout manager software.
        //getContentPane glues the JPanel to the JFrame. next create and add widgets
        getContentPane().add(mainPanel);


        JLabel recursionDepthLabel = new JLabel("Recursion Depth");
        recursionDepthSlider = new JSlider(JSlider.HORIZONTAL,1,8,5);
        recursionDepthLabel.setBounds(100, 40, 220, 40);
        recursionDepthSlider.setBounds(50, 70, 300, 40);
        recursionDepthSlider.setMajorTickSpacing(1);
        recursionDepthSlider.setPaintTicks(true);
        recursionDepthSlider.setPaintLabels(true);
        mainPanel.add(recursionDepthLabel);
        mainPanel.add(recursionDepthSlider);
        recursionDepthSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                setData();
            }
        });




        JLabel circleOpacityLabel = new JLabel("Circle opacity");
        circleOpacitySlider = new JSlider(JSlider.HORIZONTAL,0,100,60);
        circleOpacityLabel.setBounds(100, 120, 220, 40);
        circleOpacitySlider.setBounds(50, 150, 300, 40);
        circleOpacitySlider.setMajorTickSpacing(10);
        circleOpacitySlider.setPaintTicks(true);
        circleOpacitySlider.setPaintLabels(true);
        mainPanel.add(circleOpacityLabel);
        mainPanel.add(circleOpacitySlider);
        circleOpacitySlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                setData();
            }
        });


        String[] colorPatterns = {"Solid","Brilliant Set", "Blue Beach", "Heat Wave", "Neon Slime", "SnowFlakes"};
        JComboBox<String> dropMenu = new JComboBox<>(colorPatterns);
        JLabel comboLabel = new JLabel("Color theme");
        comboLabel.setBounds(100,210,100,25);
        dropMenu.setBounds(50,230,300,25);
        mainPanel.add(comboLabel);
        mainPanel.add(dropMenu);
        dropMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setData();
            }
        });


        fracColorButton = new JButton("Fractal color");
        fracColorButton.setBounds(100,290,120,25);
        mainPanel.add(fracColorButton);
        JLabel colorSwatch = new JLabel("Current Color");
        colorSwatch.setBounds(110,270,125,25);
        mainPanel.add(colorSwatch);
        // an action listener lets the button function.
        fracColorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if ( e.getSource() == fracColorButton){
                    JColorChooser colorChooser = new JColorChooser();
                    chosenColor = JColorChooser.showDialog(null,"",Color.BLUE);
                    colorSwatch.setBackground(chosenColor);
                    colorSwatch.setForeground(chosenColor);
                }
                setData();
            }
        });


        // this is a widget
        JButton drawButton = new JButton("D R A W   T H E   F R A C T A L!");
        drawButton.setBounds(100,350,210,25);
        mainPanel.add(drawButton);
        // an action listener lets the button funtion.
        drawButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO: more stuff to pass later
                // what  kind of things could we even add here????
                setData();
            }
        });


        setVisible(true);
    }

    /**
     * setData method used in communicating with the fractal drawings
     */
    public void setData(){
        subject.setData(recursionDepthSlider.getValue(),circleOpacitySlider.getValue(), fracColorButton.getBackground());


    }
}
