public class Item {

    private String id;
    private String name;
    private String userName;
    private String site;
    private String category;

    public Item(){

    }

    public Item(String id, String name){
        this.id = id;
        this.name = name;
    }

    public Item(String id, String name, String nameUser){
        this.id = id;
        this.name = name;
        this.userName = nameUser;
    }

    public Item(String id, String name, String nameUser, String site){
        this.id = id;
        this.name = name;
        this.userName = nameUser;
        this.site = site;
    }

    public Item(String id, String name, String nameUser, String site, String category) {
        this.id = id;
        this.name = name;
        this.userName = nameUser;
        this.site = site;
        this.category = category;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameUser() {
        return userName;
    }

    public void setNameUser(String nameUser) {
        this.userName = nameUser;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
