try {
socket = new Socket("localhost", 8189);
in = new DataInputStream(socket.getInputStream());
out = new DataOutputStream(socket.getOutputStream());
setAuthorized(false);
Thread t = new Thread(new Runnable) {
    @Override
    public void run(){
        try {
            while (true) {
                String strFromServer = in.readUTF();
                if(strFromServer.startWith("/authok")){
                    setAuthorized(true);
                    brek;
                }
                chatArea.appendText(strFromServer + ("\n"))
            }
            while (true) {
                String strFromServer = in.readUTF();
                if (strFromServer.equalsIgnoreCase("/end")){
                    break;
                }
                chatArea.append(strFromServer);
                chatArea.append("\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
};
 t.setDaemon(true);
 t.start();
} catch (IOException e) {
        e.printStackTrace();
}