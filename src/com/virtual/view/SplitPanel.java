/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.virtual.view;

import com.googlecode.javacpp.Loader;


import com.googlecode.javacv.CanvasFrame;
import com.googlecode.javacv.FrameGrabber;
import com.googlecode.javacv.OpenCVFrameGrabber;
import com.googlecode.javacv.cpp.opencv_core.IplImage;




import com.googlecode.javacv.cpp.opencv_objdetect;



import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Action;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.SwingUtilities;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import static com.googlecode.javacv.cpp.opencv_core.cvFlip;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Graphics;
import javax.swing.border.Border;

/**
 *
 * @author Project GURU
 */
public class SplitPanel {

    private static JFrame fsplitpane;
    private JPanel gui;
   // private JFileChooser fileChooser;
    //private JButton btnCompress;
    FilenameFilter fileNameFilter;
    //private JMenuBar menuBar;
    DefaultListModel model; 
    DefaultListModel model1; 
    static CanvasFrame cf;
    private static ArrayList<File> imgList1;
    private static ArrayList<File> fileList1;
    private static ArrayList<File> picList;
    private ArrayList<BufferedImage> input;
    private static JButton btnStart, btnBack;
    private static JButton btnStop;
    static FrameGrabber grabber1;
    static IplImage grabbedFrame1;
    private IplImage superImposedFrame1;
    static IplImage grabbedFrame2;
    //static BufferedImage bufImg=null;
    //private static BufferedImage input[];
    public Container getGui() {
        return gui;
    }
    SplitPanel(ArrayList<File> imgList) {
         
        Loader.load(opencv_objdetect.class);
        gui = new JPanel(new GridLayout());
        imgList1 =new ArrayList<File>(imgList.size());
        for(int i=0;i<imgList.size();i++){
        	imgList1.add(imgList.get(i));        	
        }
        picList = new ArrayList<File>();
        input = new ArrayList<BufferedImage>();	
        //imgList1 = imgList;
        
        //input[] = new BufferedImage[imgList1.size()]();
        JPanel imageViewContainer = new JPanel(new BorderLayout());
        imageViewContainer.setBounds(250, 2, 400, 400);
        final JLabel imageView = new JLabel();
        
        btnStart = new JButton("Start");
        btnStart.setBounds(2, 400, 100, 80);
        
        btnStop = new JButton("Convert 3D");        
        grabber1 = new OpenCVFrameGrabber(0);
        btnStart.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {        
                    cf = new CanvasFrame("Capture");
                    cf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    grabber1.start();
                    
                    grabbedFrame1 = grabber1.grab();
                    cf.setCanvasSize(grabbedFrame1.width(), grabbedFrame1.height());
                    //while(cf.isVisible()&&(grabbedFrame1 = grabber1.grab())!=null){
                        cf.showImage(grabbedFrame1);
                        for(int i=0;i<20;i++){
                            grabbedFrame1 = grabber1.grab();
                        }
                    try {
                        superImposedFrame1 = StartOptions3.getOverlaidFrame(grabbedFrame1);
                        BufferedImage bi1 = grabbedFrame1.getBufferedImage();
                        imageView.setIcon(new ImageIcon(bi1));
                        grabber1.stop();
                        grabber1.start();
                        for(int i=0;i<20;i++){
                            grabbedFrame1 = grabber1.grab();
                        }
                    } catch (IOException ex) {
                        Logger.getLogger(SplitPanel.class.getName()).log(Level.SEVERE, null, ex);
                    }
                        BufferedImage bi12 = grabbedFrame1.getBufferedImage();
                        imageView.setIcon(new ImageIcon(bi12));
                        BufferedImage  bufImg=convert3D(grabbedFrame1);
                        imageView.setIcon(new ImageIcon(bufImg));
                  //BufferedImage bi2 = grabbedFrame2.getBufferedImage();
                        //grabber1.delayedGrab(10);
                        for(int i=0;i<20;i++){
                            grabbedFrame1=grabber1.grab();
                        }
                        
                        BufferedImage img = select2D(grabbedFrame1);
                        grabbedFrame2=IplImage.createFrom(img);
                        grabber1.stop();
                        //grabbedFrame2 = grabbedFrame1;
                        
                //    }
                   // imageViewContainer.add(cf);
                    //grabber1.stop();
                    
                } catch (FrameGrabber.Exception ex) {
                    Logger.getLogger(SplitPanel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            private BufferedImage select2D(IplImage grabbedImage) {
                BufferedImage img = new BufferedImage(grabbedImage.width(),grabbedImage.height(),BufferedImage.TYPE_INT_ARGB);
                img = grabbedImage.getBufferedImage();
                return img;
            }
        });
        //imageViewContainer.add(btnStop);
        btnBack = new JButton("Logout");
        btnBack.setBounds(150, 400, 100, 80);
        btnBack.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    LoginView lg = new LoginView();
                    fsplitpane.dispose();
                    cf.dispose();
                     //To change body of generated methods, choose Tools | Templates.
                   // frame.dispose();
                }
            });

        btnStop.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                  
               BufferedImage  bufImg=convert3D(grabbedFrame1);
                  //BufferedImage bi2 = grabbedFrame2.getBufferedImage();
               imageView.setIcon(new ImageIcon(bufImg));  
                
            }
        });
        JPanel bottomPanel = new JPanel();

        bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        bottomPanel.add(btnStart);
        bottomPanel.add(btnBack);


        //imageView.setLayout(new BorderLayoutBorderLayout.CENTER);
        imageViewContainer.add(imageView,BorderLayout.CENTER);
        imageViewContainer.add(bottomPanel,BorderLayout.SOUTH);
//        btnCompress = new JButton();
        //imageViewContainer.add(btnCompress);
        model = new DefaultListModel(); 
        final JList imageList = new JList(model);
        imageList.setCellRenderer(new IconCellRenderer());
        ListSelectionListener listener = new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent lse) {
                Object o = imageList.getSelectedValue();
                if (o instanceof BufferedImage) {
                    imageView.setIcon(new ImageIcon((BufferedImage)o));
                    if(imageList.getSelectedIndex()==0){
                        File directory=new File("overlays/M");
                        try {
                            loadImages(directory);
                        } catch (IOException ex) {
                            Logger.getLogger(SplitPanel.class.getName()).log(Level.SEVERE, null, ex);
                        }                       
                        loadImages1(picList);
                    }else if(imageList.getSelectedIndex()==1){
                        File directory=new File("overlays/F");
                        try {
                            loadImages(directory);
                        } catch (IOException ex) {
                            Logger.getLogger(SplitPanel.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        loadImages1(picList);
                    }else if(imageList.getSelectedIndex()==2){
                        File directory=new File("overlays/K");
                        try {
                            loadImages(directory);
                        } catch (IOException ex) {
                            Logger.getLogger(SplitPanel.class.getName()).log(Level.SEVERE, null, ex);
                        } 
                        loadImages1(picList);
                    }
                   /* grabber1 = new OpenCVFrameGrabber(0);
		try {
                    int frameId=0;
                    int delay=10;
			grabber1.start();  
                        while (++frameId < delay)
                        grabbedFrame1 = grabber1.grab();
                        
                        superImposedFrame1 = StartOptions3.getOverlaidFrame(grabbedFrame1);
			/*while ((grabbedFrame1 = grabber1.grab()) != null){
                            //
                        }
                        BufferedImage bi = superImposedFrame1.getBufferedImage();
                        imageView.setIcon(new ImageIcon(bi));
                        for(int i=0;i<10;i++){
                            System.out.println("i="+i);
                        }
                        
                        grabber1.stop();
                }catch(Exception e){
                    e.printStackTrace();
                }*/
                
                
                   //gui.add(gui).getContentPane().getComponent(1).setVisible(true);
                
            }
            }
        };
        imageList.addListSelectionListener(listener);
        model1 = new DefaultListModel(); 
        final JList i1List = new JList(model1);
        i1List.setCellRenderer(new IconCellRenderer());
        ListSelectionListener listener1 = new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent lse) {
                Object o = i1List.getSelectedValue();
                if (o instanceof BufferedImage) {                    
                    /*try {
                        grabber1.start();
                        grabbedFrame1=grabber1.grab();*/
                        
                        for(int i=0;i<picList.size();i++){
                            if(i==i1List.getSelectedIndex()) {
                                try {
                                    
                                    String path = picList.get(i).getAbsolutePath();
                                    superImposedFrame1 = Overlay.getOverlaidFrame(grabbedFrame2, path, true);
                                    BufferedImage bi3 = superImposedFrame1.getBufferedImage();
                                    //grabber1.stop();
                                    imageView.setIcon(new ImageIcon(bi3));
                                    //grabber1.stop();
                                    break;
                                } catch (IOException ex) {
                                    Logger.getLogger(SplitPanel.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                        }
                        
                    /*} catch (FrameGrabber.Exception ex) {
                        Logger.getLogger(SplitPanel.class.getName()).log(Level.SEVERE, null, ex);
                    }*/
                }
            }
        };
        i1List.addListSelectionListener(listener1);
        //fileChooser = new JFileChooser();
        String[] imageTypes = ImageIO.getReaderFileSuffixes();
        FileNameExtensionFilter fnf = new FileNameExtensionFilter("Images", imageTypes);
        //fileChooser.setFileFilter(fnf);
        File userHome = new File(System.getProperty("user.home"));
        //fileChooser.setSelectedFile(userHome);



        fileNameFilter = new FilenameFilter() {
            @Override 
            public boolean accept(File file, String name) {
                return true;
            }
        };
        
        loadImages(imgList);
        /*menuBar = new JMenuBar();
        JMenu menu = new JMenu("File");
        menuBar.add(menu);
        JMenuItem browse = new JMenuItem("Browse");
        menu.add(browse);
        browse.addActionListener(new ActionListener(){
            @Override 
            public void actionPerformed(ActionEvent ae) {
                int result = fileChooser.showOpenDialog(gui);
                if (result==JFileChooser.APPROVE_OPTION) {
                    File eg = fileChooser.getSelectedFile();
                    // this will be an image, we want the parent directory
                    File dir = eg.getParentFile();
                    try {
                        loadImages(dir);
                    } catch(Exception e) {
                        e.printStackTrace();
                        JOptionPane.showMessageDialog(
                                gui, 
                                e, 
                                "Load failure!", 
                                JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });*/
        
        	/*gui.add(btnCompress);
        	btnCompress.setBounds(400, 590, 140, 30);*/// for next buuton 
        	
        JSplitPane sp1 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, 
                new JScrollPane(imageViewContainer),
                new JScrollPane(
                        i1List, 
                        JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, 
                        JScrollPane.HORIZONTAL_SCROLLBAR_NEVER));
        sp1.setDividerLocation(0.5);
        gui.add(new JSplitPane(
                JSplitPane.HORIZONTAL_SPLIT,                                 
                new JScrollPane(imageList, 
                        JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, 
                        JScrollPane.HORIZONTAL_SCROLLBAR_NEVER),sp1));
        fsplitpane = new JFrame("Image Browser");
                fsplitpane.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                fsplitpane.add(gui);
                fsplitpane.setLocationRelativeTo(null);
                fsplitpane.setLocationByPlatform(true);
                fsplitpane.pack();
                fsplitpane.setSize(1000,1000);
                fsplitpane.setVisible(true);
        
    }
    
    public void loadImages(File directory) throws IOException {
        File[] imageFiles = directory.listFiles(fileNameFilter);
        picList = new ArrayList<File>();
        for(int i=0;i<imageFiles.length;i++){
           // File f=new File(imageFiles[i]);
            picList.add(imageFiles[i]);
        }
        
        /*BufferedImage[] images = new BufferedImage[imageFiles.length];
        model.removeAllElements();
        for (int ii=0; ii<images.length; ii++) {
            model.addElement(ImageIO.read(imageFiles[ii]));
        }*/
    }

    

    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run() {
                //SplitPanel imageList = new SplitPanel(imgList1);
                 
                /*JFrame f = new JFrame("Image Browser");
                f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                f.add(imageList.getGui()); 
                f.setLocationRelativeTo(null);
                f.setLocationByPlatform(true);
                f.pack();
                f.setSize(1000,1000);
                f.setVisible(true);*/
            }
        });
    }
    public BufferedImage convert3D(IplImage grabbedImage){
        //IplImage a1 = new IplImage();
        BufferedImage img = new BufferedImage(grabbedImage.width(),grabbedImage.height(),BufferedImage.TYPE_INT_ARGB);
           img = grabbedImage.getBufferedImage();
        for(int i=0;i<img.getWidth();i++){
            for(int j=0;j<img.getHeight();j++){
                int rgba = img.getRGB(i, j);
                Color col=new Color(rgba,true);
                col = new Color(255-col.getRed(),255-col.getGreen(),255-col.getBlue());
                img.setRGB(i, j, col.getRGB());
            }
        }
        Graphics g = img.createGraphics();
        Graphics2D g2D = (Graphics2D) g;
        g2D.translate(170, 0);
        g2D.rotate(1);
        //g2D.drawImage(img, 0, 0, 200, 200, this);
        //a1=IplImage.createFrom(img);
        //g2D.drawImage(img, null, gui)
        return img;
    }

	public void loadImages(ArrayList<File> imgList) {
		// TODO Auto-generated method stub		
		if(imgList!=null&&imgList.size()>0){
			BufferedImage[] images = new BufferedImage[imgList.size()];
			model.removeAllElements();
			for(int i=0;i<images.length;i++){
				try {
					model.addElement(ImageIO.read(imgList.get(i)));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}		
	}
        public void loadImages1(ArrayList<File> imgList) {
		// TODO Auto-generated method stub		
		if(imgList!=null&&imgList.size()>0){
			BufferedImage[] images = new BufferedImage[imgList.size()];
			model1.removeAllElements();
			for(int i=0;i<images.length;i++){
				try {
					model1.addElement(ImageIO.read(imgList.get(i)));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}		
	}
}

class IconCellRenderer extends DefaultListCellRenderer {

    private static final long serialVersionUID = 1L;

    private int size;
    private BufferedImage icon;

    IconCellRenderer() {
        this(100);
    }

    IconCellRenderer(int size) {
        this.size = size;
        icon = new BufferedImage(size,size,BufferedImage.TYPE_INT_ARGB);
    }

    @Override
    public Component getListCellRendererComponent(
            JList list, 
            Object value, 
            int index, 
            boolean isSelected, 
            boolean cellHasFocus) {
        Component c = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        if (c instanceof JLabel && value instanceof BufferedImage) {
            JLabel l = (JLabel)c;
            l.setText("");
            BufferedImage i = (BufferedImage)value;
            l.setIcon(new ImageIcon(icon));

            Graphics2D g = icon.createGraphics();
            g.setPaint(new Color(128, 255, 64, 200));
            g.setColor(new Color(255,155,20,255));
            g.fillRect(0, 0, size, size);
            g.drawImage(i,0,0,size,size,this);

            g.dispose();
        }
        return c;
    }

    @Override 
    public Dimension getPreferredSize() {
        return new Dimension(size, size);
    }
}