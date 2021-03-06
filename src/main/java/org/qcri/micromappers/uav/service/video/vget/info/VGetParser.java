package org.qcri.micromappers.uav.service.video.vget.info;

import com.github.axet.wget.info.DownloadInfo;
import com.github.axet.wget.info.ex.DownloadInterruptedError;


import java.net.URL;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class VGetParser {

    public abstract VideoInfo info(URL web);

    public void info(VideoInfo info, AtomicBoolean stop, Runnable notify) {
        try {
            List<VideoFileInfo> dinfo = extract(info, stop, notify);

            info.setInfo(dinfo);

            for (DownloadInfo i : dinfo) {
                i.setReferer(info.getWeb());
                i.extract(stop, notify);
            }
        } catch (DownloadInterruptedError e) {
            info.setState(VideoInfo.States.STOP, e);
            notify.run();
            throw e;
        } catch (RuntimeException e) {
            info.setState(VideoInfo.States.ERROR, e);
            notify.run();
            throw e;
        }
    }

    public abstract List<VideoFileInfo> extract(final VideoInfo vinfo, final AtomicBoolean stop, final Runnable notify);

}
