package de.schmitzekater

import grails.transaction.Transactional
import com.lowagie.text.Document
import com.lowagie.text.DocumentException
import com.lowagie.text.Paragraph
import com.lowagie.text.pdf.PdfWriter
import grails.plugins.rendering.pdf.PdfRenderingService


@Transactional
class ReportService {

    def pdfRenderingService

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

    def createSampleReport(System system) {
        def file = new File("/samplePdf.pdf")
        renderPdf(template: '/reports/pdfExample/', model: [system: system])
    }
}
