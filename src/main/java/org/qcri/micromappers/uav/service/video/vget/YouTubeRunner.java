package org.qcri.micromappers.uav.service.video.vget;

import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileReader;

public class YouTubeRunner extends AppManagedDownload {

    private static final Logger LOGGER = Logger.getLogger(YouTubeRunner.class);

    public YouTubeRunner() {
    }

    public void downloadYoutube(String url, String destination){
        try{

            AppManagedDownload.main(new String[]{url, destination});
        }
        catch(Exception e){
            LOGGER.error(e);
        }
    }
/*
    public static void main(String[] args) {

        try{

            BufferedReader br = null;

            br = new BufferedReader(new FileReader("/Users/jlucas/Downloads/uaviators/csv/master.csv"));

            String sCurrentLine;

            while ((sCurrentLine = br.readLine()) != null) {
                System.out.println(sCurrentLine);
                String url = sCurrentLine;
                try{
                    AppManagedDownload.main(new String[]{url, "/Users/jlucas/Downloads/uaviators/"});
                }
                catch(Exception e){
                    System.out.println("Exception e : "  + e);
                    LOGGER.error(e);
                }

            }


        }
        catch (Exception a){
            System.out.println("Exception : "  + a);
        }

    }
    */
}
