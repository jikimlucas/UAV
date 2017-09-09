package org.qcri.micromappers.uav.service;

/**
 * Created by jlucas on 9/8/17.
 */

import java.awt.image.BufferedImage;
import java.io.File;
import org.bytedeco.javacv.*;
import javax.imageio.ImageIO;



/**
 *
 * @author Dmitriy Gerashenko <d.a.gerashenko@gmail.com>
 */
public class FFmpegStreamingTimeout {

    /**
     * There is no universal option for streaming timeout. Each of protocols has
     * its own list of options.
     */
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

    private static final String SOURCE_RTSP = "/Users/jlucas/Downloads/uaviators/16.mp4";
    private static final int TIMEOUT = 10; // In seconds.

    public static void main(String[] args) {
        rtspStreamingTest();
//        testWithCallback(); // This is not working properly. It's just for test.
    }

    private static void rtspStreamingTest() {
        try {
            FFmpegFrameGrabber grabber = new FFmpegFrameGrabber(SOURCE_RTSP);
            /**
             * "timeout" - IS IGNORED when a network cable have been unplugged
             * before a connection and sometimes when connection is lost.
             *
             * "rw_timeout" - IS IGNORED when a network cable have been
             * unplugged before a connection but the option takes effect after a
             * connection was established.
             *
             * "stimeout" - works fine.
             */
            grabber.setOption(
                    TimeoutOption.STIMEOUT.getKey(),
                    String.valueOf(TIMEOUT * 1000000)
            ); // In microseconds.
            grabber.start();

            Frame frame = null;
            /**
             * When network is disabled (before brabber was started) grabber
             * throws exception: "org.bytedeco.javacv.FrameGrabber$Exception:
             * avformat_open_input() error -138: Could not open input...".
             *
             * When connections is lost (after a few grabbed frames)
             * grabber.grab() returns null without exception.
             */
            OpenCVFrameConverter.ToIplImage converter = new OpenCVFrameConverter.ToIplImage();
            Java2DFrameConverter java2DFrameConverter = new Java2DFrameConverter();

            int i =0;
            while ((frame = grabber.grab()) != null) {
                System.out.println("frame grabbed at " + grabber.getTimestamp());
                String fileName = "/Users/jlucas/Downloads/uaviators/dv/" + i + ".png";
                if(grabber.getTimestamp() > 0){
                    BufferedImage image = java2DFrameConverter.convert(frame);
                    try{
                        ImageIO.write(image, "png", new File(fileName));
                    }
                    catch (Exception e){
                        System.out.println(e);
                    }
                    i++;
                }

            }
            System.out.println("loop end with frame: " + frame);
        } catch (FrameGrabber.Exception ex) {
            System.out.println("exception: " + ex);
        }
        System.out.println("end");
    }

}
