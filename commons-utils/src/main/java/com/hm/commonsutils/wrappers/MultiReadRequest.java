package com.hm.commonsutils.wrappers;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.stream.Collectors;

import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
/**
 * @author: Hugo Miguel Martinez Hernandez
 * @see <a href = "https://www.youtube.com/channel/UC52UbfusfkWETo6ydpvnFnw?view_as=subscriber" /> youtube.com – Mi canal de proyecyo personal </a>
 */
public class MultiReadRequest extends HttpServletRequestWrapper {

    private String requestBody;

    public MultiReadRequest(HttpServletRequest request) {
        super(request);
        try {
            requestBody = request.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ServletInputStream getInputStream() throws IOException {
        final ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(requestBody.getBytes());
        return new ServletInputStream() {
            @Override
            public boolean isFinished() {
                return byteArrayInputStream.available() == 0;
            }

            @Override
            public boolean isReady() {
                return true;
            }

            @Override
            public void setReadListener(ReadListener readListener) {

            }

            @Override
            public int read() throws IOException {
                return byteArrayInputStream.read();
            }
        };
    }

    @Override
    public BufferedReader getReader() throws IOException {
        return new BufferedReader(new InputStreamReader(this.getInputStream(), Charset.forName("UTF-8")));
    }

}
