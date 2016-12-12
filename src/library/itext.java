package library;

import java.io.FileOutputStream;
import java.util.Date;

import com.itextpdf.text.Anchor;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chapter;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.List;
import com.itextpdf.text.ListItem;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Section;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.sql.Connection;
import library.DBConnection;
import java.sql.*;

public class itext {

    static DBConnection db = new DBConnection();
    static Connection conn = db.getConn();
    static Statement stat;
    private static String FILE = "D:/temp/Report.pdf";
    private static Font catFont = new Font(Font.FontFamily.TIMES_ROMAN, 18,
            Font.BOLD);
    private static Font redFont = new Font(Font.FontFamily.TIMES_ROMAN, 12,
            Font.NORMAL, BaseColor.RED);
    private static Font subFont = new Font(Font.FontFamily.TIMES_ROMAN, 16,
            Font.BOLD);
    private static Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 12,
            Font.BOLD);

    public void getReprot() {

        try {
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(FILE));
            document.open();

            addContent(document);
            document.close();
            
        }catch (FileNotFoundException ex) {
            System.out.println("الرجاء اغلاق ملف pdf");
        }
        catch (Exception e) {
            System.out.println("Error");
        }
    }

    private static void addContent(Document document) throws DocumentException, BadElementException, SQLException {

        Anchor anchor = new Anchor("Tables", subFont);
        anchor.setName("Tables");

        Chapter catPart = new Chapter(new Paragraph(anchor), 1);

        Paragraph subPara = new Paragraph("table of books", subFont);
        Section subCatPart = catPart.addSection(subPara);

        Paragraph subPara2 = new Paragraph("table of member", subFont);
        Section subCatPart2 = catPart.addSection(subPara2);

        Paragraph subPara3 = new Paragraph("table of empolyee", subFont);
        Section subCatPart3 = catPart.addSection(subPara3);

        Paragraph paragraph = new Paragraph();
        addEmptyLine(paragraph, 3);

        subCatPart.add(paragraph);
        createTable(subCatPart);

        subCatPart.newPage();

        subCatPart2.add(paragraph);
        createTable2(subCatPart2);

        subCatPart2.newPage();

        subCatPart3.add(paragraph);
        createTable3(subCatPart3);

        document.add(catPart);

    }

    private static void createTable(Section subCatPart)
            throws BadElementException, SQLException {

        stat = conn.createStatement();
        String sql = "SELECT BOOK.BOOK_ID , BOOK.TITLE , SECTION.NAME FROM BOOK NATURAL JOIN SECTION";
        ResultSet rs = stat.executeQuery(sql);
        PdfPTable table = new PdfPTable(3);

        PdfPCell c1 = new PdfPCell(new Phrase("book_id"));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);

        c1 = new PdfPCell(new Phrase("title"));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);

        c1 = new PdfPCell(new Phrase("section name"));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);
        table.setHeaderRows(1);

        while (rs.next()) {

            table.addCell(rs.getInt("BOOK_ID") + "");
            table.addCell(rs.getString("title"));
            table.addCell(rs.getString("name"));

        }

        subCatPart.add(table);

    }

    private static void createTable2(Section subCatPart)
            throws BadElementException, SQLException {

        stat = conn.createStatement();
        String sql = "select * from member";
        ResultSet rs = stat.executeQuery(sql);
        PdfPTable table = new PdfPTable(3);

        PdfPCell c1 = new PdfPCell(new Phrase("member id"));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);

        c1 = new PdfPCell(new Phrase("name"));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);

        c1 = new PdfPCell(new Phrase("address"));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);
        table.setHeaderRows(1);

        while (rs.next()) {
            table.addCell(rs.getString("mem_id"));
            table.addCell(rs.getString("name"));
            table.addCell(rs.getString("address"));
        }

        subCatPart.add(table);

    }

    private static void createTable3(Section subCatPart)
            throws BadElementException, SQLException, DocumentException {

        stat = conn.createStatement();
        String sql = "select * from employee";
        ResultSet rs = stat.executeQuery(sql);
        PdfPTable table = new PdfPTable(6);
        table.setTotalWidth(500);
        table.setLockedWidth(true);
        PdfPCell c1 = new PdfPCell(new Phrase("emp id"));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);

        c1 = new PdfPCell(new Phrase("name"));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);

        c1 = new PdfPCell(new Phrase("address"));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);

        c1 = new PdfPCell(new Phrase("isAdmin"));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);

        c1 = new PdfPCell(new Phrase("email"));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);

        c1 = new PdfPCell(new Phrase("salary"));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);
        table.setHeaderRows(1);
        float[] columnWidths = new float[]{10f, 18f, 30f, 12f, 30f, 10f};
        table.setWidths(columnWidths);

        while (rs.next()) {
            table.addCell(rs.getString("emp_id"));
            table.addCell(rs.getString("name"));
            table.addCell(rs.getString("address"));

            int a = rs.getInt("isAdmin");
            String as = "";
            if (a == 1) {
                as = "True";
            } else {
                as = "False";
            }
            table.addCell(as);
            table.addCell(rs.getString("email"));
            table.addCell(rs.getString("salary"));
        }

        subCatPart.add(table);

    }

    private static void addEmptyLine(Paragraph paragraph, int number) {
        for (int i = 0; i < number; i++) {
            paragraph.add(new Paragraph(" "));
        }
    }

    public itext() throws SQLException {
        this.stat = conn.createStatement();
    }
}
