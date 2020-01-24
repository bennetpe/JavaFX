package gui.mvp.contact.model;

import java.io.*;

public class ImportData
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader in = new BufferedReader(new FileReader(Class.forName("gui.mvp.contact.model.ImportData").getResource("import.txt").getFile()));

        String line;
        while((line = in.readLine()) != null)
        {
            line = line.replaceAll(";", "\", \"");
            line = "createContact(\"" + line + "\");";
            System.out.println(line);
        }

        in.close();
    }
}
