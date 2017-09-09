package org.qcri.micromappers.uav.service;


import org.apache.log4j.Logger;
import org.bytedeco.javacpp.avcodec;
import org.bytedeco.javacpp.avutil;
import org.bytedeco.javacpp.opencv_core;
import org.bytedeco.javacpp.opencv_videoio;
import java.awt.image.BufferedImage;
import java.io.File;
import org.bytedeco.javacv.*;
import javax.imageio.ImageIO;

/**
 * Created by jlucas on 9/7/17.
 */
public class VideoStreamingService {

    private static final Logger LOGGER = Logger.getLogger(VideoStreamingService.class);

    private static enum TimeoutOption {
        /**
         * Depends on protocol (FTP, HTTP, RTMP, SMB, SSH, TCP, UDP, or UNIX).
         *
         * http://ffmpeg.org/ffmpeg-all.html
         */
        TIMEOUT,
        /**
         * Protocols
         *
         * Maximum time to wait for (network) read/write operations to complete,
         * in microseconds.
         *
         * http://ffmpeg.org/ffmpeg-all.html#Protocols
         */
        RW_TIMEOUT,
        /**
         * Protocols -> RTSP
         *
         * Set socket TCP I/O timeout in microseconds.
         *
         * http://ffmpeg.org/ffmpeg-all.html#rtsp
         */
        STIMEOUT;

        public String getKey() {
            return toString().toLowerCase();
        }

    }

    private String sourceVideo = "/Users/jlucas/Downloads/uaviators/16.mp4";
    private String sourceImage = "/Users/jlucas/Downloads/uaviators/16.mp4";
    private static final int TIMEOUT = 10; // In seconds.

    public VideoStreamingService() {
    }

    public String getSourceVideo() {
        return sourceVideo;
    }

    public void setSourceVideo(String sourceVideo) {
        this.sourceVideo = sourceVideo;
    }

    public void videoStreamingToPng() {
        try {
            FFmpegFrameGrabber grabber = new FFmpegFrameGrabber(sourceVideo);

            grabber.setOption(
                    TimeoutOption.STIMEOUT.getKey(),
                    String.valueOf(TIMEOUT * 1000000)
            ); // In microseconds.
            grabber.start();

            Frame frame = null;

            Java2DFrameConverter java2DFrameConverter = new Java2DFrameConverter();

            int i =0;
            while ((frame = grabber.grab()) != null) {
                System.out.println("frame grabbed at " + grabber.getTimestamp());
                String fileName = "/Users/jlucas/Downloads/uaviators/dv/" + i + ".png";

                BufferedImage image = java2DFrameConverter.convert(frame);
                try{
                    ImageIO.write(image, "png", new File(fileName));
                }
                catch (Exception e){
                    LOGGER.error(e);
                }
                i++;

            }
            System.out.println("loop end with frame: " + frame);
        } catch (FrameGrabber.Exception ex) {
            LOGGER.error("exception: " + ex);
        }

        System.out.println("end");
    }

    public void getMetaData(){
        opencv_videoio.VideoCapture capture = new opencv_videoio.VideoCapture(this.sourceVideo);
        opencv_core.Mat matOrig = new opencv_core.Mat();

        if(capture.isOpened()){
            // boolean canRead = true;
            //while (canRead){
            //   canRead = capture.read(matOrig);
            // get some meta data about frame.
            double fps = capture.get(opencv_videoio.CAP_PROP_FPS);
            double frameCount = capture.get(opencv_videoio.CAP_PROP_FRAME_COUNT);
            double h = capture.get(opencv_videoio.CAP_PROP_FRAME_HEIGHT);
            double w = capture.get(opencv_videoio.CAP_PROP_FRAME_WIDTH);
            double posFrames = capture.get(opencv_videoio.CAP_PROP_POS_FRAMES);
            double posMsec = capture.get(opencv_videoio.CAP_PROP_POS_MSEC);
            double speed = capture.get(opencv_videoio.CAP_PROP_SPEED);

            if( !matOrig.empty() ) {
                // do stuff
            }
            //  }
        }
    }

    final private static int FRAME_RATE = 30;

    public void generateVideo(){
        try{
            int captureWidth = 1920;
            int captureHeight = 1080;

            Java2DFrameConverter java2DFrameConverter = new Java2DFrameConverter();
            File folder = new File("/Users/jlucas/Downloads/uaviators/dv");

            FFmpegFrameRecorder recorder = new FFmpegFrameRecorder("/Users/jlucas/Downloads/uaviators/dv/1.mp4", captureWidth, captureHeight, 3);

            /*recorder.setVideoCodec(13);

            recorder.setFormat("mp4");
            recorder.setPixelFormat(avutil.AV_PIX_FMT_YUV420P);
            recorder.setFrameRate(30);
            recorder.setVideoBitrate(10 * 1024 * 1024);*/


            recorder.setVideoCodec(avcodec.AV_CODEC_ID_MPEG4);
            recorder.setFormat("mp4");
            recorder.setFrameRate(240);
           // recorder.setVideoBitrate(10 * 1024 * 1024);

            recorder.start();
            int index = 0;
            for (File fileEntry : folder.listFiles()) {
                //1920 × 1080, 527
                System.out.println(index++);
                System.out.println(fileEntry.getName());
                if(fileEntry.getName().endsWith(".png")) {
                    BufferedImage image = ImageIO.read(fileEntry);
                    Frame frame = java2DFrameConverter.convert(image);

                    recorder.record(frame);
                }

            }
            recorder.stop();
            //recorder.release();


        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        VideoStreamingService streamingService = new VideoStreamingService();
        streamingService.generateVideo();
        //streamingService.setSourceVideo("/Users/jlucas/Downloads/uaviators/16.mp4");
        //streamingService.getMetaData();
       // streamingService.videoStreamingToPng();
    }
}
