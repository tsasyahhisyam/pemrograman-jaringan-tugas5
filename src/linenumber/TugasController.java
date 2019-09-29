package linenumber;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.LineNumberInputStream;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.StyledDocument;

public class TugasController {
    
    private Tugas view;
    private List<Integer> list = new ArrayList<>();
    
    public TugasController(Tugas view){
        this.view = view;
        
            this.view.getBtnBaca().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                proses();
            }
        }) ;
        
        this.view.getBtnSimpan().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                save();
            }
        });
        
    }
    
    private void save() {
        JFileChooser loadFile = view.getLoadFile();
        if(JFileChooser.APPROVE_OPTION == loadFile.showSaveDialog(view)){
            BufferedWriter writer = null;
            try{
                String contents = view.getTxtPane().getText();
                if(contents != null && !contents.isEmpty()) {
                    writer = new BufferedWriter(new FileWriter(loadFile.getSelectedFile()));
                    writer.write(contents);
                }
            } catch(FileNotFoundException ex){
                Logger.getLogger(BufferedInputOutputStream.class.getName()).log(Level.SEVERE, null, ex);            
            } catch(IOException ex) {
                Logger.getLogger(BufferedInputOutputStream.class.getName()).log(Level.SEVERE, null, ex);
            }finally{
                if(writer != null) {
                    try{
                        writer.flush();
                        writer.close();
                        view.getTxtPane().setText("");
                        JOptionPane.showMessageDialog(view, "File berhasil ditulis.", "Informasi", JOptionPane.INFORMATION_MESSAGE);
                    }catch(IOException ex){
                        Logger.getLogger(BufferedInputOutputStream.class.getName()).log(Level.SEVERE, null, ex);
                        
                    }
                }
            }
        }
    }
    
    private void proses() {
        
        JFileChooser loadFile = view.getLoadFile();
         StyledDocument doc = view.getTxtPane().getStyledDocument();
             if (JFileChooser.APPROVE_OPTION == loadFile.showOpenDialog(view)) {
                 BufferedInputStream reader = null;
                 try {
                     reader = new BufferedInputStream(new FileInputStream(loadFile.getSelectedFile()));
                     File sel = loadFile.getSelectedFile();
                     doc.insertString(0, "", null);
                     int temp = 0;
                     List<Integer> list = new ArrayList<>();
                     byte[] buffer = new byte[(int) sel.length()];
                     reader.read(buffer);
                         list.add(temp);
                     if (!list.isEmpty()) {
                         byte[] dt = new byte[list.size()];
                         int i = 0;
                         for (Integer integer : list) {
                             dt[i]=integer.byteValue();
                             i++;
                         }
                         doc.insertString(doc.getLength(), new String(buffer), null);
                         try {
                 int desimal;
                 char ascii;
              
                int desimal2;
                char ascii2;

             LineNumberInputStream inputStream = new LineNumberInputStream(new FileInputStream(loadFile.getSelectedFile()));
             while ((desimal2 = inputStream.read()) != -1) {
                 ascii2 = (char) desimal2;  
             }
             
                 String line = null;
                 int wordCount = 0;
                 int characterCount = 0;
                 
                 LineNumberReader lineNumberReader = new LineNumberReader(new FileReader(loadFile.getSelectedFile()));

                 while((line = lineNumberReader.readLine()) != null){
                     String[] wordList = line.split("\\s+");
                     characterCount += line.length();
                     wordCount += wordList.length;
                     
                     for(int j=0; j<wordList.length; j++){
                         String word = wordList[j];
                         if(list.equals(word)){
                         }
                     }
                     
                 }
                 lineNumberReader.close();
                 JOptionPane.showMessageDialog(view,"File Berhasil Dibaca" + "\nJumlah Baris : "+(inputStream.getLineNumber() +1) +"\nJumlah Kata : " +wordCount + "\nJumlah Karakter :"+characterCount, "Informasi", JOptionPane.INFORMATION_MESSAGE);
             } catch (FileNotFoundException ex) {
                 Logger.getLogger(ReadFileReader.class.getName()).log(Level.SEVERE, null, ex);
             } catch (IOException ex) {
                 Logger.getLogger(ReadFileReader.class.getName()).log(Level.SEVERE, null, ex);
             }
            
                     } 
                 } catch (FileNotFoundException ex) {
                     Logger.getLogger(BufferedInputOutputStream.class.getName()).log(Level.SEVERE, null, ex);
                 } catch (IOException | BadLocationException ex) {
                     Logger.getLogger(BufferedInputOutputStream.class.getName()).log(Level.SEVERE, null, ex);
                 } finally {
                     if (reader != null) {
                         try {
                             reader.close();
                         } catch (IOException ex) {
                             Logger.getLogger(BufferedInputOutputStream.class.getName()).log(Level.SEVERE, null, ex);
                         }
                     }
                 }
             }
     }
}
    
