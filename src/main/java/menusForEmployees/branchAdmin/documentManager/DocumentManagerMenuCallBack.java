package menusForEmployees.branchAdmin.documentManager;

public class DocumentManagerMenuCallBack {
    public String menu(){
        StringBuilder menu = new StringBuilder();

        menu.append("*******************************************\n");
        menu.append(" -> Document Manager Menu\n");
        menu.append("\n");
        menu.append("Document Manager Menu");
        menu.append("1. Enter Documents\n");
        menu.append("2. View Documents\n");
        menu.append("3. Branch Manager Menu\n");
        menu.append("4. Log Out\n");
        menu.append("*******************************************");

        return menu.toString();
    }
}
