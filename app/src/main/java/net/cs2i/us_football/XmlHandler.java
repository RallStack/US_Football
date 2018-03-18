package net.cs2i.us_football;

import android.content.Context;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mduchemin on 19/02/18.
 * Read and Write xml.
 */

public class XmlHandler {
    /**
     * Create an xml 'filename' if it doesn't exist.
     *
     * @param context
     * @param filename
     */
    public void CreateXmlFile(Context context, String filename, ArrayList<String> options){
        FileOutputStream os = null;

        if (!this.fileExists(context, filename)) {
            String xmlSkeleton =
                    "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>" +
                    "<"+ filename.replace(".xml", "") +">";

            if (!options.isEmpty()){
                for (String option: options) {
                    xmlSkeleton +=
                        "<"+option+">" +
                        "</"+option+">";
                }
            }

            xmlSkeleton += "</"+ filename.replace(".xml", "") +">";

            try {
                os = context.openFileOutput(filename, context.MODE_PRIVATE);
                os.write(xmlSkeleton.getBytes());
                os.close();
            }
            catch (FileNotFoundException e) { }
            catch (IOException e) {
                e.getMessage();
            }

        }
    }

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
    public void writeXML(Context context, String data, String filename, String replaceTag){
        FileInputStream is = null;
        FileOutputStream os = null;

        try {
            is = context.openFileInput(filename);
            String newData = convertStreamToString(is);

            if(replaceTag != ""){
                //String regex = "<"+replaceTag+">.+<\\/"+replaceTag+">";
                newData = newData.replaceAll("<"+replaceTag+">.*<\\/"+replaceTag+">", data);
            }else{
                newData = newData.replace("</"+ filename.replace(".xml", "") +">", data+"</"+ filename.replace(".xml", "") +">");
            }

            os = context.openFileOutput(filename, context.MODE_PRIVATE);
            os.write(newData.getBytes());

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

    private String convertStreamToString(InputStream is) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();

        String line = null;
        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line).append('\n');
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }
}