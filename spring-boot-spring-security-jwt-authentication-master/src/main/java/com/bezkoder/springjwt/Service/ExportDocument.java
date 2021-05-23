package com.bezkoder.springjwt.Service;


import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.List;

@Service
public class ExportDocument {
    public static ByteArrayInputStream documentPDFreport(List<com.bezkoder.springjwt.bean.Document> documents) {
        Document document=new Document();
        ByteArrayOutputStream outputStream=new ByteArrayOutputStream();
        try {

            PdfWriter.getInstance(document,outputStream);
            document.open();
		/*Image img;
		try {
			img = Image.getInstance("/RHProject/src/main/java/RH/Project/onda.png");
			document.add(img);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/

            //add text to pdf file
            com.itextpdf.text.Font font= FontFactory.getFont(FontFactory.COURIER,20, Font.BOLD);
            Paragraph paragraph=new Paragraph("ATTESTATION DE TRAVAIL",font);
            paragraph.setAlignment(Element.ALIGN_CENTER);
            document.add(paragraph);
            document.add(Chunk.NEWLINE);
            com.itextpdf.text.Font font1= FontFactory.getFont(FontFactory.HELVETICA,12);

            Paragraph paragraph1=new Paragraph("Marrakech,le 29/01/2021",font1);
            paragraph1.setAlignment(Element.ALIGN_RIGHT);
            document.add(paragraph1);
            document.add(Chunk.NEWLINE);
            document.add(Chunk.NEWLINE);
            Paragraph paragraph3=new Paragraph("La Directrice Déléguée de l'Aéroport de Marrakech/Ménara,soussignée, atteste que:\r\n"
                    + "\r\n"
                    + "\r\n"
                    + "                         M.ALLA HAJAR  Mle:10170\r\n"
                    + "\r\n"
                    + "\r\n"
                    + "Est employé(e) à l'Office National des Aéropots,en qualité de Contrôleur de La Circulation Aérienne.\r\n"
                    + "\r\n"
                    + "La présente attestation est délivrée à la demande de l'intéressé(e) pour servir et valoir ce que de droit.\r\n"
                    + "",font1);

            document.add(paragraph3);


            document.close();
        } catch (DocumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return new ByteArrayInputStream(outputStream.toByteArray());
    }
}
