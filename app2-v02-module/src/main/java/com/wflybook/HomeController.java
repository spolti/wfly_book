package com.wflybook;

import java.io.IOException;
import java.io.InputStream;

import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;

@Resource
public class HomeController {

    private final java.util.logging.Logger log = java.util.logging.Logger.getLogger(this.getClass().getName());
    private final Result result;

    public HomeController(Result result) {
        this.result = result;
    }

    @Path("/")
    public void home(String level) throws IOException {

        String s = "";

        log.info("Our test Servlet was accessed");
        java.util.Properties config = new java.util.Properties();
        config.put("StrictHostKeyChecking", "no");

        JSch jsch = new JSch();
        Session session = null;
        try {
            session = jsch.getSession("Your-Linux-User", "Your-Linux-Host", 22);
        } catch (JSchException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        session.setConfig(config);
        session.setPassword("Your-Linux-Password");
        try {
            session.connect(10000);
        } catch (JSchException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

        Channel channel = null;
        try {
            channel = session.openChannel("exec");
        } catch (JSchException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        ((ChannelExec) channel).setCommand("date");
        ((ChannelExec) channel).setErrStream(System.err);
        InputStream in = channel.getInputStream();

        try {
            channel.connect();
        } catch (JSchException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        byte[] tmp = new byte[1024];
        boolean test = true;
        while (test == true) {

            while (in.available() > 0) {

                int i = in.read(tmp, 0, 1024);
                if (i < 0) {
                    break;
                }
                s += (new String(tmp, 0, i));
            }

            if (channel.isClosed()) {

                break;
            }
        }
        channel.disconnect();
        session.disconnect();

        while (s.endsWith(" ")) {
            s = s.substring(0, -1);
        }
        log.info(s);
    }

}