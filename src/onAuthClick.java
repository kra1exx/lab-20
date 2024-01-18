public void onAuthClick() {
    try{
        out.writeUTF("/auth " + loginField.getText() + " " + passField.getText());
        loginField.clear();
        passField.clear();
    } catch (Exception e) {
        e.printStackTrace();
    }
}