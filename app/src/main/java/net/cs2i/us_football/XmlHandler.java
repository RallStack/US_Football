package net.cs2i.us_football;

import android.content.Context;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by mduchemin on 19/02/18.
 * Read and Write xml.
 */

public class XmlHandler {

    /**
     * Read an xml 'filename'.
     *
     * @param context
     * @param filename
     * @return XmlPullParser parser
     */
    public XmlPullParser readXML(Context context, String filename) {
        XmlPullParserFactory parserFactory;
        XmlPullParser parser = null;
        try {
            parserFactory = XmlPullParserFactory.newInstance();
            parser = parserFactory.newPullParser();
            FileInputStream is = context.openFileInput(filename);
            parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
            parser.setInput(is, null);
            //is.close(); ça plante si on décommente !!!

        } catch (XmlPullParserException e) {} catch (IOException e) {}

        return parser;
    }

    /**
     * Write 'data' before last TAG in an xml 'filename'. Create 'filename' if it doesn't exist.
     *
     * @param context
     * @param data
     * @param filename
     */
    public void writeXML(Context context, String data, String filename){

        FileInputStream is = null;
        FileOutputStream os = null;
        File file = new File(filename);

        if (!this.fileExists(context, filename)) {
            String xmlSkeleton =
                    "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n" +
                    "<"+ filename.replace(".xml", "") +">\n" +
                    "</"+ filename.replace(".xml", "") +">";

            try {
                file.createNewFile();

                os = context.openFileOutput(filename, context.MODE_PRIVATE);
                os.write(xmlSkeleton.getBytes());
                os = null;
            }
            catch (FileNotFoundException e) { }
            catch (IOException e) { }

        }

        try {
            is = context.openFileInput(filename);
            String newData = is.toString();
            newData.replace("</"+ filename.replace(".xml", "") +">", data+"</"+ filename.replace(".xml", "") +">");

            os = context.openFileOutput(filename, context.MODE_PRIVATE);
            os.write(data.getBytes());

            os.close();
        }
        catch (FileNotFoundException e) { }
        catch (IOException e) { }
    }

    private boolean fileExists(Context context, String filename) {
        File file = context.getFileStreamPath(filename);
        if(file == null || !file.exists()) {
            return false;
        }
        return true;
    }
}