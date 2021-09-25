package com.happeo.webUtilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

public class WordUtils {

	public static String wordExtracter() {
		XWPFWordExtractor ext = null;
		try {
			FileInputStream fis = new FileInputStream("src/test/resources/External Resources/Story.docx");
			XWPFDocument file = new XWPFDocument(OPCPackage.open(fis));
			ext = new XWPFWordExtractor(file);
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return ext.getText();
	}
}
