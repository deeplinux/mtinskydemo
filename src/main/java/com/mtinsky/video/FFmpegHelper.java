package com.mtinsky.video;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *  ffmpeg辅助类，提供截图功能(使用时按需添加一些日志打印的代码)
 *  本类所在的jar所在的文件夹下的lib内需放置截图需要的ffmpeg执行文件，本项目内的ffmpeg已放置在文件夹lib/ffmpeg内
 *  ffmpeg的使用可参考官方网站：https://www.ffmpeg.org/
 */
public class FFmpegHelper {

    public static FFmpegHelper fFmpegHelper = new FFmpegHelper();

    /**
     *  构造时确定ffmpeg进程路径
     */
    private String ffmpegName = null;

    /**
     * 默认构造方法，将根据jar的路径计算出ffmpeg的路径
     */
    private FFmpegHelper(){
        String osName = System.getProperty("os.name");
        String curJarDir = this.getClass().getProtectionDomain().getCodeSource().getLocation().getPath();
        String binDir = new File(curJarDir).getParentFile().getAbsolutePath();
        osName = osName.toLowerCase();
        if(-1 != osName.indexOf("windows")){
            ffmpegName = binDir + "/lib/ffmpeg/windows/ffmpeg.exe";
        }else{
            ffmpegName = binDir + "/lib/ffmpeg/linux/ffmpeg";
        }
        System.out.println(ffmpegName);
    }

    /**
     * 截图
     * @param videoFileName 源文件路径，绝对路径
     * @param picFileName 截图文件路径，绝对路径，若文件存在，则覆盖
     * @param time 截图时间点,时间格式如：00:00:03
     * @return 1表示截图成功
     */
    public int makeVideoSnapshots(String videoFileName, String picFileName, String time){
        //保证中间目录存在
        File picFile = new File(picFileName);
        picFile.getParentFile().mkdirs();

        List<String> cmd = new ArrayList<String>();
        cmd.add(ffmpegName);
        cmd.add("-y");//不询问，直接重写输出文件
        cmd.add("-i");//输入文件的url
        cmd.add(videoFileName);
        cmd.add("-f");//Force input or output file format. The format is normally auto detected for input files and guessed from the file extension for output files, so this option is not needed in most cases.
        cmd.add("image2");
        //When used as an input option (before -i), seeks in this input file to position. Note that in most formats it is not possible to seek exactly, so ffmpeg will seek to the closest seek point before position. When transcoding and -accurate_seek is enabled (the default), this extra segment between the seek point and position will be decoded and discarded. When doing stream copy or when -noaccurate_seek is used, it will be preserved.
        //When used as an output option (before an output url), decodes but discards input until the timestamps reach position.
        //position must be a time duration specification, see (ffmpeg-utils)the Time duration section in the ffmpeg-utils(1) manual.
        cmd.add("-ss");
        cmd.add(time);
        //Set the number of video frames to output. This is an obsolete alias for -frames:v, which you should use instead.
        cmd.add("-vframes");
        cmd.add("1");
        cmd.add(picFileName);
        System.out.println(cmd.toString());
        process(cmd);
        if(picFile.exists()){
            return 1;
        }else{
            return 0;
        }
    }

    /**
     * 阻塞执行一个外部命令
     * @param cmd
     * @return
     */
    private int process(List<String> cmd){
        ProcessBuilder pb = new ProcessBuilder(cmd);
        try {
            Process p = pb.start();
            return p.waitFor();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public static void main(String[] argv){
        FFmpegHelper ffmpegHelper = new FFmpegHelper();
        ffmpegHelper.makeVideoSnapshots("D:/GM-ZAP/21.avi","D:/GM-ZAP/21.snapshots.jpg", "00:00:03");
    }
}
