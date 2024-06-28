package com.example.udemytowordjavafx;

import org.apache.poi.xwpf.usermodel.*;

import java.io.*;
import java.util.List;

public class DocxHandler {
    private static String inputFilePath = "sample.docx";

    public DocxHandler(String directoryPathStr, String heading1Str, String heading2Str, List<String> heading3List) {
        try {
            XWPFDocument document = new XWPFDocument(new FileInputStream(inputFilePath));
//            checkStylesIfAvailable(document);

            XWPFParagraph title;

            // selecting first paragraph and write
            title = document.getParagraphs().get(0);
            title.setStyle("Heading2");
            title.setAlignment(ParagraphAlignment.CENTER);
            XWPFRun tmpRun = title.createRun();
            tmpRun.setText(heading2Str);

            for (String heading3Str: heading3List) {
                // create new Heading3 paragraph
                title = document.createParagraph();
                title.setStyle("Heading3");
                title.setAlignment(ParagraphAlignment.CENTER);
                tmpRun = title.createRun();
                tmpRun.setText(heading3Str);

                // create new Normal paragraph
                title = document.createParagraph();
                title.setStyle("Normal");
                title.setAlignment(ParagraphAlignment.CENTER);
                tmpRun = title.createRun();
                tmpRun.setText("");
            }

            try {
                String fileName = heading2Str.replaceAll("[\\\\/:\\*\\?\"<>|#%&{}\\$!'@q\\+`=]", "");
                directoryPathStr = directoryPathStr.replaceAll("[\\*\\?\"<>|#%&{}\\$!'@q\\+`=]", "");
                String projectDirectoryStr = heading1Str.replaceAll("[\\\\/:\\*\\?\"<>|#%&{}\\$!'@q\\+`=]", "");

                File directory = new File(String.valueOf(directoryPathStr + "/" + projectDirectoryStr));
                if (!directory.exists()) {
                    directory.mkdir();
                }

                document.write(new FileOutputStream(directoryPathStr + "/" + projectDirectoryStr + "/"+ fileName + ".docx"));
                document.close();
                System.out.println("Word document saved successfully.");
            } catch (IOException e) {
                System.out.println("Save cannot be finished. " + e);
            }

        } catch (FileNotFoundException e) {
            System.out.println("Input file not found " + e);

        } catch (IOException f) {
            System.out.println("Saving file not possible because of " + f);
        }
    }
    private static void checkStylesIfAvailable(XWPFDocument document) {
        XWPFStyles styles = document.getStyles();

        if (styles.styleExist("Heading1")) {
            System.out.println("Style Heading1 exists."); //Template must contain named style "Hyperlink" already
        }
        if (styles.styleExist("Heading2")) {
            System.out.println("Style Heading2 exists."); //Template must contain named style "Hyperlink" already
        }
        if (styles.styleExist("Heading3")) {
            System.out.println("Style Heading3 exists."); //Template must contain named style "Hyperlink" already
        }
        if (styles.styleExist("Konzol")) {
            System.out.println("Style Konzol exists."); //Template must contain named style "Hyperlink" already
        }
        if (styles.styleExist("srt")) {
            System.out.println("Style srt exists."); //Template must contain named style "Hyperlink" already
        }
        if (styles.styleExist("Normal")) {
            System.out.println("Style Normal exists."); //Template must contain named style "Hyperlink" already
        }
    }
}
