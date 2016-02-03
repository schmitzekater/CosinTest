package de.schmitzekater

import grails.transaction.Transactional
import com.lowagie.text.Document
import com.lowagie.text.DocumentException
import com.lowagie.text.Paragraph
import com.lowagie.text.pdf.PdfWriter


@Transactional
class ReportService {

    def serviceMethod() {

    }

    def createSystemOverview(System system) throws DocumentException, IOException {
        String filename = "/testPdf.pdf"
        Document document = new Document()
        PdfWriter.getInstance(document, new FileOutputStream(filename))
        document.open()
        document.add(new Paragraph("Hello World"))
        document.close()
    }
}
