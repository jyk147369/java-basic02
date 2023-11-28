package day07.chat;

import java.io.*;
import java.net.Socket;

public class MessageProcessThread extends Thread {
    Socket socket;
    String id;

    public MessageProcessThread(String id, Socket socket) {
        this.id = id;
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            InputStream is = socket.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedInputStream bis = new BufferedInputStream(is);
            BufferedReader bir = new BufferedReader(isr);
            while (true) {
                String message = bir.readLine();

                if(message.startsWith("to:")){
                    Socket client = MultiThreadServer.socketMap.get(message.split(" ")[0].substring(3));
                    OutputStream os = client.getOutputStream();
                    OutputStreamWriter osw = new OutputStreamWriter(os);
                    BufferedWriter bw = new BufferedWriter(osw);
                    bw.write("DM : " + message.split(" ")[1]+"\n");
                    bw.flush();
                } else if(message.startsWith("img:")) {
                    for(String key : MultiThreadServer.socketMap.keySet()) {
                        if(id.equals(key)){
                            continue;
                        }

                        Socket client = MultiThreadServer.socketMap.get(key);
                        OutputStream os = client.getOutputStream();
                        OutputStreamWriter osw = new OutputStreamWriter(os);
                        BufferedWriter bw = new BufferedWriter(osw);
                        bw.write(message+"\n");
                        bw.flush();


                        BufferedOutputStream bos = new BufferedOutputStream(os);
                        int data = 0;
                        while( (data = bis.read()) != -1) {
                            bos.write(data);
                        }

                        bos.flush();

                    }
                } else {
                    for(String key : MultiThreadServer.socketMap.keySet()) {
                        if(id.equals(key)){
                            continue;
                        }
                        Socket client = MultiThreadServer.socketMap.get(key);
                        OutputStream os = client.getOutputStream();
                        OutputStreamWriter osw = new OutputStreamWriter(os);
                        BufferedWriter bw = new BufferedWriter(osw);
                        bw.write(message+"\n");
                        bw.flush();
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
